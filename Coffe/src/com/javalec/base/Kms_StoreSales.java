package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


import com.javalec.dao.Kms_Dao_AdminProduct;
import com.javalec.dao.Kms_Dao_StoreSales;

import com.javalec.dto.Kms_Dto_AdminProduct;
import com.javalec.dto.Kms_Dto_StoreSales;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;;

public class Kms_StoreSales extends JFrame {

	private JPanel contentPane;
	private JLabel wifi;
	private JLabel lblSalesInfo;
	private JButton btnDaySales;
	private JButton btnDaysSales;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private JButton btnBack;
	private final DefaultTableModel outerTable = new DefaultTableModel();
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	private JLabel lblSales;
	private JTextField tfSales;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kms_StoreSales frame = new Kms_StoreSales();
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
	public Kms_StoreSales() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();  // 테이블초기화
				daySalesAction();  // 데이터불러오기
				sumAction();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 872);							// 백그라운드 프레임 패널 사이즈
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 227, 182));	// 백그라운드 프레임 패널 색
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getWifi());
		contentPane.add(getLblSalesInfo());
		contentPane.add(getBtnDaySales());
		contentPane.add(getBtnDaysSales());
//		contentPane.add(getScrollPane());
		contentPane.add(getBtnBack());
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(6, 169, 378, 559);
		contentPane.add(scrollPane);
		
		innerTable = new JTable();
		innerTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		scrollPane.setViewportView(innerTable);
		innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		innerTable.setModel(outerTable);
		contentPane.add(getLblSales());
		contentPane.add(getTfSales());
	}
	
	private JLabel getWifi() {
		if (wifi == null) {
			wifi = new JLabel("");
			wifi.setBounds(303, 15, 65, 18);
			wifi.setIcon(new ImageIcon(Kms_StoreSales.class.getResource("/com/javalec/image/wifi.png")));
		}
		return wifi;
	}
	
	private JLabel getLblSalesInfo() {
		if (lblSalesInfo == null) {
			lblSalesInfo = new JLabel("");
			lblSalesInfo.setBounds(160, 68, 75, 22);
			lblSalesInfo.setIcon(new ImageIcon(Kms_StoreSales.class.getResource("/com/javalec/image/salesInfo.png")));
		}
		return lblSalesInfo;
	}
	private JButton getBtnDaySales() {
		if (btnDaySales == null) {
			btnDaySales = new JButton("");
			buttonGroup.add(btnDaySales);
			btnDaySales.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel model = (DefaultTableModel) innerTable.getModel();
					model.setRowCount(0);
					daySalesAction();
					sumAction();
				}
			});
			btnDaySales.setBounds(34, 114, 160, 32);
			btnDaySales.setIcon(new ImageIcon(Kms_StoreSales.class.getResource("/com/javalec/image/daySales.png")));
		}
		return btnDaySales;
	}
	private JButton getBtnDaysSales() {
		if (btnDaysSales == null) {
			btnDaysSales = new JButton("");
			buttonGroup.add(btnDaysSales);
			btnDaysSales.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel model = (DefaultTableModel) innerTable.getModel();
					model.setRowCount(0);
					yDaySalesAction();
					ysumAction();
				}
			});
			btnDaysSales.setBounds(195, 114, 160, 32);
			btnDaysSales.setIcon(new ImageIcon(Kms_StoreSales.class.getResource("/com/javalec/image/daysSales.png")));
		}
		return btnDaysSales;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					backAction();
				}
			});
			btnBack.setBounds(31, 54, 18, 24);
			btnBack.setIcon(new ImageIcon(Kms_StoreSales.class.getResource("/com/javalec/image/backbtn.png")));
			btnBack.setFocusPainted(false);
			btnBack.setBorderPainted(false);
		}
		return btnBack;
	}
	
	private JLabel getLblSales() {
		if (lblSales == null) {
			lblSales = new JLabel("총 매출:");
			lblSales.setBounds(160, 764, 48, 16);
		}
		return lblSales;
	}
	private JTextField getTfSales() {
		if (tfSales == null) {
			tfSales = new JTextField();
			tfSales.setEditable(false);
			tfSales.setBounds(218, 759, 166, 26);
			tfSales.setColumns(10);
		}
		return tfSales;
	}
	
	// ----- function ----
	
	private void tableInit() {
		outerTable.addColumn("주문번호");
		outerTable.addColumn("날짜");
		outerTable.addColumn("판매가격");
		outerTable.setColumnCount(3);
		
		int i = outerTable.getRowCount();
		for(int j = 0 ; j < i ; j++) {
			
		}
		
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
		
		int vColIndex = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
		int width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 1;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);
		

	
	
	
	
	}
	
