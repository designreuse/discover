package com.ada.user.utils;

import java.util.HashMap;

/**
 * Created by ada on 2017/6/29.
 */
public class CodeCatalog {

    private static HashMap<String,Integer> codes=new HashMap<String, Integer>();

    static {
        codes.put("register",1);
        codes.put("login",2);
        codes.put("binding",3);
        codes.put("reset",4);
        codes.put("changePhone",5);
    }
    public static Integer catalog(String catalog){
        return codes.get(catalog);
    }

}
