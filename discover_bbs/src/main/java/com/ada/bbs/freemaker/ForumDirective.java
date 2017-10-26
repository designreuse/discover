package com.ada.bbs.freemaker;

import com.ada.bbs.data.entity.Forum;
import com.ada.bbs.data.service.ForumService;
import com.ada.common.freemarker.ListDirective;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.user.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by cng19 on 2017/6/26.
 */
public class ForumDirective extends ListDirective<Forum> {


    public List<Forum> list() {
        List<Filter> filters = ListUtils.list(Filter.eq("parent.id", getInt("id")));
        List<Order> orders=ListUtils.list(Order.asc("code"));
        return forumService.list(0, getInt("size"),filters,orders );
    }

    @Autowired
    ForumService forumService;
}
