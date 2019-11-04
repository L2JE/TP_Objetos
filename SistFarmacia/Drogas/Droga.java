package Drogas;
import Filtros.*;

import java.util.ArrayList;
import MainPack.*;

public abstract class Droga {

    protected String nombre = "Unnamed";

    public abstract String getNombre();
    public abstract boolean contiene(Droga d);
    public abstract float getPorcentDroga(Droga d);
    public abstract boolean esAccionTerap(EstPato estPato);
    public abstract boolean esContraindic(Sintoma sintoma);
    public abstract ArrayList<Droga> getDrogas(Filtro filtro);
    public abstract ArrayList<Medicamento> getMeds(Filtro filtro);

}
