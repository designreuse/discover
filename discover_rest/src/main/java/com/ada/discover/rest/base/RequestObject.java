package com.ada.discover.rest.base;

import java.io.Serializable;

/**
 * Created by ada on 2017/5/16.
 */
public interface RequestObject extends Serializable {

    long time();

    String salt();

}
