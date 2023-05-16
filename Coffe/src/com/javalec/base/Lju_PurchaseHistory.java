package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.Lju_Dao_BasketAction;
import com.javalec.dao.Lju_Dao_Menu_Coffee;
import com.javalec.dao.Lju_Dao_PurchaseHistory;
import com.javalec.dao.Lju_Dao_selectTable;
import com.javalec.dto.Lju_dto;
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
import java.awt.ComponentOrientation;
public class Lju_PurchaseHistory extends JFrame{

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnHome;
	private JButton btnMenu;
	private JButton btnOrder;
	private JButton btnReview;
	private JLabel lblNewLabel_1;
	
	
	
	private final DefaultTableModel outerTable = new DefaultTableModel();
	ArrayList<Lju_dto> dtoList = null;
	
	private JLabel lblClock;
	private JPanel panel_1;
	private JButton btnExit;
	private JLabel lblIid;
	private JButton btnNewButton;
	private JLabel lblCount;				/// 바스켓 카운터 추가ㅡㅡㅡㅡ
	private JLabel lblCountNum;				/// 바스켓 카운터 추가ㅡㅡㅡ
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JTable innerTable;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lju_PurchaseHistory frame = new Lju_PurchaseHistory();
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
	
	
	public Lju_PurchaseHistory() {
		setTitle("주문내역");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 872);							// 백그라운드 프레임 패널 사이즈
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 227, 182));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblCountNum());
		contentPane.add(getLblCount());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getPanel_1());
		contentPane.add(getLblClock());
		contentPane.add(getBtnNewButton());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getScrollPane());
	
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
			btnHome.setIcon(new ImageIcon(Lju_PurchaseHistory.class.getResource("/com/javalec/image/btnHome.png")));
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
					
					Lju_MenuCoffee coffee = new Lju_MenuCoffee();
					coffee.setLocationRelativeTo(null);
					coffee.setVisible(true);
					dispose();
							
				}
			});
			btnMenu.setIcon(new ImageIcon(Lju_PurchaseHistory.class.getResource("/com/javalec/image/Group 7.png")));
			btnMenu.setFocusPainted(false);
			btnMenu.setBorderPainted(false);
		}
		return btnMenu;
	}
	private JButton getBtnOrder() {
		if (btnOrder == null) {
			btnOrder = new JButton("");
			btnOrder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnOrder.setIcon(new ImageIcon(Lju_PurchaseHistory.class.getResource("/com/javalec/image/Group 55.png")));
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
			btnReview.setIcon(new ImageIcon(Lju_PurchaseHistory.class.getResource("/com/javalec/image/btnReview.png")));
			btnReview.setFocusPainted(false);
			btnReview.setBorderPainted(false);
		}
		return btnReview;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Lju_PurchaseHistory.class.getResource("/com/javalec/image/wifi.png")));
			lblNewLabel_1.setBounds(303, 15, 65, 18);
		}
		return lblNewLabel_1;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(252, 242, 217));
			panel_1.setBounds(0, 88, 1, 1);
			panel_1.setLayout(null);
			panel_1.add(getBtnExit());
			panel_1.add(getLblIid());
			panel_1.add(getBtnNewButton_1());
		}
		return panel_1;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("");
			btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnExit.setContentAreaFilled(false);
			btnExit.setRequestFocusEnabled(false);
			btnExit.setDefaultCapable(false);
			btnExit.setIcon(new ImageIcon(Lju_PurchaseHistory.class.getResource("/com/javalec/image/backbtn.png")));
			btnExit.setFocusPainted(false);
			btnExit.setBorderPainted(false);
			btnExit.setBounds(17, 19, 40, 40);
		}
		return btnExit;
	}
	
	
	
	private JLabel getLblIid() {
		if (lblIid == null) {
			lblIid = new JLabel("");
			lblIid.setBounds(145, 625, 61, 16);
		}
		return lblIid;
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
			btnNewButton.setIcon(new ImageIcon(Lju_PurchaseHistory.class.getResource("/com/javalec/image/icon _cart_.png")));
			btnNewButton.setFocusPainted(false);
			btnNewButton.setBorderPainted(false);
			btnNewButton.setBounds(303, 50, 70, 40);
			basketCount();					//mㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ바스켓카운터
		}
		return btnNewButton;
	}
	

	private JLabel getLblCount() {
		if (lblCount == null) {
			lblCount = new JLabel("");
			lblCount.setForeground(new Color(255, 255, 255));
			lblCount.setIcon(new ImageIcon(Lju_PurchaseHistory.class.getResource("/com/javalec/image/Ellipse 7.png")));
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
	
	
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
			btnNewButton_1.setFocusPainted(false);
			btnNewButton_1.setBorderPainted(false);
			btnNewButton_1.setIcon(new ImageIcon(Lju_PurchaseHistory.class.getResource("/com/javalec/image/buttons (2).png")));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_1.setBounds(57, 595, 280, 50);
		}
		return btnNewButton_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("주문내역");
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setForeground(new Color(131, 77, 30));
			lblNewLabel.setFont(new Font("Kailasa", Font.BOLD, 30));
			lblNewLabel.setBounds(27, 51, 170, 39);
		}
		return lblNewLabel;
	}
	
	
