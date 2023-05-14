package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.DaoJoin_kwh;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Join_kwh extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JLabel lblCochoc;
	private JLabel lblBa;
	private JLabel lblKong;
	private JLabel lblCho;
	private JButton btnLogin;
	private JButton btnJoin;
	private JLabel lblName;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnCheck;
	private JTextField tfName;
	private JTextField tfID;
	private JTextField tfPhone;
	private JTextField tfEmail;
	private JTextField tfAddress;
	private JButton btnRegister;
	private JButton btnBack;
	private JComboBox cbEmail;
	private JLabel lblNewLabel_8;
	private JPasswordField pfPayPassword;
	String message = "";
	private JLabel lblPassCheck;
	private JPasswordField pfPassword;
	private JPasswordField pfPassword2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join_kwh frame = new Join_kwh();
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
	public Join_kwh() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setLocationRelativeTo(null);  // jframe이 화면에 중앙에 위치하도록 하기 
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 872);							// 백그라운드 프레임 패널 사이즈
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 227, 182));	// 백그라운드 프레임 패널 색
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblCochoc());
		contentPane.add(getLblBa());
		contentPane.add(getLblKong());
		contentPane.add(getLblCho());
		contentPane.add(getBtnLogin());
		contentPane.add(getBtnJoin());
		contentPane.add(getLblName());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getLblNewLabel_5());
		contentPane.add(getLblNewLabel_6());
		contentPane.add(getLblNewLabel_7());
		contentPane.add(getBtnCheck());
		contentPane.add(getTfName());
		contentPane.add(getTfID());
		contentPane.add(getTfPhone());
		contentPane.add(getTfEmail());
		contentPane.add(getTfAddress());
		contentPane.add(getBtnRegister());
		contentPane.add(getBtnBack());
		contentPane.add(getCbEmail());
		contentPane.add(getLblNewLabel_8());
		contentPane.add(getPfPayPassword());
		contentPane.add(getLblPassCheck());
		contentPane.add(getPfPassword());
		contentPane.add(getPfPassword2());
	}
	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(303, 15, 65, 18);
			lblNewLabel_1.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/wifi.png")));
		}
		return lblNewLabel_1;
	}
	private JLabel getLblCochoc() {
		if (lblCochoc == null) {
			lblCochoc = new JLabel("");
			lblCochoc.setBounds(105, 73, 181, 38);
			lblCochoc.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/cochok.png")));
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
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("");
			btnLogin.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/joinlog.png")));
			btnLogin.setBounds(60, 187, 270, 36);
		}
		return btnLogin;
	}
	private JButton getBtnJoin() {
		if (btnJoin == null) {
			btnJoin = new JButton("");
			btnJoin.setIcon(new ImageIcon(Hsh_login.class.getResource("/com/javalec/image/logjoin.png")));
			btnJoin.setBounds(195, 187, 135, 36);
		}
		return btnJoin;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("이름 :");
			lblName.setBounds(61, 290, 40, 15);
		}
		return lblName;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("ID :");
			lblNewLabel.setBounds(61, 255, 40, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("비밀번호 :");
			lblNewLabel_2.setBounds(61, 325, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("비밀번호 확인 :");
			lblNewLabel_3.setBounds(61, 360, 100, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("전화번호 :");
			lblNewLabel_4.setBounds(61, 395, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("E-mail :");
			lblNewLabel_5.setBounds(61, 430, 57, 15);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("주소 :");
			lblNewLabel_6.setBounds(61, 465, 57, 15);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("결제비밀번호 :");
			lblNewLabel_7.setBounds(61, 500, 100, 15);
		}
		return lblNewLabel_7;
	}
	private JButton getBtnCheck() {
		if (btnCheck == null) {
			btnCheck = new JButton("Check");
			btnCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dupCheck();
				}
			});
			btnCheck.setFont(new Font("굴림", Font.BOLD, 9));
			btnCheck.setBounds(289, 255, 60, 21);
		}
		return btnCheck;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setEditable(false);
			tfName.setColumns(10);
			tfName.setBounds(154, 285, 116, 21);
		}
		return tfName;
	}
	private JTextField getTfID() {
		if (tfID == null) {
			tfID = new JTextField();
			tfID.setColumns(10);
			tfID.setBounds(154, 255, 116, 21);
		}
		return tfID;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setEditable(false);
			tfPhone.setColumns(10);
			tfPhone.setBounds(154, 390, 116, 21);
		}
		return tfPhone;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setEditable(false);
			tfEmail.setColumns(10);
			tfEmail.setBounds(154, 425, 116, 21);
		}
		return tfEmail;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setEditable(false);
			tfAddress.setColumns(10);
			tfAddress.setBounds(154, 460, 116, 21);
		}
		return tfAddress;
	}
	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("등록");
			btnRegister.setEnabled(false);
			btnRegister.setFont(new Font("굴림", Font.BOLD, 10));
			btnRegister.setBounds(289, 495, 60, 21);
		}
		return btnRegister;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("회원가입");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					back();
				}
			});
			btnBack.setEnabled(false);
			btnBack.setBounds(60, 594, 270, 41);
		}
		return btnBack;
	}
	
	private JComboBox getCbEmail() {
		if (cbEmail == null) {
			cbEmail = new JComboBox();
			cbEmail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					emailAction();
				}
				
			});
			cbEmail.setEnabled(false);
			cbEmail.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "daum.net", "nate.com", "gmail.com", "직접 입력"}));
			cbEmail.setBounds(289, 425, 60, 21);
		}
		return cbEmail;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("@");
			lblNewLabel_8.setBounds(275, 430, 15, 15);
		}
		return lblNewLabel_8;
	}
	private JPasswordField getPfPayPassword() {
		if (pfPayPassword == null) {
			pfPayPassword = new JPasswordField();
			pfPayPassword.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') { // 패스워드창 숫자만 입력할 수 있게하기
						
					}else {
						JOptionPane.showMessageDialog(null,"숫자만 입력하세요", "경고",JOptionPane.ERROR_MESSAGE);
						pfPayPassword.setText("");
					}
				}
			});
			pfPayPassword.setEditable(false);
			pfPayPassword.setBounds(154, 495, 116, 21);
			
			
		}
		return pfPayPassword;
	}
	
	private JLabel getLblPassCheck() {
		if (lblPassCheck == null) {
			lblPassCheck = new JLabel("");
			lblPassCheck.setBounds(282, 360, 57, 15);
		}
		return lblPassCheck;
	}


	private JPasswordField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.setEditable(false);
			pfPassword.setBounds(154, 320, 116, 21);
		}
		return pfPassword;
	}
	private JPasswordField getPfPassword2() {
		if (pfPassword2 == null) {
			pfPassword2 = new JPasswordField();
			pfPassword2.setEditable(false);
			pfPassword2.setBounds(154, 355, 116, 21);
		}
		return pfPassword2;
	}


