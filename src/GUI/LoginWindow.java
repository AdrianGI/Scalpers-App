package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;

public class LoginWindow extends JFrame {

	private JPanel contentPane;
	private JTextField emailtxt;
	private JPasswordField passwordtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
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
	public LoginWindow() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 500, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Times", Font.PLAIN, 35));
		lblLogin.setBounds(190, 200, 132, 41);
		contentPane.add(lblLogin);

		JLabel lblPorFavorIntroduce = new JLabel("Por favor, introduce tu email y contraseña:");
		lblPorFavorIntroduce.setFont(new Font("Times", Font.PLAIN, 13));
		lblPorFavorIntroduce.setBounds(116, 265, 286, 16);
		contentPane.add(lblPorFavorIntroduce);

		emailtxt = new JTextField();
		emailtxt.setFont(new Font("Times", Font.PLAIN, 13));
		emailtxt.setText("Email");
		emailtxt.setBounds(105, 310, 311, 41);
		contentPane.add(emailtxt);
		emailtxt.setColumns(10);

		emailtxt.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				// emailtxt.setText(null);

			}

		});

		passwordtxt = new JPasswordField();
		passwordtxt.setFont(new Font("Times", Font.PLAIN, 13));
		passwordtxt.setText("Contraseña");

		passwordtxt.setBounds(105, 376, 311, 41);
		contentPane.add(passwordtxt);

		passwordtxt.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				passwordtxt.setText(null);

			}

		});

		JButton btnLogin = new JButton("Iniciar Sesión");
		
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setFont(new Font("Times", Font.PLAIN, 13));
		btnLogin.setBounds(101, 444, 117, 29);
		btnLogin.setBackground(Color.BLACK);
		contentPane.add(btnLogin);

		JButton btnforgetpass = new JButton("¿Olvidaste tu contraseña?");
		btnforgetpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ForgetPassWindow fpw = new ForgetPassWindow ();
				fpw.setVisible(true);
				LoginWindow.this.setVisible(false);
				
			}
		});
		btnforgetpass.setBorder(null);
		btnforgetpass.setForeground(Color.BLACK);
		btnforgetpass.setFont(new Font("Times", Font.BOLD, 14));
		btnforgetpass.setBackground(Color.BLACK);
		btnforgetpass.setBounds(222, 444, 194, 29);
		contentPane.add(btnforgetpass);

		JLabel lblno = new JLabel("¿No tienes cuenta?");
		lblno.setFont(new Font("Times", Font.PLAIN, 13));
		lblno.setBounds(148, 518, 117, 16);
		contentPane.add(lblno);

		JButton btnSignup = new JButton("Crea una ");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SignUpWindow suw = new SignUpWindow();
				suw.setVisible(true);
				LoginWindow.this.setVisible(false);

			}
		});
		btnSignup.setForeground(Color.BLACK);
		btnSignup.setFont(new Font("Times", Font.BOLD, 14));
		btnSignup.setBorder(null);
		btnSignup.setBackground(Color.BLACK);
		btnSignup.setBounds(259, 512, 63, 29);
		contentPane.add(btnSignup);

		JLabel lblscalpers = new JLabel(new ImageIcon("scalpers.jpg"));
		lblscalpers.setBounds(65, 35, 370, 115);
		contentPane.add(lblscalpers);
	}
}
