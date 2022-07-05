package ifpr.eic.info20.projetointegrador.Telas;

import java.sql.Date;
import java.time.LocalDate;

import ifpr.eic.info20.projetointegrador.App;
import ifpr.eic.info20.projetointegrador.Modelos.Voo;
import ifpr.eic.info20.projetointegrador.Repositorio.Aeroporto;
import ifpr.eic.info20.projetointegrador.Repositorio.RepCompra;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class Compras {

    @FXML
    private GridPane painelsecundario; 

    @FXML
    private Button btComprar;

    @FXML
    private TextField btCpf;

    @FXML
    private ComboBox<Voo> btDestino;

    @FXML
    private TextField btEmail;

    @FXML
    private Button btLimpar;

    @FXML
    private TextField btNascionalidade;

    @FXML
    private TextField btNome;

    @FXML
    private ComboBox<String> btSexo;

    @FXML
    private ListView<?> btValor;

    private RepCompra repcompra;
    
    public Compras(RepCompra repcompra){
        this.repcompra = repcompra;
    }

    public void initialize(){
       

    }
     
    @FXML
    private void comprar() throws Exception{
        
        String nome = btNome.getText();
        String email = btEmail.getText();
        String nacionalidade = btNascionalidade.getText();
        int cpf = Integer.valueOf(btCpf.getText());
        Voo voa = btDestino.getSelectionModel().getSelectedItem();
        Date dataNascimento = null; //= btData.getValue();

        String msg = "A";
        boolean confirm = true;
          
       

        if(nome.isEmpty() || nome.isBlank()){
            msg = "Nome é um campo obrigatorio!!";
            confirm = false;
        }
        if(email.isEmpty() || email.isBlank()){
            msg = "Email é um campo obrigatorio!!";
            confirm = false;
        }
        if(nacionalidade.isEmpty() || nacionalidade.isBlank()){
            msg = "Nacionalidade é um campo obrigatorio!!";
            confirm = false;
        }
        if(cpf <=0 || cpf > 1000000000){
            msg = "Valor invalido!!";
            confirm = false;
        }

        if(confirm){
        
          try {
              
            boolean add = repcompra.Comprar(nome, cpf,email, nacionalidade, voa);
            
            if(add){
                msg = "Compra Realizada Com Sucesso!!!";
                limpar();
             
            } else if(add = false){
             
             msg = "Opss Ocorreu Um Erro, Por Favor Tente Novamente!!!";  
            }

          } catch (Exception e) {
            msg = e.getMessage();
          } 
            
        }

        Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
            alert.showAndWait();
       
    }
     
    @FXML
    private void limpar(){
        btNome.clear();
        btNascionalidade.clear();
        btCpf.clear();
        btDestino.getSelectionModel().clearSelection();
        btCpf.clear();
        btEmail.clear();

    }

}