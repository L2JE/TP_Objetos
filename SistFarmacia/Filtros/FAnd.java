package Filtros;

import Drogas.Droga;

import java.util.ArrayList;

public class FAnd implements Filtro {

    private ArrayList<Filtro> filtros = new ArrayList<Filtro>();

    public FAnd(Filtro f1, Filtro f2){
        this.filtros.add(f1);
        this.filtros.add(f2);
    }

    public FAnd(ArrayList<Filtro> filtros) {
        this.filtros = filtros;
    }

    public boolean cumple(Droga d) {
        for(Filtro f : filtros){
            if(!f.cumple(d))
                return false;
        }
        return true;
    }

}
