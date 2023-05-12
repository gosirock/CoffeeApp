package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Lucky1_kwh extends JDialog {
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JButton btnGet;
	 private final String[] couponNames = {
	            "5% 할인쿠폰", 
	            "6%할인쿠폰", 
	            "7%할인쿠폰", 
	            "8%할인쿠폰", 
	            "9%할인쿠폰", 
	            "10%할인쿠폰"
	    };
	 private JLabel lblNewLabel_3;
	 private JLabel lblNewLabel_4;
	 private JLabel lblNewLabel_5;
	 private JTextField textField_1;
	 private JButton btnGet1;

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
				btnGet.setText("Click!");
			}
		});
		setBounds(100, 100, 471, 420);		
		setTitle("It's for YOU !!!");

		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getLblNewLabel_5());
		getContentPane().add(getTextField_1());
		getContentPane().add(getBtnGet1());

	}
	
	
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("오늘의 행운 ");
			lblNewLabel.setFont(new Font("Academy Engraved LET", Font.PLAIN, 40));
			lblNewLabel.setBounds(95, 6, 260, 75);
		}
		return lblNewLabel;
	}

	
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("/Volumes/Data/wook/java/Gift/src/com/javalec/images/pok.png"));
			lblNewLabel_1.setBounds(315, 6, 60, 55);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon("/Volumes/Data/wook/java/Gift/src/com/javalec/images/present.png"));
			lblNewLabel_2.setBounds(126, 83, 205, 181);
		}
		return lblNewLabel_2;
	}
	
	private JTextField getTextField_1() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(126, 307, 130, 26);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnGet1() {
		if (btnGet == null) {
			btnGet = new JButton("Get");
			btnGet.addActionListener(new ActionListener() {
				private CouponDisplayThread couponDisplayThread;

				
				public void actionPerformed(ActionEvent e) {
					btnGet.setText("Get!");
					
					if (couponDisplayThread == null || !couponDisplayThread.isAlive()) {
	                    couponDisplayThread = new CouponDisplayThread(textField, couponNames);
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
	
	private static class CouponDisplayThread extends Thread {
	    private final JTextField textField;
	    private final String[] couponNames;
	    private boolean stopFlag;

	    public CouponDisplayThread(JTextField textField, String[] couponNames) {
	        this.textField = textField;
	        this.couponNames = couponNames;
	        this.stopFlag = false;
	    }

	    public void run() {
	        int i = 0;
	        while (!stopFlag) {
	            String couponName = couponNames[i];
	            textField.setText(couponName);
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
	
}
