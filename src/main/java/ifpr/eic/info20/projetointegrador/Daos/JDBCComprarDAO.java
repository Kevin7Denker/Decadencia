package ifpr.eic.info20.projetointegrador.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import ifpr.eic.info20.projetointegrador.Daos.Interfaces.CompraDAO;
import ifpr.eic.info20.projetointegrador.Modelos.Compra;
import ifpr.eic.info20.projetointegrador.utils.Conection;

public class JDBCComprarDAO implements CompraDAO{

    private Conection conection; 

    @Override
    public boolean salvarCompra(Compra comp) throws Exception{

        Connection  con = conection.getConnection();
        
        String sql = "INSERT INTO Compras(nome_cliente, cpf, dataNascimento, email, nacionalidade, destino) VALUES (?,?,?,?,?,?)";
        
        PreparedStatement pp = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);         
         
        pp.setString(1, comp.getNome());
        pp.setInt(2, comp.getCpf());
        // pp.setByte(3, comp.getDatanascimento());


        pp.execute();
        
        ResultSet ids = pp.getGeneratedKeys();
        ids.next();

        int id = ids.getInt(1);
       
        ids.close();
        pp.close();
        con.close();
        
        comp.setId(id);

        return true;
    }

    @Override
    public boolean remover(Compra comp) throws Exception {
        
        Connection  con = conection.getConnection();

        String sql = "Delete from Compras Where id = ?";
  
        PreparedStatement pp = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        int id = comp.getId();

        pp.setInt(1, id);


        pp.executeUpdate();

        pp.close();
        con.close();

        return true;
    }

}