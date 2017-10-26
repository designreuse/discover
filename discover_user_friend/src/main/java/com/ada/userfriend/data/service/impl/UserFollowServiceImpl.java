package com.ada.userfriend.data.service.impl;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.user.data.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.userfriend.data.dao.UserFollowDao;
import com.ada.userfriend.data.entity.UserFollow;
import com.ada.userfriend.data.service.UserFollowService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年09月01日10:05:18.
*/


@Scope("prototype")
@Service
@Transactional
public class UserFollowServiceImpl implements UserFollowService {

	private UserFollowDao dao;


	@Override
	@Transactional(readOnly = true)
	public UserFollow findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public UserFollow save(UserFollow bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public UserFollow update(UserFollow bean) {
		Updater<UserFollow> updater = new Updater<UserFollow>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public UserFollow deleteById(Long id) {
		UserFollow bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public UserFollow[] deleteByIds(Long[] ids) {
		UserFollow[] beans = new UserFollow[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(UserFollowDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<UserFollow> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<UserFollow> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<UserFollow> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

	@Override
	public UserFollow follow(UserFollow bean) {
		UserFollow result=null;
		Finder finder = Finder.create();
		finder.append("from UserFollow u where u.userInfo.id=:userid");
		finder.setParam("userid", bean.getUser().getId());
		finder.append(" and u.follower.id=:followerid");
		finder.setParam("followerid", bean.getFollower().getId());
		List list=	dao.find(finder);
		if(list!=null&&list.size()>0){
			result=new UserFollow();
			result.setId(-1l);
		}else{
			result=dao.save(bean);
		}

		return result;
	}

	@Override
	public UserFollow unFollow(UserFollow bean) {
		UserFollow result = new UserFollow();
		dao.deleteById(bean.getId());
		result.setId(-1l);
		return result;
	}

	@Override
	public UserFollow follow(long userid, long followid) {
		if(userid==followid){
			UserFollow f=new UserFollow();
			f.setId(-2l);
			return f;
		}
		UserFollow result=null;
		Finder finder = Finder.create();
		finder.append("from UserFollow u where u.userInfo.id=:userid");
		finder.setParam("userid", userid);
		finder.append(" and u.follower.id=:followerid");
		finder.setParam("followerid", followid);
		List list=	dao.find(finder);
		if(list!=null&&list.size()>0){
			result=new UserFollow();
			result.setId(-1l);
		}else{
			UserFollow bean=new UserFollow();
			bean.setUser(UserInfo.fromId(userid));
			bean.setFollower(UserInfo.fromId(followid));
			result=dao.save(bean);
		}

		return result;
	}

	@Override
	public UserFollow unFollow(long userid, long followid) {
		Finder finder = Finder.create();
		finder.append("from UserFollow u where u.userInfo.id=:userid");
		finder.setParam("userid", userid);
		finder.append(" and u.follower.id=:followerid");
		finder.setParam("followerid", followid);
		List<UserFollow> list=	dao.find(finder);
		UserFollow result=new UserFollow();
		if(list!=null&&list.size()>0){
			dao.delete(list.get(0));
			result.setId(1l);
		}else{
			result.setId(-1l);

		}
		return result;
	}


	@Override
	public UserFollow remove(UserFollow bean) {
		UserFollow result = new UserFollow();
		Finder finder = Finder.create();
		finder.append("from UserFollow f where f.user.id=:userid");
		finder.setParam("userid", bean.getUser().getId());
		finder.append(" and  f.friend.id=:friendid ");
		finder.setParam("friendid", bean.getFollower().getId());
		List<UserFollow> follows = dao.find(finder);
		if (follows != null && follows.size() > 0) {
			dao.delete(follows.get(0));
			result.setId(1l);
			return null;
		} else {
			result.setId(-1l);
		}
		return result;
	}
}