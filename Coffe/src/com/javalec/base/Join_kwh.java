package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.DaoJoin_kwh;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

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
	private JLabel lblClock;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_9_1;
	private JLabel lblNewLabel_9_1_1;
	private JLabel lblNewLabel_9_1_2;
	private JLabel lblNewLabel_9_1_3;
	private JLabel lblNewLabel_9_1_4;
	private JLabel lblNewLabel_9_1_5;
	private JLabel lblNewLabel_9_1_6;

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
		contentPane.add(getLblKong());
		contentPane.add(getLblCho());
		contentPane.add(getBtnJoin());
		contentPane.add(getBtnLogin());
		contentPane.add(getLblName());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getLblNewLabel_5());
		contentPane.add(getLblNewLabel_6());
		contentPane.add(getLblNewLabel_7());
		contentPane.add(getBtnCheck());
		contentPane.add(getLblBa());
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
		contentPane.add(getLblClock());
		contentPane.add(getLblNewLabel_9());
		contentPane.add(getLblNewLabel_9_1());
		contentPane.add(getLblNewLabel_9_1_1());
		contentPane.add(getLblNewLabel_9_1_2());
		contentPane.add(getLblNewLabel_9_1_3());
		contentPane.add(getLblNewLabel_9_1_4());
		contentPane.add(getLblNewLabel_9_1_5());
		contentPane.add(getLblNewLabel_9_1_6());
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
			lblCochoc.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/cochok.png")));
		}
		return lblCochoc;
	}
	private JLabel getLblClock() {
		if (lblClock == null) {
			lblClock = new JLabel("");
			lblClock.setBounds(36, 15, 61, 16);
			lblClock.setFont(new Font("Malayalam Sangam MN", Font.BOLD, 15));
			clockRun();
		}
		return lblClock;
	}
	private JLabel getLblBa() {
		if (lblBa == null) {
			lblBa = new JLabel("");
			lblBa.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/배경화면.png")));
			lblBa.setBounds(0, -50, 390, 223);
		}
		return lblBa;
	}
	private JLabel getLblKong() {
		if (lblKong == null) {
			lblKong = new JLabel("");
			lblKong.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/kong.png")));
			lblKong.setBounds(0, 648, 234, 203);
		}
		return lblKong;
	}
	private JLabel getLblCho() {
		if (lblCho == null) {
			lblCho = new JLabel("");
			lblCho.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/cho.png")));
			lblCho.setBounds(173, 630, 217, 186);
		}
		return lblCho;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					log();
				}
			});
			btnLogin.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/joinlog.png")));
			btnLogin.setBounds(60, 187, 270, 36);
		}
		return btnLogin;
	}
	private JButton getBtnJoin() {
		if (btnJoin == null) {
			btnJoin = new JButton("");
			btnJoin.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/회원가입.png")));
			btnJoin.setBounds(195, 187, 135, 36);
		}
		return btnJoin;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("이름 :");
			lblName.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblName.setForeground(new Color(130, 77, 30));
			lblName.setBounds(45, 300, 40, 15);
		}
		return lblName;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Use ID :");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel.setForeground(new Color(130, 77, 30));
			lblNewLabel.setBounds(45, 255, 65, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("비밀번호 :");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_2.setForeground(new Color(130, 77, 30));
			lblNewLabel_2.setBounds(45, 345, 81, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("비밀번호 확인 :");
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			lblNewLabel_3.setForeground(new Color(130, 77, 30));
			lblNewLabel_3.setBounds(45, 390, 100, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("전화번호 :");
			lblNewLabel_4.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_4.setForeground(new Color(130, 77, 30));
			lblNewLabel_4.setBounds(45, 435, 81, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("E-mail :");
			lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_5.setForeground(new Color(130, 77, 30));
			lblNewLabel_5.setBounds(45, 480, 81, 15);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("주소 :");
			lblNewLabel_6.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_6.setForeground(new Color(130, 77, 30));
			lblNewLabel_6.setBounds(45, 525, 57, 15);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("결제비밀번호 :");
			lblNewLabel_7.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_7.setForeground(new Color(130, 77, 30));
			lblNewLabel_7.setBounds(45, 570, 100, 15);
		}
		return lblNewLabel_7;
	}
	private JButton getBtnCheck() {
		if (btnCheck == null) {
			btnCheck = new JButton("");
			btnCheck.setFocusPainted(false);
			btnCheck.setBorderPainted(false);
			btnCheck.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/check.png")));
//			ImageIcon icon =new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/btnCheck.png"));
//			Image img = icon.getImage();  // 이미지 크기조절
//			Image updateImg = img.getScaledInstance(60, 21, Image.SCALE_SMOOTH);
//			ImageIcon upImg = new ImageIcon(updateImg);
//			btnCheck.setIcon(upImg);
			btnCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dupCheck();
				}
			});
			btnCheck.setFont(new Font("굴림", Font.BOLD, 9));
			btnCheck.setBounds(282, 249, 60, 21);
		}
		return btnCheck;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBackground(new Color(251, 242, 215));
			tfName.setForeground(new Color(130, 77, 30));
			tfName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			tfName.setEditable(false);
			tfName.setColumns(10);
			tfName.setBounds(138, 294, 132, 21);
		}
		return tfName;
	}
	private JTextField getTfID() {
		if (tfID == null) {
			tfID = new JTextField();
			tfID.setForeground(new Color(130, 77, 30));
			tfID.setBackground(new Color(251, 242, 216));
			tfID.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			tfID.setColumns(10);
			tfID.setBounds(138, 249, 132, 21);
		}
		return tfID;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setBackground(new Color(251, 242, 215));
			tfPhone.setForeground(new Color(130, 77, 30));
			tfPhone.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			tfPhone.setEditable(false);
			tfPhone.setColumns(10);
			tfPhone.setBounds(138, 429, 132, 21);
		}
		return tfPhone;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setBackground(new Color(251, 242, 215));
			tfEmail.setForeground(new Color(130, 77, 30));
			tfEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			tfEmail.setEditable(false);
			tfEmail.setColumns(10);
			tfEmail.setBounds(138, 474, 132, 21);
		}
		return tfEmail;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setBackground(new Color(251, 242, 215));
			tfAddress.setForeground(new Color(130, 77, 30));
			tfAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			tfAddress.setEditable(false);
			tfAddress.setColumns(10);
			tfAddress.setBounds(138, 519, 132, 21);
		}
		return tfAddress;
	}
	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("등록");
