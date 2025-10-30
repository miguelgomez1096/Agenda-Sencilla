/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author migue
 */
import java.sql.*;
public class Controlador {
    
    //contraseña y usuario 
    String usuario = "root";
    String contrasena = ""; 
    String url = "jdbc:mysql://localhost:3306/agenda_datos";
    Connection con = null;

    
    //conectar base de datos 
    public Connection conectar() {
        try {
            con = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión correcta");
            return con;
        } catch (Exception e) {
            System.out.println("Conexión incorrecta");
            return null;
        }
    }
   
    
    //agregar usuario 
    public void agregar_usuario(String nombres, String apellidos, String telefono, String direccion, String ciudad, String gmail) {
        Connection con = conectar();
        String query = "INSERT INTO profesores(id,nombre,apellido,celular,direccion,ciudad,gmail) VALUES (null,'" + nombres + "','" + apellidos + "','" + telefono + "','" + direccion + "','" + ciudad + "','" + gmail + "');";
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            preparar.executeUpdate();
            System.out.println("Consulta correcta");
        } catch (SQLException ex) {
            System.out.println("Error en la consulta");
        }
    }

    
    //consultar profesores 
    public void consultar_profesores(DefaultTableModel modelo) {
        modelo.setRowCount(0); // limpiar tabla
        Connection con = conectar();
        String query = "SELECT * FROM profesores;";
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();
            while (resultado.next()) {
                modelo.addRow(new Object[]{
                    resultado.getInt("id"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("direccion"),
                    resultado.getString("celular"),
                    resultado.getString("gmail"),
                    resultado.getString("ciudad")
                });
            }
        } catch (SQLException ex) {
            System.out.println("Error en el sql");
        }
    }
}


