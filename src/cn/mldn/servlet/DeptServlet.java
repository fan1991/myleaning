package cn.mldn.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mldn.service.IDeptService;
import cn.mldn.util.factory.Factory;
import cn.mldn.vo.Dept;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@SuppressWarnings("serial")
@WebServlet("/DeptServlet/*")
public class DeptServlet extends HttpServlet {
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("*** 【提示信息】部门增加。...");
		Dept vo = new Dept() ;
		vo.setDname(request.getParameter("dname"));
		IDeptService deptService = Factory.getServiceInstance("dept.service");
		try {
			deptService.add(vo) ;
			response.getWriter().println(vo.getDeptno());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("*** 【提示信息】部门修改。...");
		IDeptService deptService = Factory.getServiceInstance("dept.service");
		Dept vo = new Dept() ;
		vo.setDeptno(Integer.parseInt(request.getParameter("deptno")));
		vo.setDname(request.getParameter("dname"));
		try {
			response.getWriter().println(deptService.edit(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("*** 【提示信息】部门删除。...");
		int deptno = Integer.parseInt(request.getParameter("deptno")) ;
		IDeptService deptService = Factory.getServiceInstance("dept.service");
		try {
			response.getWriter().println(deptService.delete(deptno));
		} catch (Exception e){}
	}
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("*** 【提示信息】部门列表。...");
		IDeptService deptService = Factory.getServiceInstance("dept.service");
		try {
			Iterator<Dept> iter = deptService.list().iterator();
			JSONObject obj = new JSONObject();
			JSONArray array = new JSONArray();
			while (iter.hasNext()) {
				array.add(iter.next()) ;
			}
			obj.put("alldepts", array) ;
			response.getWriter().println(obj);
		} catch (Exception e) {

		}
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String methodName = uri.substring(uri.lastIndexOf("/") + 1);
		try {
			Method method = this.getClass().getMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
