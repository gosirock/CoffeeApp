package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Kms_StoreInfo extends JFrame {
	

	private JPanel contentPane;
	private JLabel wifi;
	private JLabel up;
	private JLabel chocolate;
	private JLabel coffeeBean;
	private JLabel choc;
	private JPanel panel;
	private JLabel storeInfo;
	private JTextField tfStoreName;
	private JTextField tfAdminId;
	private JTextField tfOpenTime;
	private JTextField tfCloseTime;
	private JTextField tfStoreTel;
	private JTextField tfStoreAddress;
	private JLabel lblStoreName;
	private JLabel lblAdminId;
	private JLabel lblOpenTime;
	private JLabel lblCloseTime;
	private JLabel lblStoreTel;
	private JLabel lblStoreAddress;
	private JButton btnUpdateStore;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kms_StoreInfo frame = new Kms_StoreInfo();
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
	public Kms_StoreInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 872);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 227, 182));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getStoreInfo());
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
			wifi.setIcon(new ImageIcon(Kms_StoreInfo.class.getResource("/com/javalec/image/wifi.png")));
			wifi.setBounds(303, 15, 65, 18);
		}
		return wifi;
	}
	
	private JLabel getUp() {
		if (up == null) {
			up = new JLabel("");
			up.setBounds(0, 0, 390, 223);
			up.setIcon(new ImageIcon(Kms_StoreInfo.class.getResource("/com/javalec/image/image.png")));
		}
		return up;
	}
	
	private JLabel getChocolate() {
		if (chocolate == null) {
			chocolate = new JLabel("");
			chocolate.setBounds(188, 648, 203, 203);
			chocolate.setIcon(new ImageIcon(Kms_StoreInfo.class.getResource("/com/javalec/image/초콜릿1.png")));
		}
		return chocolate;
	}
	
	private JLabel getCoffeeBean() {
		if (coffeeBean == null) {
			coffeeBean = new JLabel("");
			coffeeBean.setBounds(0, 648, 234, 204);
			coffeeBean.setIcon(new ImageIcon(Kms_StoreInfo.class.getResource("/com/javalec/image/커피콩1.png")));
		}
		return coffeeBean;
	}
	private JLabel getChoc() {
		if (choc == null) {
			choc = new JLabel("");
			choc.setBounds(105, 73, 181, 73);
			choc.setIcon(new ImageIcon(Kms_StoreInfo.class.getResource("/com/javalec/image/상표.png")));
		}
		return choc;
	}
	
	
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(252, 242, 217));		// 하단 버튼바 패널 색상
			panel.setBounds(35, 161, 320, 481);
			panel.setLayout(null);
			panel.add(getTfStoreName());
			panel.add(getTfAdminId());
			panel.add(getTfOpenTime());
			panel.add(getTfCloseTime());
			panel.add(getTfStoreTel());
			panel.add(getTfStoreAddress());
			panel.add(getLblStoreName());
			panel.add(getLblAdminId());
			panel.add(getLblOpenTime());
			panel.add(getLblCloseTime());
			panel.add(getLblStoreTel());
			panel.add(getLblStoreAddress());
			panel.add(getBtnUpdateStore());
			
		}
		return panel;
}
	private JLabel getStoreInfo() {
		if (storeInfo == null) {
			storeInfo = new JLabel("");
			storeInfo.setBounds(168, 200, 107, 19);
			storeInfo.setIcon(new ImageIcon(Kms_StoreInfo.class.getResource("/com/javalec/image/storeInfo.png")));
		}
		return storeInfo;
	}
	private JTextField getTfStoreName() {
		if (tfStoreName == null) {
			tfStoreName = new JTextField();
			tfStoreName.setBounds(126, 85, 130, 26);
			tfStoreName.setColumns(10);
			tfStoreName.setBackground(new Color(252, 242, 217));	
		}
		return tfStoreName;
	}
	private JTextField getTfAdminId() {
		if (tfAdminId == null) {
			tfAdminId = new JTextField();
			tfAdminId.setColumns(10);
			tfAdminId.setBounds(126, 139, 130, 26);
			tfAdminId.setBackground(new Color(252, 242, 217));	
		}
		return tfAdminId;
	}
	private JTextField getTfOpenTime() {
		if (tfOpenTime == null) {
			tfOpenTime = new JTextField();
			tfOpenTime.setColumns(10);
			tfOpenTime.setBounds(126, 193, 130, 26);
			tfOpenTime.setBackground(new Color(252, 242, 217));
		}
		return tfOpenTime;
	}
	private JTextField getTfCloseTime() {
		if (tfCloseTime == null) {
			tfCloseTime = new JTextField();
			tfCloseTime.setColumns(10);
			tfCloseTime.setBounds(126, 247, 130, 26);
			tfCloseTime.setBackground(new Color(252, 242, 217));	
			
		}
		return tfCloseTime;
	}
	private JTextField getTfStoreTel() {
		if (tfStoreTel == null) {
			tfStoreTel = new JTextField();
			tfStoreTel.setColumns(10);
			tfStoreTel.setBounds(126, 301, 130, 26);
			tfStoreTel.setBackground(new Color(252, 242, 217));	
		}
		return tfStoreTel;
	}
	private JTextField getTfStoreAddress() {
		if (tfStoreAddress == null) {
			tfStoreAddress = new JTextField();
			tfStoreAddress.setColumns(10);
			tfStoreAddress.setBounds(126, 355, 130, 26);
			tfStoreAddress.setBackground(new Color(252, 242, 217));	
		}
		return tfStoreAddress;
	}
	private JLabel getLblStoreName() {
		if (lblStoreName == null) {
			lblStoreName = new JLabel("");
			lblStoreName.setBounds(26, 90, 270, 21);
			lblStoreName.setIcon(new ImageIcon(Kms_StoreInfo.class.getResource("/com/javalec/image/storeName.png")));
		}
		return lblStoreName;
	}
	private JLabel getLblAdminId() {
		if (lblAdminId == null) {
			lblAdminId = new JLabel("");
			lblAdminId.setBounds(26, 144, 270, 21);
			lblAdminId.setIcon(new ImageIcon(Kms_StoreInfo.class.getResource("/com/javalec/image/AdminId.png")));
		}
		return lblAdminId;
	}
	private JLabel getLblOpenTime() {
		if (lblOpenTime == null) {
			lblOpenTime = new JLabel("");
			lblOpenTime.setBounds(26, 198, 270, 21);
			lblOpenTime.setIcon(new ImageIcon(Kms_StoreInfo.class.getResource("/com/javalec/image/openTime.png")));
		}
		return lblOpenTime;
	}
	private JLabel getLblCloseTime() {
		if (lblCloseTime == null) {
			lblCloseTime = new JLabel("");
			lblCloseTime.setBounds(26, 252, 270, 21);
			lblCloseTime.setIcon(new ImageIcon(Kms_StoreInfo.class.getResource("/com/javalec/image/closeTime.png")));
		}
		return lblCloseTime;
	}
	private JLabel getLblStoreTel() {
		if (lblStoreTel == null) {
			lblStoreTel = new JLabel("");
			lblStoreTel.setBounds(26, 306, 270, 21);
			lblStoreTel.setIcon(new ImageIcon(Kms_StoreInfo.class.getResource("/com/javalec/image/storeTel.png")));
		}
		return lblStoreTel;
	}
	private JLabel getLblStoreAddress() {
		if (lblStoreAddress == null) {
			lblStoreAddress = new JLabel("");
			lblStoreAddress.setBounds(26, 360, 270, 21);
			lblStoreAddress.setIcon(new ImageIcon(Kms_StoreInfo.class.getResource("/com/javalec/image/storeAddress.png")));
		}
		return lblStoreAddress;
	}
	private JButton getBtnUpdateStore() {
		if (btnUpdateStore == null) {
			btnUpdateStore = new JButton("");
			btnUpdateStore.setBounds(25, 411, 270, 41);
			btnUpdateStore.setIcon(new ImageIcon(Kms_StoreInfo.class.getResource("/com/javalec/image/update.png")));
		}
		return btnUpdateStore;
	}
}