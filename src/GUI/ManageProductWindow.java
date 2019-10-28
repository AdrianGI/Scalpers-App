package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.DB;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ManageProductWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldStock;
	private JTextField textFieldPrice;

	/**
	 * Create the frame.
	 */
	public ManageProductWindow(String ref) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblRef = new JLabel("Referencia");
		lblRef.setFont(new Font("Times", Font.PLAIN, 13));
		GridBagConstraints gbc_lblRef = new GridBagConstraints();
		gbc_lblRef.anchor = GridBagConstraints.WEST;
		gbc_lblRef.insets = new Insets(0, 0, 5, 5);
		gbc_lblRef.gridx = 1;
		gbc_lblRef.gridy = 1;
		gbc_lblRef.weighty = 5;
		contentPane.add(lblRef, gbc_lblRef);

		textField = new JTextField();

		textField.setEditable(false);
		textField.setFont(new Font("Times", Font.PLAIN, 13));
		textField.setText(ref);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;

		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);

		ArrayList<String> sizes = DB.getProSizes(ref);

		String size[] = new String[sizes.size()];

		for (int i = 0; i < sizes.size(); i++) {

			size[i] = sizes.get(i);
		}

		JLabel lblSize = new JLabel("Talla");
		lblSize.setFont(new Font("Times", Font.PLAIN, 13));
		GridBagConstraints gbc_lblSize = new GridBagConstraints();
		gbc_lblSize.anchor = GridBagConstraints.WEST;
		gbc_lblSize.insets = new Insets(0, 0, 5, 5);
		gbc_lblSize.gridx = 1;
		gbc_lblSize.gridy = 4;
		gbc_lblSize.weighty = 5;
		contentPane.add(lblSize, gbc_lblSize);

		JComboBox<String> comboBoxSize = new JComboBox<String>(size);
		comboBoxSize.setFont(new Font("Times", Font.PLAIN, 13));
		comboBoxSize.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBoxSize = new GridBagConstraints();
		gbc_comboBoxSize.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxSize.gridx = 2;
		gbc_comboBoxSize.gridy = 4;
		gbc_comboBoxSize.weighty = 5;
		contentPane.add(comboBoxSize, gbc_comboBoxSize);

		JButton btnplusSize = new JButton("+");
		btnplusSize.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnplusSize = new GridBagConstraints();
		gbc_btnplusSize.insets = new Insets(0, 0, 5, 5);
		gbc_btnplusSize.gridx = 3;
		gbc_btnplusSize.gridy = 4;
		gbc_btnplusSize.weighty = 5;
		contentPane.add(btnplusSize, gbc_btnplusSize);

		JButton button = new JButton("-");
		button.setBackground(Color.WHITE);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 4;
		gbc_button.weighty = 5;
		contentPane.add(button, gbc_button);

		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Times", Font.PLAIN, 13));
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.WEST;
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 1;
		gbc_lblColor.gridy = 9;
		gbc_lblColor.weighty = 5;
		contentPane.add(lblColor, gbc_lblColor);

		ArrayList<String> colours = DB.getProductCol(ref);
		String colour[] = new String[colours.size()];

		for (int i = 0; i < colours.size(); i++) {

			colour[i] = colours.get(i);
		}

		JComboBox<String> comboBoxColour = new JComboBox<String>(colour);
		comboBoxColour.setFont(new Font("Times", Font.PLAIN, 13));
		comboBoxColour.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBoxColour = new GridBagConstraints();
		gbc_comboBoxColour.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxColour.gridx = 2;
		gbc_comboBoxColour.gridy = 9;
		gbc_comboBoxColour.weighty = 5;
		contentPane.add(comboBoxColour, gbc_comboBoxColour);

		JButton button_1 = new JButton("+");
		button_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 3;
		gbc_button_1.gridy = 9;
		gbc_button_1.weighty = 5;
		contentPane.add(button_1, gbc_button_1);

		JButton button_2 = new JButton("-");
		button_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 4;
		gbc_button_2.gridy = 9;
		gbc_button_2.weighty = 5;
		contentPane.add(button_2, gbc_button_2);

		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Times", Font.PLAIN, 13));
		GridBagConstraints gbc_lblStock = new GridBagConstraints();
		gbc_lblStock.anchor = GridBagConstraints.WEST;
		gbc_lblStock.insets = new Insets(0, 0, 5, 5);
		gbc_lblStock.gridx = 1;
		gbc_lblStock.gridy = 14;
		gbc_lblStock.weighty = 5;
		contentPane.add(lblStock, gbc_lblStock);

		textFieldStock = new JTextField();
		textFieldStock.setFont(new Font("Times", Font.PLAIN, 13));
		textFieldStock.setText(String.valueOf(DB.GetStock(ref, String.valueOf(comboBoxSize.getSelectedItem()),
				String.valueOf(comboBoxColour.getSelectedItem()))));
		textFieldStock.setColumns(10);
		GridBagConstraints gbc_textFieldStock = new GridBagConstraints();
		gbc_textFieldStock.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldStock.gridx = 2;
		gbc_textFieldStock.gridy = 14;
		gbc_textFieldStock.weighty = 5;
		contentPane.add(textFieldStock, gbc_textFieldStock);

		JLabel lblPrice = new JLabel("Precio");
		lblPrice.setFont(new Font("Times", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.anchor = GridBagConstraints.WEST;
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 1;
		gbc_lblPrice.gridy = 17;
		gbc_lblPrice.weighty = 5;
		contentPane.add(lblPrice, gbc_lblPrice);

		textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("Times", Font.PLAIN, 13));
		textFieldPrice.setText(String.valueOf(DB.GetPrice(ref)));
		textFieldPrice.setColumns(10);
		GridBagConstraints gbc_textFieldPrice = new GridBagConstraints();
		gbc_textFieldPrice.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrice.gridx = 2;
		gbc_textFieldPrice.gridy = 17;
		gbc_textFieldPrice.weighty = 5;
		contentPane.add(textFieldPrice, gbc_textFieldPrice);

		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageProductWindow.this.setVisible(false);
				AdminWindow aw = new AdminWindow();
				aw.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 19;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton = new JButton("Guardar Cambios");
		btnNewButton.setFont(new Font("Times", Font.PLAIN, 16));
		btnNewButton.setBackground(Color.WHITE);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.UpdatePrice(ref, Double.parseDouble(textFieldPrice.getText()));
				DB.UpdateStock(ref, String.valueOf(comboBoxSize.getSelectedItem()),
						String.valueOf(comboBoxColour.getSelectedItem()), Integer.parseInt(textFieldStock.getText()));
				JOptionPane.showMessageDialog(null, "Producto Actualizado");
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 19;
		gbc_btnNewButton.weighty = 5;

		contentPane.add(btnNewButton, gbc_btnNewButton);

	}

}
