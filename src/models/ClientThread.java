package models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import utils.ChangeDesktopBackground;
import utils.ScreenCapture;

public class ClientThread extends Thread{
	 private Socket s;
	 private User user;
	 private User userConnect;
	 private Test t = new Test(null);
	 private ImageIcon screen = null;
	private String messageAll = "";
	 
	 public ClientThread(Socket s) {
		 this.s = s;
	 }
	 
	 @Override
	public void run() {
		// TODO Auto-generated method stub
		Messager temp;
		while(true) {
			Object obj = readObject(s);
//			kiem tra xem object co phai la instance of user ko 
			if(obj instanceof User) {
				this.user = (User) obj;
				System.out.println("Object: "+ obj);
			}
			if(obj instanceof Messager) {
				Messager messager = (Messager) obj;
				System.out.println(messager.getText());
				if(messager.getText().equals("StC_MouseClick")) {
					System.out.println("Mouse Click");
				}
				switch(messager.getText()) {
				case "Turn off screen":
					System.out.println("Off");
					break;
				case "Connect Success":
					User user = (User) messager.getObj1();
					this.userConnect = user;
					System.out.println("Connect success " + user.getId());
					JOptionPane.showMessageDialog(null, "Connect success to ID = " + user.getId());
					break;
				case "StC_ScreenCapture" :
					System.out.println("StC_ScreenCapture");
					ScreenCapture screencapture = new ScreenCapture();
					screencapture.SaveImage();
					JOptionPane.showMessageDialog(null, "Screen Capture success!!");
					break;
				case "StC_ChangeDesktopBackground":
					if(t.isStart) {
						t.stop();
					}
					byte[] imageData = (byte[]) messager.getObj1();
					
					// Lưu dữ liệu nhận được thành file hình ảnh
					FileOutputStream fos; 		
					try {
						// Lưu ảnh vào client
						SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd-HHmmss");
						String fileName = "screen" + ".png";
						fos = new FileOutputStream(fileName);
						fos.write(imageData);
						
						// Đổi màn hình desktop bằng ảnh vừa lưu
						String abPath = new File(fileName).getAbsolutePath();
						ChangeDesktopBackground changedeskbg = new ChangeDesktopBackground(abPath);
						t = new Test(changedeskbg);
						t.start();
						JOptionPane.showMessageDialog(null, "Wait change desktop background...");

					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					break;
//				case "StC_KeyPressed":
//					int key = (int) messager.getObj1();
//					RobotKey.keyPress(key);
//					break;

				case "StC_Chat":
					String message = (String) messager.getObj1();
					messageAll += message + "\n";
					break;
				case "nontification":
					System.out.println(messager);
					String text = (String) messager.getObj1();
					JOptionPane.showMessageDialog(null, text);
					break;
				}
			}
		}
	}
	 
	 public void writeObject(Object obj, Socket s) {
		 try {
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(obj);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 }
	 
	 public Object readObject(Socket s) {
		 Object obj = null;
		 try {
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			obj = ois.readObject();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 return obj;
	 }
	 
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getUserConnect() {
		return userConnect;
	}
	public void setUserConnect(User userConnect) {
		this.userConnect = userConnect;
	}
	 

	public String getMessageAll() {
		return messageAll;
	}

	public void addMessage(String message) {
		messageAll += message + "\n";
	}

	public void setMessageAll(String messageAll) {
		this.messageAll = messageAll;
	}
}


