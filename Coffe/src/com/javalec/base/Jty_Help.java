package com.javalec.base;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.Jty_Dao_Help;
import com.javalec.dao.Jty_Dao_Profile;
import com.javalec.dto.Jty_Dto_Help;
import com.javalec.dto.Jty_Dto_Profile;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class Jty_Help extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	// private Image backgroundImage = new
	// ImageIcon(Jty_Profile.class.getResource("/com/javalec/Image/helpbackgorund.png")).getImage();
	private JButton btnBack;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblLocation;
	private JLabel lblTelno;
	private JLabel lblOpentime;
	private JLabel lblClosetime;
	private JLabel lblBusinessName;
	private JLabel lblCompanyNo;
	private JLabel lblNewLabel_2;
	private JLabel lblLine;
	private JLabel lblLine_1;
	private JLabel lblLine_2;
	private JLabel lblLine_3;
	private JLabel lblLine_4;
	private JLabel lblLine_5;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_3;
	private JLabel lblNewLabel_3_4;
	private JLabel lblNewLabel_3_5;
	private JLabel lblClock;
	private JLabel lblNewLabel_4;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jty_Help frame = new Jty_Help();
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
	public Jty_Help() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setLocationRelativeTo(null);
				openHelp();
			}
		});
		setTitle("매장정보");
		setBackground(new Color(248, 227, 182));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 872);
		contentPane = new JPanel();// {
