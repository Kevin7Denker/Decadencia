package ifpr.eic.info20.projetointegrador.Modelos;

public class Destinos {
    
    //-> variaveis 
     int id;
     String nome;
     Double valor;
     String descricao;
     int distancia;
      
    
    public Destinos(int id,String nome, Double valor, String descricao, int distancia){
       this.setId(id);
       this.setNome(nome);
       this.setValor(valor);
       this.setDistancia(distancia);
       this.setDescricao(descricao);
    }

    public Destinos(String nome, Double valor, String descricao, int distancia){
      this(-1,nome,valor,descricao,distancia);
    }

    //-> sets
      public void setDescricao(String descricao){
         this.descricao = descricao;
        }
      public void setDistancia(int distancia){
         this.distancia = distancia;
        }
      public void setValor(Double valor){
         this.valor = valor;  
        }
      public void setId(int id){
         this.id = id;    
        } 
      public void setNome(String nome){
         this.nome = nome;  
        }
      
    //-> gets
      public String getNome(){
          return nome;
        }
      public int getDistancia(){
          return distancia;
        }
      public Double getValor(){
          return valor;
        }
      public String getDescricao(){
          return descricao;
        }
      public int getId(){
          return id;
        }    
    //
}
