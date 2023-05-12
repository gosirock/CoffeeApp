package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.DaoReview_kwh;
import com.javalec.dto.DtoReview_kwh;

import java.awt.Color;
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
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JTable innerTable;
	private JRadioButton rbRecent_1;
	private JRadioButton rbRecommendation_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final DefaultTableModel outerTable = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Review2_kwh frame = new Review2_kwh();
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
			btnOrder.setIcon(new ImageIcon(Review2_kwh.class.getResource("/com/javalec/image/btnOrder.png")));
			btnOrder.setFocusPainted(false);
			btnOrder.setBorderPainted(false);
		}
		return btnOrder;
	}
	private JButton getBtnReview() {
		if (btnReview == null) {
			btnReview = new JButton("");
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
			lblNewLabel_1.setIcon(new ImageIcon(Lju_Menu01.class.getResource("/com/javalec/image/wifi.png")));
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
			scrollPane.setViewportView(getInnerTable());
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
		}
		return innerTable;
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
		outerTable.addColumn("ID");
		outerTable.addColumn("상품명");
		outerTable.addColumn("가격");
		outerTable.addColumn("제목");
		outerTable.addColumn("내용");
		outerTable.addColumn("사진");
		outerTable.addColumn("작성날짜");
		
		outerTable.setColumnCount(7);
		
		int i = outerTable.getRowCount();
		for(int j = 0 ; j < i ; j++) {
			outerTable.removeRow(0);
		}
		
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
		
		int vColIndex = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
		int width = 30;
		col.setPreferredWidth(width);
		
		vColIndex = 1;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 40;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 30;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 30;
		col.setPreferredWidth(width);
		
		vColIndex = 4;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 5;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 6;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
	
	
	
	
	}










	// DB의 table에서 화면의 table에 들어갈 정보 가져오기 메서드
	private void searchAction() {
		DaoReview_kwh dao = new DaoReview_kwh();
//		dao.selectList();   // Dao 에서 return 을 준다  받아야함
		ArrayList<DtoReview_kwh> dtoList = dao.selectList();  // 받아야 하므로 Dto type의 dtoList를 변수로 받는다
		int listCount = dtoList.size();
		
		for( int i = 0; i < listCount ; i++) {
			String temp = dtoList.get(i).getCid();
			ImageIcon imgicon = new ImageIcon("./" + dtoList.get(i).getRimagename());
			
			Object[] qTxt = {temp, dtoList.get(i).getIname(), Integer.toString(dtoList.get(i).getPprice()),dtoList.get(i).getTitle(),dtoList.get(i).getComment(),imgicon};
			outerTable.addRow(qTxt);  // 화면에 데이터 넣어주기
			
		}
		//tfCount.setText(Integer.toString(listCount));
		
	}













	private void screenPartition() {
		
		// 최신순버튼
		if (rbRecent_1.isSelected()) {//날짜별로 정렬
//			tfName.setEditable(false);
//			tfBrand.setEditable(false);
//			tfID.setEditable(false);
//			tfStock.setEditable(false);
//			tfPrice.setEditable(false);
//			tfFilePath.setEditable(false);
//			btnOK.setVisible(false);
//			btnOK.setEnabled(false);
//			btnFilePath.setVisible(false);
		}

		// 추천순버튼
		
		if (rbRecommendation_1.isSelected()) {// count정렬
//			tfName.setEditable(true);
//			tfBrand.setEditable(true);
//			tfID.setEditable(true);
//			tfStock.setEditable(true);
//			tfPrice.setEditable(true);
//			tfFilePath.setEditable(true);
//			btnOK.setVisible(true);
//			btnOK.setEnabled(true);
//			btnFilePath.setVisible(true);
//			
		}
		
		
		

	}
	
	


	
}
	

