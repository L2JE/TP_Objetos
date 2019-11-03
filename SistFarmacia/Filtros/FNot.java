package Filtros;

import Drogas.Droga;

public class FNot implements Filtro{
    Filtro f;
    public FNot(Filtro f){
        this.f = f;
    }
    public boolean cumple(Droga d){
        return !f.cumple(d);
    }
}
