package GUI;

import java.awt.EventQueue;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.DB;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.awt.event.ActionEvent;

public class ForgetPassWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;

	/**
	 * Create the frame.
	 */
	public ForgetPassWindow() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblscalpers = new JLabel(new ImageIcon("photos/scalpers215x80.png"));
		lblscalpers.setBounds(135, 49, 215, 80);
		contentPane.add(lblscalpers);

		JLabel lblRecover = new JLabel("RECUPERAR ");
		lblRecover.setFont(new Font("Times", Font.BOLD, 29));
		lblRecover.setBounds(151, 180, 198, 30);
		contentPane.add(lblRecover);

		JLabel lblpass = new JLabel("CONTRASEñA");
		lblpass.setFont(new Font("Times", Font.BOLD, 29));
		lblpass.setBounds(143, 222, 215, 30);
		contentPane.add(lblpass);

		JLabel lblplease = new JLabel("Por favor introduce tu email:");
		lblplease.setFont(new Font("Times", Font.PLAIN, 13));
		lblplease.setBounds(151, 285, 207, 16);
		contentPane.add(lblplease);

		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setToolTipText("");
		txtEmail.setFont(new Font("Times", Font.PLAIN, 13));
		txtEmail.setBounds(110, 345, 289, 36);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JButton btnRecover = new JButton("Recuperar");
		btnRecover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DB.getConnection();
					String pass = DB.ForgetPass(txtEmail.getText());
					sendEmail(txtEmail.getText(), pass);
					ForgetPassWindow.this.setVisible(false);
					LoginWindow lw = new LoginWindow();
					lw.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnRecover.setFont(new Font("Times", Font.PLAIN, 13));
		btnRecover.setBounds(191, 409, 117, 29);
		contentPane.add(btnRecover);

		JLabel lblRemember = new JLabel("¿Recuerdas tu contraeña?");
		lblRemember.setFont(new Font("Times", Font.PLAIN, 13));
		lblRemember.setBounds(110, 495, 145, 16);
		contentPane.add(lblRemember);

		JButton btnBack = new JButton("Volver al login");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LoginWindow lw = new LoginWindow();
				lw.setVisible(true);
				ForgetPassWindow.this.setVisible(false);
			}
		});
		btnBack.setBorder(null);
		btnBack.setFont(new Font("Times", Font.BOLD, 13));
		btnBack.setBounds(267, 488, 132, 29);
		contentPane.add(btnBack);
	}

	// Metodo que envia la contraseña olvidada al correo correspondiente

	// El correo gmail de envÌo
	// String correoEnvia ="scalperscompanyud@gmail.com";
	// String claveCorreo = "scalpers98";

	private void sendEmail(String mail, String pass) {

		// El correo gmail de envÌo
		String correoEnvia = "scalperscompanyud@gmail.com";
		String claveCorreo = "scalpers98";

		// La configuraciÛn para enviar correo
		Properties properties = new Properties();

		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.user", correoEnvia);
		properties.put("mail.password", claveCorreo);

		// Obtener la sesion
		Session session = Session.getInstance(properties, null);
		int aviso = 0;
		try {
			// Crear el cuerpo del mensaje
			MimeMessage mimeMessage = new MimeMessage(session);

			// Agregar quien envÌa el correo
			mimeMessage.setFrom(new InternetAddress(correoEnvia, "SCALPERS"));

			// Los destinatarios
			InternetAddress[] internetAddresses = { new InternetAddress(mail) };

			// Agregar los destinatarios al mensaje
			mimeMessage.setRecipients(Message.RecipientType.TO, internetAddresses);

			// Agregar el asunto al correo
			mimeMessage.setSubject("Recuperación de contraseña");

			// Creo la parte del mensaje
			MimeBodyPart mimeBodyPart = new MimeBodyPart();

			mimeBodyPart.setText("¿Has olvidado tu contraseña?\n" + "\n"
					+ "No importa. ¡Son cosas que pasan! La contraseña correspondiente a tu usuario es:  " + "\n"
					+ "	" + "\n" + "\n" + pass + "\n" + "\n" + "\n" + "El Equipo de Scalpers");

			// Crear el multipart para agregar la parte del mensaje anterior
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			// multipart.addBodyPart(mimeBodyPartAdjunto);

			// Agregar el multipart al cuerpo del mensaje
			mimeMessage.setContent(multipart);

			// Enviar el mensaje
			Transport transport = session.getTransport("smtp");
			transport.connect(correoEnvia, claveCorreo);
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

			transport.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Correo electrónico erroneo", "ERROR", JOptionPane.ERROR_MESSAGE);
			aviso = 1;
		}
		if (aviso == 0) {
			JOptionPane.showMessageDialog(null, "Revise su bandeja de entrada ", "Correo enviado con éxito",
					JOptionPane.INFORMATION_MESSAGE);

		}
	}

}
