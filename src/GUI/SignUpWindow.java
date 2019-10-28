package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import Data.DB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class SignUpWindow extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField surname;
	private JTextField txtEmail;
	private JTextField txtPostalCode;
	private JTextField txtPhone;
	private JButton btnBack;
	private JPasswordField txtPassword;
	private JComboBox gender;
	private JDateChooser dateChooser;

	/**
	 * Create the frame.
	 */
	public SignUpWindow() {

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
		lblscalpers.setBounds(133, 18, 215, 80);
		contentPane.add(lblscalpers);

		name = new JTextField();
		name.setToolTipText("Nombre");
		name.setBounds(95, 120, 296, 40);
		name.setFont(new Font("Times", Font.PLAIN, 13));
		name.setText("Nombre");
		contentPane.add(name);
		name.setColumns(10);

		surname = new JTextField();
		surname.setToolTipText("Apellidos");
		surname.setText("Apellidos");
		surname.setFont(new Font("Times", Font.PLAIN, 13));
		surname.setColumns(10);
		surname.setBounds(95, 173, 296, 40);
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

		txtEmail = new JTextField();
		txtEmail.setToolTipText("Email");
		txtEmail.setText("Email");
		txtEmail.setFont(new Font("Times", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		txtEmail.setBounds(95, 277, 296, 40);
		contentPane.add(txtEmail);

		txtEmail.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				txtEmail.setText(null);

			}

		});

		txtPostalCode = new JTextField();
		txtPostalCode.setToolTipText("Código postal");
		txtPostalCode.setText("Código postal");
		txtPostalCode.setFont(new Font("Times", Font.PLAIN, 13));
		txtPostalCode.setColumns(10);
		txtPostalCode.setBounds(95, 381, 296, 40);
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
		txtPhone.setBounds(95, 433, 296, 40);
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

		dateChooser = new JDateChooser();
		dateChooser.setToolTipText("Fecha de Nacimiento");
		dateChooser.setBounds(95, 329, 296, 40);
		contentPane.add(dateChooser);

		JButton btncreate = new JButton("Crear cuenta");
		btncreate.addActionListener(new ActionListener() {

			// restricciones codigo postal 5 numero valido y masculino fem

			public void actionPerformed(ActionEvent e) {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = sdf.format(dateChooser.getDate());

				String email = txtEmail.getText();
				int pos1 = email.indexOf("@");
				int pos2 = email.lastIndexOf("@");
				int pos3 = email.indexOf(".");
				int pos4 = email.lastIndexOf(".");

				if (name.getText().equals("") || surname.getText().equals("") || txtEmail.getText().equals("")
						|| txtPostalCode.getText().equals("") || txtPhone.getText().equals("") || date.equals("")) {

					JOptionPane.showMessageDialog(null, "Hay que rellenar todos los campos", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					SignUpWindow.this.setVisible(false);
					SignUpWindow suw = new SignUpWindow();
					suw.setVisible(true);

				} else {
					// tiene una única arroba
					if (pos1 != pos2 && pos1 == -1 && pos3 != pos4 && pos3 == -1) {

						JOptionPane.showMessageDialog(null, "Correo Electeónico no válido", "ERROR",
								JOptionPane.ERROR_MESSAGE);
						SignUpWindow.this.setVisible(false);
						SignUpWindow suw = new SignUpWindow();
						suw.setVisible(true);

					} else {
						try {
							if (txtPhone.getText().length() == 9 && txtPostalCode.getText().length() == 5) {
								int phone = Integer.parseInt(txtPhone.getText());
								int cp = Integer.parseInt(txtPostalCode.getText());
								try {

									DB.getConnection();
									int resultado = DB.findUser(txtEmail.getText(), txtPassword.getText());
									if (resultado != 0) {
										JOptionPane.showMessageDialog(null, "Ese usuario ya existe", "ERROR",
												JOptionPane.ERROR_MESSAGE);
									} else {

										DB.getConnection();
										DB.newUser(name.getText(), surname.getText(), txtPassword.getText(),
												txtEmail.getText(), date, txtPostalCode.getText(), txtPhone.getText(),
												gender.getSelectedItem().toString());

										JOptionPane.showMessageDialog(null, "Usuario Registrado ", null,
												JOptionPane.INFORMATION_MESSAGE);

										HomeWindow hw = new HomeWindow(txtEmail.getText());
										hw.setVisible(true);
										SignUpWindow.this.setVisible(false);
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
							JOptionPane.showMessageDialog(null,
									"El telefono y el codigo postal tienen que ser numéricos", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							SignUpWindow.this.setVisible(false);
							SignUpWindow suw = new SignUpWindow();
							suw.setVisible(true);
						}
					}
				}
			}
		});
		btncreate.setForeground(Color.BLACK);

		btncreate.setBackground(Color.BLACK);
		btncreate.setFont(new Font("Times", Font.PLAIN, 13));
		btncreate.setBounds(264, 553, 127, 29);
		contentPane.add(btncreate);

		btnBack = new JButton("Volver");
		btnBack.setBorder(null);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindow lw = new LoginWindow();
				lw.setVisible(true);
				SignUpWindow.this.setVisible(false);

			}
		});
		btnBack.setFont(new Font("Times", Font.BOLD, 13));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(95, 552, 117, 29);
		contentPane.add(btnBack);

		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("Contraseña");
		txtPassword.setText("Contraseña");
		txtPassword.setFont(new Font("Times", Font.PLAIN, 13));
		txtPassword.setBounds(95, 225, 296, 40);
		contentPane.add(txtPassword);

		gender = new JComboBox();
		gender.setToolTipText("Género");
		gender.setFont(new Font("Times", Font.PLAIN, 13));
		gender.setBounds(95, 473, 296, 56);
		gender.addItem("Masculino");
		gender.addItem("Femenino");

		contentPane.add(gender);

		txtPassword.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				txtPassword.setText(null);

			}

		});

	}

}
