package com.ada.ad.freemarker;

import com.ada.ad.data.entity.Ad;
import com.ada.ad.data.service.AdService;
import com.ada.common.freemarker.ListDirective;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.user.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdDirective extends ListDirective<Ad> {

    @Autowired
    private AdService adService;

    @Override
    public List<Ad> list() {
        List<Filter> filters= ListUtils.list(Filter.eq("adPosition.id",getInt("id",-1)));
        List<Order> orders=ListUtils.list(Order.asc("sortNum"));
        return adService.list(0,getInt("size",10),filters,orders);
    }
}
