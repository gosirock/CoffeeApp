package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.Kms_Dao_StoreInfo;
import com.javalec.dto.Kms_Dto_StoreInfo;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
	private JTextField tfScompanyno;
	private JTextField tfOpenTime;
	private JTextField tfCloseTime;
	private JTextField tfStoreTel;
	private JTextField tfStoreAddress;
	private JLabel lblStoreName;
	private JLabel lblCompanyNo;
	private JLabel lblOpenTime;
	private JLabel lblCloseTime;
	private JLabel lblStoreTel;
	private JLabel lblStoreAddress;
	private JButton btnUpdateStore;
	private JButton btnBack;
	String message;
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				storeInfo();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 872);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 227, 182));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnBack());
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
			panel.add(getTfScompanyno());
			panel.add(getTfOpenTime());
			panel.add(getTfCloseTime());
			panel.add(getTfStoreTel());
			panel.add(getTfStoreAddress());
			panel.add(getLblStoreName());
			panel.add(getLblCompanyNo());
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
	private JTextField getTfScompanyno() {
		if (tfScompanyno == null) {
			tfScompanyno = new JTextField();
			tfScompanyno.setColumns(10);
			tfScompanyno.setBounds(126, 139, 130, 26);
			tfScompanyno.setBackground(new Color(252, 242, 217));	
		}
		return tfScompanyno;
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
	private JLabel getLblCompanyNo() {
		if (lblCompanyNo == null) {
			lblCompanyNo = new JLabel("");
			lblCompanyNo.setBounds(26, 144, 270, 21);
			lblCompanyNo.setIcon(new ImageIcon(Kms_StoreInfo.class.getResource("/com/javalec/image/companyno.png")));
		}
		return lblCompanyNo;
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
			btnUpdateStore.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateAction();
				}
			});
			btnUpdateStore.setBounds(25, 411, 270, 41);
			btnUpdateStore.setIcon(new ImageIcon(Kms_StoreInfo.class.getResource("/com/javalec/image/update.png")));
		}
		return btnUpdateStore;
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
			btnBack.setIcon(new ImageIcon(Kms_StoreInfo.class.getResource("/com/javalec/image/backbtn.png")));
			btnBack.setFocusPainted(false);
			btnBack.setBorderPainted(false);
		}
		return btnBack;
	}
	
	// ----- function ----
	
	private void backAction() {
		Kms_AdminMain adminMain = new Kms_AdminMain();
		adminMain.setVisible(true);
		dispose();
	}
	
	private void storeInfo() {
		Kms_Dao_StoreInfo dao_storeinfo = new Kms_Dao_StoreInfo();
		Kms_Dto_StoreInfo dto_storeinfo = dao_storeinfo.StoreInfo();

		if (dto_storeinfo != null) {
			tfStoreName.setText(dto_storeinfo.getSname());
			tfScompanyno.setText(dto_storeinfo.getCnum());
			tfOpenTime.setText(dto_storeinfo.getOpentime());
			tfCloseTime.setText(dto_storeinfo.getClosetime());
			tfStoreTel.setText(dto_storeinfo.getTelno());
			tfStoreAddress.setText(dto_storeinfo.getAddress());
		}
	}
	
	private void updateAction() {
		String storename = tfStoreName.getText();
		String scnum = tfScompanyno.getText();
		String opentime = tfOpenTime.getText();
		String closetime = tfCloseTime.getText();
		String storetel = tfStoreTel.getText();
		String storeaddress = tfStoreAddress.getText();
		
		Kms_Dao_StoreInfo dao = new Kms_Dao_StoreInfo(storename, scnum, opentime, closetime, storetel, storeaddress);
		boolean result = dao.updateAction();
		
		if (result) {
			int i_chk = insertFieldCheck();
			if (i_chk == 0) {
				JOptionPane.showMessageDialog(this, "가게 정보 수정\n"+tfStoreName.getText()+ " 정보가 수정었습니다."); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
			}else {
				JOptionPane.showMessageDialog(this, "\n"+message+ "입력하세요!", "가게 정보",JOptionPane.INFORMATION_MESSAGE); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
			} 
			
		}else {
			JOptionPane.showMessageDialog(this, "가게 정보 수정\n"+ "수정 중 문제가 발생했습니다."); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
		}
	}
	
	
		private int insertFieldCheck() {
			int i = 0;
			
			
			if(tfStoreName.getText().trim().length() == 0) {
				i++;
				message = "StoreName을 ";
				tfStoreName.requestFocus();  // 어디 자리가 비었는지 커서로 보여
			}
			if(tfScompanyno.getText().trim().length() == 0) {
				i++;
				message = "Scompanyno를 ";
				tfScompanyno.requestFocus();
			}
			if(tfOpenTime.getText().trim().length() == 0) {
				i++;
				message = "OpenTime을 ";
				tfOpenTime.requestFocus();
			}
			if(tfCloseTime.getText().trim().length() == 0) {
				i++;
				message = "CloseTime을 ";
				tfCloseTime.requestFocus();
			}
			if(tfStoreTel.getText().trim().length() == 0) {
				i++;
				message = "StoreTel을 ";
				tfStoreTel.requestFocus();
			}
			if(tfStoreAddress.getText().trim().length() == 0) {
				i++;
				message = "StoreAddress을 ";
				tfStoreAddress.requestFocus();
			}
			return i;
			
		}
		
		

}