package com.young.template.freemarker;

import java.util.Map;

import com.young.template.View;

import freemarker.template.Template;

public class FreeMarkerView implements View{

	@Override
	public String render(Map<String, ?> model) {
		Template template=Template.getPlainTextTemplate(null, "hi", null);
		return null;
	}

}
