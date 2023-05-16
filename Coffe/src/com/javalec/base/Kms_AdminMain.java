package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Kms_AdminMain extends JFrame {
	

	private JPanel contentPane;
	private JLabel wifi;
	private JLabel up;
	private JLabel chocolate; 
	private JLabel coffeeBean;
	private JLabel choc;
	private JPanel panel;
	private JLabel admin;
	private JButton btnQtyPrice;
	private JButton btnReview;
	private JButton btnStore;
	private JButton btnSales;
	private JButton btnBack;
	private JLabel lblClock;
	DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kms_AdminMain frame = new Kms_AdminMain();
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
	public Kms_AdminMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setLocationRelativeTo(null);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 872);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 227, 182));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblClock());
		contentPane.add(getBtnBack());
		contentPane.add(getAdmin());
		contentPane.add(getPanel());
		contentPane.add(getChoc());
		contentPane.add(getWifi());
		contentPane.add(getUp());
		contentPane.add(getChocolate());
		contentPane.add(getCoffeeBean());
	}
	private JLabel getWifi() {
		if (wifi == null) {
			wifi = new JLabel("");
			wifi.setBounds(303, 15, 65, 18);
			wifi.setIcon(new ImageIcon(Kms_AdminMain.class.getResource("/com/javalec/image/wifi.png")));
		}
		return wifi;
	}
	
	private JLabel getUp() {
		if (up == null) {
			up = new JLabel("");
			up.setBounds(0, 0, 390, 223);
			up.setIcon(new ImageIcon(Kms_AdminMain.class.getResource("/com/javalec/image/image.png")));
		}
		return up;
	}
	
	private JLabel getChocolate() {
		if (chocolate == null) {
			chocolate = new JLabel("");
			chocolate.setBounds(188, 648, 203, 203);
			chocolate.setIcon(new ImageIcon(Kms_AdminMain.class.getResource("/com/javalec/image/초콜릿1.png")));
		}
		return chocolate;
	}
	
	private JLabel getCoffeeBean() {
		if (coffeeBean == null) {
			coffeeBean = new JLabel("");
			coffeeBean.setBounds(0, 648, 234, 204);
			coffeeBean.setIcon(new ImageIcon(Kms_AdminMain.class.getResource("/com/javalec/image/커피콩1.png")));
		}
		return coffeeBean;
	}
	private JLabel getChoc() {
		if (choc == null) {
			choc = new JLabel("");
			choc.setBounds(105, 73, 181, 73);
			choc.setIcon(new ImageIcon(Kms_AdminMain.class.getResource("/com/javalec/image/상표.png")));
		}
		return choc;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(35, 161, 320, 481);
			panel.setBackground(new Color(252, 242, 217));
			panel.setLayout(null);
			panel.add(getBtnQtyPrice());
			panel.add(getBtnReview());
			panel.add(getBtnStore());
			panel.add(getBtnSales());
		}
		return panel;
}
	private JLabel getAdmin() {
		if (admin == null) {
			admin = new JLabel("");
			admin.setBounds(144, 223, 107, 19);
			admin.setIcon(new ImageIcon(Kms_AdminMain.class.getResource("/com/javalec/image/Admin.png")));
		}
		return admin;
	}
	private JButton getBtnQtyPrice() {
		if (btnQtyPrice == null) {
			btnQtyPrice = new JButton("");
			btnQtyPrice.setBounds(14, 150, 300, 40);
			btnQtyPrice.setIcon(new ImageIcon(Kms_AdminMain.class.getResource("/com/javalec/image/qtyPrice.png")));
			btnQtyPrice.setFocusPainted(false);
			btnQtyPrice.setBorderPainted(false);
			btnQtyPrice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					productAction();
				}
			});
		}
		return btnQtyPrice;
	}
	private JButton getBtnReview() {
		if (btnReview == null) {
			btnReview = new JButton("");
			btnReview.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reviewAction();
				}
			});
			btnReview.setBounds(14, 225, 300, 40);
			btnReview.setIcon(new ImageIcon(Kms_AdminMain.class.getResource("/com/javalec/image/review.png")));
			btnReview.setFocusPainted(false);
			btnReview.setBorderPainted(false);
		}
		return btnReview;
	}
	private JButton getBtnStore() {
		if (btnStore == null) {
			btnStore = new JButton("");
			btnStore.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					storeAction();
				}
			});
			btnStore.setBounds(14, 300, 300, 40);
			btnStore.setIcon(new ImageIcon(Kms_AdminMain.class.getResource("/com/javalec/image/store.png")));
			btnStore.setFocusPainted(false);
			btnStore.setBorderPainted(false);
		}
		return btnStore;
	}
	private JButton getBtnSales() {
		if (btnSales == null) {
			btnSales = new JButton("");
			btnSales.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salesAction();
				}
			});
			btnSales.setBounds(14, 375, 300, 40);
			btnSales.setIcon(new ImageIcon(Kms_AdminMain.class.getResource("/com/javalec/image/sales.png")));
			btnSales.setFocusPainted(false);
			btnSales.setBorderPainted(false);
		}
		return btnSales;
	}
	
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					backAction();
				}
			});
			btnBack.setBounds(31, 54, 18, 24);
			btnBack.setIcon(new ImageIcon(Kms_AdminMain.class.getResource("/com/javalec/image/backbtn.png")));
			btnBack.setFocusPainted(false);
			btnBack.setBorderPainted(false);
		}
		return btnBack;
	}
	// ----- function -----
	 private JLabel getLblClock() {
			if (lblClock == null) {
				lblClock = new JLabel();
				lblClock.setFont(new Font("Malayalam Sangam MN", Font.BOLD, 15));
				lblClock.setBounds(36, 15, 61, 16);
				clockRun();
				
			}
			return lblClock;
		}
	 
	 // 시간표시 메소드
	 private void clockRun() {
		    javax.swing.Timer timer = new javax.swing.Timer(100, new ActionListener() {	//1초마다 갱신
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Calendar t = Calendar.getInstance();
		            int hour = t.get(Calendar.HOUR);
		            int min = t.get(Calendar.MINUTE);
		            String clock = String.format("%02d : %02d" , hour, min);	// 시간을 01:02로표시 원래 1시:2분 이런식
		            lblClock.setText(clock);
				}
			});	 
		    timer.start();
		}
	
	private void productAction() {
		Kms_AdminProduct product = new Kms_AdminProduct();
		product.setVisible(true);
		dispose();
	}
	
	private void reviewAction() { // 리뷰게시판 관리 눌렀때(Review2_kwh가 데이터베이스와 연결되었을때 아래 바 지우고 새로운class만들어서 연결할 예정)
		Kms_AdminReview review = new Kms_AdminReview();
		review.setVisible(true);
		dispose();
	}
	
	private void storeAction() { // 가게정보 눌렀을때
		Kms_StoreInfo storeInfo = new Kms_StoreInfo();
		storeInfo.setVisible(true);
		dispose();
	}
	
	private void salesAction() { // 매출정보 눌렀을때
		Kms_StoreSales storeSales = new Kms_StoreSales();
		storeSales.setVisible(true);
		dispose();
	}
	
	private void backAction() { // 뒤로가기 눌렀을때 (로그인 화면 완성되면 바꿀예정 -------------------------)
		Hsh_login storeSales = new Hsh_login();
		storeSales.setVisible(true);
		dispose();
	}
}
