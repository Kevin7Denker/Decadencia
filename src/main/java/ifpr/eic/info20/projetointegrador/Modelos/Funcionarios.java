package ifpr.eic.info20.projetointegrador.Modelos;

public class Funcionarios {
    
    //-> Variaveis
     private int id;
     private String nome;
     private String cargo;
     private String endereco;
     private int telefone;
     private Double salario;
  
    //-> Metodo Construtor;
      public Funcionarios(int id, String nome, String cargo, String endereco, int telefone, Double salario){
        this.setId(id);
        this.setNome(nome);
        this.setCargo(cargo);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
        this.setSalario(salario);
      } 
      
      public Funcionarios(String nome, String cargo, String endereco, int telefone, Double salario){
        this(-1,nome, cargo, endereco, telefone, salario);   
      }
      
    //-> Sets
      public void setId(int id){
        this.id = id;
      }
      public void setNome(String nome){
          this.nome = nome;
        }     
      public void setCargo(String cargo){
          this.cargo = cargo;
        }
      public void setEndereco(String endereco){
          this.endereco = endereco;
        }
      public void setTelefone(int telefone){
          this.telefone = telefone;
        } 
      public void setSalario(Double salario){
          this.salario = salario;     
        }
    
    //-> gets
      public String getNome(){
        return nome;
      }
      public int getId(){
        return id;
      }
      public String getCargo(){
        return cargo;  
      }
      public String getEndereco(){
        return endereco;
      }
      public int getTelefone(){
        return telefone;          
      }  
      public Double getSalario(){
        return salario;
      }

}     