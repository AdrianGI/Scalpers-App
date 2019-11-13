package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Data.DB;

public class AddAddressWindow extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField surname;
	private JTextField txtCountry;
	private JTextField txtPostalCode;
	private JTextField txtPhone;
	private JButton btnBack;
	private JTextField txtEnterprise;
	private JTextField textFieldAddress;
	private JTextField textFieldProvince;
	private JTextField txtCity;
	private boolean pay;

	/**
	 * Create the frame.
	 */
	public AddAddressWindow(String email, boolean payment) {
		pay = payment;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 500, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblscalpers = new JLabel(new ImageIcon("photos/scalpers215x80.png"));
		lblscalpers.setBounds(133, 6, 215, 80);
		contentPane.add(lblscalpers);

		name = new JTextField();
		name.setToolTipText("Nombre");
		name.setBounds(95, 98, 296, 40);
		name.setFont(new Font("Times", Font.PLAIN, 13));
		name.setText("Nombre");
		contentPane.add(name);
		name.setColumns(10);

		surname = new JTextField();
		surname.setToolTipText("Apellidos");
		surname.setText("Apellidos");
		surname.setFont(new Font("Times", Font.PLAIN, 13));
		surname.setColumns(10);
		surname.setBounds(95, 150, 296, 40);
		contentPane.add(surname);

		surname.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				surname.setText(null);

			}

		});

		txtCountry = new JTextField();
		txtCountry.setToolTipText("País");
		txtCountry.setText("País");
		txtCountry.setFont(new Font("Times", Font.PLAIN, 13));
		txtCountry.setColumns(10);
		txtCountry.setBounds(95, 254, 296, 40);
		contentPane.add(txtCountry);

		txtCountry.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				txtCountry.setText(null);

			}

		});

		txtPostalCode = new JTextField();
		txtPostalCode.setToolTipText("Código postal");
		txtPostalCode.setText("Código postal");
		txtPostalCode.setFont(new Font("Times", Font.PLAIN, 13));
		txtPostalCode.setColumns(10);
		txtPostalCode.setBounds(95, 358, 296, 40);
		contentPane.add(txtPostalCode);

		txtPostalCode.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				txtPostalCode.setText(null);

			}

		});

		txtPhone = new JTextField();
		txtPhone.setToolTipText("Teléfono");
		txtPhone.setText("Teléfono");
		txtPhone.setFont(new Font("Times", Font.PLAIN, 13));
		txtPhone.setColumns(10);
		txtPhone.setBounds(95, 413, 296, 40);
		contentPane.add(txtPhone);

		txtPhone.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				txtPhone.setText(null);

			}

		});

		txtEnterprise = new JTextField();
		txtEnterprise.setToolTipText("Empresa");
		txtEnterprise.setText("Empresa");
		txtEnterprise.setFont(new Font("Times", Font.PLAIN, 13));
		txtEnterprise.setColumns(10);
		txtEnterprise.setBounds(95, 202, 296, 40);
		contentPane.add(txtEnterprise);

		txtEnterprise.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				txtEnterprise.setText(null);

			}

		});

		textFieldAddress = new JTextField();
		textFieldAddress.setToolTipText("Dirección");
		textFieldAddress.setText("Dirección");
		textFieldAddress.setFont(new Font("Times", Font.PLAIN, 13));
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(95, 306, 296, 40);
		contentPane.add(textFieldAddress);

		textFieldAddress.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				textFieldAddress.setText(null);

			}

		});

		textFieldProvince = new JTextField();
		textFieldProvince.setToolTipText("Provincia");
		textFieldProvince.setText("Provincia");
		textFieldProvince.setFont(new Font("Times", Font.PLAIN, 13));
		textFieldProvince.setColumns(10);
		textFieldProvince.setBounds(95, 468, 296, 40);
		contentPane.add(textFieldProvince);

		textFieldProvince.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				textFieldProvince.setText(null);

			}

		});

		txtCity = new JTextField();
		txtCity.setToolTipText("Ciudad");
		txtCity.setText("Ciudad");
		txtCity.setFont(new Font("Times", Font.PLAIN, 13));
		txtCity.setColumns(10);
		txtCity.setBounds(95, 518, 296, 40);
		contentPane.add(txtCity);

		txtCity.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				txtCity.setText(null);

			}

		});

		JButton btnAdd = new JButton("Añadir");
		btnAdd.setBorder(null);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (name.getText().equals("") || surname.getText().equals("") || txtCountry.getText().equals("")
						|| txtPostalCode.getText().equals("") || txtPhone.getText().equals("")
						|| textFieldAddress.getText().equals("") || textFieldProvince.getText().equals("")
						|| txtCity.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Hay que rellenar todos los campos", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					AddAddressWindow.this.setVisible(false);
					AddAddressWindow suw = new AddAddressWindow(email, payment);
					suw.setVisible(true);

				} else {

					try {
						if (txtPhone.getText().length() == 9 && txtPostalCode.getText().length() == 5) {
							int phone = Integer.parseInt(txtPhone.getText());
							int cp = Integer.parseInt(txtPostalCode.getText());
							try {

								DB.getConnection();
								// int id= DB.maxId();
								if (pay = false) {
									DB.newAddress(email, name.getText(), surname.getText(), txtEnterprise.getText(),
											textFieldAddress.getText(), txtPostalCode.getText(), txtPhone.getText(),
											txtCountry.getText(), textFieldProvince.getText(), txtCity.getText(), 5);

									JOptionPane.showMessageDialog(null, "Dirección Añadida ", null,
											JOptionPane.INFORMATION_MESSAGE);

									AddressWindow aw = new AddressWindow(email);
									aw.setVisible(true);
									AddAddressWindow.this.setVisible(false);
								} else {

									// meter en bd compra

								}

							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"El telefono y el codigo postal tienen que tener un formato válido ", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "El telefono y el codigo postal tienen que ser numéricos",
								"ERROR", JOptionPane.ERROR_MESSAGE);
						AddAddressWindow.this.setVisible(false);
						AddAddressWindow aw = new AddAddressWindow(email, payment);
						aw.setVisible(true);
					}
				}
			}
		});
		btnAdd.setForeground(Color.BLACK);

		btnAdd.setBackground(Color.BLACK);
		btnAdd.setFont(new Font("Times", Font.BOLD, 13));
		btnAdd.setBounds(264, 582, 127, 29);
		contentPane.add(btnAdd);

		btnBack = new JButton("Volver");
		btnBack.setBorder(null);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddressWindow aw = new AddressWindow(email);
				aw.setVisible(true);
				AddAddressWindow.this.setVisible(false);

			}
		});
		btnBack.setFont(new Font("Times", Font.BOLD, 13));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(95, 581, 117, 29);
		contentPane.add(btnBack);

	}
}
