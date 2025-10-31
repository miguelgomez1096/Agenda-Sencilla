/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package Main;

import Vista.interfaz; 

public class AgendaSencilla {
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error en LookAndFeel: " + e.getMessage());
        }

        java.awt.EventQueue.invokeLater(() -> {
            interfaz vista = new interfaz(); // Usa el nombre exacto
            vista.setVisible(true);
        });
    }
}  

