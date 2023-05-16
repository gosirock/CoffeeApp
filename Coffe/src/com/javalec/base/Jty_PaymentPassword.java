package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Jty_PaymentPassword extends JFrame {

	private JPanel contentPane;
	private JLabel lblClock;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn0;
	private JButton btnbackspace;
	private JPasswordField pfnum1;
	private JPasswordField pfnum2;
	private JPasswordField pfnum3;
	private JPasswordField pfnum4;
	private JPasswordField pfAllpassword;
	private JTextField textField;

	private JTextField[] textFields;
	private JButton button;

	private int currentTextFieldIndex = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jty_PaymentPassword frame = new Jty_PaymentPassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Jty_PaymentPassword() {
		setBounds(100, 100, 390, 872);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblClock());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getPanel());

		textFields = new JTextField[] { pfnum1, pfnum2, pfnum3, pfnum4 };

		pfnum1 = new JPasswordField();
		pfnum1.setBounds(127, 145, 25, 21);
		pfnum1.setHorizontalAlignment(SwingConstants.CENTER);
		pfnum1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					currentTextFieldIndex--;
					if (currentTextFieldIndex < 0) {
						currentTextFieldIndex = textFields.length - 1;
					}
					textFields[currentTextFieldIndex].setText("");
					textFields[currentTextFieldIndex].requestFocus();
				}
			}
		});
		pfnum1.setColumns(10);
		pfnum1.setEchoChar('●');

