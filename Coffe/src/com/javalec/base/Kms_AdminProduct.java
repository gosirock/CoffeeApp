package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.Kms_Dao_AdminProduct;
import com.javalec.dto.Kms_Dto_AdminProduct;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class Kms_AdminProduct extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JLabel lblAdminProduct;
	private JRadioButton rbSearch;
	private JRadioButton rbInsert;
	private JRadioButton rbUpdate;
	private JRadioButton rbDelete;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfSelection;
	private JButton btnNewButton;
	private JComboBox cbSelection;
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
	private final DefaultTableModel outerTable = new DefaultTableModel();
	private JLabel lblDescription;
	private JLabel lblFileName;
	private JTextField tfFileName;
	private JTextField tfDescription;
	private JButton btnOK;
	private JLabel lblImage;
	String message = "";

	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	private JButton btnFilePath;
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();  // 테이블초기화
				searchAction();  // 데이터불러오기
				screenPartition(); //  radiobtn 이 눌러진 상태로 textfield 화면표시해주기
			}
		});
		setTitle("관리자모드");
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
		contentPane.add(getTfSelection());
		contentPane.add(getBtnNewButton());
		contentPane.add(getCbSelection());
//		contentPane.add(getScrollPane());
		contentPane.add(getLblProductId());
		contentPane.add(getLblProductName());
		contentPane.add(getLblProductPrice());
		contentPane.add(getLblProductQty());
		contentPane.add(getTfProductId());
		contentPane.add(getTfProductName());
		contentPane.add(getTfProductPrice());
		contentPane.add(getTfProductQty());
		contentPane.add(getLblDescription());
		contentPane.add(getLblFileName());
		contentPane.add(getTfFileName());
		contentPane.add(getTfDescription());
		contentPane.add(getBtnOK());
		contentPane.add(getLblImage());
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(18, 141, 354, 251);
		contentPane.add(scrollPane);
		
		innerTable = new JTable();
		innerTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnOK.setEnabled(true);  // 테이블누를때 클릭실행가능
				tableClick();
			}
		});
		scrollPane.setViewportView(innerTable);
		innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		innerTable.setModel(outerTable);
		contentPane.add(getBtnFilePath());
		
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
			rbSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenPartition();
				}
			});
			rbSearch.setSelected(true);
			buttonGroup.add(rbSearch);
			rbSearch.setBounds(18, 66, 65, 23);
		}
		return rbSearch;
	}
	private JRadioButton getRbInsert() {
		if (rbInsert == null) {
			rbInsert = new JRadioButton("입력");
			rbInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenPartition();
				}
			});
			buttonGroup.add(rbInsert);
			rbInsert.setBounds(111, 66, 65, 23);
		}
		return rbInsert;
	}
	private JRadioButton getRbUpdate() {
		if (rbUpdate == null) {
			rbUpdate = new JRadioButton("수정");
			rbUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenPartition();
				}
			});
			buttonGroup.add(rbUpdate);
			rbUpdate.setBounds(204, 66, 65, 23);
		}
		return rbUpdate;
	}
	private JRadioButton getRbDelete() {
		if (rbDelete == null) {
			rbDelete = new JRadioButton("삭제");
			rbDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenPartition();
				}
			});
			buttonGroup.add(rbDelete);
			rbDelete.setBounds(297, 66, 65, 23);
		}
		return rbDelete;
	}
	private JTextField getTfSelection() {
		if (tfSelection == null) {
			tfSelection = new JTextField();
			tfSelection.setBounds(111, 101, 167, 26);
			tfSelection.setColumns(10);
		}
		return tfSelection;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("검색");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionQuery();
				}
			});
			btnNewButton.setBounds(280, 101, 88, 29);
		}
		return btnNewButton;
	}
	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.setModel(new DefaultComboBoxModel(new String[] {"상품명", "상품id"}));
			cbSelection.setBounds(18, 102, 91, 27);
		}
		return cbSelection;
	}

	private JLabel getLblProductId() {
		if (lblProductId == null) {
			lblProductId = new JLabel("");
			lblProductId.setBounds(31, 425, 270, 21);
			lblProductId.setIcon(new ImageIcon(Kms_AdminProduct.class.getResource("/com/javalec/image/prodcuctID.png")));
		}
		return lblProductId;
	}
	private JLabel getLblProductName() {
		if (lblProductName == null) {
			lblProductName = new JLabel("");
			lblProductName.setBounds(31, 475, 270, 21);
			lblProductName.setIcon(new ImageIcon(Kms_AdminProduct.class.getResource("/com/javalec/image/productName.png")));
		}
		return lblProductName;
	}
	private JLabel getLblProductPrice() {
		if (lblProductPrice == null) {
			lblProductPrice = new JLabel("");
			lblProductPrice.setBounds(31, 525, 270, 21);
			lblProductPrice.setIcon(new ImageIcon(Kms_AdminProduct.class.getResource("/com/javalec/image/productPrice.png")));
		}
		return lblProductPrice;
	}
	private JLabel getLblProductQty() {
		if (lblProductQty == null) {
			lblProductQty = new JLabel("");
			lblProductQty.setBounds(31, 575, 270, 21);
			lblProductQty.setIcon(new ImageIcon(Kms_AdminProduct.class.getResource("/com/javalec/image/productQty.png")));
		}
		return lblProductQty;
	}
	private JTextField getTfProductId() {
		if (tfProductId == null) {
			tfProductId = new JTextField();
			tfProductId.setBounds(111, 420, 130, 26);
			tfProductId.setColumns(10);
			tfProductId.setBackground(new Color(248, 227, 182));
		}
		return tfProductId;
	}
	private JTextField getTfProductName() {
		if (tfProductName == null) {
			tfProductName = new JTextField();
			tfProductName.setColumns(10);
			tfProductName.setBounds(111, 470, 130, 26);
			tfProductName.setBackground(new Color(248, 227, 182));
		}
		return tfProductName;
	}
	private JTextField getTfProductPrice() {
		if (tfProductPrice == null) {
			tfProductPrice = new JTextField();
			tfProductPrice.setColumns(10);
			tfProductPrice.setBounds(111, 520, 130, 26);
			tfProductPrice.setBackground(new Color(248, 227, 182));
		}
		return tfProductPrice;
	}
	private JTextField getTfProductQty() {
		if (tfProductQty == null) {
			tfProductQty = new JTextField();
			tfProductQty.setColumns(10);
			tfProductQty.setBounds(111, 570, 130, 26);
			tfProductQty.setBackground(new Color(248, 227, 182));
		}
		return tfProductQty;
	}
	
	private JLabel getLblFileName() {
		if (lblFileName == null) {
			lblFileName = new JLabel("");
			lblFileName.setBounds(31, 625, 270, 21);
			lblFileName.setIcon(new ImageIcon(Kms_AdminProduct.class.getResource("/com/javalec/image/fileName.png")));
		}
		return lblFileName;
	}
	private JLabel getLblDescription() {
		if (lblDescription == null) {
			lblDescription = new JLabel("");
			lblDescription.setBounds(31, 675, 270, 21);
			lblDescription.setIcon(new ImageIcon(Kms_AdminProduct.class.getResource("/com/javalec/image/description.png")));
		}
		return lblDescription;
	}
	private JTextField getTfFileName() {
		if (tfFileName == null) {
			tfFileName = new JTextField();
			tfFileName.setColumns(10);
			tfFileName.setBackground(new Color(248, 227, 182));
			tfFileName.setBounds(111, 620, 130, 26);
		}
		return tfFileName;
	}
	private JTextField getTfDescription() {
		if (tfDescription == null) {
			tfDescription = new JTextField();
			tfDescription.setColumns(10);
			tfDescription.setBackground(new Color(248, 227, 182));
			tfDescription.setBounds(111, 670, 180, 26);
		}
		return tfDescription;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPartition();
				}
			});
			btnOK.setBounds(251, 791, 117, 29);
			btnOK.setIcon(new ImageIcon(Kms_AdminProduct.class.getResource("/com/javalec/image/btnOK.png")));
			btnOK.setFocusPainted(false);
			btnOK.setBorderPainted(false);
		}
		return btnOK;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setBounds(31, 708, 117, 112);
		}
		return lblImage;
	}
	private JButton getBtnFilePath() {
		if (btnFilePath == null) {
			btnFilePath = new JButton("load");
			btnFilePath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filePath();
				}
			});
			btnFilePath.setBounds(280, 617, 88, 29);
		}
		return btnFilePath;
	}
	
	// ----- function ------
	
