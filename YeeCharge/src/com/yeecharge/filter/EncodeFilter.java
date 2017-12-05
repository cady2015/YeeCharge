package com.yeecharge.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodeFilter implements Filter {
	private FilterConfig config = null;
	private String encode = null; 
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html;charset="+encode);
		request.setCharacterEncoding(encode);
		chain.doFilter(new MyHttpServletRequest( (HttpServletRequest)request), response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
		encode = config.getInitParameter("encode")==null
					? "utf-8":config.getInitParameter("encode");
	}


	/**
	 * 内部类 MyHttpServletRequest
	 * @author dxf
	 *
	 */
	class MyHttpServletRequest extends HttpServletRequestWrapper{
		
		private HttpServletRequest request = null;
		private boolean isNotEncode = true;
		public MyHttpServletRequest(HttpServletRequest request) {
			super(request);
			this.request = request;
		}
		
		
		@Override
		public String getParameter(String name) {
			return getParameterValues(name) == null ? null:getParameterValues(name)[0];
		}
		
		@Override
		public String[] getParameterValues(String name) {
			return (String[]) getParameterMap().get(name);
		}
		@Override
		public Map<String, String[]> getParameterMap() {
			try {
				if(request.getMethod().equalsIgnoreCase("POST")){//--如果是post方式提交，一行代码解决所有乱码
					request.setCharacterEncoding(encode);
					return request.getParameterMap();
				}else if(request.getMethod().equalsIgnoreCase("GET")){//--如果是get方式提交，则手动编解码后返回
					Map<String, String[]> map = request.getParameterMap();
				//---解决缓存map带来的再一次乱码--设定一个标记 
					// 第一次访问的map会先缓存起来，第二次调用时不是再一次从request请求中获取，而是直接从缓存中获取
					if(isNotEncode){ 
						for(Map.Entry<String, String[]> entry : map.entrySet()){
							String [] vs = entry.getValue();
							for(int i=0;i<vs.length;i++){
								vs[i] = new String(vs[i].getBytes("iso8859-1"),encode);
							}
						}
						isNotEncode = false;
					}
					return map;
				}else{
					return request.getParameterMap();
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		
	}
}
