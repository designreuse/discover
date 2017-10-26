package com.ada.imake;

import com.ada.data.entity.CatalogEntity;
import com.ada.data.entity.VersionEntity;
import com.ada.imake.command.*;
import com.ada.imake.template.hibernate.TemplateHibernateDir;
import com.ada.imake.templates.ace.TemplateAceDir;
import org.apache.commons.chain.Chain;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ChainBase;
import org.apache.commons.chain.impl.ContextBase;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class ChainMake {

	private Logger logger= LoggerFactory.getLogger("imake");

	private File view;

	private boolean isAction = true;
	private boolean isDao = true;
	private boolean isService = true;
	private boolean isView = true;
	private boolean isSo = true;

	/**
	 * 菜单编号
	 */
	private String menus;


	private Class<?> dir;
	
	private Class<?> codeDir;


	public ChainMake(Class<?> dir,Class<?> codeDir) {
		super();
		this.dir = dir;
		this.codeDir=codeDir;
	}

	public ChainMake() {
		super();
		this.dir = TemplateAceDir.class;
		this.codeDir=TemplateHibernateDir.class;
	}

	public boolean isAction() {
		return isAction;
	}

	public void setAction(boolean isAction) {
		this.isAction = isAction;
	}

	public boolean isDao() {
		return isDao;
	}

	public void setDao(boolean isDao) {
		this.isDao = isDao;
	}

	public boolean isService() {
		return isService;
	}

	public void setService(boolean isService) {
		this.isService = isService;
	}

	public boolean isView() {
		return isView;
	}

	public void setView(boolean isView) {
		this.isView = isView;
	}

	public void setSo(boolean isSo) {
		this.isSo = isSo;
	}


	public File getView() {
		return view;
	}

	public void setView(File view) {
		this.view = view;
	}

	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void make(Class<?> entity) {
		// TODO Auto-generated method stub
		Chain chain = new ChainBase();
		chain.addCommand(new DaoCommand());
		chain.addCommand(new ManagerCommand());
		chain.addCommand(new SoCommand());
		chain.addCommand(new ActionCommand());
		chain.addCommand(new PageCommand());

		try {
			Context contex = makeContext(entity);
			chain.execute(contex);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getMenus() {
		return menus;
	}

	public void setMenus(String menus) {
		this.menus = menus;
	}

	@SuppressWarnings("unchecked")
	private Context makeContext(Class<?> entity) {
		Context contex = new ContextBase();
		contex.put("entity", entity);
		contex.put("action", action);
		URL entityUrl=entity.getResource(".");
		if (entityUrl!=null){
			File entityPath = new File(entityUrl.getFile());
			contex.put("basedir", entityPath.getParentFile());
		}else{
			logger.info("实体路径不存在");
		}
		contex.put("config_entity", entity.getSimpleName().toLowerCase());
		contex.put("view", view);
		contex.put("isAction", isAction);
		contex.put("isDao", isDao);
		contex.put("isService", isService);
		contex.put("isView", isView);
		contex.put("isSo", isSo);
		contex.put("dir", dir);
		contex.put("menus", menus);
		contex.put("codeDir", codeDir);


		Class<?> b = CatalogEntity.class;
		if (entity.getSuperclass().equals(b)) {
			contex.put("catalog", true);
		} else {
			contex.put("catalog", false);
		}
		Class<?> VersionEntity = VersionEntity.class;
		if (entity.getSuperclass().equals(VersionEntity)) {
			contex.put("versionentity", true);
		} else {
			contex.put("versionentity", false);
		}
        String entityPackage = entity.getName();
        String lastpackage = entityPackage.substring(0, entityPackage.lastIndexOf("."));
        String packageBase = entityPackage.substring(0, lastpackage.lastIndexOf("."));
		contex.put("dao_p",packageBase +".dao");
		contex.put("manager_p", packageBase +".service");
		contex.put("page_p", packageBase+ ".page");
		contex.put("so_p", packageBase+ ".so");

		Set<Field> files = ReflectionUtils.getAllFields(entity);
		for (Field field : files) {
			Id id = field.getAnnotation(Id.class);
			if (id != null) {
				contex.put("id", field.getType());
			}
		}
		return contex;
	}

	public void makes(String packagestr) {

		Reflections reflections = new Reflections(packagestr);
		Set<Class<?>> ss = reflections.getTypesAnnotatedWith(Entity.class);
		for (Class<?> class1 : ss) {
			make(class1);
		}

	}

	public void makes(Class<?>... entitys) {

		for (Class<?> entity : entitys) {
			make(entity);

		}
	}

	public void makes(List<Class<?>> entitys) {

		for (Class<?> entity : entitys) {

			make(entity);
		}
	}
}
