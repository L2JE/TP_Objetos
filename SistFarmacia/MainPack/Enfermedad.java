package MainPack;

import java.util.ArrayList;

public class Enfermedad {
    private String nombre;
    private ArrayList<EstPato> ePatos;

    public Enfermedad(String nombre, ArrayList<EstPato> ePatos) {
        this.nombre = nombre;
        this.ePatos = ePatos;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<EstPato> getEPatos() {
        return ePatos;
    }

    public String toString(){
        String salida = "Nombre de Enfermedad: " + nombre + "\n";
        salida += "Estados Patologicos que Trata: \n";
        for(EstPato e : ePatos)
            salida += e;

        return salida;
    }
}
