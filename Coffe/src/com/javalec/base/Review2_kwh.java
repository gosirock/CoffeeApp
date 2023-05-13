package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.DaoReview_kwh;
import com.javalec.dto.DtoReview_kwh;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.Icon;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageConsumer;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JEditorPane;

public class Review2_kwh extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnHome;
	private JButton btnMenu;
	private JButton btnOrder;
	private JButton btnReview;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable innerTable2;
	private JRadioButton rbRecent_1;
	private JRadioButton rbRecommendation_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final DefaultTableModel outerTable = new DefaultTableModel();
	
	
	
	DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Review2_kwh frame = new Review2_kwh();
					frame.setLocationRelativeTo(null);  // jframe이 화면에 중앙에 위치하도록 하기
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
	public Review2_kwh() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();  // 테이블초기화
				searchAction();  // 데이터불러오기
				screenPartition(); //  radiobtn 이 눌러진 상태로 textfield 화면표시해주기
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 872);							// 백그라운드 프레임 패널 사이즈
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 227, 182));	// 백그라운드 프레임 패널 색
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel());
		contentPane.add(getScrollPane());
		contentPane.add(getRbRecent_1());
		contentPane.add(getRbRecommendation_1());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 757, 390, 87);
			panel.setBackground(new Color(131, 77, 30));
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
			btnHome.setIcon(new ImageIcon(Review2_kwh.class.getResource("/com/javalec/image/btnHome.png")));
			btnHome.setFocusPainted(false);					// 버튼 포커스라인 없애기
			btnHome.setBorderPainted(false);
			btnHome.setBackground(new Color(131, 77, 30));
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
				}
			});
			btnMenu.setIcon(new ImageIcon(Review2_kwh.class.getResource("/com/javalec/image/btnMenu.png")));
			btnMenu.setFocusPainted(false);
			btnMenu.setBorderPainted(false);
		}
		return btnMenu;
	}
	private JButton getBtnOrder() {
		if (btnOrder == null) {
			btnOrder = new JButton("");
			btnOrder.setBackground(new Color(131, 77, 30));
			btnOrder.setIcon(new ImageIcon(Review2_kwh.class.getResource("/com/javalec/image/btnOrder.png")));
			btnOrder.setFocusPainted(false);
			btnOrder.setBorderPainted(false);
		}
		return btnOrder;
	}
	private JButton getBtnReview() {
		if (btnReview == null) {
			btnReview = new JButton("");
			btnReview.setBackground(new Color(131, 77, 30));
			btnReview.setIcon(new ImageIcon(Review2_kwh.class.getResource("/com/javalec/image/btnReview.png")));
			btnReview.setFocusPainted(false);
			btnReview.setBorderPainted(false);
		}
		return btnReview;
	}
	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(303, 15, 65, 18);
			lblNewLabel_1.setIcon(new ImageIcon(Lju_base.class.getResource("/com/javalec/image/wifi.png")));
		}
		return lblNewLabel_1;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Review");
			lblNewLabel.setForeground(new Color(131, 77, 30));
			lblNewLabel.setFont(new Font("Al Nile", Font.PLAIN, 35));
			lblNewLabel.setBounds(18, 65, 125, 40);
		}
		return lblNewLabel;
	}
	
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				
				}
			});
			scrollPane.setBounds(0, 163, 390, 594);
			scrollPane.setViewportView(getinnerTable2());
			innerTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable2.setModel(outerTable);
		}
		return scrollPane;
	}
	private JTable getinnerTable2() {
		if (innerTable2 == null) {
			innerTable2 = new JTable() {
				public Class getColumnClass(int Column) {					// 컬럼에 오브젝트 이미지 넣을거야
					return (Column == 0) ? Icon.class : Object.class;
				}
			};
			innerTable2.setOpaque(false);
			innerTable2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			innerTable2.setGridColor(new Color(252, 242, 217));
			innerTable2.setSelectionForeground(new Color(248, 227, 182));
			innerTable2.setSelectionBackground(new Color(130, 77, 30));
			innerTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable2.setRequestFocusEnabled(false);
			innerTable2.setFocusTraversalKeysEnabled(false);
			innerTable2.setForeground(new Color(131, 77, 30));
			innerTable2.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 15));
			innerTable2.setBackground(new Color(252, 242, 217));
			innerTable2.setModel(outerTable); 	//<<<<< 추가
			innerTable2.setRowHeight(300);  		//<<<<< 높이조절
			tableInit();
			
			
		}
		return innerTable2;
}
	private JRadioButton getRbRecent_1() {
		if (rbRecent_1 == null) {
			rbRecent_1 = new JRadioButton("최신순");
			rbRecent_1.setSelected(true);
			buttonGroup.add(rbRecent_1);
			buttonGroup.add(rbRecent_1);
			rbRecent_1.setBounds(16, 111, 65, 23);rbRecent_1.setBackground(new Color(248, 227, 182));
		}
		return rbRecent_1;
	}
	
	private JRadioButton getRbRecommendation_1() {
		if (rbRecommendation_1 == null) {
			rbRecommendation_1 = new JRadioButton("추천순");
			buttonGroup.add(rbRecommendation_1);
			buttonGroup.add(rbRecommendation_1);
			rbRecommendation_1.setBounds(77, 111, 65, 23);
			rbRecommendation_1.setBackground(new Color(248, 227, 182));
		}
		return rbRecommendation_1;
	}
	
	
	// function
	
	
	
	private void tableInit() {

		outerTable.addColumn("");
		outerTable.addColumn("");
		outerTable.setColumnCount(2);
		
		int i = outerTable.getRowCount();
		for(int j = 0 ; j < i ; j++) {
			outerTable.removeRow(0);
		}
		
		innerTable2.setAutoResizeMode(innerTable2.AUTO_RESIZE_OFF);
		
		int vColIndex = 0;
		TableColumn col = innerTable2.getColumnModel().getColumn(vColIndex);
		int width = 130;
		col.setPreferredWidth(width);
		 vColIndex = 1;
		col = innerTable2.getColumnModel().getColumn(vColIndex);
		 width = 260;
		col.setPreferredWidth(width);
		
	
	
	}










	// DB의 table에서 화면의 table에 들어갈 정보 가져오기 메서드
	private void searchAction() {
		DaoReview_kwh dao = new DaoReview_kwh();
//		dao.selectList();   // Dao 에서 return 을 준다  받아야함
		ArrayList<DtoReview_kwh> dtoList = dao.selectList();  // 받아야 하므로 Dto type의 dtoList를 변수로 받는다
		int listCount = dtoList.size();
		
		for( int i = 0; i < listCount ; i++) {
			String temp = dtoList.get(i).getCustomer_cid();
			ImageIcon imgicon = new ImageIcon("./" + dtoList.get(i).getRimagename());
			
			Image img = imgicon.getImage();  // 이미지 크기조절
			Image updateImg = img.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
			ImageIcon upImg = new ImageIcon(updateImg);
			
			
			// 자바유틸데이트로 현재시각을 받아서 자바sql데이트에 넣어야함
			java.util.Date now = new java.util.Date();
			java.sql.Date rinsertdate = new java.sql.Date(now.getTime());
			
			Object[] qTxt = {upImg,"<html>"+temp+"<br><br>"+dtoList.get(i).getIname()+"<p><p>"+ Integer.toString(dtoList.get(i).getIprice())+"<p><p>"+dtoList.get(i).getTitle()+"<p><p>"+dtoList.get(i).getComment()+"<p><p>"+dtoList.get(i).getRinsertdate()+"<p></html>"};
			outerTable.addRow(qTxt);  // 화면에 데이터 넣어주기
			
		}
	
		//tfCount.setText(Integer.toString(listCount));
		
	}



	private void checkAction() {
		DaoReview_kwh dao = new DaoReview_kwh();
		
		ArrayList<DtoReview_kwh> dtoList = dao.checkList();  // 받아야 하므로 Dto type의 dtoList를 변수로 받는다
		int listCount = dtoList.size();
		
		for( int i = 0; i < listCount ; i++) {
			String temp = dtoList.get(i).getCustomer_cid();
			ImageIcon imgicon = new ImageIcon("./" + dtoList.get(i).getRimagename());
			
			Image img = imgicon.getImage();  // 이미지 크기조절
			Image updateImg = img.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
			ImageIcon upImg = new ImageIcon(updateImg);
			
			
			// 자바유틸데이트로 현재시각을 받아서 자바sql데이트에 넣어야함
			java.util.Date now = new java.util.Date();
			java.sql.Date rinsertdate = new java.sql.Date(now.getTime());
			
			Object[] qTxt = {upImg,"<html>"+temp+"<br><br>"+dtoList.get(i).getIname()+"<p><p>"+ Integer.toString(dtoList.get(i).getIprice())+"<p><p>"+dtoList.get(i).getTitle()+"<p><p>"+dtoList.get(i).getComment()+"<p><p>"+dtoList.get(i).getRinsertdate()+"<p></html>"};
			outerTable.addRow(qTxt);  // 화면에 데이터 넣어주기
		
		}
		//tfCount.setText(Integer.toString(listCount));
		
	}










	private void screenPartition() {
		
		// 최신순버튼
		if (rbRecent_1.isSelected()) {//날짜별로 정렬
			System.out.println("@@");
			
			tableInit();
			searchAction();  // 하면 최신순으로 돌아옴
			
		}

		// 추천순버튼
		
		if (rbRecommendation_1.isSelected()) {// count정렬
			//System.out.println("@@");
			tableInit();
			checkAction();  // 추천순 상품명 중 리뷰가 많이 작성된 순으로
			
		
		}
		
		
		

	}
	
	
	


	
}
	

