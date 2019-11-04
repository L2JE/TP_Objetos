package Filtros;

import Drogas.*;

public class FDroga implements Filtro {

    private String nombre;

    public FDroga(String nombre){
        this.nombre = nombre;
    }

    public boolean cumple(Droga drog){
        return (drog != null) && drog.getNombre().equals(nombre);
    }
}
