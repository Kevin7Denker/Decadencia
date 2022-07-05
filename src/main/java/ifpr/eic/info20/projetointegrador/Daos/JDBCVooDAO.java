package ifpr.eic.info20.projetointegrador.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import ifpr.eic.info20.projetointegrador.Daos.Interfaces.VooDAO;
import ifpr.eic.info20.projetointegrador.Modelos.Aeronaves;
import ifpr.eic.info20.projetointegrador.Modelos.Voo;
import ifpr.eic.info20.projetointegrador.Repositorio.Aeroporto;
import ifpr.eic.info20.projetointegrador.utils.Conection;


// infelizmente incompleto
public class JDBCVooDAO implements VooDAO{

    private Conection conection;
    private Aeroporto aeroporto;

    private Aeronaves aeros;

    @Override
    public boolean salvarCompra(Voo voa) throws Exception {
        
       Connection  con = conection.getConnection();
        
        String sql = "INSERT INTO Voos(nome_Aeronaves,horario, nome_Destinos,) VALUES (?,?,?)";

        PreparedStatement pp = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
        
        
        String aba = aeros.getNome();

        pp.execute();
        
        ResultSet ids = pp.getGeneratedKeys();
        ids.next();

        int id = ids.getInt(1);
       
        ids.close();
        pp.close();
        con.close();
        
        voa.setId(id);

        return true;
    }

    @Override
    public boolean remover(Voo voa) throws Exception {
        Connection  con = conection.getConnection();

        String sql = "Delete from Voos Where id = ?";
  
        PreparedStatement pp = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        int id = voa.getId();

        pp.setInt(1, id);

        pp.executeUpdate();

        pp.close();
        con.close();

        return true;
    }
    
}
