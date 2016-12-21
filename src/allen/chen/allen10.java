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
public class allen10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PrintWriter out;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		out = response.getWriter();
		
		out.println("<h1>allen10</h1><hr>");
		
		int lotto = (int)(Math.random()*49) + 1 ;
		out.print("lotto:" + lotto + "<br/>");
		
		HttpSession session = request.getSession();
		session.setAttribute("name", "allen");
		session.setAttribute("lotto",lotto );
		myCart cart = new myCart("brad");
		session.setAttribute("myCart", cart);
		
		out.println("<a href='allen11'>go to allen11</a>");
		
		
	}


}
