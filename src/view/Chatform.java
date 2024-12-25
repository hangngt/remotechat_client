package view;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;

public class Chatform  extends JFrame {

	private JFrame frame;
	   private JPanel contentPane;
	    public static JTextField messageField;
	    public static JTextArea chatArea;
	    public JButton sendButton;
	    public JButton emojiButton;
	    public JButton attachButton;
	    public JButton micButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chatform window = new Chatform();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		});
	}

	/**
	 * Create the application.
	 */


	public Chatform() {
	        // Thiết lập khung chính
	        setTitle("Chat Interface");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 500, 500); // Kích thước cửa sổ
	        contentPane = new JPanel();
	        contentPane.setLayout(new BorderLayout());
	        setContentPane(contentPane);

	        // Khu vực hiển thị tin nhắn
	        chatArea = new JTextArea();
	        chatArea.setEditable(false); // Không cho phép chỉnh sửa
	        contentPane.add(new JScrollPane(chatArea), BorderLayout.CENTER);

	        // Thanh công cụ dưới cùng
	        JPanel bottomPanel = new JPanel();
	        bottomPanel.setLayout(new BorderLayout());
	        contentPane.add(bottomPanel, BorderLayout.SOUTH);

	        // Trường nhập văn bản
	        messageField = new JTextField();
	        bottomPanel.add(messageField, BorderLayout.CENTER);

	        // Các nút chức năng
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new GridLayout(1, 4));

	        sendButton = new JButton("Gửi");
	        emojiButton = new JButton("😊");
	        attachButton = new JButton("📎");
	        micButton = new JButton("🎤");

	        buttonPanel.add(sendButton);
	        buttonPanel.add(emojiButton);
	        buttonPanel.add(attachButton);
	        buttonPanel.add(micButton);

	        bottomPanel.add(buttonPanel, BorderLayout.EAST);

	        setVisible(true); // Hiển thị giao diện
	    }
	public void addMessage(String message) {
		chatArea.append(message + "\n");
	}
}
