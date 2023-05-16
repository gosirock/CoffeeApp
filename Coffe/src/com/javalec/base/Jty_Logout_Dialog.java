package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.BevelBorder;

public class Jty_Logout_Dialog extends JDialog {
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */

	private void diaclose() {
		this.setVisible(false);
		this.dispose();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jty_Logout_Dialog dialog = new Jty_Logout_Dialog();
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
	public Jty_Logout_Dialog() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setLocationRelativeTo(null);
			}
		});
		getContentPane().setBackground(new Color(248, 227, 182));
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		setTitle("로그아웃");
		setBounds(120, 500, 352, 279);

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("정말로 로그아웃 하시겠습니까?");
			lblNewLabel.setForeground(new Color(131, 77, 30));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
			lblNewLabel.setBounds(12, 65, 314, 34);
		}
		return lblNewLabel;
	}

	private JButton getBtnNewButton() {
	    if (btnNewButton == null) {
	        btnNewButton = new JButton("예");
	        btnNewButton.setOpaque(true);
	        btnNewButton.setBorder(null);
	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Hsh_start hsh_start = new Hsh_start();
	                hsh_start.setVisible(true);
	               // dialog.dispose(); // 다이얼로그 닫기
	                dispose(); // 프로필 창 닫기
	            }

			});

			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(131, 77, 30));
			btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			btnNewButton.setBounds(48, 173, 91, 23);
		}
		return btnNewButton;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("아니오");
			btnNewButton_1.setOpaque(true);
			btnNewButton_1.setBorder(null); // 텍스트 필드의 테두리를 없앰
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton_1.setForeground(new Color(255, 255, 255));
			btnNewButton_1.setBackground(new Color(131, 77, 30));
			btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			btnNewButton_1.setBounds(196, 173, 91, 23);
		}
		return btnNewButton_1;
	}
}
