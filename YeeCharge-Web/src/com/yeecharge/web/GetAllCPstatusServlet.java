package com.yeecharge.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.yeecharge.domain.CPsStatus;
import com.yeecharge.factory.BasicFactory;
import com.yeecharge.service.CPService;

/**
 * 功能描述：从充电桩监测表中获取详细监测数据，组织成json格式返回给Ajax调用端
 * 
 * json格式举例：
 * 	var jsonPoints ={'dev1':{lon:108.999559,lat:34.260793},
					'dev2':{lon:108.997071,lat:34.259551},
					'dev3':{lon:108.998369,lat:34.259667},
					'dev4':{lon:108.997812,lat:34.259737},
					'dev5':{lon:108.999923,lat:34.259394},
					'dev6':{lon:108.997228,lat:34.260886},
					'dev7':{lon:108.997479,lat:34.259913},
					'dev8':{lon:108.9973,lat:34.259931},
					'dev9':{lon:108.999033,lat:34.259491},
					'dev10':{lon:108.997102,lat:34.259924}
		}
 * @author llj
 *
 */
public class GetAllCPstatusServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CPService service = BasicFactory.getFactory().getService(CPService.class);
		
		
		//1.向数据库中请求status_count表和cp_info表的连接查询数据
		List<CPsStatus> list = service.getCurrentCpStatus();
		
		//2.将数据组织成json格式
		JSONArray jsonData = JSONArray.fromObject(list.toArray());
		System.out.println(jsonData.toString());

		//3.json形式的数据返回给ajax调用端 
		response.getWriter().write(jsonData.toString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
