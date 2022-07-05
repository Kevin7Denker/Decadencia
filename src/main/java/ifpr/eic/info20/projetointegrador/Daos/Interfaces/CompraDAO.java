package ifpr.eic.info20.projetointegrador.Daos.Interfaces;

import ifpr.eic.info20.projetointegrador.Modelos.Compra;

public interface CompraDAO {

   boolean salvarCompra(Compra comp) throws Exception;
   boolean remover(Compra comp) throws Exception;
}
