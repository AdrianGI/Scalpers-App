package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ProductWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the applicati
	 * 
	 * /** Create the frame.
	 */
	public ProductWindow(String route) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		ImageIcon im = new ImageIcon(route);
		JLabel lblNewLabel = new JLabel(im);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		setVisible(true);
	}
}
