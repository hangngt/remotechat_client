package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ChangeLightScreenNumber {
	public JSlider numberSlider;
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChangeLightScreenNumber change = new ChangeLightScreenNumber();
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public ChangeLightScreenNumber() {
//		Tạo JFrame
		JFrame frame = new JFrame("Number Choose");
		frame.setSize(300,150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Choose Light from 1 to 100");
		
//		Tạo JSlider để chọn số từ 1 đến 100
		numberSlider = new JSlider(JSlider.HORIZONTAL,0,100,1);
		numberSlider.setMajorTickSpacing(10);
		numberSlider.setMinorTickSpacing(1);
		numberSlider.setPaintTicks(true);
		numberSlider.setPaintLabels(true);
		

        // Thêm JLabel và JSlider vào JPanel
		panel.add(label);
		panel.add(numberSlider);
		
		frame.add(panel);
		frame.setVisible(true);  	//hien thi frame
		frame.setLocationRelativeTo(null);
	}
}
