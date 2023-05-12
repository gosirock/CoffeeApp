package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Kms_Base extends JFrame {
	

	private JPanel contentPane;
	private JLabel wifi;
	private JLabel up;
	private JLabel chocolate;
	private JLabel coffeeBean;
	private JLabel choc;
	private JLabel kmsRectangle;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kms_Base frame = new Kms_Base();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Kms_Base() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 872);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 227, 182));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getKmsRectangle());
		contentPane.add(getChoc());
		contentPane.add(getWifi());
		contentPane.add(getUp());
		contentPane.add(getChocolate());
		contentPane.add(getCoffeeBean());
	}
	private JLabel getWifi() {
		if (wifi == null) {
			wifi = new JLabel("");
			wifi.setIcon(new ImageIcon(Kms_Base.class.getResource("/com/javalec/image/wifi.png")));
			wifi.setBounds(303, 15, 65, 18);
		}
		return wifi;
	}
	
	private JLabel getUp() {
		if (up == null) {
			up = new JLabel("");
			up.setBounds(0, 0, 390, 223);
			up.setIcon(new ImageIcon(Kms_Base.class.getResource("/com/javalec/image/image.png")));
		}
		return up;
	}
	
	private JLabel getChocolate() {
		if (chocolate == null) {
			chocolate = new JLabel("");
			chocolate.setBounds(188, 648, 203, 203);
			chocolate.setIcon(new ImageIcon(Kms_Base.class.getResource("/com/javalec/image/초콜릿1.png")));
		}
		return chocolate;
	}
	
	private JLabel getCoffeeBean() {
		if (coffeeBean == null) {
			coffeeBean = new JLabel("");
			coffeeBean.setBounds(0, 648, 234, 204);
			coffeeBean.setIcon(new ImageIcon(Kms_Base.class.getResource("/com/javalec/image/커피콩1.png")));
		}
		return coffeeBean;
	}
	private JLabel getChoc() {
		if (choc == null) {
			choc = new JLabel("");
			choc.setBounds(105, 73, 181, 73);
			choc.setIcon(new ImageIcon(Kms_Base.class.getResource("/com/javalec/image/상표.png")));
		}
		return choc;
	}
	private JLabel getKmsRectangle() {
		if (kmsRectangle == null) {
			kmsRectangle = new JLabel("");
			kmsRectangle.setBounds(35, 161, 320, 481);
			kmsRectangle.setIcon(new ImageIcon(Kms_Base.class.getResource("/com/javalec/image/KmsRectangle.png")));
		}
		return kmsRectangle;
	}
}
