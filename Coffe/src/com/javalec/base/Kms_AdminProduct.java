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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Kms_AdminProduct extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JLabel lblAdminProduct;
	private JRadioButton rbSearch;
	private JRadioButton rbInsert;
	private JRadioButton rbUpdate;
	private JRadioButton rbDelete;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tf;
	private JButton btnNewButton;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private JLabel lblProductId;
	private JLabel lblProductName;
	private JLabel lblProductPrice;
	private JLabel lblProductQty;
	private JTextField tfProductId;
	private JTextField tfProductName;
	private JTextField tfProductPrice;
	private JTextField tfProductQty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kms_AdminProduct frame = new Kms_AdminProduct();
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
	public Kms_AdminProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 872);							// 백그라운드 프레임 패널 사이즈
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 227, 182));	// 백그라운드 프레임 패널 색
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblAdminProduct());
		contentPane.add(getRbSearch());
		contentPane.add(getRbInsert());
		contentPane.add(getRbUpdate());
		contentPane.add(getRbDelete());
		contentPane.add(getTf());
		contentPane.add(getBtnNewButton());
		contentPane.add(getComboBox());
		contentPane.add(getScrollPane());
		contentPane.add(getLblProductId());
		contentPane.add(getLblProductName());
		contentPane.add(getLblProductPrice());
		contentPane.add(getLblProductQty());
		contentPane.add(getTfProductId());
		contentPane.add(getTfProductName());
		contentPane.add(getTfProductPrice());
		contentPane.add(getTfProductQty());
	}
	
	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(303, 15, 65, 18);
			lblNewLabel_1.setIcon(new ImageIcon(Kms_AdminProduct.class.getResource("/com/javalec/image/wifi.png")));
		}
		return lblNewLabel_1;
	}
	
	private JLabel getLblAdminProduct() {
		if (lblAdminProduct == null) {
			lblAdminProduct = new JLabel("");
			lblAdminProduct.setBounds(228, 44, 130, 22);
			lblAdminProduct.setIcon(new ImageIcon(Kms_AdminProduct.class.getResource("/com/javalec/image/adminProduct.png")));
		}
		return lblAdminProduct;
	}
	private JRadioButton getRbSearch() {
		if (rbSearch == null) {
			rbSearch = new JRadioButton("검색");
			rbSearch.setSelected(true);
			buttonGroup.add(rbSearch);
			rbSearch.setBounds(18, 66, 65, 23);
		}
		return rbSearch;
	}
	private JRadioButton getRbInsert() {
		if (rbInsert == null) {
			rbInsert = new JRadioButton("입력");
			buttonGroup.add(rbInsert);
			rbInsert.setBounds(111, 66, 65, 23);
		}
		return rbInsert;
	}
	private JRadioButton getRbUpdate() {
		if (rbUpdate == null) {
			rbUpdate = new JRadioButton("수정");
			buttonGroup.add(rbUpdate);
			rbUpdate.setBounds(204, 66, 65, 23);
		}
		return rbUpdate;
	}
	private JRadioButton getRbDelete() {
		if (rbDelete == null) {
			rbDelete = new JRadioButton("삭제");
			buttonGroup.add(rbDelete);
			rbDelete.setBounds(297, 66, 65, 23);
		}
		return rbDelete;
	}
	private JTextField getTf() {
		if (tf == null) {
			tf = new JTextField();
			tf.setBounds(111, 101, 167, 26);
			tf.setColumns(10);
		}
		return tf;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("검색");
			btnNewButton.setBounds(280, 101, 88, 29);
		}
		return btnNewButton;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"상품명", "상품id"}));
			comboBox.setBounds(18, 102, 91, 27);
		}
		return comboBox;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(18, 141, 354, 341);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
		}
		return innerTable;
	}
	private JLabel getLblProductId() {
		if (lblProductId == null) {
			lblProductId = new JLabel("");
			lblProductId.setBounds(40, 514, 270, 21);
			lblProductId.setIcon(new ImageIcon(Kms_AdminProduct.class.getResource("/com/javalec/image/prodcuctID.png")));
		}
		return lblProductId;
	}
	private JLabel getLblProductName() {
		if (lblProductName == null) {
			lblProductName = new JLabel("");
			lblProductName.setBounds(40, 564, 270, 21);
			lblProductName.setIcon(new ImageIcon(Kms_AdminProduct.class.getResource("/com/javalec/image/productName.png")));
		}
		return lblProductName;
	}
	private JLabel getLblProductPrice() {
		if (lblProductPrice == null) {
			lblProductPrice = new JLabel("");
			lblProductPrice.setBounds(40, 614, 270, 21);
			lblProductPrice.setIcon(new ImageIcon(Kms_AdminProduct.class.getResource("/com/javalec/image/productPrice.png")));
		}
		return lblProductPrice;
	}
	private JLabel getLblProductQty() {
		if (lblProductQty == null) {
			lblProductQty = new JLabel("");
			lblProductQty.setBounds(40, 664, 270, 21);
			lblProductQty.setIcon(new ImageIcon(Kms_AdminProduct.class.getResource("/com/javalec/image/productQty.png")));
		}
		return lblProductQty;
	}
	private JTextField getTfProductId() {
		if (tfProductId == null) {
			tfProductId = new JTextField();
			tfProductId.setBounds(111, 509, 130, 26);
			tfProductId.setColumns(10);
			tfProductId.setBackground(new Color(248, 227, 182));
		}
		return tfProductId;
	}
	private JTextField getTfProductName() {
		if (tfProductName == null) {
			tfProductName = new JTextField();
			tfProductName.setColumns(10);
			tfProductName.setBounds(111, 559, 130, 26);
			tfProductName.setBackground(new Color(248, 227, 182));
		}
		return tfProductName;
	}
	private JTextField getTfProductPrice() {
		if (tfProductPrice == null) {
			tfProductPrice = new JTextField();
			tfProductPrice.setColumns(10);
			tfProductPrice.setBounds(111, 609, 130, 26);
			tfProductPrice.setBackground(new Color(248, 227, 182));
		}
		return tfProductPrice;
	}
	private JTextField getTfProductQty() {
		if (tfProductQty == null) {
			tfProductQty = new JTextField();
			tfProductQty.setColumns(10);
			tfProductQty.setBounds(111, 659, 130, 26);
			tfProductQty.setBackground(new Color(248, 227, 182));
		}
		return tfProductQty;
	}
}
