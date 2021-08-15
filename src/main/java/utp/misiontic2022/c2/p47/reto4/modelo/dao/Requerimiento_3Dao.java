package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class Requerimiento_3Dao {
    
    Connection conexion;

    public Requerimiento_3Dao(){
        try {
            conexion = JDBCUtilities.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    public ArrayList<Requerimiento_3> requerimiento3() throws SQLException {
        ArrayList<Requerimiento_3> lista = new ArrayList<Requerimiento_3>();
        String sql = "SELECT ID_Proyecto, STRFTIME('%Y',Fecha ) "+
                    "From Compra c "+
                    "WHERE Pagado = 'Parcialmente' "+
                    "AND ((Fecha BETWEEN "+
                        "DATE('now','start of year','-1 year','+1 month') "+
                        "AND "+
                        "DATE('now','start of year','-1 year','+2 month','-1 day')) "+
                        "OR "+
                        "(Fecha BETWEEN  "+
                        "DATE('now','start of year','+1 month') "+
                        "AND "+
                        "DATE('now','start of year','+2 month','-1 day'))) ";
        Statement stmt = conexion.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        while(resultado.next()){
            Requerimiento_3 requerimiento_3 = new Requerimiento_3();
            requerimiento_3.setProveedor(resultado.getInt(1));
            requerimiento_3.setFecha(resultado.getInt(2));
            lista.add(requerimiento_3);
        } 
        return lista;
    }
}