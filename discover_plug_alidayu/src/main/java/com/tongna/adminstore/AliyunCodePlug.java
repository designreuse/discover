package com.tongna.adminstore;

import com.ada.discover.rest.base.ResponseObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * Created by ada on 2016/12/19.
 */
public class AliyunCodePlug {

    static String url = "http://gw.api.taobao.com/router/rest";
    private String appkey ;//= "23295373";
    private String secret ;//= "5323ef746ae21951ae74d141cec496c6";
    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";
    public AliyunCodePlug(String appkey, String secret) {
        this.appkey = appkey;
        this.secret = secret;
    }

    public ResponseObject send(CodeSendDto dto) {
        ResponseObject result = new ResponseObject();

        SendVCode codes = new SendVCode();
        codes.setCode(dto.getCode());
        codes.setProduct(dto.getProduct());
        Gson gson = new Gson();

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", appkey, secret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(dto.getPhone());
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(dto.getSignName());
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(dto.getSmsTemplateCode());
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam(gson.toJson(codes));

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        try {
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if (!sendSmsResponse.getCode().equals("OK")){
                result.setCode(-1);
                result.setMsg(sendSmsResponse.getMessage());
            }
        } catch (ClientException e) {
            e.printStackTrace();
            result.setCode(-1);
            result.setMsg(e.getErrMsg());
        }

        return result;
    }
}
