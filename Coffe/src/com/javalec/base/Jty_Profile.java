package com.javalec.base;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.Jty_Dao_Profile;
import com.javalec.dto.Jty_Dto_Profile;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Jty_Profile extends JFrame {

	private JPanel contentPane;

	// private Image backgroundImage = new
	// ImageIcon(Jty_Profile.class.getResource("/com/javalec/Image/mypagebackground.png")).getImage();
	private JLabel lblNewLabel;
	private JTextField tfName;
	private JTextField tfUserid;
	private JTextField tfPassword;
	private JTextField tfConfirmPassword;
	private JTextField tfPhone;
	private JTextField tfEmail;
	private JTextField tfAddress;
	private JButton btnBack;
	private JLabel lblNewLabel_1;
	private JLabel lblFace;
	private JButton btnAllUpdate;
	private JLabel lblDeleteUSer;
	private JLabel lblNewLabel_2_1;
	private JLabel lblInsertDate;
	private JPanel panel;
	private JLabel lblLine;
	private JLabel lblLine_1;
	private JLabel lblLine_2;
	private JLabel lblLine_3;
	private JLabel lblLine_4;
	private JLabel lblLine_5;
	private JLabel lblLine_6;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_3;
	private JLabel lblNewLabel_2_4;
	private JLabel lblNewLabel_2_5;
	private JLabel lblNewLabel_2_6;
	private JLabel lblNewLabel_2_7;

	private JLabel lblClock;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox cbEmail;
	private JLabel lblpasswordCheck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jty_Profile frame = new Jty_Profile();
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

	public Jty_Profile() {
		;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setLocationRelativeTo(null);

				openProfile();
			}
		});
		setTitle("프로필");
		setBackground(new Color(248, 227, 182));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 872);
		contentPane = new JPanel(); // {
