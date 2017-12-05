package com.yeecharge.web;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.yeecharge.domain.Product;
import com.yeecharge.factory.BasicFactory;
import com.yeecharge.service.ProdService;
import com.yeecharge.util.IOUtils;
import com.yeecharge.util.PicUtils;

public class AddProdServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProdService service = BasicFactory.getFactory().getService(ProdService.class);
		try {
			//servletContext---代表当前整个web应用
			String encode = this.getServletContext().getInitParameter("encode");
			//--用来存储product相关的请求参数
			Map<String, String> paramMap = new HashMap<String,String>();
			//1.上传图片
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024*100);
			factory.setRepository(new File(this.getServletContext().getRealPath("WEB-INF/temp")));
			
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			fileUpload.setHeaderEncoding(encode);
			fileUpload.setFileSizeMax(1024*1024*1);
			fileUpload.setSizeMax(1024*1024*10);
			
			if(!fileUpload.isMultipartContent(request)){
				throw new RuntimeException("请使用正确的表单上传！");
			}
	
			List<FileItem> list = fileUpload.parseRequest(request);
			if(list!=null){
				for(FileItem item :list){
					if(item.isFormField()){//普通字段
						String name = item.getFieldName();
						String value = item.getString("utf-8");
						paramMap.put(name, value);
					}else{//文件上传项
						String realname = item.getName();
						String uuidname = UUID.randomUUID().toString()+"_"+realname;
						//--分目录存储	
						String hash = Integer.toHexString(uuidname.hashCode());
						String upload = this.getServletContext().getRealPath("WEB-INF/upload");
						String imgurl = "/WEB-INF/upload";
						for(char c :hash.toCharArray()){
							upload += "/"+c;
							imgurl += "/"+c;
						}
						//为prod bean中添加图片文件存储路径
						imgurl +="/"+uuidname;
						paramMap.put("imgurl", imgurl);
						
						File uploadFile = new File(upload);
						if(!uploadFile.exists()){
							uploadFile.mkdirs();
						}
						InputStream in = item.getInputStream();
						OutputStream out = new FileOutputStream(new File(upload,uuidname));
						
						IOUtils.In2Out(in, out);
						IOUtils.close(in, out);
						
						item.delete();
						
						//--图片上传后，生成缩略图并存放到相同路径下，增加_s尾名
						PicUtils picu = new PicUtils(this.getServletContext().getRealPath(imgurl));
						picu.resizeByHeight(140);
					}
				}
			}
			
			//2.调用service中提供的方法在数据库中添加商品
			Product prod = new Product();
			BeanUtils.populate(prod, paramMap);
			service.addProd(prod);
			
			//3.提示成功！回到主页
			response.getWriter().write("添加成功！3秒后回到主页...");
			response.setHeader("Refresh", "3;url=/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
