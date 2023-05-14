package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.Hsh_joindao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class Hsh_join extends JFrame {

	private JPanel contentPane;
	private JButton btnLogin;
	private JButton btnJoin;
	private JLabel lblTime;
	private JLabel lblWifi;
	private JLabel lblCochoc;
	private JLabel lblBa;
	private JLabel lblKong;
	private JLabel lblCho;
	private JLabel lblCid;
	private JLabel lblName;
	private JLabel lblCpw;
	private JLabel lblCcpw;
	private JLabel lbltelno;
	private JLabel lblEmail;
	private JLabel lblAddress;
	private JLabel lblPPw;
	private JTextField tfName;
	private JTextField tfCid;
	private JTextField tfCpw;
	private JTextField tfCcpw;
	private JTextField tfTelno;
	private JTextField tfEmail;
	private JTextField tfAddress;
	private JLabel lblNewLabel;
	private JComboBox cbEmail;
	private JButton btnCheck;
	private JButton btnPaycheck;
	private JButton btnBack;
	private JPasswordField pfPaypassword;
	String message = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hsh_join frame = new Hsh_join();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);  // jframe이 화면에 중앙에 위치하도록 하기 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Hsh_join() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setLocationRelativeTo(null);  // jframe이 화면에 중앙에 위치하도록 하기 
			}
		});
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 844);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 227, 182));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnJoin());
		contentPane.add(getBtnLogin());
		contentPane.add(getLblTime());
		contentPane.add(getLblWifi());
		contentPane.add(getLblCochoc());
		contentPane.add(getLblBa());
		contentPane.add(getLblKong());
		contentPane.add(getLblCho());
		contentPane.add(getLblCid());
		contentPane.add(getLblName());
		contentPane.add(getLblCpw());
		contentPane.add(getLblCcpw());
		contentPane.add(getLbltelno());
		contentPane.add(getLblEmail());
		contentPane.add(getLblAddress());
		contentPane.add(getLblPPw());
		contentPane.add(getTfName());
		contentPane.add(getTfCid());
		contentPane.add(getTfCpw());
		contentPane.add(getTfCcpw());
		contentPane.add(getTfTelno());
		contentPane.add(getTfEmail());
		contentPane.add(getTfAddress());
		contentPane.add(getLblNewLabel());
		contentPane.add(getCbEmail());
		contentPane.add(getBtnCheck());
		contentPane.add(getBtnPaycheck());
		contentPane.add(getBtnBack());
		contentPane.add(getPfPaypassword());
	}

	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					login();
				}
			});
			btnLogin.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/joinlog.png")));
			btnLogin.setFocusPainted(false);
			btnLogin.setBorderPainted(false);
			btnLogin.setBounds(60, 187, 270, 36);
		}
		return btnLogin;
	}
	private JButton getBtnJoin() {
		if (btnJoin == null) {
			btnJoin = new JButton("");
			btnJoin.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/logjoin.png")));
			btnJoin.setFocusPainted(false);
			btnJoin.setBorderPainted(false);
			btnJoin.setBounds(195, 187, 135, 36);
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
	private JLabel getLblWifi() {
		if (lblWifi == null) {
			lblWifi = new JLabel("");
			lblWifi.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/wifi.png")));
			lblWifi.setBounds(295, 15, 65, 16);
		}
		return lblWifi;
	}
	private JLabel getLblCochoc() {
		if (lblCochoc == null) {
			lblCochoc = new JLabel("");
			lblCochoc.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/cochok.png")));
			lblCochoc.setBounds(105, 73, 181, 38);
		}
		return lblCochoc;
	}
	private JLabel getLblBa() {
		if (lblBa == null) {
			lblBa = new JLabel("");
			lblBa.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/배경화면.png")));
			lblBa.setBounds(0, 0, 390, 223);
		}
		return lblBa;
	}
	private JLabel getLblKong() {
		if (lblKong == null) {
			lblKong = new JLabel("");
			lblKong.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/kong.png")));
			lblKong.setBounds(0, 648, 234, 203);
		}
		return lblKong;
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
			lblCid.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/idbar.png")));
			lblCid.setBounds(61, 291, 270, 21);
		}
		return lblCid;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("");
			lblName.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/name.png")));
			lblName.setBounds(61, 253, 270, 21);
		}
		return lblName;
	}
	private JLabel getLblCpw() {
		if (lblCpw == null) {
			lblCpw = new JLabel("");
			lblCpw.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/password2.png")));
			lblCpw.setBounds(60, 328, 270, 21);
		}
		return lblCpw;
	}
	private JLabel getLblCcpw() {
		if (lblCcpw == null) {
			lblCcpw = new JLabel("");
			lblCcpw.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/ccpw.png")));
			lblCcpw.setBounds(60, 361, 270, 21);
		}
		return lblCcpw;
	}
	private JLabel getLbltelno() {
		if (lbltelno == null) {
			lbltelno = new JLabel("");
			lbltelno.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/telno.png")));
			lbltelno.setBounds(60, 399, 270, 28);
		}
		return lbltelno;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("");
			lblEmail.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/email.png")));
			lblEmail.setBounds(60, 437, 270, 21);
		}
		return lblEmail;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("");
			lblAddress.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/address2.png")));
			lblAddress.setBounds(60, 475, 270, 28);
		}
		return lblAddress;
	}
	private JLabel getLblPPw() {
		if (lblPPw == null) {
			lblPPw = new JLabel("");
			lblPPw.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					payRegist();
				}
			});
			lblPPw.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/ppw.png")));
			lblPPw.setBounds(60, 513, 270, 21);
		}
		return lblPPw;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBackground(new Color(248, 227, 182));
			tfName.setBounds(135, 244, 143, 26);
			tfName.setColumns(10);
			tfName.setEditable(false);
		}
		return tfName;
	}
	private JTextField getTfCid() {
		if (tfCid == null) {
			tfCid = new JTextField();
			tfCid.setColumns(10);
			tfCid.setBackground(new Color(248, 227, 182));
			tfCid.setBounds(135, 286, 143, 26);
			
		}
		return tfCid;
	}
	private JTextField getTfCpw() {
		if (tfCpw == null) {
			tfCpw = new JTextField();
			tfCpw.setColumns(10);
			tfCpw.setBackground(new Color(248, 227, 182));
			tfCpw.setBounds(135, 323, 195, 26);
			tfCpw.setEditable(false);
		}
		return tfCpw;
	}
	private JTextField getTfCcpw() {
		if (tfCcpw == null) {
			tfCcpw = new JTextField();
			tfCcpw.setColumns(10);
			tfCcpw.setBackground(new Color(248, 227, 182));
			tfCcpw.setBounds(135, 356, 195, 26);
			tfCcpw.setEditable(false);
		}
		return tfCcpw;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setColumns(10);
			tfTelno.setBackground(new Color(248, 227, 182));
			tfTelno.setBounds(135, 394, 195, 26);
			tfTelno.setEditable(false);
		}
		return tfTelno;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBackground(new Color(248, 227, 182));
			tfEmail.setBounds(135, 432, 73, 26);
			tfEmail.setEditable(false);
		}
		return tfEmail;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBackground(new Color(248, 227, 182));
			tfAddress.setBounds(135, 470, 195, 26);
			tfAddress.setEditable(false);
		}
		return tfAddress;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("@");
			lblNewLabel.setBounds(210, 440, 21, 16);
		}
		return lblNewLabel;
	}
	private JComboBox getCbEmail() {
		if (cbEmail == null) {
			cbEmail = new JComboBox();
			cbEmail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					emailAction();
				}
			});
			cbEmail.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "daum.net", "nate.com", "gmail.com", "직접입력"}));
			cbEmail.setBounds(227, 432, 105, 27);
		}
		return cbEmail;
	}
	private JButton getBtnCheck() {
			
		if (btnCheck == null) {
			btnCheck = new JButton("");
			btnCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dupCheck();
				}
			});
			btnCheck.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/check.png")));
			btnCheck.setFocusPainted(false);
			btnCheck.setBorderPainted(false);
			
			btnCheck.setBounds(280, 292, 60, 15);
		}
		return btnCheck;
	}
	private JButton getBtnPaycheck() {
		if (btnPaycheck == null) {
			btnPaycheck = new JButton("");
			btnPaycheck.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/paycheck.png")));
			btnPaycheck.setFocusPainted(false);
			btnPaycheck.setBorderPainted(false);
			btnPaycheck.setBounds(270, 513, 60, 15);
		}
		return btnPaycheck;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					back();
				}
			});
			btnBack.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/가입완료.png")));
			btnBack.setFocusPainted(false);
			btnBack.setBorderPainted(false);
			btnBack.setBounds(60, 594, 270, 41);
		}
		return btnBack;
	}
	
	
	
	private JPasswordField getPfPaypassword() {
		if (pfPaypassword == null) {
			pfPaypassword = new JPasswordField();
			pfPaypassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					pfPaypassword.setEditable(true);
				}
			});
			pfPaypassword.setBackground(new Color(248, 227, 182));
			pfPaypassword.setBounds(135, 508, 130, 26);
			pfPaypassword.setEditable(false);
		}
		return pfPaypassword;
		
	}
	
	
	
	
	
	// function
	
	
	
	
	private void login() {
		Hsh_login hsh_login = new Hsh_login();
		hsh_login.setVisible(true);
		dispose();
	}
	
	
	// 정보받아서 다오에 넘겨주기
	private void back() {
		tfAddress.setEditable(true);
		tfCcpw.setEditable(true);
		tfCpw.setEditable(true);
		tfTelno.setEditable(true);
		pfPaypassword.setEditable(true);
		tfEmail.setEditable(true);
		tfName.setEditable(true);
		
		
		
		int i_chk = insertFieldCheck();
		if (i_chk == 0) {
			insertAction();
			
		}else {
			JOptionPane.showMessageDialog(this, message + "입력하세요!","회원가입",JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		
	}
	
	
	
	
	
		private void dupCheck() {
			String uid = tfCid.getText();
			if(uid.isEmpty()) {
				JOptionPane.showMessageDialog(this,"아이디를 입력해주세요.");
			}else {
				Hsh_joindao hsh_joindao = new Hsh_joindao(uid);
				boolean result = hsh_joindao.dupCheck();
					if(result) {
						JOptionPane.showMessageDialog(this, "중복된 아이디 입니다.");
					}else {
						JOptionPane.showMessageDialog(this, "사용가능한 아이디 입니다.");
						tfName.setEditable(true);
						tfCpw.setEditable(true);
						tfEmail.setEditable(true);
						tfTelno.setEditable(true);
						tfAddress.setEditable(true);
						btnJoin.setEnabled(true);
						cbEmail.setEnabled(true);
						pfPaypassword.setEnabled(true);
						pfPaypassword.setEditable(true);
					}
			}
	
}

			private void emailAction() {
				int i = cbEmail.getSelectedIndex();
				String emailselect = "";
				switch(i) {
				case 0:
					cbEmail.setEditable(false);
					break;
				case 1:
					cbEmail.setEditable(false);
					break;
				case 2:
					cbEmail.setEditable(false);
					break;
				case 3:
					cbEmail.setEditable(true);
					break;
				default:
					break;
				}
			}
			
			
			
			
			private void payRegist() {
				
				// 결제비밀번호 화면 불러오기
				
				
				
				
				
			}
			
			
			
			
			
			private int insertFieldCheck() {
				int i = 0;
				
				
				if(tfName.getText().trim().length() == 0) {
					i++;
					message = "이름을 ";
					tfName.requestFocus();  // 어디 자리가 비었는지 커서로 보여
				}
				if(tfCid.getText().trim().length() == 0) {
					i++;
					message = "ID를 ";
					tfCid.requestFocus();
				}
				if(tfCpw.getText().trim().length() == 0) {
					i++;
					message = "비밀번호를 ";
					tfCpw.requestFocus();
				}
				if(tfTelno.getText().trim().length() == 0) {
					i++;
					message = "전화번호를 ";
					tfTelno.requestFocus();
				}
				if(tfEmail.getText().trim().length() == 0) {
					i++;
					message = "E-mail을 ";
					tfEmail.requestFocus();
				}
				if(tfAddress.getText().trim().length() == 0) {
					i++;
					message = "주소를 ";
					tfAddress.requestFocus();
				}
				if(pfPaypassword.getPassword().length == 0) {
					i++;
					message = "결제비밀번호를 ";
					pfPaypassword.requestFocus();
				}
				return i;
				
			}
			
			
			private void insertAction() {
				String uid = tfCid.getText();
				String upassword = tfCpw.getText();
				String upassword2 = tfCcpw.getText();
				
				//비빌번호 , 비밀번호확인 일치하는지 확인
				if (upassword != upassword2) {
					JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
					tfCcpw.setText("");
					tfCpw.setText("");
					
				}
				
				String uname = tfName.getText();
				String uphone = tfTelno.getText();
				String uemail = tfEmail.getText();
				String uemailcb = cbEmail.getSelectedItem().toString();
				String uaddress = tfAddress.getText();
				char[] paypassword = pfPaypassword.getPassword();
				String passwordStr = new String(paypassword);
				
				if (passwordStr.length()>6) {
					JOptionPane.showMessageDialog(this, "결제비밀번호를 4자리이하로 설정해주세요.");
					
				}

				if( uname.isEmpty() || uid.isEmpty() || upassword.isEmpty() || uphone.isEmpty() || uemail.isEmpty() || uemailcb.isEmpty()
						|| uaddress.isEmpty() || passwordStr.isEmpty() ) {
					JOptionPane.showMessageDialog(this, "회원정보를 입력해주세요");
				}

				
				Hsh_joindao hsh_joindao = new Hsh_joindao(uid, upassword, uname, uphone, uemail+"@"+uemailcb, uaddress, passwordStr);
				boolean result = hsh_joindao.joinAction();
				if(result) {
					JOptionPane.showMessageDialog(this, "회원가입이 완료되었습니다!");
				}else {
					//JOptionPane.showMessageDialog(this, "정보를 확인하세요!");
				}
				
				
			}
			
			private void clearAction() {
				tfName.setText("");
				tfAddress.setText("");
				tfCcpw.setText("");
				tfCpw.setText("");
				tfEmail.setText("");
				tfTelno.setText("");
				pfPaypassword.setText("");
				tfTelno.setText("");
			}
	
}