//        textFields = new JTextField[4];
//        for (int i = 0; i < textFields.length; i++) {
//            textFields[i] = new JTextField();
//            textFields[i].setBounds(127 + 37 * i, 145, 25, 21);
//            contentPane.add(textFields[i]);

		pfnum2 = new JPasswordField();
		pfnum2.setBounds(164, 145, 25, 21);
		pfnum2.setHorizontalAlignment(SwingConstants.CENTER);
		pfnum2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					currentTextFieldIndex--;
					if (currentTextFieldIndex < 0) {
						currentTextFieldIndex = textFields.length - 1;
					}
					textFields[currentTextFieldIndex].setText("");
					textFields[currentTextFieldIndex].requestFocus();
				}
			}
		});
		pfnum2.setColumns(10);
		pfnum2.setEchoChar('●');

		pfnum3 = new JPasswordField();
		pfnum3.setBounds(201, 145, 25, 21);
		pfnum3.setHorizontalAlignment(SwingConstants.CENTER);
		pfnum3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					currentTextFieldIndex--;
					if (currentTextFieldIndex < 0) {
						currentTextFieldIndex = textFields.length - 1;
					}
					textFields[currentTextFieldIndex].setText("");
					textFields[currentTextFieldIndex].requestFocus();
				}
			}
		});
		pfnum3.setColumns(10);
		pfnum3.setEchoChar('●');

		pfnum4 = new JPasswordField();
		pfnum4.setBounds(238, 145, 25, 21);
		pfnum4.setHorizontalAlignment(SwingConstants.CENTER);
		pfnum4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					currentTextFieldIndex--;
					if (currentTextFieldIndex < 0) {
						currentTextFieldIndex = textFields.length - 1;
					}
					textFields[currentTextFieldIndex].setText("");
					textFields[currentTextFieldIndex].requestFocus();
				}
			}
		});
		pfnum4.setColumns(10);
		pfnum4.setEchoChar('●');

		pfAllpassword = new JPasswordField();
		pfAllpassword.setBounds(127, 183, 136, 21);
		pfAllpassword.setHorizontalAlignment(SwingConstants.CENTER);
		pfAllpassword.setColumns(10);
		pfAllpassword.setEchoChar('●');

		textField = new JTextField();
		textField.setBounds(48, 183, 75, 21);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);

		button = new JButton("확인");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new String(pfAllpassword.getPassword());
				System.out.println("결제 비밀번호: " + password);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		button.setBackground(new Color(255, 128, 0));
		button.setBounds(141, 230, 90, 29);

		contentPane.add(button);
		contentPane.add(pfnum1);
		contentPane.add(pfnum2);
		contentPane.add(pfnum3);
		contentPane.add(pfnum4);
		contentPane.add(pfAllpassword);
		contentPane.add(textField);

	}

	

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Jty_PaymentPassword.class.getResource("/com/javalec/image/wifi.png")));
			lblNewLabel_1.setBounds(303, 15, 65, 18);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblClock() {
		if (lblClock == null) {
			lblClock = new JLabel();
			lblClock.setFont(new Font("Malayalam Sangam MN", Font.BOLD, 15));
			lblClock.setBounds(36, 15, 61, 16);
			clockRun();
		}
		return lblClock;
	}

	private void clockRun() {
		javax.swing.Timer timer = new javax.swing.Timer(100, new ActionListener() {
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

	private JButton getBtn1() {
		if (btn1 == null) {
			btn1 = new JButton("1");
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentTextFieldIndex++;
					if (currentTextFieldIndex >= textFields.length) {
						currentTextFieldIndex = 0;
					}
					textFields[currentTextFieldIndex].requestFocus();
				}
			}); // 추가된 중괄호
			btn1.setForeground(new Color(255, 255, 255));
			btn1.setBackground(new Color(255, 128, 0));
			btn1.setFont(new Font("맑은 고딕", Font.BOLD, 60));
			btn1.setBounds(38, 213, 101, 133);
		}
		return btn1;
	}

	private JButton getBtn2() {
		if (btn2 == null) {
			btn2 = new JButton("2");
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentTextFieldIndex++;
					if (currentTextFieldIndex >= textFields.length) {
						currentTextFieldIndex = 0;
					}
					textFields[currentTextFieldIndex].requestFocus();
				}
			}); // 추가된 중괄호
			btn2.setForeground(new Color(255, 255, 255));
			btn2.setFont(new Font("맑은 고딕", Font.BOLD, 60));
			btn2.setBackground(new Color(255, 128, 0));
			btn2.setBounds(146, 213, 101, 133);

		}
		return btn2;
	}

	private JButton getBtn3() {
		if (btn3 == null) {
			btn3 = new JButton("3");
			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentTextFieldIndex++;
					if (currentTextFieldIndex >= textFields.length) {
						currentTextFieldIndex = 0;
					}
					textFields[currentTextFieldIndex].requestFocus();
				}
			}); // 추가된 중괄호
			btn3.setForeground(new Color(255, 255, 255));
			btn3.setFont(new Font("맑은 고딕", Font.BOLD, 60));
			btn3.setBackground(new Color(255, 128, 0));
			btn3.setBounds(254, 213, 101, 133);

		}
		return btn3;
	}

	private JButton getBtn4() {
		if (btn4 == null) {
			btn4 = new JButton("4");
			btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentTextFieldIndex++;
					if (currentTextFieldIndex >= textFields.length) {
						currentTextFieldIndex = 0;
					}
					textFields[currentTextFieldIndex].requestFocus();
				}
			}); // 추가된 중괄호
			btn4.setForeground(new Color(255, 255, 255));
			btn4.setFont(new Font("맑은 고딕", Font.BOLD, 60));
			btn4.setBackground(new Color(255, 128, 0));
			btn4.setBounds(38, 356, 101, 133);
		}
		return btn4;
	}

	private JButton getBtn5() {
		if (btn5 == null) {
			btn5 = new JButton("5");
			btn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentTextFieldIndex++;
					if (currentTextFieldIndex >= textFields.length) {
						currentTextFieldIndex = 0;
					}
					textFields[currentTextFieldIndex].requestFocus();
				}
			}); // 추가된 중괄호
			btn5.setForeground(new Color(255, 255, 255));
			btn5.setFont(new Font("맑은 고딕", Font.BOLD, 60));
			btn5.setBackground(new Color(255, 128, 0));
			btn5.setBounds(146, 356, 101, 133);
		}
		return btn5;
	}

	private JButton getBtn6() {
		if (btn6 == null) {
			btn6 = new JButton("6");
			btn6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentTextFieldIndex++;
					if (currentTextFieldIndex >= textFields.length) {
						currentTextFieldIndex = 0;
					}
					textFields[currentTextFieldIndex].requestFocus();
				}
			}); // 추가된 중괄호
			btn6.setForeground(new Color(255, 255, 255));
			btn6.setFont(new Font("맑은 고딕", Font.BOLD, 60));
			btn6.setBackground(new Color(255, 128, 0));
			btn6.setBounds(254, 356, 101, 133);
		}
		return btn6;
	}

	private JButton getBtn7() {
		if (btn7 == null) {
			btn7 = new JButton("7");
			btn7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentTextFieldIndex++;
					if (currentTextFieldIndex >= textFields.length) {
						currentTextFieldIndex = 0;
					}
					textFields[currentTextFieldIndex].requestFocus();
				}
			}); // 추가된 중괄호
			btn7.setForeground(new Color(255, 255, 255));
			btn7.setFont(new Font("맑은 고딕", Font.BOLD, 60));
			btn7.setBackground(new Color(255, 128, 0));
			btn7.setBounds(36, 499, 101, 133);
		}
		return btn7;
	}

	private JButton getBtn8() {
		if (btn8 == null) {
			btn8 = new JButton("8");
			btn8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentTextFieldIndex++;
					if (currentTextFieldIndex >= textFields.length) {
						currentTextFieldIndex = 0;
					}
					textFields[currentTextFieldIndex].requestFocus();
				}
			}); // 추가된 중괄호
			btn8.setForeground(new Color(255, 255, 255));
			btn8.setFont(new Font("맑은 고딕", Font.BOLD, 60));
			btn8.setBackground(new Color(255, 128, 0));
			btn8.setBounds(146, 499, 101, 133);
		}
		return btn8;
	}

	private JButton getBtn9() {
		if (btn9 == null) {
			btn9 = new JButton("9");
			btn9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentTextFieldIndex++;
					if (currentTextFieldIndex >= textFields.length) {
						currentTextFieldIndex = 0;
					}
					textFields[currentTextFieldIndex].requestFocus();
				}
			}); // 추가된 중괄호
			btn9.setForeground(new Color(255, 255, 255));
			btn9.setFont(new Font("맑은 고딕", Font.BOLD, 60));
			btn9.setBackground(new Color(255, 128, 0));
			btn9.setBounds(254, 499, 101, 133);
		}
		return btn9;
	}

	private JButton getBtn0() {
		if (btn0 == null) {
			btn0 = new JButton("0");
			btn0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentTextFieldIndex++;
					if (currentTextFieldIndex >= textFields.length) {
						currentTextFieldIndex = 0;
					}
					textFields[currentTextFieldIndex].requestFocus();
					textFields[currentTextFieldIndex].setText("0"); // "0"을 텍스트 필드에 쓰도록 추가
				}
			});
			btn0.setForeground(new Color(255, 255, 255));
			btn0.setFont(new Font("맑은 고딕", Font.BOLD, 60));
			btn0.setBackground(new Color(255, 128, 0));
			btn0.setBounds(146, 642, 101, 133);
		}
		return btn0;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 128, 0));
			panel.setBounds(0, 41, 390, 864);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getBtnNewButton());
			panel.add(getBtn1());
			panel.add(getBtn2());
			panel.add(getBtn3());
			panel.add(getBtn4());
			panel.add(getBtn5());
			panel.add(getBtn6());
			panel.add(getBtn7());
			panel.add(getBtn8());
			panel.add(getBtn9());
			panel.add(getBtn0());
			panel.add(getBtnbackspace());
			panel.add(getPfnum1());
			panel.add(getPfnum2());
			panel.add(getPfnum3());
			panel.add(getPfnum4());
			panel.add(getPfAllpassword());
			panel.add(getTextField());
		}
		return panel;

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("결제 비밀번호를 설정해주세요");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
			lblNewLabel.setBounds(76, 97, 237, 27);
		}
		return lblNewLabel;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setBackground(new Color(255, 128, 0));
			btnNewButton.setIcon(
					new ImageIcon(Jty_PaymentPassword.class.getResource("/com/javalec/image/akar-icons_cross.png")));
			btnNewButton.setBounds(36, 30, 25, 25);
		}
		return btnNewButton;
	}

	private JButton getBtnbackspace() {
		if (btnbackspace == null) {
			btnbackspace = new JButton("");
			btnbackspace.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnbackspace
					.setIcon(new ImageIcon(Jty_PaymentPassword.class.getResource("/com/javalec/image/결제비번지우기.png")));
			btnbackspace.setFont(new Font("맑은 고딕", Font.BOLD, 60));
			btnbackspace.setBackground(new Color(255, 128, 0));
			btnbackspace.setBounds(254, 642, 101, 133);
		}
		return btnbackspace;
	}

	private JPasswordField getPfnum1() {
		if (pfnum1 == null) {
			pfnum1 = new JPasswordField();
			pfnum1.setEditable(false);
			pfnum1.setBounds(127, 145, 25, 21);
		}
		return pfnum1;
	}

	private JPasswordField getPfnum2() {
		if (pfnum2 == null) {
			pfnum2 = new JPasswordField();
			pfnum2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
				}
			});
			pfnum2.setEditable(false);
			pfnum2.setBounds(164, 145, 25, 21);
		}
		return pfnum2;
	}

	private JPasswordField getPfnum3() {
		if (pfnum3 == null) {
			pfnum3 = new JPasswordField();
			pfnum3.setEditable(false);
			pfnum3.setBounds(201, 145, 25, 21);
		}
		return pfnum3;
	}

	private JPasswordField getPfnum4() {
		if (pfnum4 == null) {
			pfnum4 = new JPasswordField();
			pfnum4.setEditable(false);
			pfnum4.setBounds(238, 145, 25, 21);
		}
		return pfnum4;
	}

//	private void insertPassword() { 
//		public void actionPerformed(ActionEvent e) {
//		textField = new JTextField();
//		if(btn1.isSelected()) {
//			textField.setText("1");
//		}}
//	};
	private JPasswordField getPfAllpassword() {
		if (pfAllpassword == null) {
			pfAllpassword = new JPasswordField();
			pfAllpassword.setBounds(137, 60, 110, 21);
		}
		return pfAllpassword;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(146, 30, 96, 21);
			textField.setColumns(10);
		}
		return textField;
	}

}
