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
import com.javalec.dao.Lju_Dao_Menu_Coffee;
import com.javalec.dao.Lju_Dao_Menu_Drink;
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
	private JButton btnBasketAlldel;
	
//	"<html>안녕<br>안녀엉<p>세번</html>" 라벨 줄바꾸기
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lju_Payment frame = new Lju_Payment();
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
		contentPane.add(getBtnBasketAlldel());
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
			lblNewLabel = new JLabel("결 제");
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
			scrollPane.setBounds(0, 100, 400, 453);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	
	
	
	
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable(){
				public Class getColumnClass(int Column) {					// 컬럼에 오브젝트 이미지 넣을거야
					if (Column == 0 || Column == 3) {
				        return Icon.class;
				    } else {
				        return Object.class;
				    }
				}
				
			};
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
			innerTable.setOpaque(false);
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
			innerTable.setRowHeight(130);  		//<<<<< 높이조절
			tableInit();
			searchAction();
			
		}
		return innerTable;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	////////////////////////////////////////////////////////////////////
	private void tableInit() {    // <<<<<<<테이블 설정
		outerTable.addColumn("");
		outerTable.addColumn("");
		outerTable.addColumn("");
		outerTable.addColumn("");
		outerTable.addColumn("");
		outerTable.setColumnCount(5);
		
		int i = outerTable.getRowCount(); //기존데이터있을까봐 지우기
		
		for(int j=0; j < i; j++) {		// 데이터지우는 for문
			outerTable.removeRow(0);
		}
		
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF); //사이즈 자동조절 안하겠다ㅣ
		
		// 컬럼크기 정하기
		
		int vColIndex = 0;		// 첫번째 컬럼 번호
		TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
		int width = 110;	// 첫번째 컬럼 폭
		col.setPreferredWidth(width);
		vColIndex = 1;		// 첫번째 컬럼 번호
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 140;	// 첫번째 컬럼 폭
		col.setPreferredWidth(width);
		vColIndex = 2;	// 세번째 컬럼번호
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 80;		// 세번째 컬럼 폭정하기
		col.setPreferredWidth(width);
		vColIndex = 3;	// 세번째 컬럼번호
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 50;		// 세번째 컬럼 폭정하기
		col.setPreferredWidth(width);
		vColIndex = 4;	// 세번째 컬럼번호
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 0;		// 세번째 컬럼 폭정하기
		col.setPreferredWidth(width);

	}
	// 장바구니 테이블 채우기
	private void searchAction() {
		
		dtoList = new ArrayList<Lju_dto>();
		Lju_Dao_BasketAction lju_Dao_BasketAction = new Lju_Dao_BasketAction();
		dtoList = lju_Dao_BasketAction.BasketLinst();
		
		int listCount = dtoList.size();
		
		
		
		for(int i = 0; i< listCount; i++) {
			
			String price = Integer.toString(dtoList.get(i).getIprice());
			int bqty = dtoList.get(i).getBqty();
			
			ImageIcon imgicon = new ImageIcon("./" + dtoList.get(i).getIimagename());
			Image img = imgicon.getImage();
			
			Image updateImg = img.getScaledInstance(100, 130, Image.SCALE_SMOOTH);
			ImageIcon upImg = new ImageIcon(updateImg);
			
			ImageIcon selectEmpty = new ImageIcon(Lju_Payment.class.getResource("/com/javalec/image/cross.png"));
			
			Object[] qTxt = {upImg, dtoList.get(i).getIname() , " x "+ bqty, selectEmpty ,dtoList.get(i).getIid()};
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

// 테이블 선택시 
	
	private void tableClick() {
		
		int i = innerTable.getSelectedRow();
		String iid = (String) innerTable.getValueAt(i, 4);
		
		Lju_BasketEmpty basketEmpty = new Lju_BasketEmpty(iid, ShareVar.loginUserId);
		basketEmpty.selectDelete();
		
		tableInit();
		searchAction();
		
		
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
				}
			});
			btnNewButton.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/icon _cart_.png")));
			btnNewButton.setFocusPainted(false);
			btnNewButton.setBorderPainted(false);
			btnNewButton.setBounds(303, 50, 70, 40);
			basketCount();
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
	
	private void basketCount() {
		
		Lju_Dao_BasketAction lju_Dao_BasketAction = new Lju_Dao_BasketAction();
		int count = lju_Dao_BasketAction.basketCount();
		
		if(count>0) {
			lblCount.setVisible(true);
			lblCountNum.setVisible(true);
			lblCountNum.setText(Integer.toString(count));
		}
		
	}
	private JButton getBtnPay() {
		if (btnPay == null) {
			btnPay = new JButton("");
			btnPay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnPay.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPay.setIcon(new ImageIcon(Lju_Payment.class.getResource("/com/javalec/image/buttons (1).png")));
			btnPay.setFocusPainted(false);
			btnPay.setBorderPainted(false);
			btnPay.setBounds(60, 644, 270, 50);
		}
		return btnPay;
	}
	private JButton getBtnBasketAlldel() {
		if (btnBasketAlldel == null) {
			btnBasketAlldel = new JButton("");
			btnBasketAlldel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					 basketAllEmpty();
				}
			});
			btnBasketAlldel.setIcon(new ImageIcon(Lju_Payment.class.getResource("/com/javalec/image/cancel.png")));
			btnBasketAlldel.setHorizontalTextPosition(SwingConstants.CENTER);
			btnBasketAlldel.setFocusPainted(false);
			btnBasketAlldel.setBorderPainted(false);
			btnBasketAlldel.setBounds(248, 565, 120, 40);
		}
		return btnBasketAlldel;
	}
	
	
	//장바구니 전체 비우기
	private void basketAllEmpty() {
		
		Lju_BasketEmpty lju_BasketEmpty = new Lju_BasketEmpty();
		lju_BasketEmpty.AllEmpty();
		tableInit();
		searchAction();
	}
	
	
	
	
	}