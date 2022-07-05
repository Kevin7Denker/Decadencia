package ifpr.eic.info20.projetointegrador.Telas;

import java.io.IOException;

import ifpr.eic.info20.projetointegrador.App;
import ifpr.eic.info20.projetointegrador.Modelos.Compra;
import ifpr.eic.info20.projetointegrador.Repositorio.Aeroporto;
import ifpr.eic.info20.projetointegrador.Repositorio.RepCompra;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class Home {
    
    @FXML
    private Button btCadastro;

    @FXML
    private Button btCompra;

    @FXML
    private Button btDark;

    @FXML
    private Button btEgg;

    @FXML
    private StackPane painel;
    
    
    private Aeroporto aeroporto; 
    private RepCompra repCompra;
     
    @FXML
    public void loadCompra(ActionEvent event) throws IOException{
     
       painel.getChildren().clear();
        painel.getChildren().add(App.loadTela("fxml/compra.fxml", (o)-> new Compra(aeroporto))); 

    }

    
    @FXML
    public void loadOp(ActionEvent event) throws IOException{
       
        painel.getChildren().clear();
        painel.getChildren().add(App.loadTela("fxml/opcoes.fxml", (o)-> new Aeroporto()));
    
    }
     
    @FXML
    public void loadListas(ActionEvent event) throws IOException{
       
        painel.getChildren().clear();
        painel.getChildren().add(App.loadTela("fxml/listas.fxml", (o)-> new Aeroporto()));
    
    }
    


    public Home(Aeroporto aeroporto, RepCompra repCompra){
        this.aeroporto = aeroporto;
    }
  
    
    




}
