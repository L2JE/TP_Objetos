package Drogas;

import java.util.ArrayList;
import Filtros.*;
import MainPack.*;


public class DrogaSimple extends Droga {

    private ArrayList<EstPato> accionesTerap;
    private ArrayList<Sintoma> contraindics;

    public DrogaSimple(String nombre, ArrayList<EstPato> accionesTerap, ArrayList<Sintoma> contraindics) {
        this.nombre = nombre;
        this.accionesTerap = accionesTerap;
        this.contraindics = contraindics;
    }


    public String getNombre(){
        return nombre;
    }

    public float getPorcentDroga(Droga d){
        return (d.getNombre() == this.nombre)? (float)1:(float)0;
    }

    public boolean esAccionTerap(EstPato estPato){
        return accionesTerap.contains(estPato);
    }

    public boolean esContraindic(Sintoma sintoma){
        return contraindics.contains(sintoma);
    }

    public ArrayList<Droga> getDrogas(Filtro filtro){
        ArrayList<Droga> res = new ArrayList<Droga>();

        return res;
    }

    public ArrayList<Medicamento> getMeds(Filtro filtro){
        ArrayList<Medicamento> res = null;

        if(filtro.cumple(this)) res = new ArrayList<Medicamento>();

        return res;
    }


}
