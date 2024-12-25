package view;

import java.awt.Button;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ScreenShareView extends JFrame {
	public JPanel contentPanel;
	public JButton screenSharebtn;
	
	public ScreenShareView() {
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        setBounds(100, 100, 3 * width / 4, height - 100);
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPanel);
        contentPanel.setLayout(new GridLayout(1, 0, 0, 0));

        screenSharebtn = new JButton("Screen Share");
        screenSharebtn.addActionListener(e -> hideCursor());
        contentPanel.add(screenSharebtn);
        this.setVisible(true);

		System.out.println("ScreenShare is running");

        // Đảm bảo JFrame có thể nhận sự kiện bàn phím
        setFocusable(true);
        requestFocusInWindow();
    } 
	
	public void hideCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = toolkit.createCustomCursor(cursorImage, new Point(0, 0), "blank cursor");
        this.setCursor(blankCursor);
    }
	
	 public void setIcon(ImageIcon icon) {
	        screenSharebtn.setIcon(icon);
	    }
}
