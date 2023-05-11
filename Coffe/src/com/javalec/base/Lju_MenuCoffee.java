package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.Lju_dao;
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
public class Lju_MenuCoffee extends JFrame implements ActionListener {	// 엔터키 액션넣기

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
	
//	"<html>안녕<br>안녀엉<p>세번</html>" 라벨 줄바꾸기
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lju_MenuCoffee frame = new Lju_MenuCoffee();
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
	
	
	public Lju_MenuCoffee() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				closeingAction();	// 사진지우
			}
		});
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
		contentPane.add(getTxtSearch());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnCoffe());
		contentPane.add(getBtnDrink());
		contentPane.add(getBtnDessert());
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
			btnHome.setIcon(new ImageIcon(Lju_MenuCoffee.class.getResource("/com/javalec/image/btnHome.png")));
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
			btnMenu.setIcon(new ImageIcon(Lju_MenuCoffee.class.getResource("/com/javalec/image/btnMenu.png")));
			btnMenu.setFocusPainted(false);
			btnMenu.setBorderPainted(false);
		}
		return btnMenu;
	}
	private JButton getBtnOrder() {
		if (btnOrder == null) {
			btnOrder = new JButton("");
			btnOrder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnOrder.setIcon(new ImageIcon(Lju_MenuCoffee.class.getResource("/com/javalec/image/btnOrder.png")));
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
			btnReview.setIcon(new ImageIcon(Lju_MenuCoffee.class.getResource("/com/javalec/image/btnReview.png")));
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
			lblNewLabel_1.setIcon(new ImageIcon(Lju_MenuCoffee.class.getResource("/com/javalec/image/wifi.png")));
			lblNewLabel_1.setBounds(303, 15, 65, 18);
		}
		return lblNewLabel_1;
	}
	private JTextField getTxtSearch() {
		if (txtSearch == null) {
			txtSearch = new JTextField();
			txtSearch.setDoubleBuffered(true);
			txtSearch.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			txtSearch.setColumns(10);
			txtSearch.setPreferredSize(new Dimension(10, 26));
			txtSearch.setRequestFocusEnabled(false);
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
				}
			});
			btnCoffe.setBorderPainted(false);
			btnCoffe.setIcon(new ImageIcon(Lju_MenuCoffee.class.getResource("/com/javalec/image/opt 1.png")));
			btnCoffe.setBounds(36, 187, 106, 32);
		}
		return btnCoffe;
	}
	private JButton getBtnDrink() {
		if (btnDrink == null) {
			btnDrink = new JButton("");
			btnDrink.setFocusPainted(false);
			btnDrink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnDrink.setIcon(new ImageIcon(Lju_MenuCoffee.class.getResource("/com/javalec/image/opt 2.png")));
			btnDrink.setBorderPainted(false);
			btnDrink.setBounds(133, 187, 113, 32);
		}
		return btnDrink;
	}
	private JButton getBtnDessert() {
		if (btnDessert == null) {
			btnDessert = new JButton("");
			btnDessert.setFocusPainted(false);
			btnDessert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnDessert.setIcon(new ImageIcon(Lju_MenuCoffee.class.getResource("/com/javalec/image/opt 3.png")));
			btnDessert.setBorderPainted(false);
			btnDessert.setBounds(245, 187, 106, 32);
		}
		return btnDessert;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(Lju_MenuCoffee.class.getResource("/com/javalec/image/options.png")));
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
			innerTable.setOpaque(false);
			innerTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			innerTable.setGridColor(new Color(252, 242, 217));
			innerTable.setSelectionForeground(new Color(248, 227, 182));
			innerTable.setSelectionBackground(new Color(130, 77, 30));
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setRequestFocusEnabled(false);
			innerTable.setFocusTraversalKeysEnabled(false);
			innerTable.setForeground(new Color(131, 77, 30));
			innerTable.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 15));
			innerTable.setBackground(new Color(252, 242, 217));
			innerTable.setModel(outerTable); 	//<<<<< 추가
			innerTable.setRowHeight(130);  		//<<<<< 높이조절
			tableInit();
			searchAction();
		}
		return innerTable;
	}
	
	private void tableInit() {    // 4- <<<<<<<테이블 설정
		outerTable.addColumn("");
		outerTable.addColumn("");
		outerTable.setColumnCount(2);
		
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
		
		vColIndex = 1;	// 두번째 컬럼번호
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 230;		// 두번째 컬럼 폭정하기
		col.setPreferredWidth(width);

	}
	// 테이블 채우기 첫
	private void searchAction() {
		
		dtoList = new ArrayList<Lju_dto>();
		Lju_dao daoLju_dao = new Lju_dao();
		dtoList = daoLju_dao.selectLinst();
		
		int listCount = dtoList.size();
		
		
		
		for(int i = 0; i< listCount; i++) {
			
			String price = Integer.toString(dtoList.get(i).getIprice());
			
			
			ImageIcon imgicon = new ImageIcon("./" + dtoList.get(i).getIimagename());
			
			
			Object[] qTxt = {imgicon, "<html>"+dtoList.get(i).getIname()+"<br><br>" + dtoList.get(i).getIdescription()+"<p><p>" + price+"</html>"};
			outerTable.addRow(qTxt);
			
	
			}
			
		}
	
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
	
	 private void SearchAction() {
		 
		 Lju_dao dao = new Lju_dao(txtSearch.getText());
		 ArrayList<Lju_dto> dtoList = dao.SearchAction();
		 int listCount = dtoList.size();
			
			
			
			for(int i = 0; i< listCount; i++) {
				
				String price = Integer.toString(dtoList.get(i).getIprice());
				
				
				ImageIcon imgicon = new ImageIcon("./" + dtoList.get(i).getIimagename());
				
				
				Object[] qTxt = {imgicon, "<html>"+dtoList.get(i).getIname()+"<br><br>" + dtoList.get(i).getIdescription()+"<p><p>" + price+"</html>"};
				outerTable.addRow(qTxt);
				
		
				}
		 
	 }

}
