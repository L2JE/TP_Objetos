package Filtros;

import Drogas.Droga;

import java.util.ArrayList;

public class FOr implements Filtro{

    private ArrayList<Filtro> filtros;

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
