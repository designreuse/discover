package com.ada.discover.pay.weixin;

import com.ada.discover.pay.weixin.api.PayService;
import com.ada.discover.pay.weixin.domain.UnifiedOrderPayBack;
import com.ada.discover.pay.weixin.domain.UnifiedOrderPayData;
import com.ada.discover.pay.weixin.impl.PayWeiXinService;
import jodd.util.StringUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by ada on 2017/7/29.
 */
public class Apps {
    public static void main(String[] args) {
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");

        UnifiedOrderPayData data = new UnifiedOrderPayData();
        data.setAppid("wx4734bb29eff92b19");
        data.setMch_id("1321697201");
        data.setNonce_str(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        data.setBody(StringUtil.convertCharset("my teacher order recharge", "UTF-8", "ISO-8859-1"));
        data.setBody("开一票订单");
        data.setOut_trade_no(format.format(new Date())+"1233001");
        data.setTotal_fee(100);
        data.setSpbill_create_ip("139.129.109.231");
        data.setNotify_url("http://139.129.109.231/iedu/payment/weixinnotifyurl.htm");
        data.setTrade_type("APP");
        //data.setOpenid("o-yAJ0f07q50JOA2sBx5r2xRxR2w");
        PayService service = new PayWeiXinService("1d286ad3178f4ebca85cea54f748920c");
        UnifiedOrderPayBack back = service.order(data);
        System.out.println(back);
        if (back != null && back.getPrepay_id() != null) {
        } else {
        }
    }
}
