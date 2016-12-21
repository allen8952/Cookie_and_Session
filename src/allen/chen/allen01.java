package allen.chen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/allen01")
public class allen01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		
		String str1 = request.getParameter("rate");
		float rate = Float.parseFloat(str1);
		
		BufferedImage bufim = new BufferedImage(400, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bufim.createGraphics();
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, 400, 20);
		g2d.setColor(Color.blue);
		g2d.fillRect(0, 0, (int)(400*rate/100), 20);
		
		OutputStream out = response.getOutputStream();
		ImageIO.write(bufim, "jpeg", out);
		out.close();
	}

	

}
