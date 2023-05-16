package com.javalec.base;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Jty_Home extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnHome;
	private JButton btnMenu;
	private JButton btnOrder;
	private JButton btnReview;
	private JLabel lblNewLabel_1;

	private Timer timer;
	private int counter;

	private JPanel toolbarPanel; // 추가: 툴바 패널
	private JLabel lblPpl;

	/**
	 * Launch the application.
	 */

	private ImageIcon[] imageIcons = { new ImageIcon(Jty_Home.class.getResource("/com/javalec/Image/coffee광고.png")),
			new ImageIcon(Jty_Home.class.getResource("/com/javalec/Image/newsuzy.png")),
			new ImageIcon(Jty_Home.class.getResource("/com/javalec/Image/IU.png")) };
	private JButton btnCategory;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPanel Category;
	private JLabel lblProfile;
	private JLabel lblHelp;
	private JLabel lblLogout;
	private JLabel lblClock;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jty_Home frame = new Jty_Home();
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

	private JPanel getCategory() {
		if (Category == null) {
			Category = new JPanel();
			Category.setBounds(180, 47, 178, 134);
			Category.setLayout(null);
			Category.add(getLabel_1());
			Category.add(getLblHelp());
			Category.add(getLblLogout());
		}
		return Category;
	}

	private void setCategoryPanelToFront() {
		getContentPane().setComponentZOrder(Category, 0);
	}

	public Jty_Home() {
		setTitle("홈");
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Category.setVisible(false);
				btnCategory.setVisible(true);
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// setComponentZOrder(Category, 0); // 패널 맨 앞으로
				setLocationRelativeTo(null);
				setCategoryPanelToFront();
				Category.setVisible(false);
				timer = new Timer(3000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						counter++;
						int index = counter % imageIcons.length;
						ImageIcon currentIcon = imageIcons[index];
						setLabelIcon(currentIcon);
					}
				});
				timer.start();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 872); // 백그라운드 프레임 패널 사이즈
		contentPane = new JPanel();

		contentPane.setBackground(new Color(248, 227, 182)); // 백그라운드 프레임 패널 색
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblPpl());
		contentPane.add(getBtnCategory());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getLblNewLabel_5());
		contentPane.add(getCategory());
		contentPane.add(getLblClock());
	}

	private void setLabelIcon(ImageIcon icon) {
		Image image = icon.getImage().getScaledInstance(321, 180, Image.SCALE_SMOOTH);
		ImageIcon scaledImageIcon = new ImageIcon(image);
		lblPpl.setIcon(scaledImageIcon);
		panel.revalidate();
		panel.repaint();
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(131, 77, 30)); // 하단 버튼바 패널 색상
			panel.setBounds(0, 757, 390, 87); // 하단 버튼바 패널 위치,사이즈
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			panel.add(getBtnHome());
			panel.add(getBtnMenu());
			panel.add(getBtnOrder());
			panel.add(getBtnReview());
		}
		return panel;
	}

	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("");
			btnHome.setBackground(new Color(131, 77, 30));
			btnHome.setIcon(new ImageIcon(Jty_Home.class.getResource("/com/javalec/image/툴바홈.png")));
			btnHome.setFocusPainted(false); // 버튼 포커스라인 없애기
			btnHome.setBorderPainted(false);
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
		return btnHome;
	}

	private JButton getBtnMenu() {
		if (btnMenu == null) {
			btnMenu = new JButton("");
			btnMenu.setBackground(new Color(131, 77, 30));
			btnMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Lju_MenuCoffee lju_MenuCoffee = new Lju_MenuCoffee();
					lju_MenuCoffee.setLocationRelativeTo(null);
					lju_MenuCoffee.setVisible(true);
					dispose();
					
				}
			});
			btnMenu.setIcon(new ImageIcon(Jty_Home.class.getResource("/com/javalec/image/툴바메뉴.png")));
			btnMenu.setFocusPainted(false);
			btnMenu.setBorderPainted(false);
		}
		return btnMenu;
	}

	private JButton getBtnOrder() {
		if (btnOrder == null) {
			btnOrder = new JButton("");
			btnOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Lju_MenuCoffee menuCoffee = new Lju_MenuCoffee();
					menuCoffee.setLocationRelativeTo(null);
					menuCoffee.setVisible(true);
					dispose();
				}
			});
			btnOrder.setBackground(new Color(131, 77, 30));
			btnOrder.setIcon(new ImageIcon(Jty_Home.class.getResource("/com/javalec/image/btnOrder.png")));
			btnOrder.setFocusPainted(false);
			btnOrder.setBorderPainted(false);
		}
		return btnOrder;
	}

	private JButton getBtnReview() {
		if (btnReview == null) {
			btnReview = new JButton("");
			btnReview.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Review2_kwh review2_kwh = new Review2_kwh();
					review2_kwh.setLocationRelativeTo(null);
					review2_kwh.setVisible(true);
					dispose();
				}
			});
			btnReview.setBackground(new Color(131, 77, 30));
			btnReview.setIcon(new ImageIcon(Jty_Home.class.getResource("/com/javalec/image/btnReview.png")));
			btnReview.setFocusPainted(false);
			btnReview.setBorderPainted(false);
		}
		return btnReview;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Jty_Home.class.getResource("/com/javalec/image/wifi.png")));
			lblNewLabel_1.setBounds(303, 15, 65, 18);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblPpl() {
		if (lblPpl == null) {
			lblPpl = new JLabel("");
			
			
			// 이미지를 직접 생성하고, BufferedImage로 변환하여 선명도 개선
            ImageIcon icon = new ImageIcon(Jty_Home.class.getResource("/com/javalec/image/coffee광고.png"));
            Image image = icon.getImage();
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bufferedImage.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.drawImage(image, 0, 0, null);
            g2d.dispose();

            // 수정된 BufferedImage로 ImageIcon 생성하여 라벨에 설정
            lblPpl.setIcon(new ImageIcon(bufferedImage));

            lblPpl.setBounds(25, 120, 321, 180);
		}
		return lblPpl;
	}
	

	private JButton getBtnCategory() {
		if (btnCategory == null) {
			btnCategory = new JButton("");
			btnCategory.setBorder(null); // 버튼의 테두리를 없앰
			btnCategory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Category.setVisible(true);
					btnCategory.setVisible(false);
				}
			});
			btnCategory.setIcon(new ImageIcon(Jty_Home.class.getResource("/com/javalec/image/홈카테고리.png")));
			btnCategory.setBounds(331, 44, 25, 34);
		}
		return btnCategory;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Jty_Home.class.getResource("/com/javalec/image/storeLogo.png")));
			lblNewLabel.setBounds(133, 44, 113, 48);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(Jty_Home.class.getResource("/com/javalec/image/Home_Line.png")));
			lblNewLabel_2.setBounds(60, 305, 252, 20);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("이달의 이벤트");
			lblNewLabel_3.setForeground(new Color(131, 77, 30));
			lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 16));
			lblNewLabel_3.setBounds(25, 339, 104, 22);
		}
		return lblNewLabel_3;
	}

	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Lucky1_kwh lucky1_kwh = new Lucky1_kwh();
					lucky1_kwh.setVisible(true);
				}
			});
			lblNewLabel_4.setIcon(new ImageIcon(Jty_Home.class.getResource("/com/javalec/image/이달의 이벤트.png")));
			lblNewLabel_4.setBounds(25, 380, 321, 180);
		}
		return lblNewLabel_4;
	}

	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("클릭시 이벤트 페이지로 넘어갑니다.");
			lblNewLabel_5.setForeground(new Color(131, 77, 30));
			lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
			lblNewLabel_5.setBounds(164, 555, 182, 15);
		}
		return lblNewLabel_5;
	}

	private JLabel getLabel_1() {
		if (lblProfile == null) {
			lblProfile = new JLabel("");
			lblProfile.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Jty_Profile jty_Profile = new Jty_Profile();
					jty_Profile.setVisible(true);
					dispose();
				}
			});
			lblProfile.setIcon(new ImageIcon(Jty_Home.class.getResource("/com/javalec/image/C_Profile.png")));
			lblProfile.setBounds(0, 0, 178, 45);

		}
		return lblProfile;
	}

	private JLabel getLblHelp() {
		if (lblHelp == null) {
			lblHelp = new JLabel("");
			lblHelp.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Jty_Help jty_Help = new Jty_Help();
					jty_Help.setVisible(true);
					dispose();
				}
			});
			lblHelp.setIcon(new ImageIcon(Jty_Home.class.getResource("/com/javalec/image/C_Help.png")));
			lblHelp.setBounds(0, 44, 178, 45);
		}
		return lblHelp;
	}

	private JLabel getLblLogout() {
		if (lblLogout == null) {
			lblLogout = new JLabel("");
			lblLogout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Jty_Logout_Dialog logout_dialog = new Jty_Logout_Dialog();
					Jty_Home frame = new Jty_Home();
					frame.dispose();
					frame.setVisible(false);
					logout_dialog.setVisible(true);
					
				}
			});
			lblLogout.setIcon(new ImageIcon(Jty_Home.class.getResource("/com/javalec/image/C_Logout.png")));
			lblLogout.setBounds(0, 89, 178, 45);
		}
		return lblLogout;
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

}
