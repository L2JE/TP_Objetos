package Filtros;

import Drogas.Droga;

///TODO: ES POSIBLE QUE NO SEA NECESARIA
public class FPorcent implements Filtro{
    private float porcent;
    private String nombreDrog;

    public FPorcent(Droga droga, float porcent){
        this.porcent = porcent;
        this.nombreDrog = droga.getNombre();
    }

    public boolean cumple(Droga d){

        return true;
    }
}
