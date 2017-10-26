package com.ada.area.api;

import com.ada.area.domain.request.AreaListRequest;
import com.ada.area.domain.request.AreaTypeRequest;
import com.ada.area.domain.response.list.AreaList;

public interface AreaHandler {

    /**
     * 根据id查找下一层数据
     *
     * @param request
     * @return
     */
    AreaList list(AreaListRequest request);


    AreaList type(AreaTypeRequest request);


}
