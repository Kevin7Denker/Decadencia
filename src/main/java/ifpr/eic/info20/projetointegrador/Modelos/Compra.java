package ifpr.eic.info20.projetointegrador.Modelos;

import java.sql.Date;

import ifpr.eic.info20.projetointegrador.Modelos.Voo;
import ifpr.eic.info20.projetointegrador.Repositorio.Aeroporto;

public class Compra {
    
  //-> Variaveis 
    private int id;
    private String nome;
    private int cpf;
    private String email;
    private String nacionalidade;
    private Voo voa;
    private Aeroporto aeroporto;

  //-> Metodos  
    
    public Compra(Aeroporto aeroporto){
      this.aeroporto = aeroporto;
    } 
  
  
  
    public Compra(int id,String nome, int cpf, String email, String nacionalidade, Voo voa){
     this.setId(id);
     this.setNome(nome);
     this.setCpf(cpf);
     this.setEmail(email);
     this.setNacionalidade(nacionalidade);
     this.setVoa(voa);   
    }

    public Compra(String nome, int cpf, String email, String nacionalidade, Voo voa){
       this(-1, nome, cpf, email, nacionalidade,voa);
    }

  //-> Sets 
   public void setId(int id){
     this.id = id;
   }
   public void setNome(String nome){
     this.nome = nome;
    }
   public void setCpf(int cpf){
     this.cpf = cpf;
    }
   public void setEmail(String email){
     this.email = email;
    } 
   public void setNacionalidade(String nacionalidade){
     this.nacionalidade = nacionalidade;
    }
   public void setVoa(Voo voa){
     this.voa = voa;
    }


  //-> Gets
    public int getId(){
      return id;
    }
    public String getNome(){
      return nome;
    }
    public int getCpf(){
      return cpf;
    }
    public String getNascionalidade(){
      return nacionalidade;
    }

    
}