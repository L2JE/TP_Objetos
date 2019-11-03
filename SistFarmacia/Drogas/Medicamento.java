package Drogas;

import java.util.ArrayList;
import Filtros.*;
import MainPack.*;

public class Medicamento implements Droga {
    private String nombre;
    private ArrayList<Droga> compuestos;
    private float[] concentracion;

    public Medicamento(ArrayList<Droga> compuestos, float[] concentracion){
        this.compuestos = new ArrayList<Droga>();
        this.compuestos.addAll(compuestos);
        int tam = compuestos.size();
        this.concentracion = new float[tam];

        for(tam -= 1; tam > -1 ; tam--){
            this.concentracion[tam] = concentracion[tam];
        }

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

    public ArrayList<Medicamento> getMeds(Filtro f){

        ArrayList<Medicamento> res = new ArrayList<Medicamento>();

        for(Medicamento m : compuestos){
            ArrayList<Medicamento> aux = m.getMeds();
            if(aux != null)
                res.addAll(aux);
        }
        return res;

    }
}
