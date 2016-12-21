package allen.chen;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/allen03")
public class allen03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			
			Cookie cook1 = new Cookie("name", "allen");
			cook1.setMaxAge(60*5);
			response.addCookie(cook1);
			
			Cookie cook2 = new Cookie("password", "123456");
			cook2.setMaxAge(60*5);
			response.addCookie(cook2);
	}



}
