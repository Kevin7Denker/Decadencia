package ifpr.eic.info20.projetointegrador.Daos.Interfaces;

import ifpr.eic.info20.projetointegrador.Modelos.Funcionarios;

public interface FuncionarioDao {
    
    boolean salvarFuncionario(Funcionarios func) throws Exception;
    boolean remover(Funcionarios func) throws Exception;
}
