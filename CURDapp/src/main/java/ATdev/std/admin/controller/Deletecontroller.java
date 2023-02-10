package ATdev.std.admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;

import ATdev.std.admin.dao.StudentService;
import ATdev.std.admin.daoimpl.StudentServiceImpl;

/**
 * Servlet implementation class Deletecontroller
 */
public class Deletecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String msg=null;
		int stdId=Integer.parseInt(request.getParameter("prodId"));
		StudentService stddao=new StudentServiceImpl();
		stddao.deleteStudent(stdId);
		HttpSession session=request.getSession();
		if(stddao!=null) {
			session.setAttribute("dpprod", stddao);
			msg="Student data Deleted from Database";
			
		}
		session.setAttribute("dstd", msg);
		response.sendRedirect("Delete.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
