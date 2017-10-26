package com.ada.discover.pay.utils;

import java.util.*;

/**
 * Created by ada on 2017/7/29.
 */
public class MapUtils {

    /**
     * 获取一个按照key排序的map
     *
     * @return
     */
    public static Map<String, String> getSortMap() {
        Map<String, String> map = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 升序排序
                        return obj1.compareTo(obj2);
                    }
                });
        return map;
    }

    /**
     * 拼接url参数
     * @param map
     * @return
     */
    public static String params(Map<String, String> map) {
        StringBuffer buffer = new StringBuffer();
        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        if (iter.hasNext()) {
            String key = iter.next();
            buffer.append(key);
            buffer.append("=");
            buffer.append(map.get(key));
        }
        while (iter.hasNext()) {
            String key = iter.next();
            buffer.append("&");
            buffer.append(key);
            buffer.append("=");
            buffer.append(map.get(key));
        }
        return buffer.toString();
    }
}
