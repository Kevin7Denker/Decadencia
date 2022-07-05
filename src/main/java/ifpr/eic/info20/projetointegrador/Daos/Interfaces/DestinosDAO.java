package ifpr.eic.info20.projetointegrador.Daos.Interfaces;

import ifpr.eic.info20.projetointegrador.Modelos.Destinos;

public interface DestinosDAO {

    boolean salvarDestino(Destinos dest) throws Exception;
    boolean remover(Destinos dest) throws Exception;
}
