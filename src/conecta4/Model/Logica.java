/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecta4.Model;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 *
 * @author Christian M. Caceres
 */
public class Logica {

    public int contadorTurno = 0;
    public boolean finJuego;
    public JFrame container;
    public String ro = "Rojo";
    public String am = "Amarillo";
    //botones
    public JButton[][] matrizBoton;
    //imagenes
    public ImageIcon img1; //Ficha roja
    public ImageIcon img2; //Ficha Amarilla
    public ImageIcon img3; //Ficha en blanco

    public Logica() {
        matrizBoton = new JButton[6][7];
        img1 = new ImageIcon("foto1.png");
        img2 = new ImageIcon("foto2.png");
        img3 = new ImageIcon("foto3.png");
    }

    //==========  determinar las cuatro fichas en linea  ==========
    public void CuatroEnLinea(int x, int y) {
        /*
		 *	x --> fila 
		 *	y --> columna
         */
        finJuego = false;
        //==========    Encontrar cuatro en linea horizontal    -   ===========
        int ganar1 = 0;
        int ganar2 = 0;
        for (int j = 0; j < 7; j++) {
            if (matrizBoton[y][j].getIcon() != img3) {
                if (matrizBoton[y][j].getIcon().equals(img1)) {
                    ganar1++;
                } else {
                    ganar1 = 0;
                }
                if (ganar1 == 4) {
                    MsgWin(ro, img1);
                    finJuego = true;
                }
                if (finJuego != true) {
                    if (matrizBoton[y][j].getIcon().equals(img2)) {
                        ganar2++;
                    } else {
                        ganar2 = 0;
                    }
                    if (ganar2 == 4) {
                        MsgWin(am, img2);
                    }
                }
            } else {
                ganar1 = 0;
                ganar2 = 0;
            }
        }
        //==========   Encontrar cuatro en linea vertical |      ================
        ganar1 = 0;
        ganar2 = 0;
        for (int i = 0; i < 6; i++) {
            if (matrizBoton[i][x].getIcon() != img3) {
                if (matrizBoton[i][x].getIcon().equals(img1)) {
                    ganar1++;
                } else {
                    ganar1 = 0;
                }
                if (ganar1 == 4) {
                    MsgWin(ro, img1);
                    finJuego = true;
                }
                if (finJuego != true) {
                    if (matrizBoton[i][x].getIcon().equals(img2)) {
                        ganar2++;
                    } else {
                        ganar2 = 0;
                    }
                    if (ganar2 == 4) {
                        MsgWin(am, img2);
                    }
                }
            }
        }
        //========== Encontrar cuatro en linea Horizontal De izquierda am derecha /  ===========
        ganar1 = 0;
        ganar2 = 0;
        int a = y;
        int b = x;
        while (b > 0 && a > 0) {
            a--;
            b--;
        }
        while (b < 6 && a < 6) {
            if (matrizBoton[a][b].getIcon() != img3) {
                if (matrizBoton[a][b].getIcon().equals(img1)) {
                    ganar1++;
                } else {
                    ganar1 = 0;
                }
                if (ganar1 == 4) {
                    MsgWin(ro, img1);
                    finJuego = true;
                }
                if (finJuego != true) {
                    if (matrizBoton[a][b].getIcon().equals(img2)) {
                        ganar2++;
                    } else {
                        ganar2 = 0;
                    }
                    if (ganar2 == 4) {
                        MsgWin(am, img2);
                    }
                }
            } else {
                ganar1 = 0;
                ganar2 = 0;
            }
            a++;
            b++;
        }
        //========== Encontrar cuatro en linea Horizontal de derecha am izquierda \  ===========
        ganar1 = 0;
        ganar2 = 0;
        a = y;
        b = x;
        //buscar posición de la esquina
        while (b < 5 && a > 0) {
            a--;
            b++;
        }
        while (b > -1 && a < 6) {
            if (matrizBoton[a][b].getIcon() != img3) {
                if (matrizBoton[a][b].getIcon().equals(img1)) {
                    ganar1++;
                } else {
                    ganar1 = 0;
                }
                if (ganar1 == 4) {
                    MsgWin(ro, img1);
                    finJuego = true;
                }
                if (finJuego != true) {
                    if (matrizBoton[a][b].getIcon().equals(img2)) {
                        ganar2++;
                    } else {
                        ganar2 = 0;
                    }
                    if (ganar2 == 4) {
                        MsgWin(am, img2);
                    }
                }
            } else {
                ganar1 = 0;
                ganar2 = 0;
            }
            a++;
            b--;
        }
    }

    //==========     Volver el juego al estado inicial   ==========	
    public void VolverEmpezar() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                matrizBoton[i][j].setIcon(img3);
            }
        }
        contadorTurno = 0;
    }

    //==========       Mensaje que anuncia el ganador    ==========
    public void MsgWin(String color, ImageIcon ima) {
        int opcion = JOptionPane.showConfirmDialog(container, "¡¡Gana Jugador " + color + " !!" + "\nDesea Iniciar una nueva partida?", "Conecta 4", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, ima);
        switch (opcion) {
            case JOptionPane.YES_OPTION:
                VolverEmpezar();
                break;
            case JOptionPane.NO_OPTION:
                System.exit(0);
                break;
            default:
                System.exit(0);
        }
    }
}
