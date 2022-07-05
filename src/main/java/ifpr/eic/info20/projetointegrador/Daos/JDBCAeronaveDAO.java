package ifpr.eic.info20.projetointegrador.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ifpr.eic.info20.projetointegrador.Daos.Interfaces.AeronaveDAO;
import ifpr.eic.info20.projetointegrador.Modelos.Aeronaves;
import ifpr.eic.info20.projetointegrador.Modelos.Filiacao;
import ifpr.eic.info20.projetointegrador.Repositorio.Aeroporto;
import ifpr.eic.info20.projetointegrador.utils.Conection;

public class JDBCAeronaveDAO implements AeronaveDAO{

    private Conection conection;

    private Filiacao filiacao;
    private Aeroporto aeroporto;
    
    public JDBCAeronaveDAO(Conection conection, Aeroporto aeroporto){
        this.conection = conection;
        this.aeroporto = aeroporto; 
    } 

    @Override
    public boolean salvarAeronave(Aeronaves aero) throws Exception{

        Connection  con = conection.getConnection();
        
        String sql = "INS0ERT INTO Aeronaves(nomeAeronave,numero_de_passageiros,Capacidade_Combustivel,nome_filiação) VALUES (?,?,?,?)";
        
        PreparedStatement pp = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
        
        pp.setString(1, aero.getNome());
        pp.setInt(2, aero.getNumPassageiros());
        pp.setDouble(3, aero.getCombustivel());
        
        // - Arrumar 
        pp.setString(4, aero.getNome());
        
        pp.execute();
        
        ResultSet ids = pp.getGeneratedKeys();
        ids.next();

        int id = ids.getInt(1);
       
        ids.close();
        pp.close();
        con.close();
        
        aero.setId(id);

        return true;
    }

    @Override
    public boolean remover(Aeronaves aero) throws Exception {
        
        Connection  con = conection.getConnection();

        String sql = "Delete from Aeronaves Where id = ?";
  
        PreparedStatement pp = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        int id = aero.getId();

        pp.setInt(1, id);

        pp.executeUpdate();

        pp.close();
        con.close();

        return true;
    }

    @Override
    public ArrayList<Aeronaves> listar() throws Exception {
        ArrayList<Aeronaves> aeros = new ArrayList<>();

        Connection  con = conection.getConnection();

        String sql = "Select * From Aeronaves";

        PreparedStatement pp = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        ResultSet ret = pp.executeQuery();
        
        while(ret.next()){

            Aeronaves aeronave = montarAirplane(ret);
            aeros.add(aeronave); 
            
        }

        pp.close();
        con.close();

        return aeros;
    }

    private Aeronaves montarAirplane(ResultSet ret) throws Exception{
        
        int id = ret.getInt("id");
        String nome = ret.getString("nomeAeronave");
        int numeroPassageiros = ret.getInt("numero_de_passageiros");
        Double combustivel = ret.getDouble("Capacidade_Combustivel");
        Filiacao filiacao = aeroporto.getFiliacao(ret.getString("nomeFiliacao"));
        
        Aeronaves aeronave = new Aeronaves(id, nome, numeroPassageiros, combustivel, filiacao);
        
        return aeronave;        
            
    }
}