package cn.appsys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.appsys.pojo.User;
import cn.appsys.tools.Constants;
	/*
	 * 自定义拦截器
	 *
	 *
	 */
	public class SysInterceptor extends HandlerInterceptorAdapter{
		private final static Logger log = Logger.getLogger(SysInterceptor.class);
		
		public boolean preHandler(HttpServletRequest request,
				HttpServletResponse response,
				Object handler) throws Exception{
			log.debug("SysInterceptor  preHandler=================>");
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.USER_SESSION);
			if(user == null){
				response.sendRedirect(request.getContextPath()+"/jsp/error.jsp");
				return false;
			}
			return true;
		}
	}
