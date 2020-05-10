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
import javax.servlet.http.HttpSession;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login.do", urlPatterns = { "/login.do" })
//http://localhost:8082/vgb/login.do 假網址需從/寫起
//Servlet 伺服器上執行的原件，HttpServlet產生http的請求與回應
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 *@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errors= new ArrayList<String>();
		//* 1. 讀取request中的form data並檢查 (表單中name屬性)
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String capture=request.getParameter("capture");
		HttpSession session = request.getSession(false);

		if(id==null || (id=id.trim()).length()==0){
			errors.add("必須輸入帳號");
		}

		if(password==null || password.length()==0){
			errors.add("必須輸入密碼");
		}
		if(capture ==null || (capture=capture.trim()).length()==0){
			errors.add("必須輸入驗證碼");
		}else{
			//* 因型態為Objcet，故將session讀取出來轉型，判斷與輸入的驗證碼是否相符
			if(session != null && capture.equalsIgnoreCase((String)session.getAttribute("captcha"))) {
				session.removeAttribute("capture");
			}else {
				errors.add("驗證碼輸入錯誤");
			}
			
		}
		//* 2. 若無錯誤，則呼叫商業邏輯
		if(errors.isEmpty()) {
		CustomerService service=new CustomerService();
		try {
			Customer c=service.login(id, password);
			
		//* 3-1 顯示登入成功的html內容
		// 需先做好回應的樣式與內容
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");

			
			//若未在getWriter前設定編碼 將會預設ISO8859 西歐字母
			//getWriter()取得文字串流 輸出HTML
			//getOutputStream() 輸出位元資料 例如圖檔
			try (PrintWriter out = response.getWriter();){
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>"
						+ "<title>登入成功</title>"
						+ "<meta http-equiv='refresh' content=\'3; url=/vgb'/>"
						+ "</head>");
				out.println("<body>");
				out.println("<h1>登入成功，"+c.getName()+"您好</h1>");
				out.println("<p>"+c.toString()+"</p>");
				out.println("<a href='/vgb/'>首頁</a>");
				out.println("</body>");
				out.println("</html>");
			}
			return;
		} catch (VGBException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			this.log("登入失敗",e);  //for 伺服器端 管理人員的系統訊息
			errors.add(e.getMessage());//for 瀏覽器端使用者的錯誤訊息
		}catch(Exception e){
			this.log("登入失敗-發生非預期的錯誤",e);  //for 伺服器端 管理人員的系統訊息
			errors.add("登入失敗-發生非預期的錯誤: "+e);
		}
	}

		//* 3-2. 顯示登入失敗的html內容 
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");

			try (PrintWriter out = response.getWriter();){
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head><title>登入失敗</title></head>");
				out.println("<style>");
				out.println("p{color:red;}");
				out.println("</style>");
				out.println("<body>");
				out.println("<h1>登入失敗</h1>");
				out.println("<p>"+errors.toString()+"</p>");
				out.println("<input type='button' value='回上一頁' onClick='history.back()'>");
				out.println("</style>");
				out.println("</html>");
			}
		
	}

}
