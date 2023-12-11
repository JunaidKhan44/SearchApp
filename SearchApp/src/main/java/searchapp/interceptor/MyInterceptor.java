/**
 * 
 */
package searchapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Junaid Khan
 *
 */

//public class MyInterceptor implements HandlerInterceptor{
//if u use this you must override its all method to prevent this use Adapter class

public class MyInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("this is pre-Handler::");
		
		String name=request.getParameter("user");
		if(name.startsWith("j")) {
			response.setContentType("text/hml");
			response.getWriter().println("Name not start with j");
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Post is called,,,");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("completion is called,,,");
		super.afterCompletion(request, response, handler, ex);
	}

	//question how to create generic interceptor
	
	
	
	
	
	
}
