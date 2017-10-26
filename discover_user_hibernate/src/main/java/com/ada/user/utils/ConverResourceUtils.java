package com.ada.user.utils;

import com.ada.data.core.Pagination;
import com.ada.data.page.Page;
import com.ada.data.rest.core.Conver;
import com.ada.discover.rest.base.ResponseList;
import com.ada.discover.rest.base.ResponsePage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ada on 2017/5/23.
 */
public class ConverResourceUtils {

    public ConverResourceUtils() {
    }


    public static <R, S> void cover(ResponsePage<R> result, Page<S> pager) {
        result.setNo(pager.getPageNumber());
        result.setSize(pager.getPageSize());
        result.setTotal((int)pager.getTotal());
        result.setTotalPage(pager.getTotalPages());
    }
    public static <R, S> void cover(ResponsePage<R> result, Pagination<S> pager) {
        result.setNo(pager.getPageNo());
        result.setSize(pager.getPageSize());
        result.setTotal((int)pager.getTotalCount());
        result.setTotalPage(pager.getTotalPage());
    }
    public static <R, S> ResponsePage<R> coverPage(ResponsePage<R> result, Page<S> pager, Conver<R, S> conver) {
        cover(result, pager);
        List<R> vos = new ArrayList();
        List<S> cs = pager.getContent();
        if(cs != null) {
            for (S item:cs){
                vos.add(conver.conver(item));

            }
        }
        result.setList(vos);
        return result;
    }
    public static <R, S> ResponsePage<R> coverPage(ResponsePage<R> result, Pagination<S> pager, Conver<R, S> conver) {
        cover(result, pager);
        List<R> vos = new ArrayList();
        List<S> cs = pager.getList();
        if(cs != null) {
            for (S item:cs){
                vos.add(conver.conver(item));

            }
        }
        result.setList(vos);
        return result;
    }
    public static <R, S> ResponseList<R> coverList(ResponseList<R> result, Page<S> pager, Conver<R, S> conver) {
        List<R> vos = new ArrayList();
        List<S> cs = pager.getContent();
        if(cs != null) {
            for (S item:cs){
                vos.add(conver.conver(item));
            }
        }
        result.setList(vos);
        return result;
    }

    public static <R, S> List<R> coverList(List<S> source, Conver<R, S> conver) {
        List<R> vos = new ArrayList();
        if(source != null) {
            for (S item:source){
                vos.add(conver.conver(item));
            }
        }

        return vos;
    }

    public static <R, S> List<R> coverCollect(Collection<S> source, Conver<R, S> conver) {
        List<R> vos = new ArrayList();
        if(source != null) {
            for (S item:source){
                vos.add(conver.conver(item));
            }
        }
        return vos;
    }
}
