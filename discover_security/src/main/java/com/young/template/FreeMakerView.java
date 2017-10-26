package com.young.template;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMakerView {

	public static void main(String[] args) throws IOException {
		Locale locale=Locale.getDefault();
		System.out.println(locale.getCountry());
		System.out.println(locale.getLanguage());
		
		Configuration config=new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
	        
//		File baseDir=new File("");
//		TemplateLoader templateLoader=new FileTemplateLoader(baseDir);
//		config.setTemplateLoader(templateLoader);
		Template template=new Template("1", "hi${user}", config);
		template=new Template("1", "hi${user}", config);
		Writer out=new StringWriter();
		HashMap<String, Object> dataModel = new HashMap<String, Object>();
		dataModel.put("user", "ada ");
		try {
			template.process(dataModel, out);
			System.out.println(out.toString());
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
