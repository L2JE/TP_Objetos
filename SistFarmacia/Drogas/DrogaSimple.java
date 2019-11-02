package Drogas;

import java.util.ArrayList;
import Filtros.*;
import MainPack.*;


public class DrogaSimple implements Droga {
    private String nombre;
    private EstPato[] accionesTerap;
    private Sintoma[] contraindics;

    public DrogaSimple(String nom, EstPato[] accTeraps, Sintoma[] contraindics){
        this.nombre = nom;
        this.accionesTerap = accTeraps;
        this.contraindics = contraindics;
    }

    public String getNombre(){

    }
    public EstPato getAccTerap(){

    }
    public Sintoma getContraindic(){

    }
    public boolean esAccionTerap(EstPato estPato){

    }

    public boolean esContraindic(Sintoma sintoma){

    }

    public ArrayList<Droga> getDrogas(Filtro filtro){

    }

    public ArrayList<Medicamento> getMeds(Filtro filtro){
        ArrayList<Medicamento> res = null;

        if(filtro.cumple(this)) res = new ArrayList<Medicamento>();

        return res;
    }


}
