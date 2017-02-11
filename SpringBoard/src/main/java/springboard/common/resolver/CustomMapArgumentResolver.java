package springboard.common.resolver;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import springboard.common.common.CommonMap;

public class CustomMapArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return CommonMap.class.isAssignableFrom(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		CommonMap commonMap = new CommonMap();
		
		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		Enumeration<?> enumberation = request.getParameterNames();
		
		String key = null;
		String[] values = null;
		
		while (enumberation.hasMoreElements()) {
			key = (String)enumberation.nextElement();
			values = request.getParameterValues(key);
			
			if (key != null && values != null) {
				if (values.length > 1) {
					List<Object> list = new ArrayList<Object>(); 
					
					for (int i = 0; i < values.length; i++) {
						list.add(values[i]);
					}
					commonMap.put(key, list);
				} else {					
					commonMap.put(key, values[0]);					
				}
			}
		}
		
		return commonMap;
	}
}
