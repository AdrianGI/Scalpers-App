package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


import Data.DB;
import javafx.stage.FileChooser;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddProductWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldref;
	private JTextField textFieldproduct;
	private JTextField textFieldprice;
	private JTextField textFieldsize;
	private JTextField textFieldcolour;
	private JTextField textFieldstock;
	private JTextField textFieldgender;
	private JTextField textFieldtype;
	private JTextField textFieldruta;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProductWindow frame = new AddProductWindow();
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
	public AddProductWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 450, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblRef = new JLabel("Referencia:");
		lblRef.setFont(new Font("Times", Font.PLAIN, 13));
		lblRef.setBounds(62, 45, 68, 16);
		contentPane.add(lblRef);
		
		JLabel lblProduct = new JLabel("Producto:");
		lblProduct.setFont(new Font("Times", Font.PLAIN, 13));
		lblProduct.setBounds(62, 90, 68, 16);
		contentPane.add(lblProduct);
		
		JLabel lblDesc = new JLabel("Descripción:");
		lblDesc.setFont(new Font("Times", Font.PLAIN, 13));
		lblDesc.setBounds(62, 154, 81, 16);
		contentPane.add(lblDesc);
		
		JLabel lblprice = new JLabel("Precio:");
		lblprice.setFont(new Font("Times", Font.PLAIN, 13));
		lblprice.setBounds(62, 221, 81, 16);
		contentPane.add(lblprice);
		
		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setFont(new Font("Times", Font.PLAIN, 13));
		lblTalla.setBounds(62, 270, 81, 16);
		contentPane.add(lblTalla);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Times", Font.PLAIN, 13));
		lblColor.setBounds(62, 318, 81, 16);
		contentPane.add(lblColor);
		
		JLabel lblRuta = new JLabel("Ruta:");
		lblRuta.setFont(new Font("Times", Font.PLAIN, 13));
		lblRuta.setBounds(62, 363, 81, 16);
		contentPane.add(lblRuta);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Times", Font.PLAIN, 13));
		lblStock.setBounds(62, 408, 81, 16);
		contentPane.add(lblStock);
		
		JLabel lblGnero = new JLabel("Género:");
		lblGnero.setFont(new Font("Times", Font.PLAIN, 13));
		lblGnero.setBounds(62, 457, 81, 16);
		contentPane.add(lblGnero);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Times", Font.PLAIN, 13));
		lblTipo.setBounds(62, 506, 81, 16);
		contentPane.add(lblTipo);
		
		textFieldref = new JTextField();
		textFieldref.setFont(new Font("Times", Font.PLAIN, 13));
		textFieldref.setBounds(153, 35, 185, 26);
		contentPane.add(textFieldref);
		textFieldref.setColumns(10);
		
		textFieldproduct = new JTextField();
		textFieldproduct.setFont(new Font("Times", Font.PLAIN, 13));
		textFieldproduct.setColumns(10);
		textFieldproduct.setBounds(153, 85, 185, 26);
		contentPane.add(textFieldproduct);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times", Font.PLAIN, 13));
		textArea.setBounds(153, 136, 185, 62);
		
		contentPane.add(textArea);
		
		
		textFieldprice = new JTextField();
		textFieldprice.setFont(new Font("Times", Font.PLAIN, 13));
		textFieldprice.setColumns(10);
		textFieldprice.setBounds(153, 211, 185, 26);
		contentPane.add(textFieldprice);
		
		textFieldsize = new JTextField();
		textFieldsize.setFont(new Font("Times", Font.PLAIN, 13));
		textFieldsize.setColumns(10);
		textFieldsize.setBounds(153, 263, 185, 26);
		contentPane.add(textFieldsize);
		
		textFieldcolour = new JTextField();
		textFieldcolour.setFont(new Font("Times", Font.PLAIN, 13));
		textFieldcolour.setColumns(10);
		textFieldcolour.setBounds(153, 311, 185, 26);
		contentPane.add(textFieldcolour);
		
		textFieldstock = new JTextField();
		textFieldstock.setFont(new Font("Times", Font.PLAIN, 13));
		textFieldstock.setColumns(10);
		textFieldstock.setBounds(153, 401, 185, 26);
		contentPane.add(textFieldstock);
		
		textFieldgender = new JTextField();
		textFieldgender.setFont(new Font("Times", Font.PLAIN, 13));
		textFieldgender.setColumns(10);
		textFieldgender.setBounds(153, 450, 185, 26);
		contentPane.add(textFieldgender);
		
		textFieldtype = new JTextField();
		textFieldtype.setFont(new Font("Times", Font.PLAIN, 13));
		textFieldtype.setColumns(10);
		textFieldtype.setBounds(155, 499, 185, 26);
		contentPane.add(textFieldtype);
		
		JButton btnSeleccionar = new JButton("Abrir");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Creamos el objeto JFileChooser
				JFileChooser fc=new JFileChooser();
				 
				//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
				int seleccion=fc.showOpenDialog(contentPane);
				 
				//Si el usuario, pincha en aceptar
				if(seleccion==JFileChooser.APPROVE_OPTION){
				 
				    //Seleccionamos el fichero
				    File fichero=fc.getSelectedFile();
				 
				    //Ecribe la ruta del fichero seleccionado en el campo de texto
				    textFieldruta.setText(fichero.getAbsolutePath());
				 
				    try(FileReader fr=new FileReader(fichero)){
				        String cadena="";
				        int valor=fr.read();
				        while(valor!=-1){
				            cadena=cadena+(char)valor;
				            valor=fr.read();
				        }
				        
				    } catch (IOException e1) {
				        e1.printStackTrace();
				    }
				}
				
			}
		});
		btnSeleccionar.setFont(new Font("Times", Font.PLAIN, 13));
		btnSeleccionar.setBounds(341, 358, 68, 29);
		contentPane.add(btnSeleccionar);
		
		textFieldruta = new JTextField();
		textFieldruta.setFont(new Font("Times", Font.PLAIN, 13));
		textFieldruta.setColumns(10);
		textFieldruta.setBounds(155, 356, 185, 26);
		contentPane.add(textFieldruta);
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					
				
				try {
					DB.getConnection();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
		DB.addProduct(textFieldref.getText(), textFieldproduct.getText(), textArea.getText(), 1, Double.parseDouble(textFieldprice.getText())
			, textFieldcolour.getText());
		DB.addProductsInfo(500,textFieldref.getText(), textFieldsize.getText(), textFieldcolour.getText(), textFieldruta.getText(), Integer.parseInt(textFieldstock.getText()), textFieldgender.getText(), textFieldtype.getText());
			}
			
			
		});
		btnAadir.setFont(new Font("Times", Font.PLAIN, 13));
		btnAadir.setBounds(313, 543, 68, 29);
		contentPane.add(btnAadir);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProductWindow.this.setVisible(false);
				AdminWindow a = new AdminWindow();
				a.setVisible(true);
			}
		});
		btnVolver.setFont(new Font("Times", Font.PLAIN, 13));
		btnVolver.setBounds(126, 541, 68, 29);
		contentPane.add(btnVolver);
	}
}