// function

	private void login() {
		Hsh_login hsh_login = new Hsh_login();
		hsh_login.setVisible(true);
		dispose();
	}
	
// 중복체크
	private void dupCheck() {
		String cid = tfID.getText();
		
		DaoJoin_kwh dao = new DaoJoin_kwh(cid);
		boolean result = dao.dupCheck();
		if(result) {// true 중복
			JOptionPane.showMessageDialog(this, "중복된 아이디 입니다.");
		}else {
			JOptionPane.showMessageDialog(this, "사용가능한 아이디 입니다.");
			tfName.setEditable(true);
			pfPassword.setEditable(true);
			pfPassword2.setEditable(true);
			tfEmail.setEditable(true);
			tfPhone.setEditable(true);
			tfAddress.setEditable(true);
			btnJoin.setEnabled(true);
			cbEmail.setEnabled(true);
			pfPayPassword.setEnabled(true);
			pfPayPassword.setEditable(true);
			btnRegister.setEnabled(true);
			btnBack.setEnabled(true);
			
			
			
			
		}
		
	}	
	// 입력되지 않은 공간 찾아주기
		private int insertFieldCheck() {
			int i = 0;
			
			
			if(tfName.getText().trim().length() == 0) {
				i++;
				message = "이름을 ";
				tfName.requestFocus();  // 어디 자리가 비었는지 커서로 보여
			}
			if(tfID.getText().trim().length() == 0) {
				i++;
				message = "ID를 ";
				tfID.requestFocus();
			}
			if(pfPassword.getText().trim().length() == 0) {
				i++;
				message = "비밀번호를 ";
				pfPassword.requestFocus();
			}
			if(pfPassword2.getText().trim().length() == 0) {
				i++;
				message = "비밀번호확인을 ";
				pfPassword2.requestFocus();
			}
			if(tfPhone.getText().trim().length() == 0) {
				i++;
				message = "전화번호를 ";
				tfPhone.requestFocus();
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
			if(pfPayPassword.getPassword().length == 0) {
				i++;
				message = "결제비밀번호를 ";
				pfPayPassword.requestFocus();
			}
			return i;
			
		}
		
	
	private void back() {
		int i_chk = insertFieldCheck();
		if (i_chk == 0) {
			insertAction();
		}else {
			JOptionPane.showMessageDialog(this, message + "입력하세요!");
		}
		
	}
	
	
	
	// dao에 데이터 넘겨주기
	private void insertAction() {
		String cid = tfID.getText();
		String cname = tfName.getText();
		char[] password = pfPassword.getPassword();
		String cpassword = new String(password);
		char[] password2 = pfPassword2.getPassword();
		String cpassword2 = new String(password2);
		
		
		
		String cphone = tfPhone.getText();
		String cemail = tfEmail.getText();
		String caddress = tfAddress.getText();
	
		// 자바유틸데이트로 현재시각을 받아서 자바sql데이트에 넣어야함
				java.util.Date now = new java.util.Date();
				java.sql.Date cinsertdate = new java.sql.Date(now.getTime());
				
		
		char[] paypassword = pfPayPassword.getPassword();
		String passwordStr = new String(paypassword);{
	
			boolean isPasswordMatched = true;   // 비밀번호가 맞는지 체크 맞으면 true 틀리면 false
			if(!cpassword.equals(cpassword2)) { 
			    isPasswordMatched = false;
			}
	
			if(isPasswordMatched) {// true일시 다오실행
			    DaoJoin_kwh dao = new DaoJoin_kwh(cid, cname, cpassword, cphone, cemail, caddress,cinsertdate,passwordStr);
			    boolean result = dao.joinAction();
			    if(result) {// true = 쿼리문이 잘 실행되어 db에 저장됌
			        JOptionPane.showMessageDialog(this, "회원가입이 완료되었습니다!");
			    } else {//db에 저장안됌
			        JOptionPane.showMessageDialog(this, "정보를 확인하세요!");
			    }
			} else {
			    JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.","오류",JOptionPane.ERROR_MESSAGE);
			}
	
	
	
		}}
	
	
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
}

