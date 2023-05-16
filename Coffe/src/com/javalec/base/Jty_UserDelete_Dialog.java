package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.javalec.dao.Jty_Dao_Profile;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Jty_UserDelete_Dialog extends JDialog {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JButton btnYes;
	private JButton btnNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jty_UserDelete_Dialog dialog = new Jty_UserDelete_Dialog();
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
	public Jty_UserDelete_Dialog() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setLocationRelativeTo(null);
			}
		});
		getContentPane().setBackground(new Color(248, 227, 182));
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_1_1());
		getContentPane().add(getBtnYes());
		getContentPane().add(getBtnNo());
		setBackground(new Color(248, 227, 182));
		setTitle("회원탈퇴");
		setBounds(120, 500, 352, 279);

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("※ 경고 ※");
			lblNewLabel.setForeground(new Color(255, 0, 0));
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			lblNewLabel.setBounds(120, 27, 86, 27);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("당신이 이대로 떠나시면 우리는 매우 슬퍼할겁니다..");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setForeground(new Color(131, 77, 30));
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_1.setBounds(12, 74, 314, 21);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("그런데도 떠나시겠습니까?");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setForeground(new Color(131, 77, 30));
			lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_1_1.setBounds(22, 105, 304, 21);
		}
		return lblNewLabel_1_1;
	}
	private JButton getBtnYes() {
		if (btnYes == null) {
			btnYes = new JButton("예");
			btnYes.setBorder(null);
			btnYes.setOpaque(true);
			btnYes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Jty_Profile jty_Profile = new Jty_Profile();
					Jty_Dao_Profile dao_Profile = new Jty_Dao_Profile();
					dao_Profile.userDelete();
					dispose();
					Hsh_start hsh_start = new Hsh_start();
					hsh_start.setVisible(true);
				}
			});
			btnYes.setBackground(new Color(131, 77, 30));
			btnYes.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			btnYes.setForeground(new Color(255, 255, 255));
			btnYes.setBounds(36, 177, 91, 23);
		}
		return btnYes;
	}
	private JButton getBtnNo() {
		if (btnNo == null) {
			btnNo = new JButton("아니오");
			btnNo.setOpaque(true);
			btnNo.setBorder(null);
			btnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNo.setForeground(new Color(255, 255, 255));
			btnNo.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			btnNo.setBackground(new Color(131, 77, 30));
			btnNo.setBounds(213, 177, 91, 23);
		}
		return btnNo;
	}
}
