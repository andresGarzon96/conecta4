/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecta4.View;

/**
 *
 * @author Christian M. Caceres
 */
import conecta4.Model.Logica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tablero extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Menus
	JMenuBar barraMenu = new JMenuBar();
	JMenu menuOpciones = new JMenu("Opciones");
	JMenuItem itemNuevaPartida = new JMenuItem("Nueva Partida");
	JMenuItem ItemSalir = new JMenuItem("Salir");

	Logica logi;

	// interfaz
	public Tablero() {

		logi = new Logica();

		// Agregar Informacion ala barra de menu
		itemNuevaPartida.addActionListener(this);
		menuOpciones.add(itemNuevaPartida);
		menuOpciones.addSeparator();
		ItemSalir.addActionListener(this);
		menuOpciones.add(ItemSalir);
		barraMenu.add(menuOpciones);
		setJMenuBar(barraMenu);

		// Panel Principal
		JPanel Principal = new JPanel();
		Principal.setLayout(new GridLayout(6, 7));

		// Colocar Matriz Botones
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {

				logi.matrizBoton[i][j] = new JButton();
				logi.matrizBoton[i][j].addActionListener(this);
				logi.matrizBoton[i][j].setBackground(Color.BLUE);
				logi.matrizBoton[i][j].setIcon(logi.img3);
				Principal.add(logi.matrizBoton[i][j]);
			}
			add(Principal, "Center");
		}
		// Para que al cerrar la ventana detenga la App
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		// Tamaño jframe
		setLocation(250, 40);
		setSize(600, 600);
		setResizable(false);
		setTitle("CONECTA 4");
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == ItemSalir) {
			int opcion = JOptionPane.showConfirmDialog(this, "¿Esta seguro que Desea \nabandonar la partida?",
					"Conecta 4", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			switch (opcion) {
			case JOptionPane.YES_OPTION:
				dispose();
				break;
			case JOptionPane.NO_OPTION:
			default:
			}
		}
		if (ae.getSource() == itemNuevaPartida) {
			int opcion = JOptionPane.showConfirmDialog(this, "¿Esta seguro que Desea \nIniciar una nueva partida?",
					"Conecta 4", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			switch (opcion) {
			case JOptionPane.YES_OPTION:
				logi.VolverEmpezar();
				break;
			case JOptionPane.NO_OPTION:
			default:
			}
		}
		int x = 0;
		int y = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (ae.getSource() == logi.matrizBoton[i][j]) {
					// Ir hasta la ultima posicion
					int k = 6;
					do {
						k--;
					} while (logi.matrizBoton[k][j].getIcon() != logi.img3 & k != 0);
					// Pintar Ficha
					if (logi.matrizBoton[k][j].getIcon() == logi.img3) {

						if (logi.contadorTurno % 2 == 0) {
							logi.matrizBoton[k][j].setIcon(logi.img1);
						} else {
							logi.matrizBoton[k][j].setIcon(logi.img2);
						}
						logi.contadorTurno++;
						x = j;
						y = k;
					}
				}
			}
		}
		logi.CuatroEnLinea(x, y);

		// Empate
		if (logi.contadorTurno == 42) {
			int opcion = JOptionPane.showConfirmDialog(this, "¡¡Han Empatado!!\nDesea Iniciar una nueva partida?",
					"Conecta 4", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			switch (opcion) {
			case JOptionPane.YES_OPTION:
				logi.VolverEmpezar();
				break;
			case JOptionPane.NO_OPTION:
				break;
			default:
				System.exit(0);
			}
		}
		logi.finJuego = false;
	}
}