//			@Override
//			protected void paintComponent(Graphics g) {
//				super.paintComponent(g);
//				g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
//			}
//		};
		contentPane.setBackground(new Color(248, 227, 182));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnBack());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBtnAllUpdate());
		contentPane.add(getLblDeleteUSer());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getLblInsertDate());
		contentPane.add(getPanel());
		contentPane.add(getLblClock());
		contentPane.add(getLblNewLabel_3());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("마이페이지");
			lblNewLabel.setBounds(23, 80, 78, 19);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			lblNewLabel.setForeground(new Color(131, 77, 30));
		}
		return lblNewLabel;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			tfName.setBounds(101, 245, 182, 21);
			tfName.setBackground(new Color(252, 242, 217));
			tfName.setColumns(10);
			tfName.setBorder(null); // 텍스트 필드의 테두리를 없앰
		}
		return tfName;
	}

	private JTextField getTfUserid() {
		if (tfUserid == null) {
			tfUserid = new JTextField();
			tfUserid.setEditable(false);
			tfUserid.setForeground(new Color(0, 0, 0));
			tfUserid.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			tfUserid.setBounds(101, 109, 182, 21);
			tfUserid.setColumns(10);
			tfUserid.setBorder(null);
			tfUserid.setBackground(new Color(252, 242, 217));
		}
		return tfUserid;
	}

	private JTextField getTfPassword() {
		if (tfPassword == null) {
			tfPassword = new JTextField();
			tfPassword.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			tfPassword.setBounds(101, 154, 182, 21);
			tfPassword.setColumns(10);
			tfPassword.setBorder(null);
			tfPassword.setBackground(new Color(252, 242, 217));
			tfPassword.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					String pass1 = new String(tfPassword.getText());
					String pass2 = new String(tfConfirmPassword.getText());
					if (pass1.equals(pass2)) {
						lblpasswordCheck.setText("비밀번호가 일치합니다.");
					} else {
						lblpasswordCheck.setText("비밀번호가 일치하지 않습니다.");
					}
				}
			});
		}
		return tfPassword;
	}

	private JTextField getTfConfirmPassword() {
		if (tfConfirmPassword == null) {
			tfConfirmPassword = new JTextField();
			tfConfirmPassword.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			tfConfirmPassword.setBounds(101, 199, 180, 21);
			tfConfirmPassword.setColumns(10);
			tfConfirmPassword.setBorder(null);
			tfConfirmPassword.setBackground(new Color(252, 242, 217));
			tfConfirmPassword.addKeyListener(new KeyAdapter() {
				
				public void keyTyped(KeyEvent e) {
					String pass1 = new String(tfPassword.getText());
					String pass2 = new String(tfConfirmPassword.getText());
					if (pass1.equals(pass2)) {
						lblpasswordCheck.setText("비밀번호가 일치합니다.");
					} else {
						lblpasswordCheck.setText("비밀번호가 일치하지 않습니다.");
					}
				}
			});

		}
		return tfConfirmPassword;
	}

	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			tfPhone.setBounds(101, 289, 182, 21);
			tfPhone.setColumns(10);
			tfPhone.setBorder(null);
			tfPhone.setBackground(new Color(252, 242, 217));
		}
		return tfPhone;
	}

	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			tfEmail.setBounds(101, 336, 94, 21);
			tfEmail.setColumns(10);
			tfEmail.setBorder(null);
			tfEmail.setBackground(new Color(252, 242, 217));
		}
		return tfEmail;
	}

	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			tfAddress.setBounds(101, 382, 182, 21);
			tfAddress.setColumns(10);
			tfAddress.setBorder(null);
			tfAddress.setBackground(new Color(252, 242, 217));
		}
		return tfAddress;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("");
			btnBack.setBorder(null); // 버튼의 테두리를 없앰
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					backAction();
				}
			});
			btnBack.setIcon(new ImageIcon(Jty_Profile.class.getResource("/com/javalec/image/BackIcon.png")));
			btnBack.setBounds(31, 54, 18, 24);
		}
		return btnBack;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Jty_Profile.class.getResource("/com/javalec/image/storeLogo.png")));
			lblNewLabel_1.setBounds(133, 44, 113, 48);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblFace() {
		if (lblFace == null) {
			lblFace = new JLabel("");
			lblFace.setBounds(128, 10, 64, 64);
			lblFace.setIcon(new ImageIcon(Jty_Profile.class.getResource("/com/javalec/image/얼굴.png")));
		}
		return lblFace;
	}

	private JButton getBtnAllUpdate() {
		if (btnAllUpdate == null) {
			btnAllUpdate = new JButton("");
			btnAllUpdate.setBorder(null); // 버튼의 테두리를 없앰
			btnAllUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					allUpdateAction();

				}
			});
			btnAllUpdate.setIcon(new ImageIcon(Jty_Profile.class.getResource("/com/javalec/image/수정버튼.png")));
			btnAllUpdate.setBackground(new Color(248, 227, 182));
			btnAllUpdate.setBounds(279, 575, 76, 33);
		}
		return btnAllUpdate;
	}

	private JLabel getLblDeleteUSer() {
		if (lblDeleteUSer == null) {
			lblDeleteUSer = new JLabel("회원탈퇴");
			lblDeleteUSer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//					Jty_Profile_Dialog profile_dialog = new Jty_Profile_Dialog();
//					profile_dialog.setVisible(true);
					userDelete();
				}
			});
			lblDeleteUSer.setHorizontalAlignment(SwingConstants.CENTER);
			lblDeleteUSer.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblDeleteUSer.setForeground(new Color(131, 77, 30));
			lblDeleteUSer.setBounds(157, 735, 70, 21);
		}
		return lblDeleteUSer;
	}

	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("가입일 : ");
			lblNewLabel_2_1.setForeground(new Color(131, 77, 30));
			lblNewLabel_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblNewLabel_2_1.setBounds(122, 768, 57, 15);
		}
		return lblNewLabel_2_1;
	}

	private JLabel getLblInsertDate() {
		if (lblInsertDate == null) {
			lblInsertDate = new JLabel("");
			lblInsertDate.setForeground(new Color(131, 77, 30));
			lblInsertDate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblInsertDate.setBounds(182, 768, 125, 15);
		}
		return lblInsertDate;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(252, 242, 217));
			panel.setBounds(35, 116, 320, 449);
			panel.setLayout(null);
			panel.add(getTfUserid());
			panel.add(getTfPassword());
			panel.add(getTfConfirmPassword());
			panel.add(getTfName());
			panel.add(getTfPhone());
			panel.add(getTfEmail());
			panel.add(getTfAddress());
			panel.add(getLblNewLabel());
			panel.add(getLblFace());
			panel.add(getLblLine());
			panel.add(getLblLine_1());
			panel.add(getLblLine_2());
			panel.add(getLblLine_3());
			panel.add(getLblLine_4());
			panel.add(getLblLine_5());
			panel.add(getLblLine_6());
			panel.add(getLblNewLabel_2());
			panel.add(getLblNewLabel_2_2());
			panel.add(getLblNewLabel_2_3());
			panel.add(getLblNewLabel_2_4());
			panel.add(getLblNewLabel_2_5());
			panel.add(getLblNewLabel_2_6());
			panel.add(getLblNewLabel_2_7());
			panel.add(getLblNewLabel_4());
			panel.add(getCbEmail());
			panel.add(getLblpasswordCheck());
		}
		return panel;
	}

	private JLabel getLblLine() {
		if (lblLine == null) {
			lblLine = new JLabel("");
			lblLine.setBounds(12, 131, 270, 1);
			lblLine.setOpaque(true); // 불투명성 활성화
			lblLine.setBackground(new Color(131, 77, 30));
			lblLine.setBackground(new Color(131, 77, 30));
		}
		return lblLine;
	}

	private JLabel getLblLine_1() {
		if (lblLine_1 == null) {
			lblLine_1 = new JLabel("");
			lblLine_1.setBounds(12, 177, 270, 1);
			lblLine_1.setOpaque(true);
			lblLine_1.setBackground(new Color(131, 77, 30));
		}
		return lblLine_1;
	}

	private JLabel getLblLine_2() {
		if (lblLine_2 == null) {
			lblLine_2 = new JLabel("");
			lblLine_2.setBounds(13, 222, 270, 1);
			lblLine_2.setOpaque(true);
			lblLine_2.setBackground(new Color(131, 77, 30));
		}
		return lblLine_2;
	}

	private JLabel getLblLine_3() {
		if (lblLine_3 == null) {
			lblLine_3 = new JLabel("");
			lblLine_3.setBounds(12, 266, 270, 1);
			lblLine_3.setOpaque(true);
			lblLine_3.setBackground(new Color(131, 77, 30));
		}
		return lblLine_3;
	}

	private JLabel getLblLine_4() {
		if (lblLine_4 == null) {
			lblLine_4 = new JLabel("");
			lblLine_4.setBounds(12, 310, 270, 1);
			lblLine_4.setOpaque(true);
			lblLine_4.setBackground(new Color(131, 77, 30));
		}
		return lblLine_4;
	}

	private JLabel getLblLine_5() {
		if (lblLine_5 == null) {
			lblLine_5 = new JLabel("");
			lblLine_5.setBounds(13, 357, 270, 1);
			lblLine_5.setOpaque(true);
			lblLine_5.setBackground(new Color(131, 77, 30));
		}
		return lblLine_5;
	}

	private JLabel getLblLine_6() {
		if (lblLine_6 == null) {
			lblLine_6 = new JLabel("");
			lblLine_6.setBounds(12, 403, 270, 1);
			lblLine_6.setOpaque(true);
			lblLine_6.setBackground(new Color(131, 77, 30));
		}
		return lblLine_6;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("아이디");
			lblNewLabel_2.setForeground(new Color(131, 77, 30));
			lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_2.setBounds(12, 109, 90, 21);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("비밀번호");
			lblNewLabel_2_2.setForeground(new Color(131, 77, 30));
			lblNewLabel_2_2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_2_2.setBounds(12, 154, 90, 21);
		}
		return lblNewLabel_2_2;
	}

	private JLabel getLblNewLabel_2_3() {
		if (lblNewLabel_2_3 == null) {
			lblNewLabel_2_3 = new JLabel("비밀번호 확인");
			lblNewLabel_2_3.setForeground(new Color(131, 77, 30));
			lblNewLabel_2_3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_2_3.setBounds(12, 199, 90, 21);
		}
		return lblNewLabel_2_3;
	}

	private JLabel getLblNewLabel_2_4() {
		if (lblNewLabel_2_4 == null) {
			lblNewLabel_2_4 = new JLabel("이름");
			lblNewLabel_2_4.setForeground(new Color(131, 77, 30));
			lblNewLabel_2_4.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_2_4.setBounds(12, 245, 90, 21);
		}
		return lblNewLabel_2_4;
	}

	private JLabel getLblNewLabel_2_5() {
		if (lblNewLabel_2_5 == null) {
			lblNewLabel_2_5 = new JLabel("전화번호");
			lblNewLabel_2_5.setForeground(new Color(131, 77, 30));
			lblNewLabel_2_5.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_2_5.setBounds(12, 289, 90, 21);
		}
		return lblNewLabel_2_5;
	}

	private JLabel getLblNewLabel_2_6() {
		if (lblNewLabel_2_6 == null) {
			lblNewLabel_2_6 = new JLabel("이메일");
			lblNewLabel_2_6.setForeground(new Color(131, 77, 30));
			lblNewLabel_2_6.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_2_6.setBounds(12, 336, 90, 21);
		}
		return lblNewLabel_2_6;
	}

	private JLabel getLblNewLabel_2_7() {
		if (lblNewLabel_2_7 == null) {
			lblNewLabel_2_7 = new JLabel("주소");
			lblNewLabel_2_7.setForeground(new Color(131, 77, 30));
			lblNewLabel_2_7.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_2_7.setBounds(12, 382, 90, 21);
		}
		return lblNewLabel_2_7;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(Lju_MenuCoffee.class.getResource("/com/javalec/image/wifi.png")));
			lblNewLabel_3.setBounds(303, 15, 65, 18);
		}
		return lblNewLabel_3;
	}

	// 시계라벨 ( 시계라벨이랑 시계랑 같이 붙여넣으세요)
	private JLabel getLblClock() {
		if (lblClock == null) {
			lblClock = new JLabel();
			lblClock.setFont(new Font("Malayalam Sangam MN", Font.BOLD, 15));
			lblClock.setBounds(36, 15, 61, 16);
			clockRun();

		}
		return lblClock;
	}

	private JLabel getLblpasswordCheck() {
		if (lblpasswordCheck == null) {
			lblpasswordCheck = new JLabel("");
			lblpasswordCheck.setBackground(new Color(252, 242, 217));
			lblpasswordCheck.setForeground(new Color(255, 0, 0));
			lblpasswordCheck.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
			lblpasswordCheck.setBounds(121, 225, 162, 15);
			lblpasswordCheck.setOpaque(true);	// 라벨 투명풀기
		}
		return lblpasswordCheck;
	}
	// ----- function -----

	// 시간표시 메소드
	private void clockRun() {
		javax.swing.Timer timer = new javax.swing.Timer(100, new ActionListener() { // 1초마다 갱신

			@Override
			public void actionPerformed(ActionEvent e) {
				Calendar t = Calendar.getInstance();
				int hour = t.get(Calendar.HOUR);
				int min = t.get(Calendar.MINUTE);
				String clock = String.format("%02d : %02d", hour, min); // 시간을 01:02로표시 원래 1시:2분 이런식
				lblClock.setText(clock);
			}
		});
		timer.start();
	}

	private void backAction() {
		Jty_Home jty_Home = new Jty_Home();
		jty_Home.setVisible(true);
		dispose();
	}

	private void openProfile() {
		Jty_Dao_Profile dao_Profile = new Jty_Dao_Profile();
		Jty_Dto_Profile dto_Profile = dao_Profile.openProfile();

		if (dto_Profile != null) {
			tfUserid.setText(dto_Profile.getCid());
			tfPassword.setText(dto_Profile.getCpassword());
			tfConfirmPassword.setText(dto_Profile.getCpassword());
			tfName.setText(dto_Profile.getCname());
			tfPhone.setText(dto_Profile.getCphone());
			tfEmail.setText(dto_Profile.getCemail());
			tfAddress.setText(dto_Profile.getCaddress());
			//pfPayPassword.setText(dto_Profile.getPaymentPassword());
			lblInsertDate.setText(dto_Profile.getCinsertdate());
		}
	}

	public void userDelete() {
		Jty_UserDelete_Dialog jty_Profile_Dialog = new Jty_UserDelete_Dialog();
		jty_Profile_Dialog.setLocationRelativeTo(null);
		jty_Profile_Dialog.setVisible(true);

	}

	private void allUpdateAction() {

		String cpassword = tfPassword.getText();
		//String confirmCpassword = tfConfirmPassword.getText();
		String cname = tfName.getText();
		String cphone = tfPhone.getText();
		String cemail = tfEmail.getText();
		String cemailcb = cbEmail.getSelectedItem().toString();
		String cemailFull = cemail + "@" + cemailcb;
		String caddress = tfAddress.getText();

		String pass1 = new String(tfPassword.getText());
		String pass2 = new String(tfConfirmPassword.getText());
		if (!pass1.equals(pass2)) {
			JOptionPane.showMessageDialog(this, "비밀번호를 일치시켜주세요", "회원정보 수정", JOptionPane.ERROR_MESSAGE);
		} else {
			if (cpassword.isEmpty() || cname.isEmpty() || cphone.isEmpty()
					|| cemail.isEmpty() || cemailcb.isEmpty() || caddress.isEmpty()) {
				JOptionPane.showMessageDialog(this, "회원정보를 입력해주세요");
			} else {
				Jty_Dao_Profile dao_Profile = new Jty_Dao_Profile(cpassword, cname, cphone, cemailFull, caddress);
				boolean result = dao_Profile.allUpdateAction();
				if (result) {
					JOptionPane.showMessageDialog(this, tfName.getText() + "님의 회원정보가 수정되었습니다.", "회원정보 수정",
							JOptionPane.INFORMATION_MESSAGE); // this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
				}
			}
		}
	}

	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("@");
			lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_4.setBounds(198, 336, 12, 21);
		}
		return lblNewLabel_4;
	}

	private JComboBox getCbEmail() {
		if (cbEmail == null) {
			cbEmail = new JComboBox();
			
			cbEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			cbEmail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					emailAction();
				}
			});
			cbEmail.setBackground(new Color(252, 242, 217));
			cbEmail.setModel(new DefaultComboBoxModel(
					new String[] { "직접 입력", "naver.com", "daum.net", "nate.com", "gmail.com" }));
			cbEmail.setBounds(213, 336, 95, 23);
		}
		return cbEmail;
	}

	private void emailAction() {
		int i = cbEmail.getSelectedIndex();
		//String emailselect = "";
		switch (i) {
		case 0:
			cbEmail.setEditable(true);
		    JTextField editor = (JTextField) cbEmail.getEditor().getEditorComponent();
		    editor.setText("");
		    editor.addFocusListener(new FocusAdapter() {
		        @Override
		        public void focusGained(FocusEvent e) {
		            if (editor.getText().equals("직접 입력")) {
		                editor.setText("");
		            }
		        }

		        @Override
		        public void focusLost(FocusEvent e) {
		            if (editor.getText().isEmpty()) {
		                editor.setText("직접 입력");
		            }
		        }
		    });
		    break;
		case 1:
			cbEmail.setEditable(false);
			break;
		case 2:
			cbEmail.setEditable(false);
			break;
		case 3:
			cbEmail.setEditable(false);
			break;
		default:
			break;

		}
	}
	
	public void diaclose() {
		this.dispose();
	}

}
