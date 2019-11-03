package Drogas;

import java.util.ArrayList;
import Filtros.*;
import MainPack.*;

public class Medicamento extends Droga {

    private ArrayList<Droga> compuestos;
    private float[] concentracion;

    public Medicamento(String nombre, ArrayList<Droga> compuestos, float[] concentracion){
        this.nombre = nombre;
        this.compuestos = new ArrayList<Droga>();
        this.compuestos.addAll(compuestos);
        int tam = compuestos.size();
        this.concentracion = new float[tam];

        for(tam -= 1; tam > -1 ; tam--){
            this.concentracion[tam] = concentracion[tam];
        }

    }

    public String getNombre(){
        return nombre;
    }

    //Devuelve el porcentaje de DrogaSimple o Medicamento que contiene this
    public float getPorcentDroga(Droga d){
        float res = (float)0.0;
        if(d.getNombre() != this.nombre)
            for(int i = 0 ; i < compuestos.size() ; i++){
                res += concentracion[i]*compuestos.get(i).getPorcentDroga(d);
            }
        else
            return (float)1;

        return res;
    }

    public boolean esAccionTerap(EstPato estPato){
        for(Droga d : compuestos){
            if(d.esAccionTerap(estPato))
                return true;
        }
        return false;
    }

    public boolean esContraindic(Sintoma sintoma){
        return true;
    }

    public ArrayList<Droga> getDrogas(Filtro filtro){
        ArrayList<Droga> res = new ArrayList<Droga>();

        return res;
    }

    public ArrayList<Medicamento> getMeds(Filtro filtro){

        ArrayList<Medicamento> res = new ArrayList<Medicamento>();
        boolean cumple = false;

        for(Droga d : compuestos){
            ArrayList<Medicamento> aux = d.getMeds(filtro);

            if(aux != null){///solo devuelve null si era DrogaSimple que no cumple filtro
                if(aux.size() > 0)
                    res.addAll(aux);

                cumple = true;
            }
        }

        if(cumple)
            res.add(this);

        return res;

    }
}
