package ifpr.eic.info20.projetointegrador.Daos.Interfaces;

import ifpr.eic.info20.projetointegrador.Modelos.Filiacao;

public interface FiliacaoDAO {
    boolean salvarFiliacao(Filiacao fili) throws Exception;
    boolean remover(Filiacao fili) throws Exception;
}