//	private void searchAction() {
//		Kms_Dao_StoreSales dao = new Kms_Dao_StoreSales();
//		//dao.selectList();   // Dao 에서 return 을 준다  받아야함
//		ArrayList<Kms_Dto_StoreSales> dtoList = dao.selectList();  // 받아야 하므로 Dto type의 dtoList를 변수로 받는다
//		int listCount = dtoList.size();
//		
//		for( int i = 0; i < listCount ; i++) {
//			String[] qTxt = {Integer.toString(dtoList.get(i).getSeqno()), dtoList.get(i).getDate(), Integer.toString(dtoList.get(i).getPrice())};
//			outerTable.addRow(qTxt);  // 화면에 데이터 넣어주기
//			
//		}
//		//tfCount.setText(Integer.toString(listCount));
//		
//	}

		private void backAction() {
			Kms_AdminMain adminMain = new Kms_AdminMain();
			adminMain.setVisible(true);
			dispose();
		}
		
		private void daySalesAction() {
			Kms_Dao_StoreSales dao = new Kms_Dao_StoreSales();
			//dao.selectList();   // Dao 에서 return 을 준다  받아야함
			ArrayList<Kms_Dto_StoreSales> dtoList = dao.dayselectList();  // 받아야 하므로 Dto type의 dtoList를 변수로 받는다
			int listCount = dtoList.size();
			
			for( int i = 0; i < listCount ; i++) {
				String[] qTxt = {Integer.toString(dtoList.get(i).getSeqno()), dtoList.get(i).getDate(), Integer.toString(dtoList.get(i).getPrice())};
				outerTable.addRow(qTxt);  // 화면에 데이터 넣어주기
			}
		
			
		}
		
		private void yDaySalesAction() {
			Kms_Dao_StoreSales dao = new Kms_Dao_StoreSales();
			//dao.selectList();   // Dao 에서 return 을 준다  받아야함
			ArrayList<Kms_Dto_StoreSales> dtoList = dao.yDayselectList();  // 받아야 하므로 Dto type의 dtoList를 변수로 받는다
			int listCount = dtoList.size();
			
			for( int i = 0; i < listCount ; i++) {
				String[] qTxt = {Integer.toString(dtoList.get(i).getSeqno()), dtoList.get(i).getDate(), Integer.toString(dtoList.get(i).getPrice())};
				outerTable.addRow(qTxt);  // 화면에 데이터 넣어주기
				
			}
			//tfCount.setText(Integer.toString(listCount));
			
		}
		
		private void sumAction() {
			Kms_Dao_StoreSales daoStoreSales = new Kms_Dao_StoreSales();
			ArrayList<Kms_Dto_StoreSales> dtoList = daoStoreSales.dayselectList();
			int listCount = dtoList.size();
			int sum =0;
			for(int i = 0; i< listCount; i++) {
				String price = Integer.toString(dtoList.get(i).getPrice());
				int a = dtoList.get(i).getPrice();
				sum += a;
		}
			tfSales.setText(Integer.toString(sum));
			
			
	}
		private void ysumAction() {
			Kms_Dao_StoreSales daoStoreSales = new Kms_Dao_StoreSales();
			ArrayList<Kms_Dto_StoreSales> dtoList = daoStoreSales.yDayselectList();
			int listCount = dtoList.size();
			int sum =0;
			for(int i = 0; i< listCount; i++) {
				String price = Integer.toString(dtoList.get(i).getPrice());
				int a = dtoList.get(i).getPrice();
				sum += a;
		}
			tfSales.setText(Integer.toString(sum));
			
			
	}
}
