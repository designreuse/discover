package com.ada.discover.pay.weixin.impl;

import com.ada.discover.pay.utils.MapUtils;
import com.ada.discover.pay.weixin.api.PayService;
import com.ada.discover.pay.weixin.domain.UnifiedOrderPayBack;
import com.ada.discover.pay.weixin.domain.UnifiedOrderPayData;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.util.StringUtil;

import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class PayWeiXinService implements PayService {


    private String key;

    public PayWeiXinService(String key) {
        this.key = key;
    }

    /**
     * MD5编码
     *
     * @param origin 原始字符串
     * @return 经过MD5加密之后的结果
     */
    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            // resultString = byteArrayToHexString(md.digest(resultString.getBytes()));//原文件内容，可能原因是：win2003时系统缺省编码为GBK，win7为utf-8
            resultString = byteArrayToHexString(md.digest(resultString.getBytes("utf-8")));//正确的写法
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    private static String byteArrayToHexString(byte[] digest) {

        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < digest.length; i++) {
            int val = ((int) digest[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString();
    }

    /**
     * 微信统一下单功能
     * @param data
     * @return
     */
    @Override
    public UnifiedOrderPayBack order(UnifiedOrderPayData data) {
        UnifiedOrderPayBack result = null;

        XStream xstream = new XStream(new DomDriver("UTF-8", new NoNameCoder()));
        xstream.alias("xml", UnifiedOrderPayData.class);
        xstream.alias("xml", UnifiedOrderPayBack.class);


        Map<String, String> map = MapUtils.getSortMap();
        map.put("appid", data.getAppid());
        map.put("body", data.getBody());
        map.put("mch_id", data.getMch_id());
        map.put("nonce_str", data.getNonce_str());
        map.put("notify_url", data.getNotify_url());
        map.put("out_trade_no", data.getOut_trade_no());
        map.put("spbill_create_ip", data.getSpbill_create_ip());
        map.put("total_fee", data.getTotal_fee() + "");
        map.put("trade_type", data.getTrade_type() + "");
        if (data.getOpenid()!=null){
            map.put("openid", data.getOpenid() + "");
        }
        String p = MapUtils.params(map);
        p = p + "&key=" + key;
        System.out.println(p);
        String sign = MD5Encode(p);
        data.setSign(sign);
        HttpRequest httpRequest = HttpRequest.post("https://api.mch.weixin.qq.com/pay/unifiedorder");
        String x = xstream.toXML(data);
        httpRequest.body(StringUtil.convertCharset(x, "UTF-8", "ISO-8859-1"));
        HttpResponse response = httpRequest.send();
        if (response.statusCode()==200){
            String body = response.body();
            body = StringUtil.convertCharset(body, "ISO-8859-1", "UTF-8");
            System.out.println(body);
            result = (UnifiedOrderPayBack) xstream.fromXML(body);
        }else{
            result=new UnifiedOrderPayBack();
            result.setReturn_msg("FAIL");
        }

        return result;
    }


    public static void main(String[] args) {

        ClassLoader classLoader = PayWeiXinService.class.getClassLoader();
        URL resource = classLoader.getResource("apiclient_cert.p12");
        String path = resource.getPath();
        System.out.println(path);
//		String path = PayWeiXinService.class.getClassLoader().getResource("/resources/apiclient_cert.p12").getPath();
//		System.out.println(path);
//		path = path.substring(1, path.indexOf("classes"))+"apiclient_cert.p12";

//		 String path=Thread.currentThread().getContextClassLoader().getResource("").toString();  
//	        path=path.replace('/', '\\'); // 将/换成\  
//	        path=path.replace("file:", ""); //去掉file:  
//	        path=path.replace("classes\\", ""); //去掉class\  
//	        path=path.substring(1); //去掉第一个\,如 \D:\JavaWeb...  
        System.out.println(path);
    }
}
