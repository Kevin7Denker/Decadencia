package ifpr.eic.info20.projetointegrador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

import ifpr.eic.info20.projetointegrador.Repositorio.Aeroporto;
import ifpr.eic.info20.projetointegrador.Repositorio.RepCompra;
import ifpr.eic.info20.projetointegrador.Telas.Home;


k
public class App extends Application {
    
    private Aeroporto aeroporto;
    private RepCompra repcompra;

    @Override
    public void start(Stage stage) throws IOException {
        
      Scene scene = new Scene(loadTela("fxml/home.fxml",o-> new Home(aeroporto, repcompra)), 1000, 600);
      
      scene.getStylesheets().add(getClass().getResource("css/estilo.css").toExternalForm());
      
      stage.setScene(scene);
      stage.show();
    
    }


    public static Parent loadTela(String fxml, Callback Controller) throws IOException {
      Parent root = null;
      
      try{  
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource(fxml));
        loader.setControllerFactory(Controller);

        root =  loader.load();
      
      } catch(Exception e){
        System.out.println("Problema no arquivo fxml. Está correto?? "+fxml);
        e.printStackTrace();
        System.exit(0);
      }  

        return root;
    }

    public static void main(String[] args) {
        launch();
    }

}