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

import Data.DB;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ProductsWindow extends JFrame {

	private JPanel contentPane, PanelCentre;
	private JFrame ventanaAnterior;
	private String gender, type;
	private JScrollPane scroll;
	private JPanel panelWest;
	private JPanel panelEast;

	public ProductsWindow(String email) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JFrame v = this;

		JPanel PanelUp = new JPanel();
		PanelUp.setBackground(Color.WHITE);
		contentPane.add(PanelUp, BorderLayout.NORTH);
		PanelUp.setLayout(new BorderLayout(0, 0));

		panelWest = new JPanel();
		PanelUp.add(panelWest, BorderLayout.WEST);
		panelWest.setBackground(Color.WHITE);

		panelEast = new JPanel();
		PanelUp.add(panelEast, BorderLayout.EAST);
		panelEast.setBackground(Color.WHITE);

		try {
			DB.getConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JMenuBar MenuBar = new JMenuBar();
		panelWest.add(MenuBar);

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
				gender = "Femenino";
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
						new ProductWindow(pi.getRoute(), v);
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
				gender = "Femenino";
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
						new ProductWindow(pi.getRoute(), v);
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
				gender = "Femenino";
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
						new ProductWindow(pi.getRoute(), v);
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
				gender = "Femenino";
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
						new ProductWindow(pi.getRoute(), v);
					}
				});
				scroll = new JScrollPane(PanelCentre);
				contentPane.add(scroll, BorderLayout.CENTER);
				contentPane.updateUI();
			}
		});

		JMenuItem jewells = new JMenuItem("Bolsos");
		jewells.setFont(new Font("Times", Font.PLAIN, 13));
		Female.add(jewells);
		jewells.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gender = "Femenino";
				type = "Bolso";
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
						new ProductWindow(pi.getRoute(), v);
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

		String colours[] = { "Blanco", "Rojo", "Azul", "Rosa", "Negro", "Gris", "Marrón", "Burdeos" };

		mntmCamisetaHombre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gender = "Masculino";
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
						new ProductWindow(pi.getRoute(), v);
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
				gender = "Masculino";
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
						new ProductWindow(pi.getRoute(), v);
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
				gender = "Masculino";
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
						new ProductWindow(pi.getRoute(), v);
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
				gender = "Masculino";
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
						new ProductWindow(pi.getRoute(), v);
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

		JButton btncart = new JButton(new ImageIcon("photos/cart.png"));
		btncart.setToolTipText("Carrito");
		btncart.setBorder(null);
		panelEast.add(btncart);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setHorizontalAlignment(SwingConstants.TRAILING);
		btnVolver.setBorder(null);
		panelEast.add(btnVolver);
		btnVolver.setFont(new Font("Times", Font.BOLD, 13));

		JPanel panelCentre = new JPanel();
		panelCentre.setBackground(Color.WHITE);
		PanelUp.add(panelCentre, BorderLayout.CENTER);

		JLabel lblfilters = new JLabel("FILTROS");
		panelCentre.add(lblfilters);

		lblfilters.setFont(new Font("Times", Font.PLAIN, 13));

		JComboBox comboBoxColor = new JComboBox(colours);
		comboBoxColor.setBackground(Color.WHITE);
		panelCentre.add(comboBoxColor);
		comboBoxColor.setFont(new Font("Times", Font.PLAIN, 13));

		comboBoxColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				contentPane.remove(scroll);
				try {
					PanelCentre = new PhotosPanel(gender, type, String.valueOf(comboBoxColor.getSelectedItem()));
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
						new ProductWindow(pi.getRoute(), v);
					}
				});

				scroll = new JScrollPane(PanelCentre);
				contentPane.add(scroll, BorderLayout.CENTER);
				contentPane.updateUI();
			}

		});
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
				gender = "Masculino";
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
						new ProductWindow(pi.getRoute(), v);
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