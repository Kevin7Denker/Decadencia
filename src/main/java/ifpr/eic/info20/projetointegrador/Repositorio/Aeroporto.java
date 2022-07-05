package ifpr.eic.info20.projetointegrador.Repositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import ifpr.eic.info20.projetointegrador.Modelos.Funcionarios;
import ifpr.eic.info20.projetointegrador.Modelos.Voo;
import ifpr.eic.info20.projetointegrador.Modelos.Compra;
import ifpr.eic.info20.projetointegrador.Daos.Interfaces.AeronaveDAO;
import ifpr.eic.info20.projetointegrador.Daos.Interfaces.DestinosDAO;
import ifpr.eic.info20.projetointegrador.Daos.Interfaces.FiliacaoDAO;
import ifpr.eic.info20.projetointegrador.Daos.Interfaces.FuncionarioDao;
import ifpr.eic.info20.projetointegrador.Daos.Interfaces.VooDAO;
import ifpr.eic.info20.projetointegrador.Modelos.Aeronaves;
import ifpr.eic.info20.projetointegrador.Modelos.Destinos;
import ifpr.eic.info20.projetointegrador.Modelos.Filiacao;

public class Aeroporto {
   
  //-> Arrays 
    private ArrayList<Funcionarios> funcionarios;
    private ArrayList<Destinos> destinos;
    private ArrayList<Aeronaves> aeronaves;
    private ArrayList<Filiacao> filiacoes;
    private ArrayList<Voo> voos;
    
    private Filiacao filiacao;

    private AeronaveDAO aeronaveDao;
    private FuncionarioDao funcionarioDAO;
    private DestinosDAO destinosDAO;
    private VooDAO vooDAO;
    private FiliacaoDAO filiacaoDAO;

    private Aeronaves aeronave;

    public Aeroporto(){
      funcionarios = new ArrayList<>();
      destinos = new ArrayList<>();
      aeronaves = new ArrayList<>();
      voos = new ArrayList<>();
    }
 
 /*   
⠀⠀⠀⠀    ⣖⠲⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠉⡇⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠸⡆⠹⡀⣠⢤⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡏⠀⡧⢤⡄⠀⠀⠀⠀⠀   
⠀⠀⠀⠀⠀⠀⠀⠀⡧⢄⣹⣅⣜⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠁⠀⢹⠚⠃⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⣀⠴⢒⣉⡹⣶⣤⣀⡉⠉⠒⠒⠒⠤⠤⣀⣀⣀⠇⠀⠀⢸⠠⣄⠀⠀⠀⠀⠀Aeroporto Caioba 
⠀⠀⠀⠀⠀⠈⠉⠁⠀⠀⠀⠉⠒⠯⣟⣲⠦⣤⣀⡀⠀⠀⠈⠉⠉⠉⠛⠒⠻⢥⣀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⣲⡬⠭⠿⢷⣦⣤⢄⣀⠀⠀⠚⠛⠛⠓⢦⡀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠤⠴⠚⠉⠁⠀⠀⠀⠀⣀⣉⡽⣕⣯⡉⠉⠉⠑⢒⣒⡾
⠀⠀⠀⠀⠀⠀⣀⡠⠴⠒⠉⠉⠀⢀⣀⣀⠤⡤⢶⣶⣋⠉⠉⠀⠀⠀⠈⠉⠉⠉⠉⠉⠁⠀
⠀⠀⠀⠀⣖⣉⣁⣠⠤⠶⡶⡶⢍⡉⠀⠀⠀⠙⠒⠯⠜⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠑⢦⣯⠇ 
*/
    
    public boolean cadastrarFuncionario(String nome, String cargo, String endereco, int telefone, Double salario) throws SQLException{
      Funcionarios fun = new Funcionarios(nome, cargo, endereco, telefone, salario);
     
    try {
      
      funcionarioDAO.salvarFuncionario(fun);
      this.funcionarios.add(fun);

      return true;
       
    } catch (Exception e) {
      
      System.out.println("Erro no metodo cadastrarFuncionarios do repositorio");
       
      e.printStackTrace();
      throw new SQLException(e.getMessage());
    }

    }
    
    public boolean cadastrarAeronave(String nome, int numeroPassageiros,Double combustivel, Filiacao filiacao) throws SQLException{
      Aeronaves aero = new Aeronaves(nome, numeroPassageiros, combustivel, filiacao);
      
    try {
        
        aeronaveDao.salvarAeronave(aero);
        this.aeronaves.add(aero);
        return true;
        
    } catch (Exception e) {
        
        System.out.println("Erro no metodo cadastrarAeronave do repositorio");
        e.printStackTrace();
        throw new SQLException(e.getMessage());
      }
    } 
    
    public boolean cadastrarDestinos(String nome, Double valor, String descricao, int distancia) throws SQLException{
       Destinos dest = new Destinos(nome, valor, descricao, distancia);
    
    try {
      
      destinosDAO.salvarDestino(dest);
      this.destinos.add(dest);
            
      return true;
        
    } catch (Exception e) {
        
        System.out.println("Erro no metodo cadastrarDestinos do repositorio");
        e.printStackTrace();
        throw new SQLException(e.getMessage());
      }
    }
   
   public boolean cadastrarFiliacao(String nome, String descricao, int cnpj) throws SQLException{
      Filiacao fili = new Filiacao(nome, descricao, cnpj);   

    try{
     
      filiacaoDAO.salvarFiliacao(fili);
      this.filiacoes.add(fili);     
      return true;

    } catch (Exception e){
      
      System.out.println("Erro no metodo cadastrarFiliacao do repositorio");
      e.printStackTrace();
      throw new SQLException(e.getMessage());
    }  
     
   } 
    
   public boolean cadastrarVoo(Aeronaves aviao, Destinos destino, double hora) throws SQLException{
      Voo voa = new Voo(aviao, destino, hora);
       
    try{
      
      vooDAO.salvarCompra(voa);
      this.voos.add(voa);

      return true;

    } catch (Exception e){
      
      System.out.println("Erro no metodo cadastrarFiliacao do repositorio");
      e.printStackTrace();
      throw new SQLException(e.getMessage());
      
    }
   }

  public Filiacao getFiliacao(String nome) {
    
    return this.filiacoes.stream().filter((filiacao) -> filiacao.getNome().equals(nome)).findFirst().orElse(null);
    
  }

  public Destinos getVoos (String nome){

    return this.destinos.stream().filter((destinos) -> destinos.getNome().equals(nome)).findFirst().orElse(null);
  }
   
  public Aeronaves getAeros(String nome){
    return this.aeronaves.stream().filter((aeronave) -> aeronave.getNome().equals(nome)).findFirst().orElse(null);

  }


}