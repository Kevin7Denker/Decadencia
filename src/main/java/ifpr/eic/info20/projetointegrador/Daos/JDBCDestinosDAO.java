package ifpr.eic.info20.projetointegrador.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import ifpr.eic.info20.projetointegrador.Daos.Interfaces.DestinosDAO;
import ifpr.eic.info20.projetointegrador.Modelos.Destinos;
import ifpr.eic.info20.projetointegrador.utils.Conection;

public class JDBCDestinosDAO implements DestinosDAO{

    private Conection conection; 

    @Override
    public boolean salvarDestino(Destinos dest) throws Exception{

        Connection  con = conection.getConnection();
        
        String sql = "INSERT INTO Destinos(nome_destino, descrição, valor) VALUES (?,?,?)";
        
        PreparedStatement pp = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 


        pp.setString(1, dest.getNome());
        pp.setString(2, dest.getDescricao());
        pp.setDouble(3, dest.getValor());
         
        pp.execute();
        
        ResultSet ids = pp.getGeneratedKeys();
        ids.next();

        int id = ids.getInt(1);
       
        ids.close();
        pp.close();
        con.close();
        
        dest.setId(id);

        return true;
    }

    @Override
    public boolean remover(Destinos dest) throws Exception {
        
        Connection  con = conection.getConnection();

        String sql = "Delete from Destinos Where id = ?";
  
        PreparedStatement pp = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        int id = dest.getId();

        pp.setInt(1, id);

        pp.executeUpdate();

        pp.close();
        con.close();

        return true;
    }
}