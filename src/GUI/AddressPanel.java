package GUI;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Data.DB;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Checkbox;

public class AddressPanel extends JPanel {

	private boolean condition;
	private Checkbox checkbox;
	private String email;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblNewLabel;
	private Thread t;
	

	/**
	 * Create the panel.
	 */
	public AddressPanel(int id, String email, boolean purchase) {

		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblName = new JLabel();
		lblName.setText(DB.Getname(id));
		lblName.setToolTipText("Nombre");
		lblName.setFont(new Font("Times", Font.PLAIN, 15));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		add(lblName, gbc_lblName);

		lblSurname = new JLabel();
		lblSurname.setText(DB.Getsurname(id));
		lblSurname.setToolTipText("Apellido");
		lblSurname.setFont(new Font("Times", Font.PLAIN, 15));
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.gridwidth = 2;
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
		gbc_lblEnterprise.gridx = 6;
		gbc_lblEnterprise.gridy = 1;
		add(lblEnterprise, gbc_lblEnterprise);

		JLabel lblPhone = new JLabel();
		lblPhone.setText(String.valueOf(DB.GetPhone(id)));
		lblPhone.setToolTipText("Telefono");
		lblPhone.setFont(new Font("Times", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 8;
		gbc_lblPhone.gridy = 1;
		add(lblPhone, gbc_lblPhone);

		checkbox = new Checkbox("");

		GridBagConstraints gbc_checkbox = new GridBagConstraints();
		gbc_checkbox.insets = new Insets(0, 0, 5, 5);
		gbc_checkbox.gridx = 0;
		gbc_checkbox.gridy = 2;
		add(checkbox, gbc_checkbox);

		
		

		checkbox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				checkbox.setState(true);
				AddressWindow.closeWindow();
				//JComponent comp = (JComponent) e.getSource();
				//  Window win = SwingUtilities.getWindowAncestor(comp);
				//  win.dispose();
				
			}
		});
		lblNewLabel = new JLabel();
		lblNewLabel.setText(DB.GetAddress(id));
		lblNewLabel.setToolTipText("Direccion");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblcity = new JLabel();
		lblcity.setText(DB.GetCity(id));
		lblcity.setToolTipText("Ciudad");
		lblcity.setFont(new Font("Times", Font.PLAIN, 15));
		GridBagConstraints gbc_lblcity = new GridBagConstraints();
		gbc_lblcity.gridwidth = 2;
		gbc_lblcity.insets = new Insets(0, 0, 5, 5);
		gbc_lblcity.gridx = 2;
		gbc_lblcity.gridy = 3;
		add(lblcity, gbc_lblcity);

		JLabel lblcountry = new JLabel();
		lblcountry.setText(DB.GetCountry(id));
		lblcountry.setToolTipText("País");
		lblcountry.setFont(new Font("Times", Font.PLAIN, 15));
		GridBagConstraints gbc_lblcountry = new GridBagConstraints();
		gbc_lblcountry.insets = new Insets(0, 0, 5, 5);
		gbc_lblcountry.gridx = 6;
		gbc_lblcountry.gridy = 3;
		add(lblcountry, gbc_lblcountry);

		JLabel lblPc = new JLabel();
		lblPc.setText(String.valueOf(DB.GetPC(id)));
		lblPc.setToolTipText("Codigo Postal");
		lblPc.setFont(new Font("Times", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPc = new GridBagConstraints();
		gbc_lblPc.insets = new Insets(0, 0, 0, 5);
		gbc_lblPc.gridx = 2;
		gbc_lblPc.gridy = 4;
		add(lblPc, gbc_lblPc);

		JLabel lblProvince = new JLabel();
		lblProvince.setText(DB.GetProvince(id));
		lblProvince.setToolTipText("Provincia");
		lblProvince.setFont(new Font("Times", Font.PLAIN, 15));
		GridBagConstraints gbc_lblProvince = new GridBagConstraints();
		gbc_lblProvince.insets = new Insets(0, 0, 0, 5);
		gbc_lblProvince.gridx = 6;
		gbc_lblProvince.gridy = 4;
		add(lblProvince, gbc_lblProvince);

		JButton btnNewButton = new JButton("X");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.DeleteAddress(email, lblName.getText(), lblNewLabel.getText());
				AddressPanel.this.removeAll();
				AddressPanel.this.updateUI();
				JOptionPane.showMessageDialog(null, "Dirección Eliminada ");
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Times", Font.PLAIN, 13));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);

		if (purchase == true) {
			checkbox.setVisible(true);
			btnNewButton.setVisible(false);
		} else {
			checkbox.setVisible(false);

		}

		t = new Thread(r);
		t.start();

	}

	Runnable r = new Runnable() {

		@Override
		public void run() {

			condition = true;
			while (condition) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (checkbox.getState() == true) {
					condition = false;
					int iddir = DB.Getdirid(email, lblName.getText(), lblSurname.getText(), lblNewLabel.getText());
					System.out.println(iddir);
					PaymentWindow pw = new PaymentWindow(email, iddir);
					
					
					pw.setVisible(true);
					t.stop();
				}

			}
			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	};

}
