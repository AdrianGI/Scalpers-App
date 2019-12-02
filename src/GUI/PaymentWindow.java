package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtNmeroDeTarjeta;
	private JTextField txtNombreDelTitular;
	private JTextField txtmmaa;
	private JTextField txtCdigoDeSeguridad;

	/**
	 * Launch the applicatio /** Create the frame.
	 */
	public PaymentWindow(String email, int dirid) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 550, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("TRAMITAR PEDIDO");
		lblNewLabel.setFont(new Font("Times", Font.PLAIN, 24));
		lblNewLabel.setBounds(161, 22, 231, 23);
		contentPane.add(lblNewLabel);

		JLabel lblDirecciones = new JLabel("PASO 2: Pago");
		lblDirecciones.setFont(new Font("Times", Font.PLAIN, 20));
		lblDirecciones.setBounds(206, 57, 130, 44);
		contentPane.add(lblDirecciones);

		txtNmeroDeTarjeta = new JTextField();
		txtNmeroDeTarjeta.setText("Número de Tarjeta");
		txtNmeroDeTarjeta.setFont(new Font("Times", Font.PLAIN, 15));
		txtNmeroDeTarjeta.setToolTipText("Número de Tarjeta");
		txtNmeroDeTarjeta.setBounds(98, 139, 328, 44);
		contentPane.add(txtNmeroDeTarjeta);
		txtNmeroDeTarjeta.setColumns(10);

		txtNmeroDeTarjeta.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				txtNmeroDeTarjeta.setText(null);

			}

		});

		txtNombreDelTitular = new JTextField();
		txtNombreDelTitular.setText("Nombre del Titular");
		txtNombreDelTitular.setToolTipText("Nombre del Titular");
		txtNombreDelTitular.setFont(new Font("Times", Font.PLAIN, 15));
		txtNombreDelTitular.setColumns(10);
		txtNombreDelTitular.setBounds(98, 195, 328, 44);
		contentPane.add(txtNombreDelTitular);

		txtNombreDelTitular.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				txtNombreDelTitular.setText(null);

			}

		});

		txtmmaa = new JTextField();
		txtmmaa.setToolTipText("Fecha de vencimiento");
		txtmmaa.setText("(MM/AA)");
		txtmmaa.setFont(new Font("Times", Font.PLAIN, 15));
		txtmmaa.setColumns(10);
		txtmmaa.setBounds(98, 251, 165, 44);
		contentPane.add(txtmmaa);

		txtmmaa.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				txtmmaa.setText(null);

			}

		});

		txtCdigoDeSeguridad = new JTextField();
		txtCdigoDeSeguridad.setToolTipText("Código de seguridad");
		txtCdigoDeSeguridad.setText("Código de seguridad");
		txtCdigoDeSeguridad.setFont(new Font("Times", Font.PLAIN, 15));
		txtCdigoDeSeguridad.setColumns(10);
		txtCdigoDeSeguridad.setBounds(261, 251, 165, 44);
		contentPane.add(txtCdigoDeSeguridad);

		txtCdigoDeSeguridad.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				txtCdigoDeSeguridad.setText(null);

			}

		});

		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtCdigoDeSeguridad.getText().equals("") || txtmmaa.getText().equals("")
						|| txtNmeroDeTarjeta.getText().equals("") || txtNombreDelTitular.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Hay que rellenar todos los campos", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					PaymentWindow.this.setVisible(false);
					PaymentWindow pw = new PaymentWindow(email, dirid);

					pw.setVisible(true);

				} else {

					try {

						if (txtCdigoDeSeguridad.getText().length() == 3 && txtNmeroDeTarjeta.getText().length() == 16) {

							PurchaseWindow pw = new PurchaseWindow(email, dirid);
							pw.setVisible(true);
							PaymentWindow.this.setVisible(false);

						} else {

							JOptionPane.showMessageDialog(null,
									"El Numero de Tarjeta y el CVC tienen que tener un formato válido ", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							PaymentWindow.this.setVisible(false);
							PaymentWindow pw = new PaymentWindow(email, dirid);
							pw.setVisible(true);
						}
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "El telefono y el codigo postal tienen que ser numéricos",
								"ERROR", JOptionPane.ERROR_MESSAGE);
						PaymentWindow.this.setVisible(false);
						PaymentWindow pw = new PaymentWindow(email, dirid);
						pw.setVisible(true);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Times", Font.PLAIN, 13));
		btnNewButton.setBounds(356, 330, 117, 29);
		contentPane.add(btnNewButton);

		JButton btnVolver = new JButton("Cancelar");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				HomeWindow hw = new HomeWindow(email);
				hw.setVisible(true);
				PaymentWindow.this.setVisible(false);
			}
		});
		btnVolver.setFont(new Font("Times", Font.PLAIN, 13));
		btnVolver.setBounds(52, 328, 117, 29);
		contentPane.add(btnVolver);

	}
}
