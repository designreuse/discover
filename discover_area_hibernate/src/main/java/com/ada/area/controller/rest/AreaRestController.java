package com.ada.area.controller.rest;


import com.ada.area.api.AreaHandler;
import com.ada.area.domain.request.AreaListRequest;
import com.ada.area.domain.request.AreaTypeRequest;
import com.ada.area.domain.response.list.AreaList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest")
public class AreaRestController {


    @RequestMapping(value = "/area/list")
    public AreaList list(AreaListRequest request) {
        return hander.list(request);
    }

    @RequestMapping(value = "/area/type")
    public AreaList type(AreaTypeRequest request) {
        return hander.type(request);
    }

    @Autowired
    private AreaHandler hander;
}
