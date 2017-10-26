package com.young.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cng19 on 2017/6/26.
 */
public class ListUtils {

    public static <T> List<T> list(T t) {
        List<T> result = new ArrayList<T>();
        if (t != null) {
            result.add(t);
        }
        return result;
    }
}
