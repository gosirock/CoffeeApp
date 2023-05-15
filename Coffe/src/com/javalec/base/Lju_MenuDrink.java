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
import com.javalec.dao.Lju_Dao_Menu_Drink;
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
public class Lju_MenuDrink extends JFrame implements ActionListener {	// 엔터키 액션넣기

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnHome;
	private JButton btnMenu;
	private JButton btnOrder;
	private JButton btnReview;
	private JLabel lblNewLabel;
	private JLabel lblLikeToDrink;
	private JLabel lblNewLabel_1;
	private JTextField txtSearch;
	private JScrollPane scrollPane;
	private JButton btnCoffe;
	private JButton btnDrink;
	private JButton btnDessert;
	private JLabel lblNewLabel_4;
	
	
	
	private final DefaultTableModel outerTable = new DefaultTableModel();
	ArrayList<Lju_dto> dtoList = null;
	
	DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	private JTable innerTable;
	private JLabel lblClock;
	private JPanel panel_1;
	private JLabel lblclickimg;
	private JLabel lblName;
	private JLabel lblBasket;
	private JLabel lblgra;
	private JLabel lblBuy;
	private JButton btnMinus;
	private JButton btnPlus;
	private JLabel lblQty;
	private JLabel lblNewLabel_2;
	private JLabel lblclickimg_1;
	private JButton btnExit;
	private JLabel lblIid;
	private JButton btnNewButton;
	private JLabel lblCount;
	private JLabel lblCountNum;
	
//	"<html>안녕<br>안녀엉<p>세번</html>" 라벨 줄바꾸기
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lju_MenuDrink frame = new Lju_MenuDrink();
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
	
	
	public Lju_MenuDrink() {
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
		contentPane.add(getPanel_1());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblLikeToDrink());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTxtSearch());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnCoffe());
		contentPane.add(getBtnDrink());
		contentPane.add(getBtnDessert());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getLblClock());
		contentPane.add(getLblCountNum());
		contentPane.add(getLblCount());
		contentPane.add(getBtnNewButton());
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
				}
			});
			btnMenu.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/btnMenu.png")));
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
			lblNewLabel_1.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/wifi.png")));
			lblNewLabel_1.setBounds(303, 15, 65, 18);
		}
		return lblNewLabel_1;
	}
	private JTextField getTxtSearch() {
		if (txtSearch == null) {
			txtSearch = new JTextField();
			txtSearch.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					SearchAction();
				}
				@Override
				public void keyReleased(KeyEvent e) {
					SearchAction();
				}
			});
			txtSearch.setDoubleBuffered(true);
			txtSearch.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			txtSearch.setColumns(10);
			txtSearch.setPreferredSize(new Dimension(10, 26));
			txtSearch.addMouseMotionListener(new MouseMotionAdapter() {
			});
			txtSearch.setSelectionColor(new Color(252, 242, 217));
			txtSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txtSearch.setText(null);
				}
			});
			txtSearch.setDisabledTextColor(new Color(131, 77, 30));
			txtSearch.setCaretColor(new Color(131, 77, 30));
			txtSearch.setSelectedTextColor(new Color(131, 77, 30));
			txtSearch.setBackground(new Color(252, 242, 217));
			txtSearch.setForeground(new Color(131, 77, 30));
			txtSearch.setText("    검색");
			txtSearch.setBounds(35, 114, 321, 43);
			txtSearch.addActionListener(this);
		}
		return txtSearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setAutoscrolls(true);
			scrollPane.setBackground(new Color(252, 242, 217));
			scrollPane.setBounds(0, 239, 400, 520);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JButton getBtnCoffe() {
		if (btnCoffe == null) {
			btnCoffe = new JButton("");
			btnCoffe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnCoffe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Lju_MenuCoffee lju_MenuCoffee = new Lju_MenuCoffee();
					lju_MenuCoffee.setLocationRelativeTo(null);
					lju_MenuCoffee.setVisible(true);
					dispose();
				}
			});
			btnCoffe.setBorderPainted(false);
			btnCoffe.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/opt 1 (1).png")));
			btnCoffe.setBounds(36, 187, 106, 32);
		}
		return btnCoffe;
	}
	private JButton getBtnDrink() {
		if (btnDrink == null) {
			btnDrink = new JButton("");
			btnDrink.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			btnDrink.setFocusPainted(false);
			btnDrink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnDrink.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/opt 2 (2).png")));
			btnDrink.setBorderPainted(false);
			btnDrink.setBounds(141, 187, 113, 32);
		}
		return btnDrink;
	}
	private JButton getBtnDessert() {
		if (btnDessert == null) {
			btnDessert = new JButton("");
			btnDessert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					Lju_MenuDessert lju_MenuDessert = new Lju_MenuDessert();
					lju_MenuDessert.setLocationRelativeTo(null);
					lju_MenuDessert.setVisible(true);
					dispose();
				}
			});
			btnDessert.setFocusPainted(false);
			btnDessert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnDessert.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/opt 3.png")));
			btnDessert.setBorderPainted(false);
			btnDessert.setBounds(250, 187, 106, 32);
		}
		return btnDessert;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/options.png")));
			lblNewLabel_4.setBounds(35, 187, 321, 32);
		}
		return lblNewLabel_4;
	}
	
	
	
	
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable(){
				public Class getColumnClass(int Column) {					// 컬럼에 오브젝트 이미지 넣을거야
					return (Column == 0) ? Icon.class : Object.class;
				}
			};
			innerTable.setRequestFocusEnabled(false);
			innerTable.setShowVerticalLines(false);
			innerTable.setShowHorizontalLines(false);
			innerTable.setShowGrid(false);
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
			innerTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			innerTable.setGridColor(new Color(252, 242, 217));
			innerTable.setSelectionForeground(new Color(248, 227, 182));
			innerTable.setSelectionBackground(new Color(130, 77, 30));
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setFocusTraversalKeysEnabled(false);
			innerTable.setForeground(new Color(131, 77, 30));
			innerTable.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 15));
			innerTable.setBackground(new Color(252, 242, 217));
			innerTable.setModel(outerTable); 	//<<<<< 추가
			innerTable.setRowHeight(140);  		//<<<<< 높이조절
			innerTable.setFillsViewportHeight(true);
			tableInit();
			searchAction();
			panel_1.setVisible(false);
			
		}
		return innerTable;
	}
	
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(252, 242, 217));
			panel_1.setBounds(0, 88, 390, 672);
			panel_1.setLayout(null);
			panel_1.add(getLblBasket());
			panel_1.add(getLblBuy());
			panel_1.add(getBtnMinus());
			panel_1.add(getBtnExit());
			panel_1.add(getBtnPlus());
			panel_1.add(getLblQty());
			panel_1.add(getLblNewLabel_2());
			panel_1.add(getLblName());
			panel_1.add(getLblgra());
			panel_1.add(getLblclickimg());
			panel_1.add(getLblclickimg_1());
			panel_1.add(getLblIid());
		}
		return panel_1;
	}
	private JLabel getLblclickimg() {
		if (lblclickimg == null) {
			lblclickimg = new JLabel("");
			lblclickimg.setBounds(6, 6, 380, 680);
			
			
			
			
			
		}
		return lblclickimg;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel();
			lblName.setForeground(new Color(124, 79, 40));
			lblName.setFont(new Font("Lucida Grande", Font.BOLD, 30));
			lblName.setBounds(31, 306, 313, 257);
		}
		return lblName;
	}
	private JLabel getLblBasket() {
		if (lblBasket == null) {
			lblBasket = new JLabel("");
			lblBasket.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					basketAction();
					basketCount();
				}
			});
			lblBasket.addAncestorListener(new AncestorListener() {
				public void ancestorAdded(AncestorEvent event) {
				
					
				}
				public void ancestorMoved(AncestorEvent event) {
				}
				public void ancestorRemoved(AncestorEvent event) {
				}
			});
			lblBasket.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblBasket.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/selectjang.png")));
			lblBasket.setBounds(48, 568, 120, 30);
		}
		return lblBasket;
	}
	private JLabel getLblgra() {
		if (lblgra == null) {
			lblgra = new JLabel("");
			lblgra.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/layer.png")));
			lblgra.setBounds(0, 55, 386, 690);
		}
		return lblgra;
	}
	private JLabel getLblBuy() {
		if (lblBuy == null) {
			lblBuy = new JLabel("");
			lblBuy.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//결제페이지로 이동하기 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
					purchaseGo();
				}
			});
			lblBuy.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/selectbar.png")));
			lblBuy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblBuy.setBounds(214, 568, 120, 30);
		}
		return lblBuy;
	}
	
	private JButton getBtnPlus() {
		if (btnPlus == null) {
			btnPlus = new JButton("");
			btnPlus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnPlus.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					String i = lblQty.getText();
					int j = Integer.parseInt(i);
					if(j<99) {
						j++;
						String k = Integer.toString(j);
						lblQty.setText(k);
					}
					
					
				}
			});
			btnPlus.setFocusPainted(false);
			btnPlus.setBorderPainted(false);
			btnPlus.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/select.png")));
			btnPlus.setBounds(320, 457, 30, 40);
		}
		return btnPlus;
	}
	private JLabel getLblQty() {
		if (lblQty == null) {
			int i = 0;
			lblQty = new JLabel("1");
			lblQty.setHorizontalAlignment(SwingConstants.CENTER);
			lblQty.setFont(new Font("Lucida Grande", Font.BOLD, 25));
			lblQty.setForeground(new Color(124, 79, 40));
			lblQty.setBounds(264, 453, 50, 40);
		}
		return lblQty;
	}

	private JButton getBtnMinus() {
		if (btnMinus == null) {
			btnMinus = new JButton("");
			btnMinus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnMinus.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String i = lblQty.getText();
					int j = Integer.parseInt(i);
					if(j>1) {
						j--;
						String k = Integer.toString(j);
						lblQty.setText(k);
					}
					
				}
			});
			btnMinus.setFocusPainted(false);
			btnMinus.setBorderPainted(false);
			btnMinus.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/selectami.png")));
			btnMinus.setBounds(230, 457, 30, 40);
		}
		return btnMinus;
	}
	

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("원");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 30));
			lblNewLabel_2.setForeground(new Color(124, 79, 40));
			lblNewLabel_2.setBounds(126, 455, 61, 30);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblclickimg_1() {
		if (lblclickimg_1 == null) {
			lblclickimg_1 = new JLabel("");
			lblclickimg_1.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/Group 52.png")));
			lblclickimg_1.setBounds(0, 0, 400, 680);
		}
		return lblclickimg_1;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("");
			btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					closeingAction();
					scrollPane.setVisible(true);
					panel_1.setVisible(false);
				}
			});
			btnExit.setContentAreaFilled(false);
			btnExit.setRequestFocusEnabled(false);
			btnExit.setDefaultCapable(false);
			btnExit.setIcon(new ImageIcon(Lju_MenuDrink.class.getResource("/com/javalec/image/akar-icons_cross.png")));
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
		int width = 150;	// 첫번째 컬럼 폭
		col.setPreferredWidth(width);
		vColIndex = 1;		// 첫번째 컬럼 번호
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 230;	// 첫번째 컬럼 폭
		col.setPreferredWidth(width);
		vColIndex = 2;	// 세번째 컬럼번호
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 1;		// 세번째 컬럼 폭정하기
		col.setPreferredWidth(width);

	}
	// 음료메뉴 테이블 채우기 iid가 b인것만
	private void searchAction() {
		
		dtoList = new ArrayList<Lju_dto>();
		Lju_Dao_Menu_Drink daoLju_dao = new Lju_Dao_Menu_Drink();
		dtoList = daoLju_dao.Linst();
		
		int listCount = dtoList.size();
		
		
		
		for(int i = 0; i< listCount; i++) {
			
			String price = Integer.toString(dtoList.get(i).getIprice());
			
			
			ImageIcon imgicon = new ImageIcon("./" + dtoList.get(i).getIimagename());
			Image img = imgicon.getImage();
			
			Image updateImg = img.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
			ImageIcon upImg = new ImageIcon(updateImg);
			
			Object[] qTxt = {upImg, "<html>"+dtoList.get(i).getIname()+"<br><br>" + dtoList.get(i).getIdescription()+"<p><p>" + price+" 원</html>",dtoList.get(i).getIid()};
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
	
	
	// 텍스트 필드 엔터누르면 액션 
	 public void actionPerformed(ActionEvent e) {	
	        if (e.getSource() == txtSearch) {
	            // 텍스트 필드에서 엔터키 누름
	            String text = txtSearch.getText();
	            int i = outerTable.getRowCount(); //기존데이터있을까봐 지우기
	    		
	    		for(int j=0; j < i; j++) {		// 데이터지우는 for문
	    			outerTable.removeRow(0);
	    		}
	            SearchAction();
	            // 여기에 필요한 액션을 추가
	            
	        }
	    }
	
	 
	 // 검색기능 음료매뉴만 iid 가 b들어간것
	 private void SearchAction() {
		 tableInit();
		 Lju_Dao_Menu_Drink dao = new Lju_Dao_Menu_Drink(txtSearch.getText());
		 ArrayList<Lju_dto> dtoList = dao.SearchAction();
		 int listCount = dtoList.size();
			
			
			
			for(int i = 0; i< listCount; i++) {
				
				String price = Integer.toString(dtoList.get(i).getIprice());
				
				
				ImageIcon imgicon = new ImageIcon("./" + dtoList.get(i).getIimagename());
				Image img = imgicon.getImage();
				
				Image updateImg = img.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
				ImageIcon upImg = new ImageIcon(updateImg);
				
				Object[] qTxt = {upImg, "<html>"+dtoList.get(i).getIname()+"<br><br>" + dtoList.get(i).getIdescription()+"<p><p>" + price+" 원</html>", dtoList.get(i).getIid()};
				outerTable.addRow(qTxt);
				
		
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
		
		lblQty.setText("1");
		panel_1.setVisible(true);
		scrollPane.setVisible(false);
		int i = innerTable.getSelectedRow();
		String wkpid = (String) innerTable.getValueAt(i, 2);
		
		Lju_Dao_selectTable dao = new Lju_Dao_selectTable(wkpid);
		Lju_dto dto = dao.tableClick();
		lblIid.setText(dto.getIid());
		lblName.setText("<html>"+dto.getIname()+"<br><br>"+dto.getIprice()+"</html>");
		lblclickimg.setIcon(null);
		ImageIcon imgicon = new ImageIcon("./" + dto.getIimagename());
//		Image img = imgicon.getImage();
		
//		Image updateImg = img.getScaledInstance(380, 710, Image.SCALE_SMOOTH);
//		ImageIcon upImg = new ImageIcon(updateImg);
		
		lblclickimg.setIcon(imgicon);
		lblclickimg.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
	}


	
	
	private void basketAction(){
		
		String iid = lblIid.getText();
		String qty = lblQty.getText();
		
		Lju_Dao_BasketAction dao = new Lju_Dao_BasketAction(iid, qty);
		boolean result = dao.basketAction();
		
		if(result) {
			Lju_Basket_Dialog basket_Dialog = new Lju_Basket_Dialog();
			basket_Dialog.setLocationRelativeTo(null);
			basket_Dialog.setVisible(true);
			
		}else {
			JOptionPane.showMessageDialog(this, "재고가 부족합니다");
		}
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
			lblCountNum = new JLabel("1");
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

private void purchaseGo(){
		
		String iid = lblIid.getText();
		String qty = lblQty.getText();
		
		Lju_Dao_BasketAction dao = new Lju_Dao_BasketAction(iid, qty);
		boolean result = dao.basketAction();
		
		Lju_Payment lju_Payment = new Lju_Payment();
		lju_Payment.setLocationRelativeTo(null);
		lju_Payment.setVisible(true);
		
		dispose();
	}
	
	
	
	
	
	
	
	
	}