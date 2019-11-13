package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PaymentWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtNmeroDeTarjeta;
	private JTextField txtNombreDelTitular;
	private JTextField txtmmaa;
	private JTextField txtCdigoDeSeguridad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentWindow frame = new PaymentWindow();
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
	public PaymentWindow() {
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

		JLabel lblDirecciones = new JLabel("PASO 3: Pago");
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

		txtNombreDelTitular = new JTextField();
		txtNombreDelTitular.setText("Nombre del Titular");
		txtNombreDelTitular.setToolTipText("Nombre del Titular");
		txtNombreDelTitular.setFont(new Font("Times", Font.PLAIN, 15));
		txtNombreDelTitular.setColumns(10);
		txtNombreDelTitular.setBounds(98, 195, 328, 44);
		contentPane.add(txtNombreDelTitular);

		txtmmaa = new JTextField();
		txtmmaa.setToolTipText("Fecha de vencimiento");
		txtmmaa.setText("(MM/AA)");
		txtmmaa.setFont(new Font("Times", Font.PLAIN, 15));
		txtmmaa.setColumns(10);
		txtmmaa.setBounds(98, 251, 165, 44);
		contentPane.add(txtmmaa);

		txtCdigoDeSeguridad = new JTextField();
		txtCdigoDeSeguridad.setToolTipText("Código de seguridad");
		txtCdigoDeSeguridad.setText("Código de seguridad");
		txtCdigoDeSeguridad.setFont(new Font("Times", Font.PLAIN, 15));
		txtCdigoDeSeguridad.setColumns(10);
		txtCdigoDeSeguridad.setBounds(261, 251, 165, 44);
		contentPane.add(txtCdigoDeSeguridad);

		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.setFont(new Font("Times", Font.PLAIN, 13));
		btnNewButton.setBounds(356, 330, 117, 29);
		contentPane.add(btnNewButton);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Times", Font.PLAIN, 13));
		btnVolver.setBounds(52, 328, 117, 29);
		contentPane.add(btnVolver);

	}
}
