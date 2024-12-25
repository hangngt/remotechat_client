package utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class ScreenCapture {
	private BufferedImage screenFullImage;
	private String fileName;
	private String format;
	private byte[] imageData;
	
	public ScreenCapture() {
		try {
//			tham khảo https://www.geeksforgeeks.org/java-program-take-screenshots/
//			thu vien Robot điều khiển các thao tác của chuột, bàn phím và thực hiện các hành động tự động hóa GUI
			Robot robot = new Robot();
			format = "png";
			
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			screenFullImage = robot.createScreenCapture(screenRect);
			
			// Vẽ thêm con trỏ chuột
			Point mouselocation = MouseInfo.getPointerInfo().getLocation();
			int mouseX = mouselocation.x - screenRect.x;
			int mouseY = mouselocation.y - screenRect.y;
			Graphics2D g2d = screenFullImage.createGraphics();
			g2d.setColor(Color.RED);
			g2d.fillOval(mouseX, mouseY, 15, 15);
			g2d.dispose();
			
			// Tạo tên file dựa trên thời gian hiện tại
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd-HHmmss");
			fileName = "Screen_" + dateformat.format(new Date()) + "." + format;
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(screenFullImage, "png", baos);
			imageData = baos.toByteArray();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void SaveImage() {
//	 Tạo thư mục nếu chưa tồn tại
		File folder = new File("images");
		if(!folder.exists()) {
			folder.mkdir();
		}
		// Lưu ảnh vào thư mục images
		try {
			File file = new File("images", fileName);
			ImageIO.write(screenFullImage, format, file);
			System.out.println("Screen Image saved: " + file.getAbsolutePath());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public BufferedImage getScreenFullImage() {
		return screenFullImage;
	}

	public void setScreenFullImage(BufferedImage screenFullImage) {
		this.screenFullImage = screenFullImage;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
	
}
