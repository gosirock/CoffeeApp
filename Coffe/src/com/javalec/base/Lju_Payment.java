package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.Lju_BasketEmpty;
import com.javalec.dao.Lju_Dao_BasketAction;
import com.javalec.dao.Lju_Dao_CouponCheck;
import com.javalec.dao.Lju_Dao_Menu_Coffee;
import com.javalec.dao.Lju_Dao_Menu_Drink;
import com.javalec.dao.Lju_Dao_PurchaseHistory;
import com.javalec.dao.Lju_Dao_selectTable;
import com.javalec.dto.Lju_dto;
import com.javalec.util.ShareVar;
import com.mysql.cj.x.protobuf.MysqlxCrud.Column;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.DropMode;
import java.awt.Cursor;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
public class Lju_Payment extends JFrame {	

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnHome;
	private JButton btnMenu;
	private JButton btnOrder;
	private JButton btnReview;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	
	
	
	private final DefaultTableModel outerTable = new DefaultTableModel();
	ArrayList<Lju_dto> dtoList = null;
	
	DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	private JTable innerTable;
	private JLabel lblClock;
	private JButton btnNewButton;
	private JLabel lblCount;
	private JLabel lblCountNum;
	private JButton btnPay;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1;
	private JCheckBox chckbxcoupon;
	private JLabel lblNewLabel_2_1_1_1;
	private JLabel lblNewLabel_2_1_1_1_1;
	private JTextField textField;
	private JLabel lblNewLabel_2_1_1_1_1_1;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_2_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	int payprice;
	int payqty;
	int pay;
	int paytotal;
	private JLabel lblTotal;
	private JLabel lblDiscount;
	private JLabel lblTotalPay;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_3_2;
//	"<html>안녕<br>안녀엉<p>세번</html>" 라벨 줄바꾸기
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lju_Payment frame = new Lju_Payment();
					frame.setLocationRelativeTo(null);
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
	
	
	public Lju_Payment() {
		setTitle("커피메뉴");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				closeingAction();//사진지우기
			}
			@Override
			public void windowOpened(WindowEvent e) {
				basketCount();
				totalPay();
				couponCheck();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 872);							// 백그라운드 프레임 패널 사이즈
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 227, 182));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getScrollPane());
		contentPane.add(getLblClock());
		contentPane.add(getLblCountNum());
		contentPane.add(getLblCount());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnPay());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getLblNewLabel_2_1_1());
		contentPane.add(getChckbxcoupon());
		contentPane.add(getLblNewLabel_2_1_1_1());
		contentPane.add(getLblNewLabel_2_1_1_1_1());
		contentPane.add(getTextField());
		contentPane.add(getLblNewLabel_2_1_1_1_1_1());
		contentPane.add(getRadioButton());
		contentPane.add(getRadioButton_1());
		contentPane.add(getRadioButton_2());
		contentPane.add(getRadioButton_2_1());
		contentPane.add(getLblTotal());
		contentPane.add(getLblDiscount());
		contentPane.add(getLblTotalPay());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLblNewLabel_3_1());
		contentPane.add(getLblNewLabel_3_2());
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
			btnHome.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/btnHome.png")));
			btnHome.setFocusPainted(false);					// 버튼 포커스라인 없애기
			btnHome.setBorderPainted(false);
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Jty_Home jty_Home = new Jty_Home();
					jty_Home.setLocationRelativeTo(null);
					jty_Home.setVisible(true);
					dispose();
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
					Lju_MenuCoffee lju_MenuCoffee = new Lju_MenuCoffee();
					lju_MenuCoffee.setLocationRelativeTo(null);
					lju_MenuCoffee.setVisible(true);
					dispose();

				}
			});
			btnMenu.setIcon(new ImageIcon(Lju_Payment.class.getResource("/com/javalec/image/Group 7.png")));
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
					
					Lju_PurchaseHistory history = new Lju_PurchaseHistory();
					history.setLocationRelativeTo(null);
					history.setVisible(true);
					dispose();
				}
			});
			btnOrder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnOrder.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/btnOrder.png")));
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
			btnReview.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnReview.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/btnReview.png")));
			btnReview.setFocusPainted(false);
			btnReview.setBorderPainted(false);
		}
		return btnReview;
	}
	
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("주문하기");
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setForeground(new Color(131, 77, 30));
			lblNewLabel.setFont(new Font("Kailasa", Font.BOLD, 30));
			lblNewLabel.setBounds(27, 51, 170, 39);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/wifi.png")));
			lblNewLabel_1.setBounds(303, 15, 65, 18);
		}
		return lblNewLabel_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setAutoscrolls(true);
			scrollPane.setBackground(new Color(252, 242, 217));
			scrollPane.setBounds(0, 100, 400, 163);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	
	
	
	
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.setEnabled(false);
			innerTable.setRowSelectionAllowed(false);
			innerTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			innerTable.setGridColor(new Color(252, 242, 217));
			innerTable.setSelectionForeground(new Color(248, 227, 182));
			innerTable.setSelectionBackground(new Color(130, 77, 30));
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setRequestFocusEnabled(false);
			innerTable.setFocusTraversalKeysEnabled(false);
			innerTable.setForeground(new Color(131, 77, 30));
			innerTable.setFont(new Font("Nanum Gothic", Font.PLAIN, 20));
			innerTable.setBackground(new Color(252, 242, 217));
			innerTable.setModel(outerTable); 	//<<<<< 추가
			innerTable.setRowHeight(40);  		//<<<<< 높이조절
			innerTable.setFillsViewportHeight(true);
			tableInit();
			searchAction();
			
		}
		return innerTable;
	}


	
	

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton.addMouseListener(new MouseAdapter() {
			
				
				 //장바구니로 이동 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
				@Override
				public void mouseClicked(MouseEvent e) {
					Lju_Basket lju_Payment = new Lju_Basket();
					lju_Payment.setLocationRelativeTo(null);
					lju_Payment.setVisible(true);
					dispose();
				}
			});
			btnNewButton.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/icon _cart_.png")));
			btnNewButton.setFocusPainted(false);
			btnNewButton.setBorderPainted(false);
			btnNewButton.setBounds(303, 50, 70, 40);
		
		}
		return btnNewButton;
	}
	
	private JLabel getLblCount() {
		if (lblCount == null) {
			lblCount = new JLabel("");
			lblCount.setForeground(new Color(255, 255, 255));
			lblCount.setIcon(new ImageIcon(Lju_MenuCoffee.class.getResource("/com/javalec/image/Ellipse 7.png")));
			lblCount.setBounds(345, 40, 25, 22);
			lblCount.setVisible(false);
		}
		return lblCount;
	}
	private JLabel getLblCountNum() {
		if (lblCountNum == null) {
			lblCountNum = new JLabel("");
			lblCountNum.setHorizontalAlignment(SwingConstants.CENTER);
			lblCountNum.setForeground(new Color(255, 255, 255));
			lblCountNum.setBounds(345, 43, 24, 16);
			lblCountNum.setVisible(false);
		}
		return lblCountNum;
 	}
	
	
	private JButton getBtnPay() {
		if (btnPay == null) {
			btnPay = new JButton("");
			btnPay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					purchaseAction();
				}
			});
			btnPay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnPay.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPay.setIcon(new ImageIcon(Lju_Payment.class.getResource("/com/javalec/image/buttons (1).png")));
			btnPay.setFocusPainted(false);
			btnPay.setBorderPainted(false);
			btnPay.setBounds(61, 695, 270, 50);
		}
		return btnPay;
	}
	
	
	
	
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("결제금액 :");
			lblNewLabel_2.setForeground(new Color(130, 77, 30));
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2.setBounds(27, 652, 80, 20);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("할인금액 :");
			lblNewLabel_2_1.setForeground(new Color(130, 77, 30));
			lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_1.setBounds(27, 615, 80, 20);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("상품금액 :");
			lblNewLabel_2_1_1.setForeground(new Color(130, 77, 30));
			lblNewLabel_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_1_1.setBounds(27, 580, 80, 20);
		}
		return lblNewLabel_2_1_1;
	}
	private JCheckBox getChckbxcoupon() {
		if (chckbxcoupon == null) {
			chckbxcoupon = new JCheckBox("사용 가능한 쿠폰이 없습니다.");
			chckbxcoupon.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					totalPay();
				}
			});
			chckbxcoupon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					discount();
					totalPay();
				}
			});
			chckbxcoupon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			chckbxcoupon.setForeground(new Color(130, 77, 30));
			chckbxcoupon.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			chckbxcoupon.setBounds(28, 527, 218, 40);
		
		}
		return chckbxcoupon;
	}
	private JLabel getLblNewLabel_2_1_1_1() {
		if (lblNewLabel_2_1_1_1 == null) {
			lblNewLabel_2_1_1_1 = new JLabel("쿠폰적용");
			lblNewLabel_2_1_1_1.setForeground(new Color(130, 77, 30));
			lblNewLabel_2_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_1_1_1.setBounds(28, 507, 80, 20);
		}
		return lblNewLabel_2_1_1_1;
	}
	private JLabel getLblNewLabel_2_1_1_1_1() {
		if (lblNewLabel_2_1_1_1_1 == null) {
			lblNewLabel_2_1_1_1_1 = new JLabel("요청사항");
			lblNewLabel_2_1_1_1_1.setForeground(new Color(130, 77, 30));
			lblNewLabel_2_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_1_1_1_1.setBounds(27, 287, 80, 20);
		}
		return lblNewLabel_2_1_1_1_1;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				 textField.setText(null);
				}
			});
			textField.setForeground(new Color(61, 60, 69));
			textField.setBackground(new Color(252, 242, 217));
			textField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			textField.setText("  매장 요청사항이 있으면 적어주세요.");
			textField.setBounds(16, 319, 352, 39);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel_2_1_1_1_1_1() {
		if (lblNewLabel_2_1_1_1_1_1 == null) {
			lblNewLabel_2_1_1_1_1_1 = new JLabel("결제수단");
			lblNewLabel_2_1_1_1_1_1.setForeground(new Color(130, 77, 30));
			lblNewLabel_2_1_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_1_1_1_1_1.setBounds(27, 388, 80, 20);
		}
		return lblNewLabel_2_1_1_1_1_1;
	}
	private JRadioButton getRadioButton() {
		if (radioButton == null) {
			radioButton = new JRadioButton(" 신용카드");
			radioButton.setSelected(true);
			radioButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			buttonGroup.add(radioButton);
			radioButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			radioButton.setForeground(new Color(61, 60, 69));
			radioButton.setBounds(37, 420, 141, 23);
		}
		return radioButton;
	}
	private JRadioButton getRadioButton_1() {
		if (radioButton_1 == null) {
			radioButton_1 = new JRadioButton(" 간편카드결제");
			radioButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			buttonGroup.add(radioButton_1);
			radioButton_1.setForeground(new Color(61, 60, 69));
			radioButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			radioButton_1.setBounds(190, 420, 141, 23);
		}
		return radioButton_1;
	}
	private JRadioButton getRadioButton_2() {
		if (radioButton_2 == null) {
			radioButton_2 = new JRadioButton(" 네이버페이");
			radioButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			buttonGroup.add(radioButton_2);
			radioButton_2.setForeground(new Color(61, 60, 69));
			radioButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			radioButton_2.setBounds(37, 455, 141, 23);
		}
		return radioButton_2;
	}
	private JRadioButton getRadioButton_2_1() {
		if (radioButton_2_1 == null) {
			radioButton_2_1 = new JRadioButton(" 카카오페이");
			radioButton_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			buttonGroup.add(radioButton_2_1);
			radioButton_2_1.setForeground(new Color(61, 60, 69));
			radioButton_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			radioButton_2_1.setBounds(190, 456, 141, 23);
		}
		return radioButton_2_1;
	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel((Integer.toString(pay)));
			lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTotal.setForeground(new Color(130, 77, 30));
			lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblTotal.setBounds(129, 580, 180, 20);
		}
		return lblTotal;
	}
	private JLabel getLblDiscount() {
		if (lblDiscount == null) {
			lblDiscount = new JLabel("0");
			lblDiscount.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDiscount.setForeground(new Color(130, 77, 30));
			lblDiscount.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblDiscount.setBounds(129, 615, 180, 20);
		}
		return lblDiscount;
	}
	private JLabel getLblTotalPay() {
		if (lblTotalPay == null) {
			lblTotalPay = new JLabel("0");
			lblTotalPay.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTotalPay.setForeground(new Color(130, 77, 30));
			lblTotalPay.setFont(new Font("Lucida Grande", Font.BOLD, 21));
			lblTotalPay.setBounds(129, 652, 180, 20);
		}
		return lblTotalPay;
	}
	
	
	
	
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("원");
			lblNewLabel_3.setForeground(new Color(130, 77, 30));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_3.setBounds(307, 580, 24, 20);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("원");
			lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3_1.setForeground(new Color(130, 77, 30));
			lblNewLabel_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_3_1.setBounds(307, 615, 24, 20);
		}
		return lblNewLabel_3_1;
	}
	private JLabel getLblNewLabel_3_2() {
		if (lblNewLabel_3_2 == null) {
			lblNewLabel_3_2 = new JLabel("원");
			lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3_2.setForeground(new Color(130, 77, 30));
			lblNewLabel_3_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_3_2.setBounds(307, 652, 24, 20);
		}
		return lblNewLabel_3_2;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	////////////////////////////////////////////////////////////////////
	private void tableInit() {    // <<<<<<<테이블 설정
		outerTable.addColumn("");
		outerTable.addColumn("");
		outerTable.addColumn("");
		outerTable.setColumnCount(3);
		
		int i = outerTable.getRowCount(); //기존데이터있을까봐 지우기
		
		for(int j=0; j < i; j++) {		// 데이터지우는 for문
			outerTable.removeRow(0);
		}
		
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF); //사이즈 자동조절 안하겠다ㅣ
		
		// 컬럼크기 정하기
		
		int vColIndex = 0;		// 첫번째 컬럼 번호
		TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
		int width = 230;	// 첫번째 컬럼 폭
		col.setPreferredWidth(width);
		vColIndex = 1;		// 첫번째 컬럼 번호
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 100;	// 첫번째 컬럼 폭
		col.setPreferredWidth(width);
		vColIndex = 2;	// 세번째 컬럼번호
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 60;		// 세번째 컬럼 폭정하기
		col.setPreferredWidth(width);

	}
	// 주문하기 테이블 채우기
	private void searchAction() {
		
		dtoList = new ArrayList<Lju_dto>();
		Lju_Dao_BasketAction lju_Dao_BasketAction = new Lju_Dao_BasketAction();
		dtoList = lju_Dao_BasketAction.BasketLinst();
		
		int listCount = dtoList.size();
		
		
		
		for(int i = 0; i< listCount; i++) {
			
			String price = Integer.toString(dtoList.get(i).getIprice());
			int bqty = dtoList.get(i).getBqty();
			payqty = bqty;
			payprice = dtoList.get(i).getIprice();
			pay += bqty * payprice;
			ImageIcon imgicon = new ImageIcon("./" + dtoList.get(i).getIimagename());
			Image img = imgicon.getImage();
			
			Image updateImg = img.getScaledInstance(100, 130, Image.SCALE_SMOOTH);
			ImageIcon upImg = new ImageIcon(updateImg);
			
			ImageIcon selectEmpty = new ImageIcon(Lju_Payment.class.getResource("/com/javalec/image/cross.png"));
			
			Object[] qTxt = {dtoList.get(i).getIname() ,payprice, " x "+ bqty};
			outerTable.addRow(qTxt);
			
			}
		closeingAction();
		}
	
	
	
	// 불러온 사진 지우기
	private void closeingAction() {	//사진지우기
		for(int i=0; i <dtoList.size(); i++) {
			File file = new File(dtoList.get(i).getIimagename());
			file.delete();	
		}
				
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
	 
	 // 시간표시 메소드
	 private void clockRun() {
		    javax.swing.Timer timer = new javax.swing.Timer(100, new ActionListener() {	//1초마다 갱신
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Calendar t = Calendar.getInstance();
		            int hour = t.get(Calendar.HOUR);
		            int min = t.get(Calendar.MINUTE);
		            String clock = String.format("%02d : %02d" , hour, min);	// 시간을 01:02로표시 원래 1시:2분 이런식
		            lblClock.setText(clock);
				}
			});	 
		    timer.start();
		}


	 //장바구니 버튼에 숫자넣기
	private void basketCount() {
		
		Lju_Dao_BasketAction lju_Dao_BasketAction = new Lju_Dao_BasketAction();
		int count = lju_Dao_BasketAction.basketCount();
		
		if(count>0) {
			lblCount.setVisible(true);
			lblCountNum.setVisible(true);
			lblCountNum.setText(Integer.toString(count));
		}

	}
	//쿠폰 체크박스 쿠폰유무 및 종류 체크
	private void couponCheck() {
			
			Lju_Dao_CouponCheck lju_Dao_CouponCheck = new Lju_Dao_CouponCheck();
			int coupon = lju_Dao_CouponCheck.couponCheck();
			if(coupon == 1) {
				chckbxcoupon.setText("사용가능한 쿠폰이 없습니다.");
				chckbxcoupon.setEnabled(false);
			}else if(coupon == 5) {
				chckbxcoupon.setText("5% 할인 쿠폰");
			
			}else if(coupon == 6) {
				chckbxcoupon.setText("6% 할인 쿠폰");
			}else if(coupon == 7) {
				chckbxcoupon.setText("7% 할인 쿠폰");
			}else if(coupon == 8) {
				chckbxcoupon.setText("8% 할인 쿠폰");
			}else if(coupon == 9) {
				chckbxcoupon.setText("9% 할인 쿠폰");
			}else if(coupon == 10) {
				chckbxcoupon.setText("10% 할인 쿠폰");
			}else {
				chckbxcoupon.setText("관리자에게 문의하세요");
			}
			
		}
		// 		상품 할인가격 표시/ 뺄숫자
		private void discount() {
			String dis = chckbxcoupon.getText();
			int i = 0;
			if(chckbxcoupon.isSelected() && dis.equals("10% 할인 쿠폰")) {
				i = (int) (pay * 0.10);
				lblDiscount.setText(Integer.toString(i));
			}else if(chckbxcoupon.isSelected() && dis.equals("9% 할인 쿠폰")) {
				i = (int) (pay * 0.09);
				lblDiscount.setText(Integer.toString(i));
			}else if(chckbxcoupon.isSelected() && dis.equals("8% 할인 쿠폰")) {
				i = (int) (pay * 0.08);
				lblDiscount.setText(Integer.toString(i));
			}else if(chckbxcoupon.isSelected() && dis.equals("7% 할인 쿠폰")) {
				i = (int) (pay * 0.07);
				lblDiscount.setText(Integer.toString(i));
			}else if(chckbxcoupon.isSelected() && dis.equals("6% 할인 쿠폰")) {
				i = (int) (pay * 0.06);
				lblDiscount.setText(Integer.toString(i));
			}else if(chckbxcoupon.isSelected() && dis.equals("5% 할인 쿠폰")) {
				i = (int) (pay * 0.05);
				lblDiscount.setText(Integer.toString(i));
			}else {
				lblDiscount.setText("0");
				
			}
			
		}
		
		// 할인된 총 가격 표시하기
		private void totalPay() {
			
			paytotal = pay - Integer.parseInt(lblDiscount.getText());
			
			lblTotalPay.setText(Integer.toString(paytotal));
			
		}
		
		
		private void purchaseAction() {
			String i = lblTotalPay.getText();
			if(i.equals("0")) {
				Lju_Purchase_Dialog2 dialog2 = new Lju_Purchase_Dialog2();
				dialog2.setLocationRelativeTo(null);
				dialog2.setVisible(true);
			
			}else {
				String buydis = "";
				if(chckbxcoupon.isSelected()) {
					buydis = chckbxcoupon.getText();
				}
				Lju_Dao_PurchaseHistory dao_PurchaseHistory = new Lju_Dao_PurchaseHistory(buydis);
				dao_PurchaseHistory.purchaseAciont();
				
				Lju_PurchaseHistory history = new Lju_PurchaseHistory();
				history.setLocationRelativeTo(null);
				history.setVisible(true);
				Lju_Purchase_Dialog dialog = new Lju_Purchase_Dialog();
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
				
				dispose();
			}
			
			
		}
		
		
	}