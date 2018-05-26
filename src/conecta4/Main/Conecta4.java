/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecta4.Main;

import conecta4.View.Tablero;

/**
 *
 * @author Lenovo
 */
public class Conecta4 {

    public static void main(String[] args) {
        try {
            new Tablero();
        } catch (Exception error) {
            System.out.println(error);
        }

    }
}
