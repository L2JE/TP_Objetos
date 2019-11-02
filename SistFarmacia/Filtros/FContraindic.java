package Filtros;

import Drogas.*;
import MainPack.*;

public class FContraindic {

    private Sintoma contraindic;

    public FContraindic(Sintoma contraindic){
        this.contraindic = contraindic;
    }

    public boolean cumple(Droga drog){
        return (drog != null) && drog.esContraindic(contraindic);
    }
}