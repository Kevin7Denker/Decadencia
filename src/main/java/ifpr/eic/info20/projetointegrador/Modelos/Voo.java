package ifpr.eic.info20.projetointegrador.Modelos;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.Initializable;

public class Voo {
   
    int id; 
    Aeronaves aviao;
    Destinos destino;
    double hora;

    public Voo(int id, Aeronaves aviao, Destinos destino, double hora){
       this.setId(id);
       this.setAero(aviao);
       this.setDestino(destino);    
    }

    public Voo(Aeronaves aviao, Destinos destino, double hora){
       this(-1, aviao, destino, hora);    
    } 
    
    public void Initializable(){

    }

    public void setDestino(Destinos destino) {
        this.destino = destino;
    }
    public void setAero(Aeronaves aviao){
        this.aviao = aviao;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public Aeronaves getAviao(){
        return aviao;
    }
}
