package ifpr.eic.info20.projetointegrador.Daos.Interfaces;

import java.util.ArrayList;

import ifpr.eic.info20.projetointegrador.Modelos.Aeronaves;
public interface AeronaveDAO{

   boolean salvarAeronave(Aeronaves aero) throws Exception;
   boolean remover(Aeronaves aero) throws Exception;
   ArrayList<Aeronaves> listar() throws Exception; 

} 