//			ImageIcon icon1 =new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/btnRegister.png"));
//			Image img1 = icon1.getImage();  // 이미지 크기조절
//			Image updateImg1 = img1.getScaledInstance(60, 21, Image.SCALE_SMOOTH);
//			ImageIcon upImg = new ImageIcon(updateImg1);
//			btnCheck.setIcon(upImg);
			btnRegister.setEnabled(false);
			btnRegister.setFont(new Font("굴림", Font.BOLD, 10));
			btnRegister.setBounds(303, 570, 60, 21);
		}
		return btnRegister;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("");
			btnBack.setBorderPainted(false);
			btnBack.setDefaultCapable(false);
			btnBack.setFocusPainted(false);
			btnBack.setRequestFocusEnabled(false);
			btnBack.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/buttons (3).png")));
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					back();
					log();
				}
			});
			btnBack.setEnabled(false);
			btnBack.setBounds(60, 606, 270, 54);
		}
		return btnBack;
	}
	
	private JComboBox getCbEmail() {
		if (cbEmail == null) {
			cbEmail = new JComboBox();
			cbEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			cbEmail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					emailAction();
				}
				
			});
			cbEmail.setEnabled(false);
			cbEmail.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "daum.net", "nate.com", "gmail.com", "직접 입력"}));
			cbEmail.setBounds(282, 475, 102, 21);
		}
		return cbEmail;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("@");
			lblNewLabel_8.setForeground(new Color(130, 77, 30));
			lblNewLabel_8.setBounds(272, 475, 15, 15);
		}
		return lblNewLabel_8;
	}
	private JPasswordField getPfPayPassword() {
		if (pfPayPassword == null) {
			pfPayPassword = new JPasswordField();
			pfPayPassword.setBackground(new Color(251, 242, 215));
			pfPayPassword.setForeground(new Color(130, 77, 30));
			pfPayPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
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
			pfPayPassword.setBounds(138, 564, 132, 21);
			
			
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
			pfPassword.setBackground(new Color(251, 242, 215));
			pfPassword.setForeground(new Color(130, 77, 30));
			pfPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			pfPassword.addKeyListener(new KeyAdapter() {
			    public void keyTyped(KeyEvent e) {
			        String pass1 = new String(pfPassword.getPassword());
			        String pass2 = new String(pfPassword2.getPassword());
			        if (pass1.equals(pass2)) {
			            lblPassCheck.setText("일치");
			        } else {
			            lblPassCheck.setText("불일치");
			        }
			    }
			});
			
			pfPassword.setEditable(false);
			pfPassword.setBounds(138, 339, 132, 21);
		}
		return pfPassword;
	}
	private JPasswordField getPfPassword2() {
		if (pfPassword2 == null) {
			pfPassword2 = new JPasswordField();
			pfPassword2.setBackground(new Color(251, 242, 215));
			pfPassword2.setForeground(new Color(130, 77, 30));
			pfPassword2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			pfPassword2.addKeyListener(new KeyAdapter() {
			    public void keyTyped(KeyEvent e) {
			        String pass1 = new String(pfPassword.getPassword());
			        String pass2 = new String(pfPassword2.getPassword());
			        if (pass1.equals(pass2)) {
			            lblPassCheck.setText("일치");
			        } else {
			            lblPassCheck.setText("불일치");
			        }
			    }
			});
				
					
				
			pfPassword2.setEditable(false);
			pfPassword2.setBounds(141, 384, 129, 21);
		}
		return pfPassword2;
	}


