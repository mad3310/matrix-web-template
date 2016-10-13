package com.le.matrix.template.rest.handler;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionHandlerResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
         /*Map<String, Object> model = new HashMap<String, Object>();
	        model.put("ex", ex);

	        // 根据不同错误转向不同页面
	        if(ex instanceof BusinessException) {
	            return new ModelAndView("error-business", model);
	        }else if(ex instanceof ParameterException) {
	            return new ModelAndView("error-parameter", model);
	        } else {
	            return new ModelAndView("error", model);
	        }*/
        return null;
    }

}
