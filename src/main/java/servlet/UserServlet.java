package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.Users;
import service.UsersService;
import serviceimpl.UsersServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    UsersService us = new UsersServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String opr = request.getParameter("opr");
		if(opr==null||opr.equals("login")) {
			userslogin(request, response);
		}
		
		
		out.flush();
		out.close();
		
	}
	
	public void userslogin(HttpServletRequest request, HttpServletResponse response)throws IOException {
	PrintWriter out = response.getWriter();
	String username = request.getParameter("username");
	String password = request.getParameter("user_password");  
		  
		  String json = "{\"key\":\"ok\"}";
		  Users users = us.userlogin(username, password);
		  if(users==null) {
			 json = "{\"key\":\"no\"}";
		  }
		 request.getSession().setAttribute("user", users);
		  
		  out.print(json);
		  out.flush();
		  out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
