package ifpr.eic.info20.projetointegrador.Repositorio;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import ifpr.eic.info20.projetointegrador.Daos.Interfaces.CompraDAO;
import ifpr.eic.info20.projetointegrador.Modelos.Compra;
import ifpr.eic.info20.projetointegrador.Modelos.Voo;

public class RepCompra {

    private ArrayList<Integer> bah;
    private ArrayList<Compra> compras;

    private CompraDAO compraDAO;

    private Voo vo;
     
    public RepCompra(){
       this.bah = new ArrayList<>();
       this.compras = new ArrayList<>();
    }

    
    public boolean Comprar(String nome, int cpf, String email, String nacionalidade, Voo voa) throws Exception{
        Compra comp = new Compra(nome, cpf, email, nacionalidade, voa);
        
      try {
        
        
        if(bah.size() >= vo.getAviao().getNumPassageiros()){
          
          System.out.println("Error");
          
  
        } else{

          compraDAO.salvarCompra(comp);
          this.compras.add(comp); 
          
          bah.add(+1);
        }
        
        return true;
  
      } catch (Exception e) {
        
        System.out.println("Erro no metodo Comprar do repositorio");
        
        e.printStackTrace();
        throw new SQLException(e.getMessage());
      }
  
      }


}