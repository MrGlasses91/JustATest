package Testing;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class ParamMap {
	HttpServletRequest request;
	Map<String, String[]> params; 
	
	public ParamMap(HttpServletRequest request) {
		this.request = request;
		params = request.getParameterMap();
		for(String p : params.keySet()) {
			System.out.println(p);
		}
	}
	
	public boolean containsKey(String key) {
		Set<String> keys = params.keySet(); 
		for(String s : keys) {
			if(s.equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	public String[] getValueSet(String key) {
		if(params.get(key) != null) {
			return params.get(key);
		}else {
			return null;
		}
	}
	
	public String getFirstValue(String key) {
		System.out.println(params.get(key)[0]);
		if(params.get(key) != null) {
			return params.get(key)[0];
		}else {
			return null;
		}
	}
}
