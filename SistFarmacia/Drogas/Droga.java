package Drogas;
import Filtros.*;

import java.util.ArrayList;
import MainPack.*;

public interface Droga {

    public abstract String getNombre();
    public abstract EstPato getAccTerap();
    public abstract Sintoma getContraindic();
    public abstract boolean esAccionTerap(EstPato estPato);
    public abstract boolean esContraindic(Sintoma sintoma);
    public abstract ArrayList<Droga> getDrogas(Filtro filtro);
    public abstract ArrayList<Medicamento> getMeds(Filtro filtro);

}
