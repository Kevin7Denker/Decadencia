package ifpr.eic.info20.projetointegrador.Modelos;

import ifpr.eic.info20.projetointegrador.Repositorio.Aeroporto;

public class Aeronaves {
   
     //-> Variaveis 
     private int id;
     private String nome;
     private int numeroPassageiros;
     private Double combustivel;
     private Filiacao filiacao; 
     private Aeroporto aeroporto;

   //-> Metodo

     public Aeronaves(Aeroporto aeroporto){
       this.aeroporto = aeroporto;
     }


     public Aeronaves(int id,String nome,int numeroPassageiros,Double combustivel, Filiacao filiacao){
         this.setId(id);
         this.setNome(nome);    
         this.setNumPassageiros(numeroPassageiros);
         this.setCombustivel(combustivel);
         this.setFiliacao(filiacao); 
        } 

      public Aeronaves(String nome, int numeroPassageiros, Double combustivel, Filiacao filiacao){
           this(-1, nome, numeroPassageiros, combustivel,filiacao);
      }  

    //-> Sets
    public void setId(int id){
        this.id = id;
      }
    public void setNome(String nome){
        this.nome = nome;
      }       
     public void setNumPassageiros(int numeroPassageiros){
        this.numeroPassageiros = numeroPassageiros;
      }

     public void setCombustivel(Double combustivel){
        this.combustivel = combustivel;
      }
     public void setFiliacao(Filiacao filiacao){
        this.filiacao = filiacao;
      } 

      //-> Gets
      public int getId(){
        return id;
      }
      public String getNome(){
        return nome;
      }
      public int getNumPassageiros(){
        return numeroPassageiros;
      }
      public Double getCombustivel(){
        return combustivel;
      } 
      
}

