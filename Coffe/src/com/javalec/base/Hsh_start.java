package com.javalec.base;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class Hsh_start extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hsh_start frame = new Hsh_start();
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
	public Hsh_start() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				setLocationRelativeTo(null);  // jframe이 화면에 중앙에 위치하도록 하기 
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 872);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblClock());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(-2, -10, 393, 880);
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					click();
				}
			});
			lblNewLabel.setIcon(new ImageIcon(Hsh_start.class.getResource("/com/javalec/image/Group 57.png")));
		}
		return lblNewLabel;
	}
		private void click() {
			Hsh_login login_hsh = new Hsh_login();
			login_hsh.setLocationRelativeTo(null);  // jframe이 화면에 중앙에 위치하도록 하기
			login_hsh.setVisible(true);
			dispose();	
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
	            String clock = String.format("%02d : %02d : %02d" , hour, min);	// 시간을 01:02로표시 원래 1시:2분 이런식
	            lblClock.setText(clock);
			}
		});	 
	    timer.start();
	}

}
