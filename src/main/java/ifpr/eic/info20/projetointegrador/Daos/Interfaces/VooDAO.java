package ifpr.eic.info20.projetointegrador.Daos.Interfaces;

import ifpr.eic.info20.projetointegrador.Modelos.Voo;

public interface VooDAO {

    boolean salvarCompra(Voo voa) throws Exception;
    boolean remover(Voo voa) throws Exception;
}
