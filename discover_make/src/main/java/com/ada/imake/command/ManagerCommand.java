package com.ada.imake.command;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManagerCommand implements Command {


	private Logger logger = LoggerFactory.getLogger(getClass());

	public boolean execute(Context context) throws Exception {
		boolean isService=(Boolean) context.get("isService");
		if (!isService) {
			return false;
		}
		logger.info("Manager接口和实现生成");
		logger.info("Dao接口和实现生成");
		Class<?> codedir=(Class<?>) context.get("codeDir");

		ClassTemplateLoader ctl = new ClassTemplateLoader(codedir, "/"+codedir.getName().replace(codedir.getSimpleName(),"").replace(".","/"));
		//String fieldir = codedir.getResource(".").getFile();
		// String dao=TemplateDir.class.getResource("dao.txt").getFile();
		// String
		// daoimpl=TemplateDir.class.getResource("dao_impl.txt").getFile();

		Configuration config = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);

		config.setTemplateLoader(ctl);
		Template template = config.getTemplate("manager.ftl");
		try {
			File basedir = (File) context.get("basedir");
			if (basedir==null){
				logger.info("不能生成服务代码，实体不存在");
				return false;
			}
			File dir = new File(basedir.getAbsolutePath().replace("\\target\\classes", "\\src\\main\\java"));
			File daodir = new File(dir, "service");
			// \src\main\java
			// D:\workspace\imakedemo\target\classes\com\ada\imakedemo\data
			if (!daodir.exists()) {
				daodir.mkdirs();
			}
			Class<?> entity = (Class<?>) context.get("entity");

			
			
			File daodirfile = new File(daodir, entity.getSimpleName() + "Service.java");

			FileWriter writer = new FileWriter(daodirfile);

			template.process(context, writer);
			
			
			Template templateimpl = config.getTemplate("manager_impl.ftl");
			File daodirimple = new File(daodir, "impl");
			if (!daodirimple.exists()) {
				daodirimple.mkdirs();
			}
			File daodirimplefile = new File(daodirimple, entity.getSimpleName() + "ServiceImpl.java");

			FileWriter implewriter = new FileWriter(daodirimplefile);
			templateimpl.process(context, implewriter);
			logger.info("Dao接口和实现生成完成");
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
