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
public class Lju_Payment extends JFrame implements ActionListener {	// 엔터키 액션넣기

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	
	
	
	private final DefaultTableModel outerTable = new DefaultTableModel();
	ArrayList<Lju_dto> dtoList = null;
	
	DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	private JLabel lblClock;
	private JButton btnNewButton;
	
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
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getLblClock());
		contentPane.add(getBtnNewButton());

	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Lju_Payment.class.getResource("/com/javalec/image/wifi.png")));
			lblNewLabel_1.setBounds(303, 15, 65, 18);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(Lju_Payment.class.getResource("/com/javalec/image/options.png")));
			lblNewLabel_4.setBounds(35, 187, 321, 32);
		}
		return lblNewLabel_4;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton.addMouseListener(new MouseAdapter() {
				
				 //장바구니로 이동 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			btnNewButton.setIcon(new ImageIcon(Lju_Payment.class.getResource("/com/javalec/image/icon _cart_.png")));
			btnNewButton.setFocusPainted(false);
			btnNewButton.setBorderPainted(false);
			btnNewButton.setBounds(303, 50, 70, 40);
		}
		return btnNewButton;
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
		
		// 컬럼크기 정하기
		
		int vColIndex = 0;
		int width = 150;	// 첫번째 컬럼 폭
		col.setPreferredWidth(width);
		vColIndex = 1;
		width = 230;	// 첫번째 컬럼 폭
		col.setPreferredWidth(width);
		vColIndex = 2;
		width = 1;		// 세번째 컬럼 폭정하기
		col.setPreferredWidth(width);

	}
	// 커피메뉴 테이블 채우기 iid가 a인것만
	private void searchAction() {
		
		dtoList = new ArrayList<Lju_dto>();
		Lju_Dao_Menu_Coffee daoLju_dao = new Lju_Dao_Menu_Coffee();
		dtoList = daoLju_dao.Linst();
		
		int listCount = dtoList.size();
		
		
		
		for(int i = 0; i< listCount; i++) {
			
			String price = Integer.toString(dtoList.get(i).getIprice());
			
			
			ImageIcon imgicon = new ImageIcon("./" + dtoList.get(i).getIimagename());
			Image img = imgicon.getImage();
			
			Image updateImg = img.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
			ImageIcon upImg = new ImageIcon(updateImg);
			
			Object[] qTxt = {upImg, "<html>"+dtoList.get(i).getIname()+"<br><br>" + dtoList.get(i).getIdescription()+"<p><p>" + price+"</html>",dtoList.get(i).getIid()};
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
	    }
	
	 
	 // 검색기능 커피매뉴만 iid 가 a 들어간것
	 private void SearchAction() {
		 tableInit();
		 Lju_Dao_Menu_Coffee dao = new Lju_Dao_Menu_Coffee(txtSearch.getText());
		 ArrayList<Lju_dto> dtoList = dao.SearchAction();
		 int listCount = dtoList.size();
			
			
			for(int i = 0; i< listCount; i++) {
				
				String price = Integer.toString(dtoList.get(i).getIprice());
				
				
				ImageIcon imgicon = new ImageIcon("./" + dtoList.get(i).getIimagename());
				Image img = imgicon.getImage();
				
				Image updateImg = img.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
				ImageIcon upImg = new ImageIcon(updateImg);
				
				Object[] qTxt = {upImg, "<html>"+dtoList.get(i).getIname()+"<br><br>" + dtoList.get(i).getIdescription()+"<p><p>" + price+"</html>", dtoList.get(i).getIid()};
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
	
	
	




private void Run() {
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


}