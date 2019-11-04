package MainPack;

import Drogas.DrogaSimple;

import java.util.ArrayList;

public class Paciente {
    private ArrayList<DrogaSimple> alergias = new ArrayList<DrogaSimple>();
    private ArrayList<Sintoma> sintomas = new ArrayList<Sintoma>();

    public Paciente(Sintoma s){
        this.sintomas.add(s);
    }

    public Paciente(DrogaSimple alergia, Sintoma sintoma) {///PARA PRUEBAAAASSSS
        this.alergias.add(alergia);
        this.sintomas.add(sintoma);
    }

    public Paciente(ArrayList<DrogaSimple> alergias, ArrayList<Sintoma> sintomas) {
        this.alergias = alergias;
        this.sintomas = sintomas;
    }

    public ArrayList<DrogaSimple> getAlergias(){
    	return this.alergias;
    }
    
    public ArrayList<Sintoma> getSintomas(){
    	return this.sintomas;
    }

    public String toString(){
        String salida = "Alergias del Paciente: \n(";
        for(DrogaSimple e : alergias)
            salida += e.getNombre() + ", ";

        salida += ")\nSintomas del Paciente: \n(";
        for(Sintoma e : sintomas)
            salida += e + ", ";

        return salida + ")";
    }
    
}
