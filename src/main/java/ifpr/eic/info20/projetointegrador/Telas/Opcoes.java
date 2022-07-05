package ifpr.eic.info20.projetointegrador.Telas;

import ifpr.eic.info20.projetointegrador.Repositorio.Aeroporto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class Opcoes{

    @FXML
    private ListView<?> btAerosList;

    @FXML
    private Button btCadastrarAviao;

    @FXML
    private Button btCadastrarFiliacao;

    @FXML
    private TextField btCapPassageiros;

    @FXML
    private TextField btCnpj;

    @FXML
    private TextField btCombustivel;

    @FXML
    private TextField btDescricao;

    @FXML
    private ComboBox<?> btFiliacao;

    @FXML
    private Button btLimpar;

    @FXML
    private TextField btNomeAero;

    @FXML
    private TextField btNomeFiliacao;

    @FXML
    private TabPane painel;

    private Aeroporto aeroporto;

    public Opcoes(Aeroporto aeroporto){
        this.aeroporto = aeroporto;

        painel.getStylesheets().add(getClass().getResource("css/estilo.css").toExternalForm());
    }
}
