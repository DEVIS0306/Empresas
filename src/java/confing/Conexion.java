package confing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jevergara
 */
public class Conexion {

    public static void main(String[] args) {
        Conexion.getConexion();
    }

    public static Connection getConexion() {
        String conexionUrl = "jdbc:sqlserver://localhost:1433;"
                + "database=Empresa;"
                + "user=sa;"
                + "password=Devis123@";

        try {
            Connection con = DriverManager.getConnection(conexionUrl);
            return con;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void desconectar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
