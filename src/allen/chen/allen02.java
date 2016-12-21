package allen.chen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/allen02")
public class allen02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		
		String imgPath = getServletContext().getInitParameter("img-path"); 
		File filePath = new File(imgPath,"bg.jpg");
		
		BufferedImage buf = ImageIO.read(filePath);
		Graphics2D g2d = buf.createGraphics();
		
		Font fon = new Font(null, Font.BOLD+Font.ITALIC, 36);
		
		AffineTransform aff = new AffineTransform();
		aff.rotate(Math.toRadians(-60), 0, 100);
		Font newfon = fon.deriveFont(aff);
		
		g2d.setFont(newfon);
		g2d.setColor(Color.DARK_GRAY);
		g2d.drawString("Come baby", 200, 200);
		
		g2d.setFont(fon);
		g2d.setColor(Color.CYAN);
		g2d.drawString("Come on", 200, 200);
		
		OutputStream out = response.getOutputStream();
		ImageIO.write(buf, "jpeg", out);
		out.close();
		
	}

	

}
