package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.javalec.dao.DaoCoupon_kwh;
import com.javalec.util.ShareVar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Lucky1_kwh extends JDialog {
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnGet;
	 
	
	
	private final int[] couponNames = {5,6,7,8,9};   // 쿠폰할인 퍼센트
	
	 
	 
	 private JLabel lblDiscount;
	 private JLabel lblMessage;
	 private JLabel lblPresent;
	 private JLabel lblFirecracker;
	 String message = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lucky1_kwh dialog = new Lucky1_kwh();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Lucky1_kwh() {
		getContentPane().setBackground(new Color(248, 227, 182));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setLocationRelativeTo(null);  // jframe이 화면에 중앙에 위치하도록 하기 
				btnGet.setText("Click!");
				deleteDate();
				
			}
		});
		setBounds(100, 100, 390, 390);		
		setTitle("It's for YOU !!!");

		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getBtnGet1());
		getContentPane().add(getLblDiscount());
		getContentPane().add(getLblMessage());
		getContentPane().add(getLblPresent());
		getContentPane().add(getLblFirecracker());

	}
	
	
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("오늘의 행운 ");
			lblNewLabel.setFont(new Font("Academy Engraved LET", Font.PLAIN, 40));
			lblNewLabel.setBounds(95, 6, 260, 75);
		}
		return lblNewLabel;
	}
	private JButton getBtnGet1() {
		if (btnGet == null) {
			btnGet = new JButton("Get");
			btnGet.addActionListener(new ActionListener() {
				private CouponDisplayThread couponDisplayThread;

				
				public void actionPerformed(ActionEvent e) {
					btnGet.setText("Get!");
					insertAction();
					
					
					if (couponDisplayThread == null || !couponDisplayThread.isAlive()) {
	                    couponDisplayThread = new CouponDisplayThread(lblDiscount, couponNames);
	                    couponDisplayThread.start();
	                } else {
	                    couponDisplayThread.setStopFlag(true);
	                }
	            }
	        });
	        btnGet.setBounds(269, 307, 117, 29);
	    }
	    return btnGet;
	}
	
	private JLabel getLblPresent() {
		if (lblPresent == null) {
			lblPresent = new JLabel("");
			lblPresent.setIcon(new ImageIcon(Lucky1_kwh.class.getResource("/com/javalec/image/present.png")));
			lblPresent.setBounds(126, 83, 205, 181);
		}
		return lblPresent;
	}
	private JLabel getLblFirecracker() {
		if (lblFirecracker == null) {
			lblFirecracker = new JLabel("");
			lblFirecracker.setIcon(new ImageIcon(Lucky1_kwh.class.getResource("/com/javalec/image/firecracker.png")));
			lblFirecracker.setBounds(315, 6, 60, 55);
		}
		return lblFirecracker;
	}

	
	private JLabel getLblDiscount() {
		if (lblDiscount == null) {
			lblDiscount = new JLabel("");
			lblDiscount.setBounds(170, 314, 57, 15);
		}
		return lblDiscount;
	}
	private JLabel getLblMessage() {
		if (lblMessage == null) {
			lblMessage = new JLabel("% 할인쿠폰!");
			lblMessage.setBounds(188, 314, 81, 15);
		}
		return lblMessage;
	}
	
	private static class CouponDisplayThread extends Thread {
		private JLabel lblDiscount;
		private final int[] couponNames;
	    private boolean stopFlag;

	    public CouponDisplayThread(JLabel lblDiscount, int[] couponNames) {
	        this.lblDiscount = lblDiscount;
	        this.couponNames = couponNames;
	        this.stopFlag = false;
	    }

	   
	    
	    
	 // function
	    
	    
	    
	    
	    
	    
	    
	    
	    public void run() {
	        int i = 0;
	        
	        while (!stopFlag) {
	            int couponName = couponNames[i];     // couponName이 int라서 이거 받으시면 될 것 같습니다.
	            lblDiscount.setText(Integer.toString(couponName));
	            i = (i + 1) % couponNames.length;
	            try {
	                Thread.sleep(100);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public void setStopFlag(boolean stopFlag) {
	        this.stopFlag = stopFlag;
	    }
	}


		
	
	
	
	
	
	
	
		// 쿠폰등록
		public void insertAction() {
			String customer_cid = ShareVar.testid;
			
			int discount = 0;
			try {
			   discount = Integer.parseInt(lblDiscount.getText());
			} catch (NumberFormatException ex) {
			    // 오류 처리
			}
			
			// 자바유틸데이트로 현재시각을 받아서 자바sql데이트에 넣어야함
			java.util.Date now = new java.util.Date();
			java.sql.Date cpinsertdate = new java.sql.Date(now.getTime());
			
			
			if(!lblDiscount.getText().equals("")) {
			
			DaoCoupon_kwh dao = new DaoCoupon_kwh(discount, customer_cid, cpinsertdate);
			boolean result = dao.insertAction(); 
			
			if (result) {
				message = Integer.toString(discount)+"%할인" ;
				
				dispose();
				JOptionPane.showMessageDialog(this,  message+"쿠폰이 등록되었습니다.", "Congratulation!!",JOptionPane.INFORMATION_MESSAGE); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
			}else {
				JOptionPane.showMessageDialog(this,  "쿠폰 등록이 실패했습니다.", "Error",JOptionPane.ERROR_MESSAGE); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
			}
			
			}
		}

		
		private void deleteDate() {
			DaoCoupon_kwh dao = new DaoCoupon_kwh();
			dao.deleteAction();
		}









}
