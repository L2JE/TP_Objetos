package MainPack;

import java.util.*;
import Drogas.*;
import Filtros.*;

public class Farmacia {

    private static ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
    private static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

    public static void main(String[] args){
        inicArrs();

        System.out.println("Holita");
    }

    private static void inicArrs(){

        //INICIALIZANDO DROGAS SIMPLES
        ArrayList<EstPato> accTerap0 = new ArrayList<EstPato>();
        ArrayList<Sintoma> contra0 = new ArrayList<Sintoma>();
        accTerap0.add(EstPato.E1);
        contra0.add(Sintoma.S1);
        DrogaSimple d0 = new DrogaSimple("d0", accTerap0, contra0);

        ArrayList<EstPato> accTerap1 = new ArrayList<EstPato>();
        ArrayList<Sintoma> contra1 = new ArrayList<Sintoma>();
        accTerap1.add(EstPato.E2);
        contra1.add(Sintoma.S2);
        DrogaSimple d1 = new DrogaSimple("d1", accTerap1, contra1);

        ArrayList<EstPato> accTerap2 = new ArrayList<EstPato>();
        ArrayList<Sintoma> contra2 = new ArrayList<Sintoma>();
        accTerap2.add(EstPato.E3);
        contra2.add(Sintoma.S3);
        DrogaSimple d2 = new DrogaSimple("d2", accTerap2, contra2);

        ArrayList<EstPato> accTerap3 = new ArrayList<EstPato>();
        ArrayList<Sintoma> contra3 = new ArrayList<Sintoma>();
        accTerap3.add(EstPato.E4);
        contra3.add(Sintoma.S4);
        DrogaSimple d3 = new DrogaSimple("d3", accTerap3, contra3);

        ArrayList<EstPato> accTerap4 = new ArrayList<EstPato>();
        ArrayList<Sintoma> contra4 = new ArrayList<Sintoma>();
        accTerap4.add(EstPato.Gripe);
        contra4.add(Sintoma.Cardiaco);
        DrogaSimple d4 = new DrogaSimple("d4", accTerap4, contra4);

        //INICIALIZANDO MEDICAMENTOS
        float[] cons = {(float) 0.5, (float) 0.5};

        ArrayList<Droga> comp5 = new ArrayList<Droga>();
        comp5.add(d1);
        comp5.add(d0);
        Medicamento m5 = new Medicamento("m5", comp5, cons);

        ArrayList<Droga> comp4 = new ArrayList<Droga>();
        comp4.add(d3);
        comp4.add(d4);
        Medicamento m4 = new Medicamento("m4", comp4, cons);

        ArrayList<Droga> comp3 = new ArrayList<Droga>();
        comp3.add(d2);
        comp3.add(m4);
        Medicamento m3 = new Medicamento("m3", comp3, cons);

        ArrayList<Droga> comp2 = new ArrayList<Droga>();
        comp2.add(m3);
        comp2.add(m5);
        Medicamento m2 = new Medicamento("m2", comp2, cons);

        ArrayList<Droga> comp1 = new ArrayList<Droga>();
        comp1.add(m2);
        comp1.add(d1);
        Medicamento m1 = new Medicamento("m1", comp1, cons);

        ///CARGO ESTRUCTURAS DEL SISTEMA
        medicamentos.add(m1);
        medicamentos.add(m2);
        medicamentos.add(m3);
        medicamentos.add(m4);
        medicamentos.add(m5);

        pacientes.add(new Paciente(d1, Sintoma.Cardiaco));
        pacientes.add(new Paciente(d3, Sintoma.S2));

    }
}
