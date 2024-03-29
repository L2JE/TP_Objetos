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

    public boolean contiene(Droga d){
        for(Droga c : compuestos){
            if(c.contiene(d))
                return true;
        }
        return false;
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
        for(Droga d : compuestos){
            if(d.esContraindic(sintoma))
                return true;
        }
        return false;
    }

    public ArrayList<Droga> getDrogas(Filtro filtro){
        ArrayList<Droga> res = new ArrayList<Droga>();

        boolean cumple = false;

        for(Droga d : compuestos){
            ArrayList<Droga> aux = d.getDrogas(filtro);
            if(aux.size() > 0){
                for(Droga dAux : aux){
                    if (!res.contains(dAux))
                        res.add(dAux);
                }
                cumple = true;
            }
        }

        if(cumple)
            res.add(this);
        
        return res;
    }

    public ArrayList<Medicamento> getMeds(Filtro filtro){

        ArrayList<Medicamento> res = new ArrayList<Medicamento>();
        boolean cumple = false;

        for(Droga d : compuestos){
            ArrayList<Medicamento> aux = d.getMeds(filtro);

            if(aux != null){///solo devuelve null si era DrogaSimple que no cumple filtro
                if(aux.size() > 0)
                    for(Medicamento dAux : aux){
                        if (!res.contains(dAux))
                            res.add(dAux);
                    }

                cumple = true;
            }
        }

        if(cumple)
            res.add(this);

        return res;

    }
}
