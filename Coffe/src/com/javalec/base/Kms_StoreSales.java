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
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;;

public class Kms_StoreSales extends JFrame {

	private JPanel contentPane;
	private JLabel wifi;
	private JLabel lblSalesInfo;
	private JButton btnDaySales;
	private JButton btnDaysSales;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnBack;

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
		contentPane.add(getScrollPane());
		contentPane.add(getBtnBack());
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
			btnDaySales.setBounds(34, 114, 160, 32);
			btnDaySales.setIcon(new ImageIcon(Kms_StoreSales.class.getResource("/com/javalec/image/daySales.png")));
		}
		return btnDaySales;
	}
	private JButton getBtnDaysSales() {
		if (btnDaysSales == null) {
			btnDaysSales = new JButton("");
			btnDaysSales.setBounds(195, 114, 160, 32);
			btnDaysSales.setIcon(new ImageIcon(Kms_StoreSales.class.getResource("/com/javalec/image/daysSales.png")));
		}
		return btnDaysSales;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 169, 378, 559);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
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
	
	
	// ----- function ----
	
		private void backAction() {
			Kms_AdminMain adminMain = new Kms_AdminMain();
			adminMain.setVisible(true);
			dispose();
		}
}
