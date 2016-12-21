package allen.chen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/allen03")
public class allen04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PrintWriter out ;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			
			Cookie [] cookies = request.getCookies();
			if(cookies!=null){
				for(Cookie cookie : cookies){
					String name = cookie.getName();
					String value = cookie.getValue();
					out.println(name + " : " + value + "<br/>" );
				}
			}
			
	}



}