private void basketCount() {		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ  바스켓 카운터
		
		Lju_Dao_BasketAction lju_Dao_BasketAction = new Lju_Dao_BasketAction();
		int count = lju_Dao_BasketAction.basketCount();
		
		if(count>0) {
			lblCount.setVisible(true);
			lblCountNum.setVisible(true);
			lblCountNum.setText(Integer.toString(count));
		}
		
	}










////////////////////////////////////////////////////////////////////


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



	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(0, 143, 390, 613);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable() {
				public Class getColumnClass(int Column) {					// 컬럼에 오브젝트 이미지 넣을거야
				return (Column == 0) ? Icon.class : Object.class;
			}
				
			};
			innerTable.setAutoCreateRowSorter(true);
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Review_kwh review_kwh = new Review_kwh();
					review_kwh.setLocationRelativeTo(null);
					review_kwh.setVisible(true);
					dispose();
				}
			});
			innerTable.setFocusTraversalKeysEnabled(false);
			innerTable.setGridColor(new Color(252, 242, 217));
			innerTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			innerTable.setUpdateSelectionOnSort(false);
			innerTable.setShowVerticalLines(false);
			innerTable.setShowHorizontalLines(false);
			innerTable.setShowGrid(false);
			innerTable.setBackground(new Color(252, 242, 217));
			innerTable.setForeground(new Color(130, 77, 30));
			innerTable.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			innerTable.setModel(outerTable); 	//<<<<< 추가
			innerTable.setRowHeight(130);  		//<<<<< 높이조절
			innerTable.setFillsViewportHeight(true);

			tableInit();
			searchAction();
		}
		return innerTable;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
		int width = 130;	// 첫번째 컬럼 폭
		col.setPreferredWidth(width);
		vColIndex = 1;		// 첫번째 컬럼 번호
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 175;	// 첫번째 컬럼 폭
		col.setPreferredWidth(width);
		vColIndex = 2;	// 세번째 컬럼번호
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 80;		// 세번째 컬럼 폭정하기
		col.setPreferredWidth(width);

	}
	
	// 구매내역 테이블 채우기
		private void searchAction() {
			
			dtoList = new ArrayList<Lju_dto>();
			Lju_Dao_PurchaseHistory lju_Dao_PurchaseHistory = new Lju_Dao_PurchaseHistory();
			dtoList = lju_Dao_PurchaseHistory.History();
			
			int listCount = dtoList.size();
			
			for(int i = 0; i< listCount; i++) {
				
				ImageIcon imgicon = new ImageIcon("./" + dtoList.get(i).getIimagename());
				Image img = imgicon.getImage();
				
				Image updateImg = img.getScaledInstance(100, 130, Image.SCALE_SMOOTH);
				ImageIcon upImg = new ImageIcon(updateImg);
				
				
				String pdate = dtoList.get(i).getPdate();
				String iname = dtoList.get(i).getIname();
				int qty = dtoList.get(i).getPqty();
				int price = dtoList.get(i).getPsaleprice();
				
				Object[] qTxt = {upImg, "<html>"+ iname + "<br><font size = 3>"+pdate+"</font><br>" ,"<html>외 "+(qty-1)+"개<br> "+price+"원</html>"};
				outerTable.addRow(qTxt);
				
				
				
				}
			closeingAction();
			}
		
		
	
}