// function
	
	
	private void log() { // 로그인 버튼누르면 로그인창
		Hsh_login hi = new Hsh_login();
		hi.setVisible(true);
		setVisible(false);
	}

	private void login() {
		Hsh_login hsh_login = new Hsh_login();
		hsh_login.setVisible(true);
		dispose();
	}
	
// 중복체크
	private void dupCheck() {
		String cid = tfID.getText();
		
	
		
		boolean blank = true;   // 중복체가 맞는지 체크 맞으면 true 틀리면 false
		if(cid.equals("")) { 
			JOptionPane.showMessageDialog(this,"ID를 입력하세요.");
			blank = false;
		    
		}
		if(blank){
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
			if(pfPassword.getPassword().length == 0) {
				i++;
				message = "비밀번호를 ";
				pfPassword.requestFocus();
			}
			if(pfPassword2.getPassword().length == 0) {
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
	
	
	
	private void clockRun() {
	    javax.swing.Timer timer = new javax.swing.Timer(100, new ActionListener() {	//1초마다 갱신
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Calendar t = Calendar.getInstance();
				int hour = t.get(Calendar.HOUR);
	            int min = t.get(Calendar.MINUTE);
	            int second = t.get(Calendar.SECOND);
	            String clock = String.format("%02d : %02d : %02d" , hour, min,second);	// 시간을 01:02로표시 원래 1시:2분 이런식
	            lblClock.setText(clock);
			}
		});	 
	    timer.start();
	}

	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("");
			lblNewLabel_9.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/Line 1.png")));
			lblNewLabel_9.setBounds(45, 269, 304, 16);
		}
		return lblNewLabel_9;
	}
	private JLabel getLblNewLabel_9_1() {
		if (lblNewLabel_9_1 == null) {
			lblNewLabel_9_1 = new JLabel("");
			lblNewLabel_9_1.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/Line 1.png")));
			lblNewLabel_9_1.setBounds(45, 314, 304, 16);
		}
		return lblNewLabel_9_1;
	}
	private JLabel getLblNewLabel_9_1_1() {
		if (lblNewLabel_9_1_1 == null) {
			lblNewLabel_9_1_1 = new JLabel("");
			lblNewLabel_9_1_1.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/Line 1.png")));
			lblNewLabel_9_1_1.setBounds(45, 359, 304, 16);
		}
		return lblNewLabel_9_1_1;
	}
	private JLabel getLblNewLabel_9_1_2() {
		if (lblNewLabel_9_1_2 == null) {
			lblNewLabel_9_1_2 = new JLabel("");
			lblNewLabel_9_1_2.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/Line 1.png")));
			lblNewLabel_9_1_2.setBounds(45, 404, 304, 16);
		}
		return lblNewLabel_9_1_2;
	}
	private JLabel getLblNewLabel_9_1_3() {
		if (lblNewLabel_9_1_3 == null) {
			lblNewLabel_9_1_3 = new JLabel("");
			lblNewLabel_9_1_3.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/Line 1.png")));
			lblNewLabel_9_1_3.setBounds(45, 449, 304, 16);
		}
		return lblNewLabel_9_1_3;
	}
	private JLabel getLblNewLabel_9_1_4() {
		if (lblNewLabel_9_1_4 == null) {
			lblNewLabel_9_1_4 = new JLabel("");
			lblNewLabel_9_1_4.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/Line 1.png")));
			lblNewLabel_9_1_4.setBounds(45, 494, 304, 16);
		}
		return lblNewLabel_9_1_4;
	}
	private JLabel getLblNewLabel_9_1_5() {
		if (lblNewLabel_9_1_5 == null) {
			lblNewLabel_9_1_5 = new JLabel("");
			lblNewLabel_9_1_5.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/Line 1.png")));
			lblNewLabel_9_1_5.setBounds(45, 539, 304, 16);
		}
		return lblNewLabel_9_1_5;
	}
	private JLabel getLblNewLabel_9_1_6() {
		if (lblNewLabel_9_1_6 == null) {
			lblNewLabel_9_1_6 = new JLabel("");
			lblNewLabel_9_1_6.setIcon(new ImageIcon(Join_kwh.class.getResource("/com/javalec/image/Line 1.png")));
			lblNewLabel_9_1_6.setBounds(45, 584, 304, 16);
		}
		return lblNewLabel_9_1_6;
	}
}

