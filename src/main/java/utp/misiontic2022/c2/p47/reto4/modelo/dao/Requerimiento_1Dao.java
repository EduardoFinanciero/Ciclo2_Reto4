package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class Requerimiento_1Dao {

    Connection conexion;

    public  Requerimiento_1Dao(){
        try {
            conexion = JDBCUtilities.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public ArrayList<Requerimiento_1> requerimiento1() throws SQLException {
        
        ArrayList <Requerimiento_1> lista = new ArrayList<Requerimiento_1>();
        String sql = "SELECT ID_Compra "+
                    "From Compra "+
                    "WHERE Pagado = 'No' "+
                    "AND Proveedor = 'JUMBO'";
        
        Statement stmt = conexion.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
       
        while (resultado.next()){
            Requerimiento_1 requerimiento1 = new Requerimiento_1();
            requerimiento1.setID_Compra(resultado.getInt(1));
            lista.add(requerimiento1);
        }
        return lista;
    }
}