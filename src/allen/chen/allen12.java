package allen.chen;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/allen10")
public class allen12 extends HttpServlet {
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
		out.println("<h1>allen12</h1><hr/>");
		out.println(name + " : " + num + "<hr/>");
		
		HashMap<String,Integer> temp = cart.getMap();
		Set<String> buySets = temp.keySet();
		for(String buySet : buySets){
			out.println(buySet + ":" + temp.get(buySet) +" <br/> ");
		}
		out.println("<a href='allen13'>go to allen13</a>");
	}


}
