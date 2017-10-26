package com.young.template;

import java.util.Map;

public interface View {
	
	String render(Map<String, ?> model); 
}
