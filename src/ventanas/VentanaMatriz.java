package ventanas;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import controladores.VentanaMatrizControlador;

@SuppressWarnings("serial")
public class VentanaMatriz extends JFrame {
	public VentanaMatriz() {
	}

	private JScrollPane scrollPane;
	private JTable table;
	private JLabel[] labelsFilas;
	private JLabel[] labelsColumnas;
	private JButton btnSuma;
	private File imagen;
	private Image icono;
	private JLabel lblx;

	/**
	 * Create the application.
	 */
	public void iniciarFacil() {
		getContentPane().setBackground(new Color(163, 200, 211));
		setBounds(100, 100, 550, 490);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//Cargar icono y titulo de ventana
		try {
			imagen = new File("C:\\Users\\ftbar\\eclipse-workspace\\trabajo-practico-1-programacion-3\\imagenes\\icono.png");
			icono = ImageIO.read(imagen);
			setIconImage(icono);
		} catch (Exception e) {
			System.out.println("Error cargando imagen: " + e.getMessage());
		}
		setTitle("Puzzles Aritmeticos");
		setLocationRelativeTo(null); //Centra la ventana en pantalla
		setResizable(false);
		
		JLabel lblMatriz = new JLabel("MATRIZ");
		lblMatriz.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatriz.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMatriz.setBounds(0, 22, 534, 32);
		getContentPane().add(lblMatriz);
		
		lblx = new JLabel("4x4");
		lblx.setHorizontalAlignment(SwingConstants.CENTER);
		lblx.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblx.setBounds(0, 51, 534, 32);
		getContentPane().add(lblx);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(149, 94, 238, 241);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 24));
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Integer[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		// Cosas aniadidas manualmente para mejorar lo visual de la Table
		table.getTableHeader().setVisible(false);
		table.setRowHeight(60);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
		    table.getColumnModel().getColumn(i).setPreferredWidth(60);
		    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
		scrollPane.setColumnHeaderView(table);
		
		labelsFilas = new JLabel[4];
		labelsColumnas = new JLabel[4];
		//Estas son las sumas, el numero puede ser modificado manualmente con labelname.setText("nuevo valor").
		labelsFilas[0] = new JLabel("5");
		labelsFilas[0].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[0].setBounds(410, 100, 40, 50);
		getContentPane().add(labelsFilas[0]);
		
		labelsFilas[1] = new JLabel("7");
		labelsFilas[1].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[1].setBounds(410, 160, 40, 50);
		getContentPane().add(labelsFilas[1]);
		
		labelsFilas[2] = new JLabel("12");
		labelsFilas[2].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[2].setBounds(410, 220, 40, 50);
		getContentPane().add(labelsFilas[2]);
		
		labelsFilas[3] = new JLabel("7");
		labelsFilas[3].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[3].setBounds(410, 280, 40, 50);
		getContentPane().add(labelsFilas[3]);
		
		labelsColumnas[0] = new JLabel("7");
		labelsColumnas[0].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[0].setBounds(175, 335, 40, 50);
		getContentPane().add(labelsColumnas[0]);
		
		labelsColumnas[1] = new JLabel("9");
		labelsColumnas[1].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[1].setBounds(235, 335, 40, 50);
		getContentPane().add(labelsColumnas[1]);
		
		labelsColumnas[2] = new JLabel("9");
		labelsColumnas[2].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[2].setBounds(295, 335, 40, 50);
		getContentPane().add(labelsColumnas[2]);
		
		labelsColumnas[3] = new JLabel("6");
		labelsColumnas[3].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[3].setBounds(355, 335, 40, 50);
		getContentPane().add(labelsColumnas[3]);
		
		btnSuma = new JButton("Suma");
		btnSuma.setBounds(414, 398, 110, 40);
		getContentPane().add(btnSuma);
		
		
		
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!VentanaMatrizControlador.noHayVacias(table)) {
					JOptionPane.showMessageDialog(null, "Hay celdas vacias");
				} else {
					boolean verif = true;
					for (int i = 0; i < table.getRowCount(); i++) {
						verif = verif && VentanaMatrizControlador.filaSumaResultado(table, labelsFilas, i) && 
								VentanaMatrizControlador.columnaSumaResultado(table, labelsColumnas, i);
					}
					if (verif) {
						JOptionPane.showMessageDialog(null, "Correcto");
					} else {
						JOptionPane.showMessageDialog(null, "Incorrecto");
					}
				}
			}
		});

		
	}

	public void iniciarMedio() {
		getContentPane().setBackground(new Color(163, 200, 211));
		setBounds(100, 100, 610, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//Cargar icono y titulo de ventana
		try {
			imagen = new File("C:\\Users\\ftbar\\eclipse-workspace\\trabajo-practico-1-programacion-3\\imagenes\\icono.png");
			icono = ImageIO.read(imagen);
			setIconImage(icono);
		} catch (Exception e) {
			System.out.println("Error cargando imagen: " + e.getMessage());
		}
		setTitle("Puzzles Aritmeticos");
		setLocationRelativeTo(null); //Centra la ventana en pantalla
		setResizable(false);
		
		JLabel lblMatriz = new JLabel("MATRIZ");
		lblMatriz.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatriz.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMatriz.setBounds(0, 22, 594, 32);
		getContentPane().add(lblMatriz);
		
		lblx = new JLabel("5x5");
		lblx.setHorizontalAlignment(SwingConstants.CENTER);
		lblx.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblx.setBounds(0, 51, 594, 32);
		getContentPane().add(lblx);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 94, 298, 301);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 24));
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Integer[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		// Cosas aniadidas manualmente para mejorar lo visual de la Table
		table.getTableHeader().setVisible(false);
		table.setRowHeight(60);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
		    table.getColumnModel().getColumn(i).setPreferredWidth(40);
		    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
		scrollPane.setColumnHeaderView(table);
		
		labelsFilas = new JLabel[5];
		labelsColumnas = new JLabel[5];
		//Estas son las sumas, el numero puede ser modificado manualmente con labelname.setText("nuevo valor").
		labelsFilas[0] = new JLabel("5");
		labelsFilas[0].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[0].setBounds(455, 100, 40, 50);
		getContentPane().add(labelsFilas[0]);
		
		labelsFilas[1] = new JLabel("7");
		labelsFilas[1].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[1].setBounds(455, 160, 40, 50);
		getContentPane().add(labelsFilas[1]);
		
		labelsFilas[2] = new JLabel("12");
		labelsFilas[2].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[2].setBounds(455, 220, 40, 50);
		getContentPane().add(labelsFilas[2]);
		
		labelsFilas[3] = new JLabel("7");
		labelsFilas[3].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[3].setBounds(455, 280, 40, 50);
		getContentPane().add(labelsFilas[3]);
		
		labelsFilas[4] = new JLabel("5");
		labelsFilas[4].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[4].setBounds(455, 340, 40, 50);
		getContentPane().add(labelsFilas[4]);
		
		labelsColumnas[0] = new JLabel("7");
		labelsColumnas[0].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[0].setBounds(175, 390, 40, 50);
		getContentPane().add(labelsColumnas[0]);
		
		labelsColumnas[1] = new JLabel("9");
		labelsColumnas[1].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[1].setBounds(235, 390, 40, 50);
		getContentPane().add(labelsColumnas[1]);
		
		labelsColumnas[2] = new JLabel("9");
		labelsColumnas[2].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[2].setBounds(295, 390, 40, 50);
		getContentPane().add(labelsColumnas[2]);
		
		labelsColumnas[3] = new JLabel("6");
		labelsColumnas[3].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[3].setBounds(355, 390, 40, 50);
		getContentPane().add(labelsColumnas[3]);
		
		labelsColumnas[4] = new JLabel("9");
		labelsColumnas[4].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[4].setBounds(415, 390, 40, 50);
		getContentPane().add(labelsColumnas[4]);
		
		btnSuma = new JButton("Suma");
		btnSuma.setBounds(474, 458, 110, 40);
		getContentPane().add(btnSuma);
		
		
		
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!VentanaMatrizControlador.noHayVacias(table)) {
					JOptionPane.showMessageDialog(null, "Hay celdas vacias");
				} else {
					boolean verif = true;
					for (int i = 0; i < table.getRowCount(); i++) {
						verif = verif && VentanaMatrizControlador.filaSumaResultado(table, labelsFilas, i) && 
								VentanaMatrizControlador.columnaSumaResultado(table, labelsColumnas, i);
					}
					if (verif) {
						JOptionPane.showMessageDialog(null, "Correcto");
					} else {
						JOptionPane.showMessageDialog(null, "Incorrecto");
					}
				}
			}
		});

		
	}

	public void iniciarDificil() {
		getContentPane().setBackground(new Color(163, 200, 211));
		setBounds(100, 100, 670, 610);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//Cargar icono y titulo de ventana
		try {
			imagen = new File("C:\\Users\\ftbar\\eclipse-workspace\\trabajo-practico-1-programacion-3\\imagenes\\icono.png");
			icono = ImageIO.read(imagen);
			setIconImage(icono);
		} catch (Exception e) {
			System.out.println("Error cargando imagen: " + e.getMessage());
		}
		setTitle("Puzzles Aritmeticos");
		setLocationRelativeTo(null); //Centra la ventana en pantalla
		setResizable(false);
		
		JLabel lblMatriz = new JLabel("MATRIZ");
		lblMatriz.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatriz.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMatriz.setBounds(0, 22, 654, 32);
		getContentPane().add(lblMatriz);
		
		lblx = new JLabel("6x6");
		lblx.setHorizontalAlignment(SwingConstants.CENTER);
		lblx.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblx.setBounds(0, 51, 654, 32);
		getContentPane().add(lblx);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 94, 358, 361);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 24));
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Integer[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New columns"
			}
		));
		// Cosas aniadidas manualmente para mejorar lo visual de la Table
		table.getTableHeader().setVisible(false);
		table.setRowHeight(60);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
		    table.getColumnModel().getColumn(i).setPreferredWidth(40);
		    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
		scrollPane.setColumnHeaderView(table);
		
		labelsFilas = new JLabel[6];
		labelsColumnas = new JLabel[6];
		//Estas son las sumas, el numero puede ser modificado manualmente con labelname.setText("nuevo valor").
		labelsFilas[0] = new JLabel("5");
		labelsFilas[0].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[0].setBounds(515, 100, 40, 50);
		getContentPane().add(labelsFilas[0]);
		
		labelsFilas[1] = new JLabel("7");
		labelsFilas[1].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[1].setBounds(515, 160, 40, 50);
		getContentPane().add(labelsFilas[1]);
		
		labelsFilas[2] = new JLabel("12");
		labelsFilas[2].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[2].setBounds(515, 220, 40, 50);
		getContentPane().add(labelsFilas[2]);
		
		labelsFilas[3] = new JLabel("7");
		labelsFilas[3].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[3].setBounds(515, 280, 40, 50);
		getContentPane().add(labelsFilas[3]);
		
		labelsFilas[4] = new JLabel("5");
		labelsFilas[4].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[4].setBounds(515, 340, 40, 50);
		getContentPane().add(labelsFilas[4]);
		
		labelsFilas[5] = new JLabel("9");
		labelsFilas[5].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[5].setBounds(515, 400, 40, 50);
		getContentPane().add(labelsFilas[5]);
		
		labelsColumnas[0] = new JLabel("7");
		labelsColumnas[0].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[0].setBounds(175, 450, 40, 50);
		getContentPane().add(labelsColumnas[0]);
		
		labelsColumnas[1] = new JLabel("9");
		labelsColumnas[1].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[1].setBounds(235, 450, 40, 50);
		getContentPane().add(labelsColumnas[1]);
		
		labelsColumnas[2] = new JLabel("9");
		labelsColumnas[2].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[2].setBounds(295, 450, 40, 50);
		getContentPane().add(labelsColumnas[2]);
		
		labelsColumnas[3] = new JLabel("6");
		labelsColumnas[3].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[3].setBounds(355, 450, 40, 50);
		getContentPane().add(labelsColumnas[3]);
		
		labelsColumnas[4] = new JLabel("9");
		labelsColumnas[4].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[4].setBounds(415, 450, 40, 50);
		getContentPane().add(labelsColumnas[4]);
		
		labelsColumnas[5] = new JLabel("12");
		labelsColumnas[5].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[5].setBounds(475, 450, 40, 50);
		getContentPane().add(labelsColumnas[5]);
		
		btnSuma = new JButton("Suma");
		btnSuma.setBounds(534, 518, 110, 40);
		getContentPane().add(btnSuma);
		
		
		
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!VentanaMatrizControlador.noHayVacias(table)) {
					JOptionPane.showMessageDialog(null, "Hay celdas vacias");
				} else {
					boolean verif = true;
					for (int i = 0; i < table.getRowCount(); i++) {
						verif = verif && VentanaMatrizControlador.filaSumaResultado(table, labelsFilas, i) && 
								VentanaMatrizControlador.columnaSumaResultado(table, labelsColumnas, i);
					}
					if (verif) {
						JOptionPane.showMessageDialog(null, "Correcto");
					} else {
						JOptionPane.showMessageDialog(null, "Incorrecto");
					}
				}
			}
		});

		
	}
}
