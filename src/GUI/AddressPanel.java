package GUI;

import javax.swing.JPanel;

import Data.DB;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Insets;

public class AddressPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AddressPanel(int id) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton btnNewButton = new JButton("X");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Times", Font.PLAIN, 13));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);

		JLabel lblName = new JLabel();
		lblName.setText(DB.Getname(id));
		lblName.setToolTipText("Nombre");
		lblName.setFont(new Font("Times", Font.PLAIN, 15));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		add(lblName, gbc_lblName);

		JLabel lblSurname = new JLabel();
		lblSurname.setText(DB.Getsurname(id));
		lblSurname.setToolTipText("Nombre");
		lblSurname.setFont(new Font("Times", Font.PLAIN, 15));
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 2;
		gbc_lblSurname.gridy = 1;
		add(lblSurname, gbc_lblSurname);

		JLabel lblEnterprise = new JLabel();
		lblEnterprise.setText(DB.GetEnterprise(id));
		lblEnterprise.setToolTipText("Empresa");
		lblEnterprise.setFont(new Font("Times", Font.PLAIN, 15));
		GridBagConstraints gbc_lblEnterprise = new GridBagConstraints();
		gbc_lblEnterprise.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterprise.gridx = 5;
		gbc_lblEnterprise.gridy = 1;
		add(lblEnterprise, gbc_lblEnterprise);

		JLabel lblPhone = new JLabel();
		lblPhone.setText(String.valueOf(DB.GetPhone(id)));
		lblPhone.setToolTipText("Nombre");
		lblPhone.setFont(new Font("Times", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.insets = new Insets(0, 0, 5, 0);
		gbc_lblPhone.gridx = 7;
		gbc_lblPhone.gridy = 1;
		add(lblPhone, gbc_lblPhone);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText(DB.GetAddress(id));
		lblNewLabel.setToolTipText("Direccion");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 7;
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblcity = new JLabel();
		lblcity.setText(DB.GetCity(id));
		lblcity.setToolTipText("City");
		lblcity.setFont(new Font("Times", Font.PLAIN, 15));
		GridBagConstraints gbc_lblcity = new GridBagConstraints();
		gbc_lblcity.insets = new Insets(0, 0, 5, 5);
		gbc_lblcity.gridx = 1;
		gbc_lblcity.gridy = 3;
		add(lblcity, gbc_lblcity);

		JLabel lblcountry = new JLabel();
		lblcountry.setText(DB.GetCountry(id));
		lblcountry.setToolTipText("Country");
		lblcountry.setFont(new Font("Times", Font.PLAIN, 15));
		GridBagConstraints gbc_lblcountry = new GridBagConstraints();
		gbc_lblcountry.insets = new Insets(0, 0, 5, 5);
		gbc_lblcountry.gridx = 5;
		gbc_lblcountry.gridy = 3;
		add(lblcountry, gbc_lblcountry);

		JLabel lblPc = new JLabel();
		lblPc.setText(String.valueOf(DB.GetPC(id)));
		lblPc.setToolTipText("Codigo Postal");
		lblPc.setFont(new Font("Times", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPc = new GridBagConstraints();
		gbc_lblPc.insets = new Insets(0, 0, 0, 5);
		gbc_lblPc.gridx = 1;
		gbc_lblPc.gridy = 4;
		add(lblPc, gbc_lblPc);

		JLabel lblProvince = new JLabel();
		lblProvince.setText(DB.GetProvince(id));
		lblProvince.setToolTipText("Province");
		lblProvince.setFont(new Font("Times", Font.PLAIN, 15));
		GridBagConstraints gbc_lblProvince = new GridBagConstraints();
		gbc_lblProvince.insets = new Insets(0, 0, 0, 5);
		gbc_lblProvince.gridx = 5;
		gbc_lblProvince.gridy = 4;
		add(lblProvince, gbc_lblProvince);

	}

}
