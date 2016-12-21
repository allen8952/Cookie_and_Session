package allen.chen;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/allen05")
public class allen05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PrintWriter out;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		out = response.getWriter();
		
		Cookie [] cookies = request.getCookies();
		if(cookies!=null){
			HashMap<String,String> cookieMap = new HashMap<>();
			for(Cookie cookie : cookies){
				String name = cookie.getName();
				String value = cookie.getValue();
				cookieMap.put(name,value);
			}if(cookieMap.containsKey("name")&&cookieMap.containsKey("passwd")){
				String name = cookieMap.get("name");
				String passwd = cookieMap.get("passwd");
				
				if(name.equals("iii")&&passwd.equals("11234")){
					request.getRequestDispatcher("allen06").forward(request, response);
					return;
				}
			}
		}
		
		
		
		
		
		
		String name = request.getParameter("name");
		String passwd = request.getParameter("password");
		if(name!=null){
			if(name.equals("iii")&&passwd.equals("11234")){
				String auto = request.getParameter("auto");
				if( auto!=null && auto.equals("press") ){
					
					Cookie cookie1 = new Cookie("name", "iii");
					Cookie cookie2 = new Cookie("passwd", "11234");
					cookie1.setMaxAge(30); cookie2.setMaxAge(30);
					response.addCookie(cookie1); response.addCookie(cookie2);
					
					
				}request.getRequestDispatcher("allen06").forward(request, response);
			}else{out.println("XXXXXX");}
		}
		
		
		outHTML();
	}

	private void outHTML(){
		out.println("<h1>以下為測試測試再測試</h1>");
		out.println("<form>");
		out.println("<input type='text' name='name'  /><br/>");
		out.println("<input type='password' name='password'  /><br/>");
		out.println("<input type='checkbox' name='auto' value='press'  />auto<br/>");
		out.println("<input type='submit' value='Send'  />");
		out.println("</form>");
	}
}
