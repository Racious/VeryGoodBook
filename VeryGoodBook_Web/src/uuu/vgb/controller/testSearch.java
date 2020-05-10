package uuu.vgb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.testproduct;
import uuu.vgb.service.CustomerService;

/**
 * Servlet implementation class testSearch
 */
@WebServlet("/testSearch.do")
public class testSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errors= new ArrayList<String>();
		request.setCharacterEncoding("UTF-8");
		String search =request.getParameter("search");
		CustomerService service=new CustomerService();
		List<testproduct> tp = new ArrayList<testproduct>();
		try {
			tp=service.search(search);
			//將查詢結果存起來
			request.setAttribute("testproduct",tp);
			request.getRequestDispatcher("test2.jsp").forward(request, response);
			
		} catch (VGBException e) {
			// TODO Auto-generated catch block
			errors.add(e.getMessage());
		} 
		
		//* 3-2. 顯示登入失敗的html內容 
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try (PrintWriter out = response.getWriter();){
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head><title>查詢結果</title></head>");
			out.println("<style>");
			out.println("p{color:red;}");
			out.println("</style>");
			out.println("<body>");
			out.println("<h1>查詢結果</h1>");
			out.println("<p>"+errors.toString()+"</p>");
			out.println("<input type='button' value='回上一頁' onClick='history.back()'>");
			out.println("</style>");
			out.println("</html>");
		}
		
	}

}
