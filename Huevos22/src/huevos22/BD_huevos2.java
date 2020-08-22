/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huevos22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author michi
 */
public class BD_huevos2 {
    static Connection contacto = null;
    int Activo = 0;

    //CONEXION BASE DE DATOS----------------------------------------------------------------------
    public static Connection getConexion() {
        String url = "jdbc:sqlserver://bdhuevos.mssql.somee.com;databaseName=bdhuevos";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Conectado.");
        } catch (ClassNotFoundException e) {

            System.out.println("error driver.");
        }
        try {
            contacto = DriverManager.getConnection(url, "JohanFZ_SQLLogin_1", "4so2rpfdrs");
        } catch (SQLException e) {
            System.out.println("error conexion.");
        }
        return contacto;
    }

    public void desconectar() {
        try {
            contacto.close();
            System.out.println("desconcetado");
        } catch (SQLException ex) {
            System.out.println("Error en el cierre" + ex.getMessage());
        }
    }

    public static ResultSet Consulta(String Consulta) {
        Connection con = getConexion();
        Statement declara;
        try {
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(Consulta);
            return respuesta;
        } catch (SQLException e) {
            System.out.println("error conexion.");
        }
        return null;
    }
}