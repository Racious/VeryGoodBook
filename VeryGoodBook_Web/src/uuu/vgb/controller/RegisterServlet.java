package uuu.vgb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.DataInvalidException;
import uuu.vgb.entity.DuplicateKeyException;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<String> errors = new ArrayList<String>();

		// 1.取得request的form data,並檢查

		// required fields:
		// 註冊畫面request的form data 有中文 進行中文編碼處理
		//若在request.getParameter有中文，需在之前先加上編碼處理
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		// optional fields:
		String phone = request.getParameter("phone");
		String married = request.getParameter("married");
		String address = request.getParameter("address");
		// 驗證碼
		String capture = request.getParameter("capture");
		

		if (id == null || id.length() == 0) {
			errors.add("必須輸入帳號");
		}
		if (name == null || name.length() == 0) {
			errors.add("必須輸入姓名");
		}
		if (password1 == null || password1.length() == 0 || !(password1.equals(password2))) {
			errors.add("密碼及確認密碼未一致");
		}
		if (gender == null || gender.charAt(0) != Customer.FEMALE && gender.charAt(0) != Customer.MALE) {
			errors.add("必須輸入正確性別");
		}
		if (email == null || email.length() == 0) {
			errors.add("必須輸入電子信箱");
		}
		if (birthday == null || birthday.length() == 0) {
			errors.add("必須輸入出生日期");
		}
		if (capture == null || (capture = capture.trim()).length() == 0) {
			errors.add("必須輸入驗證碼");
		} else {
			// TODO session
			if (session != null && capture.equalsIgnoreCase((String) session.getAttribute("captcha"))) {
				session.removeAttribute("capture");
			} else {
				errors.add("驗證碼輸入錯誤");
			}

		}
		if (errors.isEmpty()) {
			try {

				Customer c = new Customer();
				c.setId(id);
				c.setName(name);
				c.setPassword(password1);
				c.setGender(gender.charAt(0));
				c.setEmail(email);
				c.setBirthday(LocalDate.parse(birthday));
				c.setPhone(phone);
				c.setAddress(address);
				c.setMarried(married != null);

				CustomerService service = new CustomerService();
				service.register(c);

				// 3-1 顯示成功註冊html
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");

				// 若未在getWriter前設定編碼 將會預設ISO8859 西歐字母
				// getWriter()取得文字串流 輸出HTML
				// getOutputStream() 輸出位元資料 例如圖檔
				try (PrintWriter out = response.getWriter();) {
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<head>" + "<title>註冊成功</title>" + "<meta http-equiv='refresh' content=\'5; url=/vgb'/>"
							+ "</head>");
					out.println("<style>");
					out.println("h1{color:blue;}");
					out.println("</style>");
					out.println("<body>");
					out.println("<h1>註冊成功，" + c.getName() + "您好</h1>");
					out.println("<a href='/vgb/'>首頁</a>");
					out.println("</body>");
					out.println("</html>");
				}
				return;
				// 錯誤處理 沒有Compiler提醒的 子類別比父類別優先做
				// 註冊 預防主鍵值重複的錯誤處理
			} catch (DuplicateKeyException e) {
				// this.log("註冊失敗", e); 使用者的錯 可不用通知系統管理員
				errors.add(e.getMessage());
				// 其他資料庫的錯 ex:資料庫有錯 需聯絡系統管理員
			} catch (VGBException e) {
				// 給系統管理員看的
				this.log("註冊失敗-發生非預期錯誤", e);
				// 給使用者看的
				errors.add(e.getMessage() + "請聯絡系統管理員");
				// 資料輸入不符合格式
			} catch (DataInvalidException e) {
				// 給使用者看
				errors.add(e.getMessage());
			} catch (Exception e) {
				// 給系統管理員看的
				this.log("註冊失敗-發生非預期錯誤", e);
				// 給使用者看
				errors.add("註冊失敗-發生非預期錯誤" + e);
			}

		}
		// 3-2 顯示註冊失敗html
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try (PrintWriter out = response.getWriter();) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head><title>註冊失敗</title></head>");
			out.println("<style>");
			out.println("p{color:red;}");
			out.println("</style>");
			out.println("<body>");
			out.println("<h1>註冊失敗</h1>");
			out.println("<p>" + errors.toString() + "</p>");
			out.println("<input type='button' value='回上一頁' onClick='history.back()'>");
			out.println("</style>");
			out.println("</html>");
		}

	}

}
// id, password, name, gender, email, birthday, phone, address, married