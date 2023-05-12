package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Basket_kwh extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnHome;
	private JButton btnMenu;
	private JButton btnOrder;
	private JButton btnReview;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblCount;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_3;
	private JTextField tfTotal;
	private JLabel lblNewLabel_3_1;
	private JTextField tfDiscount;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_3_1_1;
	private JLabel lblPay;
	private JLabel lblNewLabel_4_1;

	

    

    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Basket_kwh frame = new Basket_kwh();
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
	public Basket_kwh() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				paint(getGraphics());
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 872);							// 백그라운드 프레임 패널 사이즈
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 227, 182));	// 백그라운드 프레임 패널 색
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblCount());
		contentPane.add(getScrollPane());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getTfTotal());
		contentPane.add(getLblNewLabel_3_1());
		contentPane.add(getTfDiscount());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getLblNewLabel_3_1_1());
		contentPane.add(getLblPay());
		contentPane.add(getLblNewLabel_4_1());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 757, 390, 87);
			panel.setBackground(new Color(131, 77, 30));
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			panel.add(getBtnHome());
			panel.add(getBtnMenu());
			panel.add(getBtnOrder());
			panel.add(getBtnReview());
		}
		return panel;
	}
	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("");
			btnHome.setIcon(new ImageIcon(Basket_kwh.class.getResource("/com/javalec/image/btnHome.png")));
			btnHome.setFocusPainted(false);					// 버튼 포커스라인 없애기
			btnHome.setBorderPainted(false);
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnHome;
	}
	private JButton getBtnMenu() {
		if (btnMenu == null) {
			btnMenu = new JButton("");
			btnMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnMenu.setIcon(new ImageIcon(Basket_kwh.class.getResource("/com/javalec/image/btnMenu.png")));
			btnMenu.setFocusPainted(false);
			btnMenu.setBorderPainted(false);
		}
		return btnMenu;
	}
	private JButton getBtnOrder() {
		if (btnOrder == null) {
			btnOrder = new JButton("");
			btnOrder.setIcon(new ImageIcon(Basket_kwh.class.getResource("/com/javalec/image/btnOrder.png")));
			btnOrder.setFocusPainted(false);
			btnOrder.setBorderPainted(false);
		}
		return btnOrder;
	}
	private JButton getBtnReview() {
		if (btnReview == null) {
			btnReview = new JButton("");
			btnReview.setIcon(new ImageIcon(Basket_kwh.class.getResource("/com/javalec/image/btnReview.png")));
			btnReview.setFocusPainted(false);
			btnReview.setBorderPainted(false);
		}
		return btnReview;
	}
	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(303, 15, 65, 18);
			lblNewLabel_1.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/wifi.png")));
		}
		return lblNewLabel_1;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("장바구니 목록");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
			lblNewLabel.setBounds(18, 65, 393, 40);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("상품");
			lblNewLabel_2.setBounds(29, 174, 29, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblCount() {
		if (lblCount == null) {
			lblCount = new JLabel("(갯수)");
			lblCount.setBounds(60, 174, 35, 16);
		}
		return lblCount;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(18, 202, 351, 301);
		}
		return scrollPane;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("총 합계금액");
			lblNewLabel_3.setBounds(60, 569, 77, 16);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfTotal() {
		if (tfTotal == null) {
			tfTotal = new JTextField();
			tfTotal.setEditable(false);
			tfTotal.setBounds(212, 564, 130, 26);
			tfTotal.setColumns(10);
		}
		return tfTotal;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("할인액 ");
			lblNewLabel_3_1.setBounds(60, 597, 77, 16);
		}
		return lblNewLabel_3_1;
	}
	private JTextField getTfDiscount() {
		if (tfDiscount == null) {
			tfDiscount = new JTextField();
			tfDiscount.setEditable(false);
			tfDiscount.setColumns(10);
			tfDiscount.setBounds(212, 592, 130, 26);
		}
		return tfDiscount;
	}

	public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(40, 680, 350, 680); // (x1, y1, x2, y2)
    }
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("-");
			lblNewLabel_4.setBounds(183, 597, 17, 16);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_3_1_1() {
		if (lblNewLabel_3_1_1 == null) {
			lblNewLabel_3_1_1 = new JLabel("결제금액 ");
			lblNewLabel_3_1_1.setBounds(60, 655, 77, 16);
		}
		return lblNewLabel_3_1_1;
	}
	private JLabel getLblPay() {
		if (lblPay == null) {
			lblPay = new JLabel("New label");
			lblPay.setBounds(212, 655, 130, 16);
		}
		return lblPay;
	}
	private JLabel getLblNewLabel_4_1() {
		if (lblNewLabel_4_1 == null) {
			lblNewLabel_4_1 = new JLabel("=");
			lblNewLabel_4_1.setBounds(183, 655, 17, 16);
		}
		return lblNewLabel_4_1;
	}
}
