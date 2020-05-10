package uuu.vgb.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CaptchaServlet
 */
//@WebServlet("/images/captcha.jpg")
//@WebServlet(name="CaptchaServlet" ,urlPatterns = "/images/captcha.jpg")
//http://localhost:8082/vgb/images/captcha.jpg
public class CaptchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int len = 6;// 驗證碼長度預設為6個字元的大寫英數字
	private int width = 16 * 2 + 12 * len, height = 20;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CaptchaServlet() {
		super();
		System.out.println("CaptchaServlet 建立了一個物件");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init() {
		//初始化需寫在init 利用xml設定檔 宣告init-param (param-name  param-value)
		//如果是註冊畫面 因為設定檔關係此類別才會建立物件，
		String len =this.getInitParameter("length");
		if(len!=null && len.matches("\\d+")) {
			this.len=Integer.parseInt(len);
			//this.width=16 * 2 + 12 * this.len;
		}
	}
	
	private BufferedImage generateImage(String rand, int width, int height) {
		// 開始建立圖片
		BufferedImage image =
				new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics(); // 取得影像繪圖區
		// 畫出背景方塊
		g.setColor(getRandomColor(200, 250)); // 設定繪圖區背景色
		g.fillRect(0, 0, width, height); // 在繪圖區畫個長方型
		// 畫干擾線讓背景雜亂
		Random random = new Random();
		g.setColor(getRandomColor(170, 210));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// 畫出認證文字
		g.setFont(new Font("MV Boli", Font.PLAIN, 18));// 設定字體
		g.setColor(getRandomColor(20, 140));
		// 將認證文字畫到image中
		g.drawString(rand, 16, 16);
		g.dispose();
		return image;
	}
	private Color getRandomColor(int fc, int bc) {
		// 在參數設定的範圍內，隨機產生顏色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO 1.不須讀取request中的資料
		// TODO 2.執行商業邏輯-亂數產生驗證碼字串
		String captcha = "";
		Random random = new Random();
		for (int i = 0; i < len; i++) {
			int data = random.nextInt(36);// 亂數產生0~35任一個整數
			char thechar = (char) (data < 10 ? data + '0' : data - 10 + 'A');
			System.out.println("data->thechar: " + data + "->" + thechar);// 測試用訊息
			captcha += thechar;
		}
		System.out.println("captcha: " + captcha);
		request.getSession().setAttribute("captcha", captcha);

		
		
		// 將captcha字串繪製成圖片
		BufferedImage image = generateImage(captcha, width, height);
		
		// TODO 3.將圖片輸出到http response中
//		response.setHeader("Pragma", "No-cache");
//        response.setHeader("Cache-Control", "no-cache");
//        response.setDateHeader("Expires", 0);

        response.setContentType("image/jpeg");
        //將影像輸出到頁面  影像位元資料getOutputStream()
        try (ServletOutputStream outStream = response.getOutputStream();){      
			//將來源image用指定的格式寫入outStream
            ImageIO.write(image, "JPEG", outStream);

        }


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response) protected void doPost(HttpServletRequest request,
	 *      HttpServletResponse response) throws ServletException, IOException { //
	 *      TODO Auto-generated method stub doGet(request, response); }
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}

}
