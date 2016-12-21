package allen.chen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/allen10")
public class allen11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		out = response.getWriter();
		
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");
		Integer num = (Integer)session.getAttribute("lotto");
		myCart cart = (myCart)session.getAttribute("myCart");
		if(name==null){
			response.sendRedirect("allen10");
			return;
		}
		out.println("<h1>allen11</h1><hr/>");
		out.println(name + " : " + num + "<hr/>");
		
		cart.addMap("apple", 10);
		cart.addMap("pen", 50);
		out.println("<a href='allen12'>go to allen12</a>");
	}


}
