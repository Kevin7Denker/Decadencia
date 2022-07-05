package ifpr.eic.info20.projetointegrador.Daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import ifpr.eic.info20.projetointegrador.Daos.Interfaces.FuncionarioDao;
import ifpr.eic.info20.projetointegrador.Modelos.Funcionarios;
import ifpr.eic.info20.projetointegrador.utils.Conection;

public class JDBCFuncionariosDAO implements FuncionarioDao{

    private Conection conection; 

    @Override
    public boolean salvarFuncionario(Funcionarios func) throws Exception{

        Connection  con = conection.getConnection();
        
        String sql = "INSERT INTO Funcionarios(nome_funcionario, cargo, salario) VALUES (?,?,?)";

        PreparedStatement pp = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
        
        pp.setString(1, func.getNome());
        pp.setString(2, func.getCargo());
        pp.setDouble(3, func.getSalario());

        pp.execute();
        
        ResultSet ids = pp.getGeneratedKeys();
        ids.next();

        int id = ids.getInt(1);
       
        ids.close();
        pp.close();
        con.close();
        
        func.setId(id);

        return true;
    }

    @Override
    public boolean remover(Funcionarios func) throws Exception {
        
        Connection  con = conection.getConnection();

        String sql = "Delete from Funcionarios Where id = ?";
  
        PreparedStatement pp = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        int id = func.getId();

        pp.setInt(1, id);

        pp.executeUpdate();

        pp.close();
        con.close();

        return true;
    }
    
    
}
