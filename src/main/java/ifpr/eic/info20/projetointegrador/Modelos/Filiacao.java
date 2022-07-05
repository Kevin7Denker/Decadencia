package ifpr.eic.info20.projetointegrador.Modelos;

public class Filiacao {

   private int id; 
   private String nome;
   private String descricao;
   private int cnpj;
    
   public Filiacao(int id,String nome, String descricao, int cnpj){
      this.setId(id); 
      this.setNome(nome);
      this.setDescricao(descricao);
      this.setCnpj(cnpj);                
   }
 
   public Filiacao(String nome,String descricao, int cnpj){
      this(-1,nome,descricao,cnpj);
   }

   public void setCnpj(int cnpj){
    this.cnpj = cnpj; 
   }
   public void setDescricao(String descricao){
      this.descricao = descricao; 
   }
   public void setNome(String nome){
      this.nome = nome;
   }
   public void setId(int id){
      this.id = id;
   } 

   public int getId(){
      return id;
   }
   public String getNome(){
      return nome;
   } 
   public int getCnpj(){
      return cnpj;
   }

}

