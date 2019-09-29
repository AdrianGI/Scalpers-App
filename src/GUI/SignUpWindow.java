package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpWindow extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField surname;
	private JTextField txtEmail;
	private JTextField txtPostalCode;
	private JTextField txtBirthDate;
	private JTextField txtPhone;
	private JTextField txtGender;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpWindow frame = new SignUpWindow();
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

		JLabel lblscalpers = new JLabel(new ImageIcon("scalpers215x80.png"));
		lblscalpers.setBounds(133, 18, 215, 80);
		contentPane.add(lblscalpers);

		name = new JTextField();
		name.setBounds(95, 128, 296, 40);
		name.setFont(new Font("Times", Font.PLAIN, 13));
		name.setText("Nombre");
		contentPane.add(name);
		name.setColumns(10);
		

		surname = new JTextField();
		surname.setText("Apellidos");
		surname.setFont(new Font("Times", Font.PLAIN, 13));
		surname.setColumns(10);
		surname.setBounds(95, 180, 296, 40);
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
		txtEmail.setText("Email");
		txtEmail.setFont(new Font("Times", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		txtEmail.setBounds(95, 233, 296, 40);
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
		txtPostalCode.setText("Código postal");
		txtPostalCode.setFont(new Font("Times", Font.PLAIN, 13));
		txtPostalCode.setColumns(10);
		txtPostalCode.setBounds(95, 337, 296, 40);
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

		txtBirthDate = new JTextField();
		txtBirthDate.setText("Fecha de nacimiento                   Ej:01/01/2000");
		txtBirthDate.setFont(new Font("Times", Font.PLAIN, 13));
		txtBirthDate.setColumns(10);
		txtBirthDate.setBounds(95, 285, 296, 40);
		contentPane.add(txtBirthDate);

		txtBirthDate.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				txtBirthDate.setText(null);

			}

		});

		txtPhone = new JTextField();
		txtPhone.setText("Teléfono");
		txtPhone.setFont(new Font("Times", Font.PLAIN, 13));
		txtPhone.setColumns(10);
		txtPhone.setBounds(95, 389, 296, 40);
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

		txtGender = new JTextField();
		txtGender.setText("Género");
		txtGender.setFont(new Font("Times", Font.PLAIN, 13));
		txtGender.setColumns(10);
		txtGender.setBounds(95, 440, 296, 40);
		contentPane.add(txtGender);

		txtGender.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				txtGender.setText(null);

			}

		});

		JButton btncreate = new JButton("Crear cuenta");
		
		btncreate.setBackground(Color.BLACK);
		btncreate.setFont(new Font("Times", Font.PLAIN, 13));
		btncreate.setBounds(264, 534, 127, 29);
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
		btnBack.setBounds(95, 534, 117, 29);
		contentPane.add(btnBack);

	}
}
