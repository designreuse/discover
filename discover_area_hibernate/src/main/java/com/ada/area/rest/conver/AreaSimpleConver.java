package com.ada.area.rest.conver;

import com.ada.area.data.entity.Area;
import com.ada.area.domain.response.simple.AreaSimple;
import com.ada.data.rest.core.Conver;

public class AreaSimpleConver implements Conver<AreaSimple,Area> {
    @Override
    public AreaSimple conver(Area source) {
        AreaSimple result=new AreaSimple();
        result.setId(source.getId());
        result.setPid(source.getParentId());
        result.setName(source.getName());
        result.setType(source.getType());
        result.setCode(source.getCode());
        return result;
    }
}
