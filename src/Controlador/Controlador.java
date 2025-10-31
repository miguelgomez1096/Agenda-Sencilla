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
    
//funciones de busqueda
    //listar campo en especifico 
    public void listarCampo(DefaultTableModel modelo, String campo) {
        modelo.setRowCount(0);
        Connection con = conectar();
        String query = "SELECT " + campo + " FROM profesores";
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();
            while (resultado.next()) {
                modelo.addRow(new Object[]{resultado.getString(campo)});
            }
        } catch (SQLException ex) {
            System.out.println("Error en listarCampo: " + ex.getMessage());
        }
    }

    //funciones letras 
         //buscar con nombre 
    public void buscar_nombre(DefaultTableModel modelo, String nombre) {
        modelo.setRowCount(0);
        Connection con = conectar();
        String query = "SELECT * FROM profesores WHERE nombre LIKE '" + nombre + "%' OR apellido LIKE '" + nombre + "%'";
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
            System.out.println("Error en buscar_nombre: " + ex.getMessage());
        }
    }

         //buscar apellido 
    public void buscar_apellido(DefaultTableModel modelo, String apellido) {
        modelo.setRowCount(0);
        Connection con = conectar();
        String query = "SELECT * FROM profesores WHERE apellido LIKE '" + apellido + "%'";
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
            System.out.println("Error en buscar_apellido: " + ex.getMessage());
        }
    }

         //listar alfabeticamente 
    public void listar_alfabeticamente(DefaultTableModel modelo) {
        modelo.setRowCount(0);
        Connection con = conectar();
        String query = "SELECT * FROM profesores ORDER BY nombre ASC";
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
            System.out.println("Error en listar_alfabeticamente: " + ex.getMessage());
        }
    }

         //listar ciudad 
    public void listar_ciudad(DefaultTableModel modelo, String ciudad) {
        modelo.setRowCount(0);
        Connection con = conectar();
        String query = "SELECT * FROM profesores WHERE direccion LIKE '%" + ciudad + "%'";
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
            System.out.println("Error en listar_ciudad: " + ex.getMessage());
        }
    }

         //listar calles 
    public void listar_calles(DefaultTableModel modelo) {
        modelo.setRowCount(0);
        Connection con = conectar();
        String query = "SELECT * FROM profesores WHERE direccion LIKE 'Cl%'";
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
            System.out.println("Error en listar_calles: " + ex.getMessage());
        }
    }

         //listar carreras
    public void listar_carreras(DefaultTableModel modelo) {
        modelo.setRowCount(0);
        Connection con = conectar();
        String query = "SELECT * FROM profesores WHERE direccion LIKE 'Cra%'";
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
            System.out.println("Error en listar_carreras: " + ex.getMessage());
        }
    }

   //funciones numeros  
         //buscar por id 
    public void buscarPorID(DefaultTableModel modelo, int id) {
        modelo.setRowCount(0);
        Connection con = conectar();
        String query = "SELECT * FROM profesores WHERE id = " + id;
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
            System.out.println("Error en buscarPorID: " + ex.getMessage());
        }
    }

   //listar id pares 
    public void listar_ID_par(DefaultTableModel modelo) {
        modelo.setRowCount(0);
        Connection con = conectar();
        String query = "SELECT * FROM profesores WHERE MOD(id, 2) = 0";
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
            System.out.println("Error en listar_ID_par: " + ex.getMessage());
        }
    }

  //listar id inpar 
    public void listarIDImpar(DefaultTableModel modelo) {
        modelo.setRowCount(0);
        Connection con = conectar();
        String query = "SELECT * FROM profesores WHERE MOD(id, 2) != 0";
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
            System.out.println("Error en listarIDImpar: " + ex.getMessage());
        }
    }
}