private void tableClick() {  //
		
		if(rbUpdate.isSelected()) {
			tfProductId.setEditable(false);
			tfProductName.setEditable(true);
			tfProductPrice.setEditable(true);
			tfProductQty.setEditable(true);
			tfFileName.setEditable(false);
			btnOK.setVisible(true);
			btnOK.setEnabled(true);
			btnFilePath.setVisible(true);
		}
		
		
		if(rbDelete.isSelected()) {
			tfProductId.setEditable(false);
			tfProductName.setEditable(false);
			tfProductPrice.setEditable(false);
			tfProductQty.setEditable(false);
			tfFileName.setEditable(false);
			btnOK.setVisible(true);
			btnOK.setEnabled(true);
			btnFilePath.setVisible(true);
		}
		
		if (rbInsert.isSelected()) {
			tfProductId.setEditable(true);
			tfProductName.setEditable(true);
			tfProductPrice.setEditable(true);
			tfProductQty.setEditable(true);
			tfFileName.setEditable(false);
			btnOK.setVisible(true);
			btnOK.setEnabled(true);
			btnFilePath.setVisible(true);
		}
		
		int i = innerTable.getSelectedRow();
		String wkSequence = (String) innerTable.getValueAt(i, 0);
//		int wkSeqno = Integer.parseInt(wkSequence);
		
		// Dao 에 의뢰한다.
		Kms_Dao_AdminProduct dao = new Kms_Dao_AdminProduct(wkSequence);
		Kms_Dto_AdminProduct dto = dao.tableclick();
		
		tfProductId.setText(dto.getIid());
		tfProductName.setText(dto.getIname());
		tfProductPrice.setText(Integer.toString(dto.getIprice()));
		tfProductQty.setText(Integer.toString(dto.getIstock()));
		tfFileName.setText(dto.getIimagename());
		tfDescription.setText(dto.getIdescription());
		
		
		// Image 처리
		String filePath = dto.getIimagename();
		
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);  // label의 중앙에 파일 위치
		
		// 이미지 크기조절
		//String filePath = dto.getPimagename();
		ImageIcon imgicon = new ImageIcon(filePath);
		Image img = imgicon.getImage();
		
		Image updateImg = img.getScaledInstance(150,150, Image.SCALE_SMOOTH);
		lblImage.setIcon(new ImageIcon(updateImg));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		File file = new File(filePath);
		file.delete();
		
		
	}
	
	private void tableInit() {
		outerTable.addColumn("상품 ID");
		outerTable.addColumn("상품명");
		outerTable.addColumn("재고");
		outerTable.addColumn("가격");
		outerTable.addColumn("설명");
		outerTable.setColumnCount(5);
		
		int i = outerTable.getRowCount();
		for(int j = 0 ; j < i ; j++) {
			outerTable.removeRow(0);
		}
		
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
		
		int vColIndex = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
		int width = 40;
		col.setPreferredWidth(width);
		
		vColIndex = 1;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 40;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 40;
		col.setPreferredWidth(width);
		
		vColIndex = 4;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);
	}
	
	private void searchAction() {
		Kms_Dao_AdminProduct dao = new Kms_Dao_AdminProduct();
		//dao.selectList();   // Dao 에서 return 을 준다  받아야함
		ArrayList<Kms_Dto_AdminProduct> dtoList = dao.selectList();  // 받아야 하므로 Dto type의 dtoList를 변수로 받는다
		int listCount = dtoList.size();
		
		for( int i = 0; i < listCount ; i++) {
			String temp = dtoList.get(i).getIid();
			String[] qTxt = {temp, dtoList.get(i).getIname(), Integer.toString(dtoList.get(i).getIstock()), Integer.toString(dtoList.get(i).getIprice()),dtoList.get(i).getIdescription()};
			outerTable.addRow(qTxt);  // 화면에 데이터 넣어주기
			
		}
		
	}
	private void screenPartition() {
		
		// 검색의 경우
		if (rbSearch.isSelected()) {
			tfProductId.setEditable(false);
			tfProductName.setEditable(false);
			tfProductPrice.setEditable(false);
			tfProductQty.setEditable(false);
			tfFileName.setEditable(false);
			tfDescription.setEditable(false);
			btnOK.setVisible(false);
			btnOK.setEnabled(false);
			btnFilePath.setVisible(false);
		}

		// 입력의 경우
		
		if (rbInsert.isSelected()) {
			tfProductId.setEditable(true);
			tfProductName.setEditable(true);
			tfProductPrice.setEditable(true);
			tfProductQty.setEditable(true);
			tfFileName.setEditable(true);
			tfDescription.setEditable(true);
			btnOK.setVisible(true);
			btnOK.setEnabled(true);
			btnFilePath.setVisible(true);
			
		}
		
		// 수정의 경우
		if 	(rbUpdate.isSelected()) {
			tfProductId.setEditable(false);
			tfProductName.setEditable(false);
			tfProductPrice.setEditable(false);
			tfProductQty.setEditable(false);
			tfFileName.setEditable(false);
			tfDescription.setEditable(false);
			btnOK.setVisible(true);
			btnOK.setEnabled(false);
			btnFilePath.setVisible(false);
		}
		
		// 삭제의 경우
		if 	(rbDelete.isSelected() ) {
			tfProductId.setEditable(false);
			tfProductName.setEditable(false);
			tfProductPrice.setEditable(false);
			tfProductQty.setEditable(false);
			tfFileName.setEditable(false);
			tfDescription.setEditable(false);
			btnOK.setVisible(false);
			btnOK.setEnabled(false);
			btnFilePath.setVisible(false);
			
			
		}
		

	}
	
	private void actionPartition() {
		// 입력의 경우 OK 버튼을 눌렀을 때
		if (rbInsert.isSelected()) {
			int i_chk = insertFieldCheck();
			if (i_chk == 0) {
				insertAction();
				tableInit();
				searchAction();
				clearColumn();
				
			}else {
				JOptionPane.showMessageDialog(this, "\n"+message+ "입력하세요!", "",JOptionPane.INFORMATION_MESSAGE); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
			} 
		}
		
		// 수정의 경우 OK 버튼을 눌렀을 때
		if (rbUpdate.isSelected()) {
			int i_chk = insertFieldCheck();
			if (i_chk == 0) {
				updateAction();
				tableInit();
				searchAction();
				clearColumn();
				
			}else {
			JOptionPane.showMessageDialog(this, "\n"+message+ "입력하세요!", "",JOptionPane.INFORMATION_MESSAGE); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
			} 
		}
		// 삭제의 경우 OK 버튼을 눌렀을때
		if (rbDelete.isSelected()) {
			int i_chk = insertFieldCheck();
			if (i_chk == 0) {
				deleteAction();
				tableInit();
				searchAction();
				clearColumn();
				
			}else {
				JOptionPane.showMessageDialog(this, "\n"+message+ "입력하세요!", "",JOptionPane.INFORMATION_MESSAGE); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
			} 
		}
		
		
	}
	
	private int insertFieldCheck() {
		int i = 0;
		
		
		if(tfProductId.getText().trim().length() == 0) {
			i++;
			message = "상품ID를 ";
			tfProductId.requestFocus();  // 어디 자리가 비었는지 커서로 보여
		}
		if(tfProductName.getText().trim().length() == 0) {
			i++;
			message = "상품명을 ";
			tfProductName.requestFocus();
		}
		if(tfProductPrice.getText().trim().length() == 0) {
			i++;
			message = "상품가격을 ";
			tfProductPrice.requestFocus();
		}
		if(tfProductQty.getText().trim().length() == 0) {
			i++;
			message = "재고를 ";
			tfProductQty.requestFocus();
		}
		if(tfFileName.getText().trim().length() == 0) {
			i++;
			message = "파일명을 ";
			tfFileName.requestFocus();
		}
		if(tfDescription.getText().trim().length() == 0) {
			i++;
			message = "설명을 ";
			tfDescription.requestFocus();
		}
		return i;
		
	}
	private void clearColumn() {
		tfProductId.setText("");
		tfProductName.setText("");
		tfProductPrice.setText("");
		tfProductQty.setText("");
		tfFileName.setText("");
		tfDescription.setText("");
		lblImage.setIcon(null);
	}

	private void deleteAction() {
		String id = tfProductId.getText();
		String name = tfProductName.getText();
		int price = Integer.parseInt(tfProductPrice.getText());
		int stock = Integer.parseInt(tfProductQty.getText());
		String description = tfDescription.getText();
		
		Kms_Dao_AdminProduct dao = new Kms_Dao_AdminProduct(id, name,price,stock,description);
		boolean result = dao.deleteAction();
		
		if (result) {
			JOptionPane.showMessageDialog(this, "정보 삭제\n"+tfProductName.getText()+ "의 정보가 삭제되었습니다."); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
		}else {
			JOptionPane.showMessageDialog(this, "정보 삭제\n"+ "삭제 중 문제가 발생했습니다."); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
		}
		
	}
	
	private void updateAction() {
		String id = tfProductId.getText();
		String name = tfProductName.getText();
		int price = Integer.parseInt(tfProductPrice.getText());
		int stock = Integer.parseInt(tfProductQty.getText());
		String description = tfDescription.getText();
		
		Kms_Dao_AdminProduct dao = new Kms_Dao_AdminProduct(id, name, stock, price, description);
		boolean result = dao.updateAction();
		
		if (result) {
			JOptionPane.showMessageDialog(this, "정보 수정\n"+tfProductName.getText()+ " 정보가 수정었습니다."); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
		}else {
			JOptionPane.showMessageDialog(this, "정보 수정\n"+ "수정 중 문제가 발생했습니다."); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
		}
		
	}
	
