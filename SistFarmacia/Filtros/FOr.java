package Filtros;

import Drogas.Droga;

import java.util.ArrayList;

public class FOr implements Filtro{

    private ArrayList<Filtro> filtros = new ArrayList<Filtro>();
/*
    public FOr(Filtro filtro1, Filtro filtro2) {
        this.filtros.add(filtro1);
        this.filtros.add(filtro2);
    }
*/
    public FOr(ArrayList<Filtro> filtros) {
        this.filtros = filtros;
    }

    public boolean cumple(Droga d) {
        for(Filtro f : filtros){
            if(f.cumple(d))
                return true;
        }
        return false;
    }
}
