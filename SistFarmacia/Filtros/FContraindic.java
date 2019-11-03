package Filtros;

import Drogas.*;
import MainPack.*;

public class FContraindic implements Filtro {

    private Sintoma contraindic;

    public FContraindic(Sintoma contraindic){
        this.contraindic = contraindic;
    }

    public boolean cumple(Droga d){
        return (d != null) && d.esContraindic(contraindic);
    }
}