//		@Override
//		 protected void paintComponent(Graphics g) {
//	            super.paintComponent(g);
//	            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
//	        }
//	    };
		contentPane.setBackground(new Color(248, 227, 182));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnBack());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblLocation());
		contentPane.add(getLblTelno());
		contentPane.add(getLblOpentime());
		contentPane.add(getLblClosetime());
		contentPane.add(getLblBusinessName());
		contentPane.add(getLblCompanyNo());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblLine());
		contentPane.add(getLblLine_1());
		contentPane.add(getLblLine_2());
		contentPane.add(getLblLine_3());
		contentPane.add(getLblLine_4());
		contentPane.add(getLblLine_5());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLblNewLabel_3_1());
		contentPane.add(getLblNewLabel_3_2());
		contentPane.add(getLblNewLabel_3_3());
		contentPane.add(getLblNewLabel_3_4());
		contentPane.add(getLblNewLabel_3_5());
		contentPane.add(getLblClock());
		contentPane.add(getLblNewLabel_4());
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
			btnBack.setIcon(new ImageIcon(Jty_Help.class.getResource("/com/javalec/image/BackIcon.png")));
			btnBack.setBounds(31, 54, 18, 24);
		}
		return btnBack;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Jty_Help.class.getResource("/com/javalec/image/storeLogo.png")));
			lblNewLabel.setBounds(133, 44, 113, 48);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Jty_Help.class.getResource("/com/javalec/image/매장사진.jpg")));
			lblNewLabel_1.setBounds(33, 167, 320, 255);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblLocation() {
		if (lblLocation == null) {
			lblLocation = new JLabel("");
			lblLocation.setForeground(new Color(131, 77, 30));
			lblLocation.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblLocation.setBounds(158, 436, 195, 20);
		}
		return lblLocation;
	}

	private JLabel getLblTelno() {
		if (lblTelno == null) {
			lblTelno = new JLabel("");
			lblTelno.setForeground(new Color(131, 77, 30));
			lblTelno.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblTelno.setBounds(158, 478, 195, 20);
		}
		return lblTelno;
	}

	private JLabel getLblOpentime() {
		if (lblOpentime == null) {
			lblOpentime = new JLabel("");
			lblOpentime.setForeground(new Color(131, 77, 30));
			lblOpentime.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblOpentime.setBounds(157, 522, 195, 20);
		}
		return lblOpentime;
	}

	private JLabel getLblClosetime() {
		if (lblClosetime == null) {
			lblClosetime = new JLabel("");
			lblClosetime.setForeground(new Color(131, 77, 30));
			lblClosetime.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblClosetime.setBounds(157, 568, 195, 20);
		}
		return lblClosetime;
	}

	private JLabel getLblBusinessName() {
		if (lblBusinessName == null) {
			lblBusinessName = new JLabel("");
			lblBusinessName.setForeground(new Color(131, 77, 30));
			lblBusinessName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblBusinessName.setBounds(157, 618, 195, 20);
		}
		return lblBusinessName;
	}

	private JLabel getLblCompanyNo() {
		if (lblCompanyNo == null) {
			lblCompanyNo = new JLabel("");
			lblCompanyNo.setForeground(new Color(131, 77, 30));
			lblCompanyNo.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblCompanyNo.setBounds(158, 665, 195, 20);
		}
		return lblCompanyNo;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("매장정보");
			lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
			lblNewLabel_2.setForeground(new Color(131, 77, 30));
			lblNewLabel_2.setBounds(31, 133, 64, 24);
		}
		return lblNewLabel_2;
	}


	private JLabel getLblLine() {
		if (lblLine == null) {
			lblLine = new JLabel("");
			lblLine.setOpaque(true);
			lblLine.setBackground(new Color(131, 77, 30));
			lblLine.setBounds(33, 460, 320, 1);
		}
		return lblLine;
	}

	private JLabel getLblLine_1() {
		if (lblLine_1 == null) {
			lblLine_1 = new JLabel("");
			lblLine_1.setOpaque(true);
			lblLine_1.setBackground(new Color(131, 77, 30));
			lblLine_1.setBounds(32, 500, 320, 1);
		}
		return lblLine_1;
	}

	private JLabel getLblLine_2() {
		if (lblLine_2 == null) {
			lblLine_2 = new JLabel("");
			lblLine_2.setOpaque(true);
			lblLine_2.setBackground(new Color(131, 77, 30));
			lblLine_2.setBounds(32, 544, 320, 1);
		}
		return lblLine_2;
	}

	private JLabel getLblLine_3() {
		if (lblLine_3 == null) {
			lblLine_3 = new JLabel("");
			lblLine_3.setOpaque(true);
			lblLine_3.setBackground(new Color(131, 77, 30));
			lblLine_3.setBounds(32, 592, 320, 1);
		}
		return lblLine_3;
	}

	private JLabel getLblLine_4() {
		if (lblLine_4 == null) {
			lblLine_4 = new JLabel("");
			lblLine_4.setOpaque(true);
			lblLine_4.setBackground(new Color(131, 77, 30));
			lblLine_4.setBounds(32, 640, 320, 1);
		}
		return lblLine_4;
	}

	private JLabel getLblLine_5() {
		if (lblLine_5 == null) {
			lblLine_5 = new JLabel("");
			lblLine_5.setOpaque(true);
			lblLine_5.setBackground(new Color(131, 77, 30));
			lblLine_5.setBounds(32, 688, 320, 1);
		}
		return lblLine_5;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("주소");
			lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblNewLabel_3.setForeground(new Color(131, 77, 30));
			lblNewLabel_3.setBounds(31, 436, 100, 20);
		}
		return lblNewLabel_3;
	}

	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("전화번호");
			lblNewLabel_3_1.setForeground(new Color(131, 77, 30));
			lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblNewLabel_3_1.setBounds(31, 478, 100, 20);
		}
		return lblNewLabel_3_1;
	}

	private JLabel getLblNewLabel_3_2() {
		if (lblNewLabel_3_2 == null) {
			lblNewLabel_3_2 = new JLabel("오픈시간");
			lblNewLabel_3_2.setForeground(new Color(131, 77, 30));
			lblNewLabel_3_2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblNewLabel_3_2.setBounds(31, 522, 100, 20);
		}
		return lblNewLabel_3_2;
	}

	private JLabel getLblNewLabel_3_3() {
		if (lblNewLabel_3_3 == null) {
			lblNewLabel_3_3 = new JLabel("마감시간");
			lblNewLabel_3_3.setForeground(new Color(131, 77, 30));
			lblNewLabel_3_3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblNewLabel_3_3.setBounds(31, 568, 100, 20);
		}
		return lblNewLabel_3_3;
	}

	private JLabel getLblNewLabel_3_4() {
		if (lblNewLabel_3_4 == null) {
			lblNewLabel_3_4 = new JLabel("상호명");
			lblNewLabel_3_4.setForeground(new Color(131, 77, 30));
			lblNewLabel_3_4.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblNewLabel_3_4.setBounds(31, 618, 100, 20);
		}
		return lblNewLabel_3_4;
	}

	private JLabel getLblNewLabel_3_5() {
		if (lblNewLabel_3_5 == null) {
			lblNewLabel_3_5 = new JLabel("사업자등록번호");
			lblNewLabel_3_5.setForeground(new Color(131, 77, 30));
			lblNewLabel_3_5.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblNewLabel_3_5.setBounds(31, 665, 107, 20);
		}
		return lblNewLabel_3_5;
	}
	
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(Lju_MenuCoffee.class.getResource("/com/javalec/image/wifi.png")));
			lblNewLabel_4.setBounds(303, 15, 65, 18);
		}
		return lblNewLabel_4;
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
	
	private void openHelp() {
		Jty_Dao_Help dao_help = new Jty_Dao_Help();
		Jty_Dto_Help dto_help = dao_help.openHelp();
		
		lblLocation.setText(dto_help.getSlocation());
		lblTelno.setText(dto_help.getStelno());
		lblOpentime.setText(dto_help.getSopentime());
		lblClosetime.setText(dto_help.getSclosetime());
		lblBusinessName.setText(dto_help.getSbusinessname());
		lblCompanyNo.setText(dto_help.getScompanyno());
		
	}
	
}
