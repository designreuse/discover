package com.ada.imake.command;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;

public class ActionCommand implements Command {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public boolean execute(Context context) throws Exception {
		boolean isAction=(Boolean) context.get("isAction");
		if (!isAction) {
			return false;
		}
		logger.info("Action接口和实现生成");

		logger.info("Dao接口和实现生成");
		Class<?> codedir=(Class<?>) context.get("codeDir");
		ClassTemplateLoader ctl = new ClassTemplateLoader(codedir, "/"+codedir.getName().replace(codedir.getSimpleName(),"").replace(".","/"));
		Configuration config = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);

		config.setTemplateLoader(ctl);
		Template template = null;
		Boolean catalog = (Boolean) context.get("catalog");
		if (catalog){
			template = config.getTemplate("catalog_action.ftl");
		}else{
			template = config.getTemplate("action.ftl");
		}
		
		Class<?> entity = (Class<?>) context.get("entity");

		String action=(String) context.get("action");
		
		String path = action.replaceAll("\\.", "/");
		System.out.println(path);

		String b=entity.getResource("/").getFile();
		
		b=b.replace("/target/classes", "/src/main/java")+path;
		File actiondir=new File(b);
		if (!actiondir.exists()) {
			actiondir.mkdirs();
		}
		File daodirfile = new File(b, entity.getSimpleName() + "Action.java");

		FileWriter writer = new FileWriter(daodirfile);

		template.process(context, writer);
		
		return false;
	}

}
