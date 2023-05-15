package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


import com.javalec.dao.DaoReview_kwh;
import com.javalec.util.ShareVar;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.util.Calendar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Review_kwh extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnHome;
	private JButton btnMenu;
	private JButton btnOrder;
	private JButton btnReview;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JTextField tfTitle;
	private JTextField tfComment;
	private JButton btnPlus;
	private JButton btnPost;
	private JButton btnCancel;
	private JLabel lblImage;
	private JTextField tfFilePath;
	private JLabel lblClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Review_kwh frame = new Review_kwh();
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
	public Review_kwh() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tfFilePath.setVisible(false);
				setLocationRelativeTo(null);  // jframe이 화면에 중앙에 위치하도록 하기 
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
		contentPane.add(getTfTitle());
		contentPane.add(getTfComment());
		contentPane.add(getBtnPlus());
		contentPane.add(getBtnPost());
		contentPane.add(getBtnCancel());
		contentPane.add(getLblImage());
		contentPane.add(getTfFilePath());
		contentPane.add(getLblClock());
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
			btnHome.setBackground(new Color(131, 77, 30));
			btnHome.setIcon(new ImageIcon(Review_kwh.class.getResource("/com/javalec/image/btnHome.png")));
			btnHome.setFocusPainted(false);					// 버튼 포커스라인 없애기
			btnHome.setBorderPainted(false);
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					home();
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
					menu();
				}
			});
			btnMenu.setIcon(new ImageIcon(Review_kwh.class.getResource("/com/javalec/image/btnMenu.png")));
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
					order();
				}
			});
			btnOrder.setBackground(new Color(131, 77, 30));
			btnOrder.setIcon(new ImageIcon(Review_kwh.class.getResource("/com/javalec/image/btnOrder.png")));
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
					review();
				}
			});
			btnReview.setBackground(new Color(131, 77, 30));
			btnReview.setIcon(new ImageIcon(Review_kwh.class.getResource("/com/javalec/image/btnReview.png")));
			btnReview.setFocusPainted(false);
			btnReview.setBorderPainted(false);
		}
		return btnReview;
	}
	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Lju_base.class.getResource("/com/javalec/image/wifi.png")));
			lblNewLabel_1.setBounds(303, 15, 65, 18);
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
	private JTextField getTfTitle() {
		if (tfTitle == null) {
			tfTitle = new JTextField();
			tfTitle.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tfTitle.setText("");
				}
			});
			tfTitle.setText("title");
			tfTitle.setBounds(16, 144, 358, 56);
			tfTitle.setColumns(10);
			
		}
		return tfTitle;
	}
	private JTextField getTfComment() {
		if (tfComment == null) {
			tfComment = new JTextField();
			tfComment.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tfComment.setText("");
				}
			});
			tfComment.setText("comment");
			tfComment.setBounds(16, 216, 358, 224);
			tfComment.setColumns(10);
		}
		return tfComment;
	}
	private JButton getBtnPlus() {
		if (btnPlus == null) {
			btnPlus = new JButton("+");
			btnPlus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					filePath();
					
				}
			});
			btnPlus.setBackground(new Color(248, 227, 182));
			btnPlus.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			btnPlus.setBounds(16, 456, 358, 72);
		}
		return btnPlus;
	}
	private JButton getBtnPost() {
		if (btnPost == null) {
			btnPost = new JButton("post");
			btnPost.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					postAction();  
					
				}
			});
			btnPost.setForeground(Color.BLACK);
			btnPost.setBackground(Color.YELLOW);
			btnPost.setBounds(267, 671, 117, 29);
		}
		return btnPost;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cancelAction();
				}
			});
			btnCancel.setBackground(Color.YELLOW);
			btnCancel.setBounds(6, 671, 117, 29);
		}
		return btnCancel;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setBounds(18, 540, 110, 100);
			ImageIcon imgicon = new ImageIcon(Review_kwh.class.getResource("/com/javalec/image/imagelabel.png"));  // 라벨에 기본이미지넣어두기
			Image img = imgicon.getImage();  // 이미지 크기조절
			Image updateImg = img.getScaledInstance(110,100, Image.SCALE_SMOOTH);
			ImageIcon upImg = new ImageIcon(updateImg);
			lblImage.setIcon(upImg);
		}
		return lblImage;
	}

	
	private JTextField getTfFilePath() {
		if (tfFilePath == null) {
			tfFilePath = new JTextField();
			tfFilePath.setBounds(238, 562, 130, 26);
			tfFilePath.setColumns(10);
		}
		return tfFilePath;
	}
	



	// function
	


	// postAction  리뷰등록
	private void postAction() {   // insert 
	
		String item_iid  = ShareVar.testitem;/// sharevar에서 넘어와야함
		String customer_cid = ShareVar.testid;
		String title = tfTitle.getText();
		String comment = tfComment.getText();
		String imagename = "image";
		
		// 자바유틸데이트로 현재시각을 받아서 자바sql데이트에 넣어야함
		java.util.Date now = new java.util.Date();
		java.sql.Date rinsertdate = new java.sql.Date(now.getTime());
		

		
		// Image File
		FileInputStream input = null;    // inputstream 은 insert 
		
	
		File file = new File(tfFilePath.getText());   // 이미지에서 헤드를 분리하는 작업 헤드 / 데이터
		try {
			input = new FileInputStream(file);
		}catch(Exception e){
			e.printStackTrace();
			
			
		}
		
		boolean check = true;
		if (title.equals("") || title.equals("") || comment.equals("") || comment.equals("comment")) {
			check=false;
		}
			
		if(check) {	
		DaoReview_kwh dao = new DaoReview_kwh(item_iid, customer_cid, title, comment, imagename, rinsertdate, input);
				
		boolean result = dao.postAction(); 
			if (result) {
				JOptionPane.showMessageDialog(this,  "리뷰가 등록되었습니다.", "Review",JOptionPane.INFORMATION_MESSAGE); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
			}else {
				JOptionPane.showMessageDialog(this,  "리뷰 등록이 실패했습니다.", "경고",JOptionPane.ERROR_MESSAGE); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
			}
		}else {
			JOptionPane.showMessageDialog(this, "리뷰를 작성해주세요.");
		}
			
	}
	
	

	
	
	// 등록취소
	private void cancelAction() {
		//전페이지로 돌아가기
	}
	

	private void filePath() {   // file loading method
		
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg","png","bmp");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(this, "파일을 선택하지 않았습니다.", "경고",JOptionPane.ERROR_MESSAGE);
			
			return;
		}
		
		String filePath = chooser.getSelectedFile().getPath();
		tfFilePath.setText(filePath);
		
		
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		
	}
	private JLabel getLblClock() {
		if (lblClock == null) {
			lblClock = new JLabel("");
			lblClock.setFont(new Font("Malayalam Sangam MN", Font.BOLD, 15));
			lblClock.setBounds(36, 15, 80, 16);
			clockRun();
		}
		return lblClock;
	}
	
	private void clockRun() {
	    javax.swing.Timer timer = new javax.swing.Timer(100, new ActionListener() {	//1초마다 갱신
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Calendar t = Calendar.getInstance();
				int hour = t.get(Calendar.HOUR);
	            int min = t.get(Calendar.MINUTE);
	            int second = t.get(Calendar.SECOND);
	            String clock = String.format("%02d : %02d : %02d" , hour, min,second);	// 시간을 01:02로표시 원래 1시:2분 이런식
	            lblClock.setText(clock);
			}
		});	 
	    timer.start();
	}

	
	private void home() {
		Jty_Home hi = new Jty_Home();
		hi.setVisible(true);
		dispose();
	}
	
	private void menu() {
		Lju_MenuCoffee hi =new Lju_MenuCoffee();
		hi.setVisible(true);
		dispose();
	}
	
	private void order() {
		Lju_PurchaseHistory hi =new Lju_PurchaseHistory();
		hi.setVisible(true);
		dispose();
	}
	
	private void review() {
		Review2_kwh hi = new Review2_kwh();
		hi.setVisible(true);
		dispose();
	}
}
	



