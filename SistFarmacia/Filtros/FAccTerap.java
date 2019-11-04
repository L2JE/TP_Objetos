package Filtros;

import Drogas.*;
import MainPack.*;

public class FAccTerap implements Filtro {
	
	private EstPato accion;
	
	public FAccTerap(EstPato accion) {
		this.accion = accion;
	}
	
    public boolean cumple(Droga d){
        return (d != null) && d.esAccionTerap(this.accion);
    }
    
}