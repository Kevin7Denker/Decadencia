package ifpr.eic.info20.projetointegrador.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import ifpr.eic.info20.projetointegrador.Daos.Interfaces.FiliacaoDAO;
import ifpr.eic.info20.projetointegrador.Modelos.Filiacao;
import ifpr.eic.info20.projetointegrador.utils.Conection;

public class JDBCFiliacaoDAO implements FiliacaoDAO{

    private Conection conection; 

    @Override
    public boolean salvarFiliacao(Filiacao fili) throws Exception{

        Connection  con = conection.getConnection();
        
        String sql = "INSERT INTO Filiacao(nome_filiação, cnpj) VALUES (?,?)";
        
        PreparedStatement pp = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
        
        pp.setString(1, fili.getNome());
        pp.setInt(1, fili.getCnpj());
        
        pp.execute();
        
        ResultSet ids = pp.getGeneratedKeys();
        ids.next();

        int id = ids.getInt(1);
       
        ids.close();
        pp.close();
        con.close();
        
        fili.setId(id);

        return true;
    }

    @Override
    public boolean remover(Filiacao fili) throws Exception {
        
        Connection  con = conection.getConnection();

        String sql = "Delete from Filiacao Where id = ?";
  
        PreparedStatement pp = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        int id = fili.getId();

        pp.setInt(1, id);

        pp.executeUpdate();

        pp.close();
        con.close();

        return true;
    }
    
}