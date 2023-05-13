package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lju_Basket_Dialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Lju_Basket_Dialog dialog = new Lju_Basket_Dialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Lju_Basket_Dialog() {
		setBounds(120, 500, 352, 279);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					dispose();
				}
			});
			btnNewButton.setFocusPainted(false);
			btnNewButton.setBorderPainted(false);
			btnNewButton.setIcon(new ImageIcon(Lju_Basket_Dialog.class.getResource("/com/javalec/image/buttons.png")));
			btnNewButton.setBounds(29, 195, 300, 50);
			contentPanel.add(btnNewButton);
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Lju_Basket_Dialog.class.getResource("/com/javalec/image/popup.png")));
			lblNewLabel.setBounds(0, 0, 400, 250);
			contentPanel.add(lblNewLabel);
		}
	}

}
