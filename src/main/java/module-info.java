module ifpr.eic.info20.projetointegrador {
    
    requires javafx.controls;
    requires javafx.fxml;
    
    requires java.sql;
    
    opens ifpr.eic.info20.projetointegrador.Telas to javafx.fxml;
    exports ifpr.eic.info20.projetointegrador;
}
