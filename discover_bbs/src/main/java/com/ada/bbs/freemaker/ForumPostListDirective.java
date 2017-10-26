package com.ada.bbs.freemaker;

import com.ada.bbs.data.entity.ForumPost;
import com.ada.bbs.data.service.ForumPostService;
import com.ada.common.freemarker.ListDirective;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.user.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ada on 2017/7/1.
 */
public class ForumPostListDirective extends ListDirective<ForumPost> {
    @Override
    public List<ForumPost> list() {
        List<Filter> filters = ListUtils.list(Filter.ge("forum.id",getInt("forum")));
        List<Order> orders=ListUtils.list(Order.desc(getString("order","id")));
        return postService.list(0, getInt("size"),filters,orders );
    }
    @Autowired
    ForumPostService postService;
}
