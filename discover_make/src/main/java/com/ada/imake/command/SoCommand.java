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

/**
 * Created by ada on 2017/4/12.
 */
public class SoCommand implements Command {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public boolean execute(Context context) throws Exception {

        boolean isSo=(Boolean) context.get("isSo");
        if (!isSo) {
            return false;
        }
        logger.info("So对象生成");
        Class<?> codedir=(Class<?>) context.get("codeDir");

        ClassTemplateLoader ctl = new ClassTemplateLoader(codedir, "/"+codedir.getName().replace(codedir.getSimpleName(),"").replace(".","/"));

        Configuration config = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);

        config.setTemplateLoader(ctl);
        Template template = config.getTemplate("so.ftl");
        try {
            File basedir = (File) context.get("basedir");
            if (basedir==null){
                logger.info("不能生成Dao代码，实体不存在");
                return false;
            }
            File dir = new File(basedir.getAbsolutePath().replace("\\target\\classes", "\\src\\main\\java"));
            File soDir = new File(dir, "so");
            if (!soDir.exists()) {
                soDir.mkdirs();
            }
            Class<?> entity = (Class<?>) context.get("entity");

            File daodirfile = new File(soDir, entity.getSimpleName() + "So.java");
            FileWriter writer = new FileWriter(daodirfile);
            template.process(context, writer);


            logger.info("So对象生成完成");
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
