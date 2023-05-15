package com.javalec.base;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.Hsh_logindao;
import com.javalec.util.ShareVar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPasswordField;

public class Hsh_login extends JFrame {
	private JPanel panel;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnLogin;
	private JButton btnJoin;
	private JLabel lblTime;
	private JLabel lblba;
	private JLabel lblkong;
	private JLabel lblCho;
	private JLabel lblCid;
	private JTextField tfCid;
	private JLabel lblCpw;
	private JButton btnGomenu;
	private JLabel lblCochoc;
	private JPasswordField pfCpw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hsh_login frame = new Hsh_login();
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
	public Hsh_login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setLocationRelativeTo(null);  // jframe이 화면에 중앙에 위치하도록 하기 
			}
		});
		setTitle("로그인");
		getContentPane().setLayout(null);
		getContentPane().add(getPanel_3());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 872);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 227, 182));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnLogin());
		contentPane.add(getBtnJoin());
		contentPane.add(getLblTime());
		contentPane.add(getLblCochoc());
		contentPane.add(getLblba());
		contentPane.add(getLblkong());
		contentPane.add(getLblCho());
		contentPane.add(getLblCid());
		contentPane.add(getTfCid());
		contentPane.add(getLblCpw());
		contentPane.add(getBtnGomenu());
		contentPane.add(getPfCpw());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(Lju_base.class.getResource("/com/javalec/image/wifi.png")));
			lblNewLabel.setBounds(303, 15, 65, 18);
		}
		return lblNewLabel;
	}

	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBounds(0, 0, 390, 844);
		}
		return panel_3;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("");
			btnLogin.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/btnLogin.png")));
			btnLogin.setFocusPainted(false);
			btnLogin.setBorderPainted(false);
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnLogin.setBounds(60, 187, 135, 36);
		}
		return btnLogin;
	}
	private JButton getBtnJoin() {
		if (btnJoin == null) {
			btnJoin = new JButton("");
			btnJoin.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/btnjoin.png")));
			btnJoin.setFocusPainted(false);
			btnJoin.setBorderPainted(false);
			btnJoin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					joinAction();
				}
			});
			btnJoin.setBounds(60, 187, 270, 36);
		}
		return btnJoin;
	}
	private JLabel getLblTime() {
		if (lblTime == null) {
			lblTime = new JLabel("");
			lblTime.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/time.png")));
			lblTime.setBounds(32, 13, 32, 21);
		}
		return lblTime;
	}
	private JLabel getLblba() {
		if (lblba == null) {
			lblba = new JLabel("");
			lblba.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/배경화면.png")));
			lblba.setBounds(0, 0, 390, 223);
		}
		return lblba;
	}
	private JLabel getLblkong() {
		if (lblkong == null) {
			lblkong = new JLabel("");
			lblkong.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/kong.png")));
			lblkong.setBounds(0, 648, 234, 168);
		}
		return lblkong;
	}
	private JLabel getLblCho() {
		if (lblCho == null) {
			lblCho = new JLabel("");
			lblCho.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/cho.png")));
			lblCho.setBounds(173, 630, 217, 186);
		}
		return lblCho;
	}
	private JLabel getLblCid() {
		if (lblCid == null) {
			lblCid = new JLabel("");
			lblCid.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/Cid.png")));
			lblCid.setBounds(60, 272, 270, 21);
		}
		return lblCid;
	}
	private JTextField getTfCid() {
		if (tfCid == null) {
			tfCid = new JTextField();
			tfCid.setBounds(122, 265, 208, 26);
			tfCid.setColumns(10);
		}
		return tfCid;
	}
	private JLabel getLblCpw() {
		if (lblCpw == null) {
			lblCpw = new JLabel("");
			lblCpw.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/Cpw.png")));
			lblCpw.setBounds(60, 323, 270, 21);
		}
		return lblCpw;
	}
	private JButton getBtnGomenu() {
		if (btnGomenu == null) {
			btnGomenu = new JButton("");
			btnGomenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					login();
				}
			});
			btnGomenu.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/menu.png")));
			btnGomenu.setFocusPainted(false);
			btnGomenu.setBorderPainted(false);
			btnGomenu.setBounds(60, 407, 270, 50);
		}
		return btnGomenu;
	}
	private JLabel getLblCochoc() {
		if (lblCochoc == null) {
			lblCochoc = new JLabel("");
			lblCochoc.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/cochok.png")));
			lblCochoc.setBounds(105, 73, 181, 38);
		}
		return lblCochoc;
	}
	private void joinAction() {
//		Hsh_join hsh_join = new Hsh_join();
//		hsh_join.setVisible(true);
//		setVisible(false);
		Join_kwh hi = new Join_kwh();
		hi.setVisible(true);
		setVisible(false);
	}	
	
	
	
	private void login() {
		String uid = tfCid.getText();
		String upassword = pfCpw.getText();
		
		if(uid.equals("admin") && upassword.equals("1234")) {
			ShareVar.loginUserId = uid;
			Kms_AdminMain ksm_adminmain = new Kms_AdminMain();
			ksm_adminmain.setVisible(true);
			dispose();
		}else {

			Hsh_logindao hsh_logindao = new Hsh_logindao(uid, upassword);
			
			boolean result = hsh_logindao.logincheck();
			
			if(result == true) {
				ShareVar.loginUserId = uid;
				JOptionPane.showMessageDialog(this, uid+"님 환영합니다");
				
//				buy  = new Buy();
//				buy.setVisible(true);											ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ메인화면으로 연결
//				dispose();
				
			}else {
				JOptionPane.showMessageDialog(this, "ID, PassWord를 확인하세요");
			}
	}
	}
	private JPasswordField getPfCpw() {
		if (pfCpw == null) {
			pfCpw = new JPasswordField();
			pfCpw.setBounds(122, 318, 208, 26);
		}
		return pfCpw;
	}
	

	
}
	
