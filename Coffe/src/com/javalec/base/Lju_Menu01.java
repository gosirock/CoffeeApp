package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.event.MouseMotionAdapter;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.DropMode;
import java.awt.Cursor;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class Lju_Menu01 extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnHome;
	private JButton btnMenu;
	private JButton btnOrder;
	private JButton btnReview;
	private JLabel lblTime;
	private JLabel lblNewLabel;
	private JLabel lblLikeToDrink;
	private JLabel lblNewLabel_1;
	private JTextField txtSe;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblNewLabel_2_1_2;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_3;
	private JButton btnNewButton_2;
	private JButton btnNewButton_2_1;
	private JButton btnNewButton_2_2;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton_3;
	private JButton btnNewButton_1_1;
	private JButton btnNewButton_3_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_5;
	
	
	
	
	
	
//	"<html>안녕<br>안녀엉<p>세번</html>" 라벨 줄바꾸기
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lju_Menu01 frame = new Lju_Menu01();
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
	
	
	public Lju_Menu01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 872);							// 백그라운드 프레임 패널 사이즈
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 227, 182));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblTime());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblLikeToDrink());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTxtSe());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getBtnNewButton_2_1());
		contentPane.add(getBtnNewButton_2_2());
		contentPane.add(getLblNewLabel_4());

	}
	
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(131, 77, 30));		// 하단 버튼바 패널 색상
			panel.setBounds(0, 757, 390, 87);					// 하단 버튼바 패널 위치,사이즈
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
			btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnHome.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/btnHome.png")));
			btnHome.setFocusPainted(false);					// 버튼 포커스라인 없애기
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
			btnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnMenu.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/btnMenu.png")));
			btnMenu.setFocusPainted(false);
			btnMenu.setBorderPainted(false);
		}
		return btnMenu;
	}
	private JButton getBtnOrder() {
		if (btnOrder == null) {
			btnOrder = new JButton("");
			btnOrder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnOrder.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/btnOrder.png")));
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
				}
			});
			btnReview.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnReview.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/btnReview.png")));
			btnReview.setFocusPainted(false);
			btnReview.setBorderPainted(false);
		}
		return btnReview;
	}
	
	private JLabel getLblTime() {
		if (lblTime == null) {
			lblTime = new JLabel("");
			lblTime.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblTime.setBounds(40, 13, 32, 21);
		}
		return lblTime;
	}
	
	private void ClockRun() {
		
		while(true) {
			
			Calendar cal = Calendar.getInstance();
			String now = cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE);
			
			
			lblTime.setText(now);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
	
		
	
	
	
	
	
	
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("What would you ");
			lblNewLabel.setForeground(new Color(131, 77, 30));
			lblNewLabel.setFont(new Font("Kailasa", Font.PLAIN, 18));
			lblNewLabel.setBounds(35, 44, 170, 22);
		}
		return lblNewLabel;
	}
	private JLabel getLblLikeToDrink() {
		if (lblLikeToDrink == null) {
			lblLikeToDrink = new JLabel("like to drink today?");
			lblLikeToDrink.setForeground(new Color(131, 77, 30));
			lblLikeToDrink.setFont(new Font("Kailasa", Font.PLAIN, 18));
			lblLikeToDrink.setBounds(35, 66, 170, 22);
		}
		return lblLikeToDrink;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/wifi.png")));
			lblNewLabel_1.setBounds(303, 15, 65, 18);
		}
		return lblNewLabel_1;
	}
	private JTextField getTxtSe() {
		if (txtSe == null) {
			txtSe = new JTextField();
			txtSe.setDoubleBuffered(true);
			txtSe.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			txtSe.setColumns(10);
			txtSe.setPreferredSize(new Dimension(10, 26));
			txtSe.setRequestFocusEnabled(false);
			txtSe.addMouseMotionListener(new MouseMotionAdapter() {
			});
			txtSe.setSelectionColor(new Color(252, 242, 217));
			txtSe.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txtSe.setText(null);
				}
			});
			txtSe.setDisabledTextColor(new Color(131, 77, 30));
			txtSe.setCaretColor(new Color(131, 77, 30));
			txtSe.setSelectedTextColor(new Color(131, 77, 30));
			txtSe.setBackground(new Color(252, 242, 217));
			txtSe.setForeground(new Color(131, 77, 30));
			txtSe.setText("    검색");
			txtSe.setBounds(35, 114, 321, 43);
		}
		return txtSe;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setAutoscrolls(true);
			scrollPane.setBackground(new Color(252, 242, 217));
			scrollPane.setBounds(0, 239, 400, 520);
			scrollPane.setViewportView(getPanel_1_1());
		}
		return scrollPane;
	}
	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			panel_1.setForeground(new Color(252, 242, 217));
			panel_1.setBackground(new Color(252, 242, 217));
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
			gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton_3.gridx = 1;
			gbc_btnNewButton_3.gridy = 1;
			panel_1.add(getBtnNewButton_3(), gbc_btnNewButton_3);
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 2;
			gbc_lblNewLabel_3.gridy = 1;
			panel_1.add(getLblNewLabel_3(), gbc_lblNewLabel_3);
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 3;
			gbc_lblNewLabel_5.gridy = 1;
			panel_1.add(getLblNewLabel_5(), gbc_lblNewLabel_5);
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 4;
			gbc_lblNewLabel_2.gridy = 1;
			panel_1.add(getLblNewLabel_2(), gbc_lblNewLabel_2);
			GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
			gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
			gbc_btnNewButton_1.gridx = 5;
			gbc_btnNewButton_1.gridy = 1;
			panel_1.add(getBtnNewButton_1(), gbc_btnNewButton_1);
			GridBagConstraints gbc_btnNewButton_3_1 = new GridBagConstraints();
			gbc_btnNewButton_3_1.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton_3_1.gridx = 1;
			gbc_btnNewButton_3_1.gridy = 2;
			panel_1.add(getBtnNewButton_3_1(), gbc_btnNewButton_3_1);
			GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
			gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2_1.gridx = 1;
			gbc_lblNewLabel_2_1.gridy = 3;
			panel_1.add(getLblNewLabel_2_1(), gbc_lblNewLabel_2_1);
			GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
			gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3_1.gridx = 2;
			gbc_lblNewLabel_3_1.gridy = 3;
			panel_1.add(getLblNewLabel_3_1(), gbc_lblNewLabel_3_1);
			GridBagConstraints gbc_btnNewButton_1_1 = new GridBagConstraints();
			gbc_btnNewButton_1_1.insets = new Insets(0, 0, 5, 0);
			gbc_btnNewButton_1_1.gridx = 5;
			gbc_btnNewButton_1_1.gridy = 3;
			panel_1.add(getBtnNewButton_1_1_1(), gbc_btnNewButton_1_1);
			GridBagConstraints gbc_lblNewLabel_2_1_1 = new GridBagConstraints();
			gbc_lblNewLabel_2_1_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2_1_1.gridx = 1;
			gbc_lblNewLabel_2_1_1.gridy = 5;
			panel_1.add(getLblNewLabel_2_1_1(), gbc_lblNewLabel_2_1_1);
			GridBagConstraints gbc_lblNewLabel_3_2 = new GridBagConstraints();
			gbc_lblNewLabel_3_2.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_3_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3_2.gridx = 2;
			gbc_lblNewLabel_3_2.gridy = 5;
			panel_1.add(getLblNewLabel_3_2(), gbc_lblNewLabel_3_2);
			GridBagConstraints gbc_lblNewLabel_2_1_2 = new GridBagConstraints();
			gbc_lblNewLabel_2_1_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2_1_2.gridx = 1;
			gbc_lblNewLabel_2_1_2.gridy = 7;
			panel_1.add(getLblNewLabel_2_1_2(), gbc_lblNewLabel_2_1_2);
			GridBagConstraints gbc_lblNewLabel_3_3 = new GridBagConstraints();
			gbc_lblNewLabel_3_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3_3.gridx = 2;
			gbc_lblNewLabel_3_3.gridy = 7;
			panel_1.add(getLblNewLabel_3_3(), gbc_lblNewLabel_3_3);
		}
		return panel_1;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("<html>아이스 아메리카노<br><br>쓴거<p>원두커피<p><p>3000원</html>");
			lblNewLabel_3.setFont(new Font("Lao Sangam MN", Font.PLAIN, 16));
			lblNewLabel_3.setForeground(new Color(131, 77, 30));
			lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
		return lblNewLabel_3;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
			btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton_1.setBorderPainted(false);
			btnNewButton_1.setFocusPainted(false);
			btnNewButton_1.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/select.png")));
		}
		return btnNewButton_1;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("");
			lblNewLabel_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblNewLabel_2_1.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/Rectangle (1).png")));
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("");
			lblNewLabel_2_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblNewLabel_2_1_1.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/unsplash_WdJ_5Txrg7k.png")));
		}
		return lblNewLabel_2_1_1;
	}
	private JLabel getLblNewLabel_2_1_2() {
		if (lblNewLabel_2_1_2 == null) {
			lblNewLabel_2_1_2 = new JLabel("");
			lblNewLabel_2_1_2.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/Rectangle.png")));
		}
		return lblNewLabel_2_1_2;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("<html>아이스 카페라떼<br><br>입니다<p>허허허<p><p>3000원</html>");
			lblNewLabel_3_1.setFont(new Font("Lao Sangam MN", Font.PLAIN, 16));
			lblNewLabel_3_1.setForeground(new Color(131, 77, 30));
			lblNewLabel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
		return lblNewLabel_3_1;
	}
	private JLabel getLblNewLabel_3_2() {
		if (lblNewLabel_3_2 == null) {
			lblNewLabel_3_2 = new JLabel("<html>카페라떼<br><br>카<p>페라떼<p><p>3000원</html>");
			lblNewLabel_3_2.setFont(new Font("Lao Sangam MN", Font.PLAIN, 16));
			lblNewLabel_3_2.setForeground(new Color(131, 77, 30));
			lblNewLabel_3_2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
		return lblNewLabel_3_2;
	}
	private JLabel getLblNewLabel_3_3() {
		if (lblNewLabel_3_3 == null) {
			lblNewLabel_3_3 = new JLabel("<html>아이스 아메리카노<br><br>존맛탱<p>아샷추꺼져<p><p>3000원</html>");
		}
		return lblNewLabel_3_3;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("");
			btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_2.setBorderPainted(false);
			btnNewButton_2.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/opt 1.png")));
			btnNewButton_2.setBounds(36, 187, 106, 32);
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_2_1() {
		if (btnNewButton_2_1 == null) {
			btnNewButton_2_1 = new JButton("");
			btnNewButton_2_1.setFocusPainted(false);
			btnNewButton_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton_2_1.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/opt 2.png")));
			btnNewButton_2_1.setBorderPainted(false);
			btnNewButton_2_1.setBounds(133, 187, 113, 32);
		}
		return btnNewButton_2_1;
	}
	private JButton getBtnNewButton_2_2() {
		if (btnNewButton_2_2 == null) {
			btnNewButton_2_2 = new JButton("");
			btnNewButton_2_2.setFocusPainted(false);
			btnNewButton_2_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton_2_2.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/opt 3.png")));
			btnNewButton_2_2.setBorderPainted(false);
			btnNewButton_2_2.setBounds(245, 187, 106, 32);
		}
		return btnNewButton_2_2;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/options.png")));
			lblNewLabel_4.setBounds(35, 187, 321, 32);
		}
		return lblNewLabel_4;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("");
			btnNewButton_3.setFocusable(false);
			btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton_3.setBorderPainted(false);
			btnNewButton_3.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/Rectangle.png")));
		}
		return btnNewButton_3;
	}
	private JButton getBtnNewButton_1_1_1() {
		if (btnNewButton_1_1 == null) {
			btnNewButton_1_1 = new JButton("");
			btnNewButton_1_1.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/select.png")));
			btnNewButton_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton_1_1.setFocusPainted(false);
			btnNewButton_1_1.setBorderPainted(false);
		}
		return btnNewButton_1_1;
	}
	private JButton getBtnNewButton_3_1() {
		if (btnNewButton_3_1 == null) {
			btnNewButton_3_1 = new JButton("");
			btnNewButton_3_1.setFocusable(false);
			btnNewButton_3_1.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/Rectangle.png")));
			btnNewButton_3_1.setBorderPainted(false);
		}
		return btnNewButton_3_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("                  ");
		}
		return lblNewLabel_5;
	}
}
