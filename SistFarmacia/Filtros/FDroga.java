package Filtros;

import Drogas.*;

public class FDroga implements Filtro {

    private Droga droga;

    public FDroga(Droga droga){
        this.droga = droga;
    }

    public boolean cumple(Droga d){
        return d.contiene(d);
    }
}
