package view;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import models.User;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ClientMainView extends JFrame {
	

	private JPanel contentPane;
	public JTextField ip_tf;
	public JTextField port_tf;
	private JTextField myID;
	private JTextField myPass;
	public JTextField idTf;
	public JButton connectServer;
	public JTextField passTf;
	private JPanel connect_pn;
	private JPanel main_pn;
	public JButton connectScreen;
	public JButton screenCapture;
	public JButton changeDesktopBackground;
	public JButton Changelightscreen;
	public JButton screenShare;
	private boolean isChat = false;
	public JButton ChatBt;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClientMainView clientmainview = new ClientMainView();
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ClientMainView() {
		setTitle("Control Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 10, 649, 202);
		contentPane.add(panel);
		panel.setLayout(null);
		
		main_pn = new JPanel();
		main_pn.setBackground(new Color(219, 219, 219));
		main_pn.setBounds(13, 20, 614, 165);
		panel.add(main_pn);
		main_pn.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(215, 215, 215));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 11, 283, 126);
		main_pn.add(panel_1_1);
		
		myID = new JTextField();
		myID.setText("");
		myID.setBackground(new Color(255, 255, 255));
		myID.setFont(new Font("Roboto", Font.BOLD, 13));
		myID.setColumns(10);
		myID.setBounds(49, 50, 224, 26);
		myID.setHorizontalAlignment(JTextField.CENTER);
		panel_1_1.add(myID);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(0, 128, 0));
		lblId.setFont(new Font("Dialog", Font.BOLD, 11));
		lblId.setBounds(10, 56, 61, 14);
		panel_1_1.add(lblId);
		
		JLabel lblChoPhpKt = new JLabel("Allow connection", SwingConstants.CENTER);
		lblChoPhpKt.setForeground(new Color(0, 0, 160));
		lblChoPhpKt.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblChoPhpKt.setBounds(10, 11, 263, 14);
		panel_1_1.add(lblChoPhpKt);
		
		JLabel lblPass = new JLabel("PASS");
		lblPass.setForeground(new Color(0, 128, 0));
		lblPass.setFont(new Font("Dialog", Font.BOLD, 11));
		lblPass.setBounds(10, 93, 61, 14);
		panel_1_1.add(lblPass);
		
		myPass = new JTextField();
		myPass.setBackground(new Color(255, 255, 255));
		myPass.setFont(new Font("Roboto", Font.BOLD, 13));
		myPass.setColumns(10);
		myPass.setBounds(49, 87, 224, 26);
		myPass.setHorizontalAlignment(JTextField.CENTER);
		panel_1_1.add(myPass);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(290, 11, 8, 141);
		main_pn.add(separator);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(321, 11, 283, 171);
		main_pn.add(panel_1_2);
		panel_1_2.setBackground(new Color(228, 228, 228));
		panel_1_2.setLayout(null);
		
		idTf = new JTextField();
		idTf.setBackground(new Color(255, 255, 255));
		idTf.setFont(new Font("Roboto", Font.BOLD, 13));
		idTf.setColumns(10);
		idTf.setBounds(52, 50, 221, 26);
		idTf.setHorizontalAlignment(JTextField.CENTER);
		panel_1_2.add(idTf);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 56, 61, 14);
		panel_1_2.add(lblNewLabel_1);
		
		JLabel lbliuKhinMn = new JLabel("Control other screen", SwingConstants.CENTER);
		lbliuKhinMn.setForeground(new Color(0, 0, 160));
		lbliuKhinMn.setFont(new Font("Roboto", Font.PLAIN, 17));
		lbliuKhinMn.setBounds(10, 10, 263, 14);
		panel_1_2.add(lbliuKhinMn);
		
		JLabel lblPort_1 = new JLabel("PASS");
		lblPort_1.setForeground(new Color(0, 128, 0));
		lblPort_1.setFont(new Font("Dialog", Font.BOLD, 11));
		lblPort_1.setBounds(10, 93, 61, 14);
		panel_1_2.add(lblPort_1);
		
		passTf = new JTextField();
		passTf.setBackground(new Color(255, 255, 255));
		passTf.setFont(new Font("Roboto", Font.BOLD, 13));
		passTf.setColumns(10);
		passTf.setBounds(52, 87, 221, 26);
		passTf.setHorizontalAlignment(JTextField.CENTER);
		panel_1_2.add(passTf);
		
		connectScreen = new JButton("Connect");
		connectScreen.setFont(new Font("Roboto", Font.PLAIN, 11));
		connectScreen.setBackground(new Color(255, 255, 255));
		connectScreen.setForeground(new Color(0, 0, 128));
		connectScreen.setBounds(101, 125, 89, 23);
		panel_1_2.add(connectScreen);
		
		connect_pn = new JPanel();
		connect_pn.setBounds(147, 31, 273, 171);
		panel.add(connect_pn);
		connect_pn.setBackground(new Color(192, 192, 192));
		connect_pn.setLayout(null);
		
		ip_tf = new JTextField("localhost");
		ip_tf.setBackground(Color.decode("#acadaf"));
		ip_tf.setFont(new Font("Roboto", Font.BOLD, 13));
		ip_tf.setBounds(49, 50, 214, 26);
		ip_tf.setHorizontalAlignment(JTextField.CENTER);
		connect_pn.add(ip_tf);
		ip_tf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("IP");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 56, 46, 14);
		connect_pn.add(lblNewLabel);
		
		JLabel lblKtNiTi = new JLabel("Connect to Server", SwingConstants.CENTER);
		lblKtNiTi.setBackground(Color.decode("#3d3b37"));
		lblKtNiTi.setForeground(new Color(0, 0, 160));
		lblKtNiTi.setFont(new Font("Dialog", Font.BOLD, 17));
		lblKtNiTi.setBounds(10, 11, 263, 14);
		connect_pn.add(lblKtNiTi);
		
		JLabel lblPort = new JLabel("PORT");
		lblPort.setForeground(new Color(0, 128, 0));
		lblPort.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblPort.setBounds(10, 93, 46, 14);
		connect_pn.add(lblPort);
		
		port_tf = new JTextField("1009");
		port_tf.setBackground(Color.decode("#acadaf"));
		port_tf.setFont(new Font("Roboto", Font.BOLD, 13));
		port_tf.setColumns(10);
		port_tf.setHorizontalAlignment(JTextField.CENTER);
		port_tf.setBounds(49, 87, 214, 26);
		connect_pn.add(port_tf);
		
		connectServer = new JButton("Connect");
		connectServer.setFont(new Font("Dialog", Font.BOLD, 11));
		connectServer.setBackground(new Color(255, 255, 255));
		connectServer.setForeground(new Color(64, 128, 128));
		connectServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelMain();
			}
		});
		connectServer.setBounds(101, 125, 89, 23);
		connect_pn.add(connectServer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 230));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(24, 230, 635, 159);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		screenCapture = new JButton("screen_capture");
		screenCapture.setBounds(10, 24, 133, 44);
		panel_1.add(screenCapture);
		
		changeDesktopBackground = new JButton("change_desktop \n background");
		changeDesktopBackground.setBounds(197, 24, 165, 44);
		panel_1.add(changeDesktopBackground);
		
		Changelightscreen = new JButton("Change_Lightscreen");
		Changelightscreen.setBounds(414, 24, 133, 44);
		panel_1.add(Changelightscreen);
		
		screenShare = new JButton("screen_share");
		screenShare.setBounds(414, 105, 132, 44);
		panel_1.add(screenShare);
		
		ChatBt = new JButton("Chat");
		ChatBt.setBounds(10, 105, 133, 44);
		panel_1.add(ChatBt);
		
		JButton screenCapture_1_2 = new JButton("Exit");
		screenCapture_1_2.setBounds(209, 105, 132, 44);
		panel_1.add(screenCapture_1_2);
		setLocationRelativeTo(null);
		this.addHoverListener();
		
		setPanelConnect();
		setVisible(true);
	}



	private void setPanelConnect() {
		// TODO Auto-generated method stub
		main_pn.setVisible(false);
	}

	private void addHoverListener() {
		// TODO Auto-generated method stub
		screenCapture.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				screenCapture.setText("ScreenCapture");;
			}
		});
	}
	
	
	public void setPanelMain() {
		main_pn.setVisible(true);
		connect_pn.setVisible(false);
	}
	
	public void setUser(User user) {
		myID.setText(user.getId() + "");
		myPass.setText(user.getPassword() + "");
	}
}
