package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgetPassWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgetPassWindow frame = new ForgetPassWindow();
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
		
		
		
		JLabel lblscalpers = new JLabel(new ImageIcon("scalpers215x80.png"));
		lblscalpers.setBounds(135, 49, 215, 80);
		contentPane.add(lblscalpers);
		
		JLabel lblRecover = new JLabel("RECUPERAR ");
		lblRecover.setFont(new Font("Times", Font.BOLD, 29));
		lblRecover.setBounds(151, 180, 198, 30);
		contentPane.add(lblRecover);
		
		JLabel lblpass = new JLabel("CONTRASEÑA");
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
				
				//correo electronico manda contraseña
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
}
