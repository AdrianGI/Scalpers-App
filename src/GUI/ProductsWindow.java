package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingConstants;

public class ProductsWindow extends JFrame {

	private JPanel contentPane, PanelCentre;
	private JFrame ventanaAnterior;
	private String gender, type;
	private JScrollPane scroll;

	public ProductsWindow(String email) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JFrame ventana = this;

		JPanel PanelUp = new JPanel();
		PanelUp.setBackground(Color.WHITE);
		FlowLayout fl_PanelUp = (FlowLayout) PanelUp.getLayout();
		fl_PanelUp.setAlignment(FlowLayout.LEFT);
		contentPane.add(PanelUp, BorderLayout.NORTH);

		JMenuBar MenuBar = new JMenuBar();
		PanelUp.add(MenuBar);

		JMenu Female = new JMenu("MUJER");
		Female.setFont(new Font("Times", Font.PLAIN, 13));
		MenuBar.add(Female);
		Female.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				gender = "Femenino";
			}
		});

		JMenuItem mntmCamisetaMujer = new JMenuItem("Camisetas");
		mntmCamisetaMujer.setFont(new Font("Times", Font.PLAIN, 13));
		Female.add(mntmCamisetaMujer);
		mntmCamisetaMujer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				type = "Camiseta";
				contentPane.remove(scroll);
				try {
					PanelCentre = new PhotosPanel(gender, type, "");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PanelCentre.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("HAS HECHO CLICK");
						PhotosPanel pf = (PhotosPanel) e.getComponent();
						int x = e.getX();
						int y = e.getY();
						ProductPanelInfo pi = (ProductPanelInfo) pf.getComponentAt(x, y);
						new ProductWindow(pi.getRoute());
					}
				});
				scroll = new JScrollPane(PanelCentre);
				contentPane.add(scroll, BorderLayout.CENTER);
				contentPane.updateUI();
			}
		});

		JMenuItem mntmShirts = new JMenuItem("Camisas");
		mntmShirts.setFont(new Font("Times", Font.PLAIN, 13));
		Female.add(mntmShirts);
		mntmShirts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				type = "Camisa";
				contentPane.remove(scroll);
				try {
					PanelCentre = new PhotosPanel(gender, type, "");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PanelCentre.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("HAS HECHO CLICK");
						PhotosPanel pf = (PhotosPanel) e.getComponent();
						int x = e.getX();
						int y = e.getY();
						ProductPanelInfo pi = (ProductPanelInfo) pf.getComponentAt(x, y);
						new ProductWindow(pi.getRoute());
					}
				});
				scroll = new JScrollPane(PanelCentre);
				contentPane.add(scroll, BorderLayout.CENTER);
				contentPane.updateUI();
			}
		});

		JMenuItem sweatShirt = new JMenuItem("Sudaderas");
		sweatShirt.setFont(new Font("Times", Font.PLAIN, 13));
		Female.add(sweatShirt);
		sweatShirt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				type = "Sudadera";
				contentPane.remove(scroll);
				try {
					PanelCentre = new PhotosPanel(gender, type, "");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PanelCentre.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("HAS HECHO CLICK");
						PhotosPanel pf = (PhotosPanel) e.getComponent();
						int x = e.getX();
						int y = e.getY();
						ProductPanelInfo pi = (ProductPanelInfo) pf.getComponentAt(x, y);
						new ProductWindow(pi.getRoute());
					}
				});
				scroll = new JScrollPane(PanelCentre);
				contentPane.add(scroll, BorderLayout.CENTER);
				contentPane.updateUI();
			}
		});

		JMenuItem glasses = new JMenuItem("Gafas");
		glasses.setFont(new Font("Times", Font.PLAIN, 13));
		Female.add(glasses);
		glasses.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				type = "Gafa";
				contentPane.remove(scroll);
				try {
					PanelCentre = new PhotosPanel(gender, type, "");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PanelCentre.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("HAS HECHO CLICK");
						PhotosPanel pf = (PhotosPanel) e.getComponent();
						int x = e.getX();
						int y = e.getY();
						ProductPanelInfo pi = (ProductPanelInfo) pf.getComponentAt(x, y);
						new ProductWindow(pi.getRoute());
					}
				});
				scroll = new JScrollPane(PanelCentre);
				contentPane.add(scroll, BorderLayout.CENTER);
				contentPane.updateUI();
			}
		});

		JMenuItem jewells = new JMenuItem("Bisutería");
		jewells.setFont(new Font("Times", Font.PLAIN, 13));
		Female.add(jewells);
		jewells.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				type = "Bisuteria";
				contentPane.remove(scroll);
				try {
					PanelCentre = new PhotosPanel(gender, type, "");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PanelCentre.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("HAS HECHO CLICK");
						PhotosPanel pf = (PhotosPanel) e.getComponent();
						int x = e.getX();
						int y = e.getY();
						ProductPanelInfo pi = (ProductPanelInfo) pf.getComponentAt(x, y);
						new ProductWindow(pi.getRoute());
					}
				});
				scroll = new JScrollPane(PanelCentre);
				contentPane.add(scroll, BorderLayout.CENTER);
				contentPane.updateUI();
			}
		});
		JMenu Male = new JMenu("HOMBRE");
		Male.setFont(new Font("Times", Font.PLAIN, 13));
		MenuBar.add(Male);
		Male.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				gender = "Masculino";
			}
		});

		JMenuItem mntmCamisetaHombre = new JMenuItem("Camisetas");
		mntmCamisetaHombre.setFont(new Font("Times", Font.PLAIN, 13));
		Male.add(mntmCamisetaHombre);

		/*
		 * String colours[] =
		 * {"Blanco","Rojo","Azul","Rosa","Negro","Gris","Marrón","Burdeos"};
		 * 
		 * 
		 * JComboBox comboBoxColor = new JComboBox(colours); PanelUp.add(comboBoxColor);
		 * comboBoxColor.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 * method stub contentPane.remove(scroll); try { PanelCentre = new
		 * PhotosPanel(gender,type,String.valueOf(comboBoxColor.getSelectedItem())); }
		 * catch (Exception e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } PanelCentre.addMouseListener(new MouseListener() {
		 * 
		 * @Override public void mouseReleased(MouseEvent e) { // TODO Auto-generated
		 * method stub
		 * 
		 * }
		 * 
		 * @Override public void mousePressed(MouseEvent e) { // TODO Auto-generated
		 * method stub
		 * 
		 * }
		 * 
		 * @Override public void mouseExited(MouseEvent e) { // TODO Auto-generated
		 * method stub
		 * 
		 * }
		 * 
		 * @Override public void mouseEntered(MouseEvent e) { // TODO Auto-generated
		 * method stub
		 * 
		 * }
		 * 
		 * @Override public void mouseClicked(MouseEvent e) {
		 * System.out.println("HAS HECHO CLICK"); PhotosPanel pf =
		 * (PhotosPanel)e.getComponent(); int x = e.getX(); int y = e.getY();
		 * ProductPanelInfo pi = (ProductPanelInfo)pf.getComponentAt(x, y); new
		 * ProductWindow(pi.getRoute()); } }); scroll = new JScrollPane(PanelCentre);
		 * contentPane.add(scroll, BorderLayout.CENTER); contentPane.updateUI(); } });
		 * 
		 */

		mntmCamisetaHombre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				type = "Camiseta";
				contentPane.remove(scroll);
				try {
					PanelCentre = new PhotosPanel(gender, type, "");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PanelCentre.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("HAS HECHO CLICK");
						PhotosPanel pf = (PhotosPanel) e.getComponent();
						int x = e.getX();
						int y = e.getY();
						ProductPanelInfo pi = (ProductPanelInfo) pf.getComponentAt(x, y);
						new ProductWindow(pi.getRoute());
					}
				});
				scroll = new JScrollPane(PanelCentre);
				contentPane.add(scroll, BorderLayout.CENTER);
				contentPane.updateUI();
			}
		});

		JMenuItem mtmShirts = new JMenuItem("Camisas");
		mtmShirts.setFont(new Font("Times", Font.PLAIN, 13));
		Male.add(mtmShirts);
		mtmShirts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				type = "Camisa";
				contentPane.remove(scroll);
				try {
					PanelCentre = new PhotosPanel(gender, type, "");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PanelCentre.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("HAS HECHO CLICK");
						PhotosPanel pf = (PhotosPanel) e.getComponent();
						int x = e.getX();
						int y = e.getY();
						ProductPanelInfo pi = (ProductPanelInfo) pf.getComponentAt(x, y);
						new ProductWindow(pi.getRoute());
					}
				});
				scroll = new JScrollPane(PanelCentre);
				contentPane.add(scroll, BorderLayout.CENTER);
				contentPane.updateUI();
			}
		});

		JMenuItem mtnSweatshirt = new JMenuItem("Sudaderas");
		mtnSweatshirt.setFont(new Font("Times", Font.PLAIN, 13));
		Male.add(mtnSweatshirt);
		mtnSweatshirt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				type = "Sudadera";
				contentPane.remove(scroll);
				try {
					PanelCentre = new PhotosPanel(gender, type, "");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PanelCentre.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("HAS HECHO CLICK");
						PhotosPanel pf = (PhotosPanel) e.getComponent();
						int x = e.getX();
						int y = e.getY();
						ProductPanelInfo pi = (ProductPanelInfo) pf.getComponentAt(x, y);
						new ProductWindow(pi.getRoute());
					}
				});
				scroll = new JScrollPane(PanelCentre);
				contentPane.add(scroll, BorderLayout.CENTER);
				contentPane.updateUI();
			}
		});

		JMenuItem Bracelet = new JMenuItem("Pulseras");
		Bracelet.setFont(new Font("Times", Font.PLAIN, 13));
		Male.add(Bracelet);
		Bracelet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				type = "Pulsera";
				contentPane.remove(scroll);
				try {
					PanelCentre = new PhotosPanel(gender, type, "");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PanelCentre.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("HAS HECHO CLICK");
						PhotosPanel pf = (PhotosPanel) e.getComponent();
						int x = e.getX();
						int y = e.getY();
						ProductPanelInfo pi = (ProductPanelInfo) pf.getComponentAt(x, y);
						new ProductWindow(pi.getRoute());
					}
				});
				scroll = new JScrollPane(PanelCentre);
				contentPane.add(scroll, BorderLayout.CENTER);
				contentPane.updateUI();
			}
		});

		JMenuItem Cap = new JMenuItem("Gorras");
		Cap.setFont(new Font("Times", Font.PLAIN, 13));
		Male.add(Cap);
		JButton btnVolver = new JButton("Volver");
		btnVolver.setHorizontalAlignment(SwingConstants.TRAILING);
		PanelUp.add(btnVolver);
		btnVolver.setFont(new Font("Times", Font.PLAIN, 13));
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ProductsWindow.this.setVisible(false);
				HomeWindow hw = new HomeWindow(email);
				hw.setVisible(true);
			}
		});
		Cap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				type = "Gorra";
				contentPane.remove(scroll);
				try {
					PanelCentre = new PhotosPanel(gender, type, "");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PanelCentre.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("HAS HECHO CLICK");
						PhotosPanel pf = (PhotosPanel) e.getComponent();
						int x = e.getX();
						int y = e.getY();
						ProductPanelInfo pi = (ProductPanelInfo) pf.getComponentAt(x, y);
						new ProductWindow(pi.getRoute());
					}
				});
				scroll = new JScrollPane(PanelCentre);
				contentPane.add(scroll, BorderLayout.CENTER);
				contentPane.updateUI();
			}
		});

		PanelCentre = new PanelInformation();

		scroll = new JScrollPane(PanelCentre);
		contentPane.add(scroll, BorderLayout.CENTER);
		setVisible(true);

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

}