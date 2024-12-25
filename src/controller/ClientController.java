package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileFilter;

import models.Client;
import models.Messager;
import models.User;
import view.Chatform;
import view.ClientMainView;
import view.ScreenShareView;

public class ClientController extends Thread{
	private Client client;
	private ClientMainView clientView;
	private Chatform chatform;
	private boolean isConnect;
	
	public ClientController() {
		// TODO Auto-generated constructor stub
		clientView = new ClientMainView();
//		chatform = new Chatform();

		clientView.connectServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ip = clientView.ip_tf.getText();
				int port = Integer.parseInt(clientView.port_tf.getText());
				client = new Client(ip, port);
			}
		});

		clientView.connectScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(clientView.idTf.getText());
				int pass = Integer.parseInt(clientView.passTf.getText());
				User user = new User(id, pass);
				Messager messager = new Messager("connect", user);
				client.writeObjectToServer(messager);
			}
		});

		clientView.screenCapture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (client == null) {
					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy chủ");
					return;
				}
				if (client.getUserConnect() == null) {
					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy khác");
					return;
				}
				User userConnect = client.getUserConnect();
				Messager messager = new Messager("StC_ScreenCapture", userConnect);
				client.writeObjectToServer(messager);
			}
		});

		clientView.changeDesktopBackground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (client == null) {
					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy chủ");
					return;
				}
				if (client.getUserConnect() == null) {
					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy khác");
					return;
				}
				JFileChooser fileChooser = new JFileChooser();
				// Chỉ cho phép chọn các file hình ảnh
				fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
					public boolean accept(File f) {
						return f.getName().toLowerCase().endsWith(".jpg") 
								|| f.getName().toLowerCase().endsWith(".png")|| f.isDirectory();
					}

					public String getDescription() {
						return "Image files (*.jpg,*.png)";
					}
				});

				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					// Xử lý file đã chọn ở đây, ví dụ: hiển thị đường dẫn file
					JOptionPane.showMessageDialog(null, "Đường dẫn tới ảnh: " + selectedFile.getAbsolutePath());

					try {
						// Đọc hình ảnh từ file
						File imageFile = new File(selectedFile.getAbsolutePath());
						FileInputStream fileInputStream = new FileInputStream(imageFile);
						byte[] imageData = new byte[(int) imageFile.length()];
						fileInputStream.read(imageData);
						
						User userConnect = client.getUserConnect();
						Messager messager = new Messager("StC_ChangeDesktopBackground", imageData, userConnect);
						client.writeObjectToServer(messager);
					} catch (Exception e1) {
						// TODO: handle exception
						e1.printStackTrace();
					}
				}
			}
		});
		
		clientView.ChatBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if (client == null) {
//					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy chủ");
//					return;
//				}
//				if (client.getUserConnect() == null) {
//					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy khác");
//					return;
//				}
				
				chatform = new Chatform();
				Chatform.messageField.addKeyListener(new KeyListener() {
					@Override
					public void keyTyped(KeyEvent e) {
						// Không cần xử lý sự kiện này trong trường hợp này
					}

					@Override
					public void keyPressed(KeyEvent e) {
						// Không cần xử lý sự kiện này trong trường hợp này
					}

					  public void keyReleased(KeyEvent e) {
					        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					            String message = Chatform.messageField.getText();
					            if (message.equals("")) {
					                JOptionPane.showMessageDialog(null, "Không thể gửi tin nhắn rỗng");
					                return;
					            }
					            User userConnect = client.getUserConnect();
					            Messager messager = new Messager("StC_Chat", message, userConnect);
					            client.writeObjectToServer(messager);
					            Chatform.messageField.setText("");

					            // Cập nhật client và chatArea
					            client.addMessage("Tôi: " + message + "\n");
					            chatform.chatArea.setText(client.getMessageAll());
					        }
					}
				});

			}
			
		});
	}


	


	@Override
	public void run() {

		while (true) {
			System.out.print("");
			if (isConnect) {
				 // Lấy tất cả tin nhắn mới từ client
	            String messages = client.getMessageAll();

//	            // Hiển thị chatform nếu chưa có hoặc chưa hiển thị
//	            if (chatform == null || !chatform.isVisible()) {
//	                chatform = new Chatform();
//	                chatform.setVisible(true);
//	            }
//	         // Cập nhật nội dung chatArea
//	            if (chatform != null) {
//	                chatform.chatArea.setText(messages);
//	            }


			} else {
				if (client == null)
					continue;
				User user = client.getUser();
				if (user != null) {
					isConnect = true;
					clientView.setUser(user);
					clientView.setPanelMain();
					System.out.println("Connect");
				}
			}
			 try {
		            Thread.sleep(100); // Nghỉ 100ms mỗi vòng lặp
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		}
	}
}

