package com.tongna;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;

import javax.naming.spi.ObjectFactory;

/**
 * Created by ada on 2016/12/30.
 */
public class ClientFactory {

    /**
     * 用户的域名
     *
     * @param domain
     * @return
     */
   public BosClient create(String domain){
       String ACCESS_KEY_ID = "216e91b84ba64c85861e7783ff9009e1"; // 用户的Access
       // Key ID
       String SECRET_ACCESS_KEY = "1b10fb0d54594b2a91cf7d5c59c31ea2"; // 用户的Secret
       // 初始化一个BosClient
       BosClientConfiguration config = new BosClientConfiguration();
       config.setCredentials(new DefaultBceCredentials(ACCESS_KEY_ID, SECRET_ACCESS_KEY));
       config.setEndpoint(domain);// 用户自己指定的域名

       BosClient client = new BosClient(config);
       return client;
    }
}