private void filePath() {   // file loading method
		
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg","png","bmp");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		String filePath = chooser.getSelectedFile().getPath();
		tfFileName.setText(filePath);
		
		
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		
	}
	
	
	
	
	private void conditionQuery() {
		int i = cbSelection.getSelectedIndex();
		String conditionQueryColumn = "";
		switch(i) {
		case 0:
			conditionQueryColumn = "iname";
			break;
		case 1:
			conditionQueryColumn = "iid";
			break;
		default:
			break;
		
	}
		tableInit();
		conditionQueryAction(conditionQueryColumn);
		clearColumn();
	}
	
	private void conditionQueryAction(String conditionQueryColumn) {
		
		Kms_Dao_AdminProduct dao = new Kms_Dao_AdminProduct(conditionQueryColumn, tfSelection.getText()); 
		ArrayList<Kms_Dto_AdminProduct> dtoList = dao.conditionList();
		int listCount = dtoList.size();
		
		for(int i = 0; i < listCount; i++) {
			String price = Integer.toString(dtoList.get(i).getIprice());
			String stock = Integer.toString(dtoList.get(i).getIstock());
			
			String[] qTxt = {dtoList.get(i).getIid(), dtoList.get(i).getIname(), stock,
					price};
			outerTable.addRow(qTxt);
		}

	}
	
	private void insertAction() {
		String id = tfProductId.getText();
		String name = tfProductName.getText();
		int price = Integer.parseInt(tfProductPrice.getText());
		int stock = Integer.parseInt(tfProductQty.getText());
		String imagename = "image";
		String description = tfDescription.getText();
		
		// Image File
		FileInputStream input = null;
		
		File file = new File(tfFileName.getText());
		try {
			input = new FileInputStream(file);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		
		Kms_Dao_AdminProduct dao = new Kms_Dao_AdminProduct(id, name, price, stock, description, input, description);
		boolean result = dao.insertAction(); 
		
		if (result) {
			JOptionPane.showMessageDialog(this, "정보 입력\n"+tfProductName.getText()+ "의 정보가 입력되었습니다."); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
		}else {
			JOptionPane.showMessageDialog(this, "정보 입력\n"+ "입력 중 문제가 발생했습니다."); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
		}
		
	}
}
