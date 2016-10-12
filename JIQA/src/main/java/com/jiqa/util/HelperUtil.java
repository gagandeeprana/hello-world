package com.jiqa.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.jiqa.model.Failed;
import com.jiqa.model.Success;

public class HelperUtil {

	public String getErrorJSONString(String code, String message) throws JsonGenerationException, JsonMappingException, IOException {
		Failed error = new Failed(code, message);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(error);
		return json;
	}
	
	public String getSuccessJSONString(String code, String message) throws JsonGenerationException, JsonMappingException, IOException {
		Success success = new Success(code, message);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(success);
		return json;
	}
	
	public boolean checkValue(String val) {
		if(val != null && !"".equalsIgnoreCase(val) && val.length() > 0 && !"null".equalsIgnoreCase(val)) {
			return true;
		}
		return false;
	}
}
