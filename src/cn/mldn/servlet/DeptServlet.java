package cn.mldn.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/DeptServlet/*")
public class DeptServlet extends HttpServlet {
	public void add(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("增加部门数据");
		
	}
	public void edit(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("修改部门数据");
		
	}
	public void delete(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("删除部门数据");
		
	}
	public void list(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("列出部门数据");
		
	}
      @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  String uri=request.getRequestURI();
    	  String methodName=uri.substring(uri.lastIndexOf("/")+1);//根据地址取得要反射调用 的方法名称
		try {
		    Method method = this.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this,request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.doPost(request, response);
    }
}
