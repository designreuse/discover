package com.tongna.adminstore;

import com.ada.discover.rest.base.ResponseObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AliyunCodePlug plug=new AliyunCodePlug("LTAI5rIYav12KhGh","RzWXcCEJg0jweOVurYrbwdJZ1uVHyq");

        CodeSendDto dto=new CodeSendDto();
        dto.setCode("123456");
        dto.setPhone("18229060103");
        dto.setProduct("开一票");
        dto.setSignName("开一票");
        dto.setSmsTemplateCode("SMS_78910259");
        ResponseObject vo=  plug.send(dto);
        System.out.println(vo);
    }
}
