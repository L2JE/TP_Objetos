package MainPack;

import java.util.*;
import Drogas.*;
import Filtros.*;

public class Farmacia {

    private static ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
    private static ArrayList<Integer> stock = new ArrayList<>();
    private static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

    public static void main(String[] args){
        inicArrs();
        //testFiltradoDroga();//OK
        //testRecetarAEnf();//OK
        //testRecetarAEnfPac();//OK
        //testRecetarDrogas();//ok
        testPorcentajes();


    }

    //Se resolveria c/algoritmo asignacion de tareas
    public static ArrayList<Medicamento> recetarMed(Enfermedad enf){
    	ArrayList<Medicamento> res = new ArrayList<Medicamento>();
    	
    	ArrayList<EstPato> estadosPatologicos = enf.getEPatos();

    	for(Medicamento m: medicamentos){
    	    boolean cumple = true;
            for(EstPato e: estadosPatologicos)///DEVE CURAR TODOS LOS ESTADOS PATOLOGICOS,
                if (!m.esAccionTerap(e)){
                    cumple = false;
                    break;
                }

            if(cumple && (stock.get(medicamentos.indexOf(m)) > 0))
                res.add(m);
        }

    	return res;
    	
    }

    public static ArrayList<Droga> recetarDrog(Enfermedad enf){///Ignoramos el Stock
        ArrayList<Droga> res = new ArrayList<Droga>();

        ArrayList<EstPato> estadosPatologicos = enf.getEPatos();
        ArrayList<Filtro> filtros = new ArrayList<Filtro>();
        for(EstPato e : estadosPatologicos)
            filtros.add(new FAccTerap(e));

        Filtro f = new FAnd(filtros);

        for(Medicamento m: medicamentos){
            ArrayList<Droga> aux = m.getDrogas(f);
            for(Droga d : aux )
                if(!res.contains(d))
                    res.add(d);
        }

        for(Medicamento m : medicamentos){

        }


        return res;

    }
    
    /*TODO: ESPERAR RESPUESTA DEL PROFE
            *consultar por los constructores con ArrayList de los FLogicos
            *getMeds devuelve los medicamentos por los que esta compuesto M
            *getDrogas devuelve Medicamento y DrogaSimple del que esta hecho
            *para recetar, que pasa si M2 es la cura y no lo tengo, M1 tiene M2 => solo deveria devolver M1
    */
    public static ArrayList<Medicamento> recetarMed(Enfermedad enf, Paciente pac) {
        ArrayList<Medicamento> res = new ArrayList<Medicamento>();
        FAnd f;
        {
            ArrayList<DrogaSimple> alergias = pac.getAlergias();
            ArrayList<Sintoma> sintomas = pac.getSintomas();
            ArrayList<EstPato> ePatos = enf.getEPatos();

            ArrayList<Filtro> fsAlergias = new ArrayList<Filtro>();//drogas que no puede consumir
            ArrayList<Filtro> fsSintomas = new ArrayList<Filtro>();//contraindicaciones que no puede tener
            ArrayList<Filtro> fsAccTerap = new ArrayList<Filtro>();//ePatologicos que debe curar

            for (DrogaSimple d : alergias)
                fsAlergias.add(new FDroga(d));
            for (Sintoma s : sintomas)
                fsSintomas.add(new FContraindic(s));
            for (EstPato e : ePatos)
                fsAccTerap.add(new FAccTerap(e));

            ArrayList<Filtro> filtros = new ArrayList<Filtro>();
            filtros.add(new FAnd(fsAccTerap));
            filtros.add(new FNot(new FOr(fsAlergias)));
            filtros.add(new FNot(new FOr(fsSintomas)));

            f = new FAnd(filtros);
       }



        for (Medicamento m : medicamentos)
            if(f.cumple(m) && (stock.get(medicamentos.indexOf(m)) > 0))
                res.add(m);

        /*Solucion SIN FILTROS
        ArrayList<DrogaSimple> alergias = pac.getAlergias();
        ArrayList<Sintoma> sintomas = pac.getSintomas();
        ArrayList<EstPato> ePatos = enf.getEPatos();
        for(Medicamento m : medicamentos){
            boolean cumple = true;
            for(Droga d : alergias)
                if(m.contiene(d)){
                    cumple = false;
                    break;
                }
            if(cumple){
                for (Sintoma s : sintomas){
                    if (m.esContraindic(s)){
                        cumple = false;
                        break;
                    }
                }
                if(cumple){
                    for(EstPato e : ePatos){
                        if(!m.esAccionTerap(e)){
                            cumple = false;
                            break;
                        }
                    }
                }
            }
            if(cumple && (stock.get(medicamentos.indexOf(m)) > 0))
                res.add(m);
        }
        */

        return res;
    }
    
    public static float getPorcentajeMed(Medicamento m, Droga d) {
    	return m.getPorcentDroga(d);
    }

    public static ArrayList<Medicamento> getMedsPorcentaje(Droga d, float porcent){
        ArrayList<Medicamento> res = new ArrayList<Medicamento>();
        for(Medicamento m : medicamentos){
            if(m.getPorcentDroga(d) > porcent)
                res.add(m);
        }
        return res;
    }

    private static void inicArrs(){

        //INICIALIZANDO DROGAS SIMPLES
        ArrayList<EstPato> accTerap5 = new ArrayList<EstPato>();
        ArrayList<Sintoma> contra5 = new ArrayList<Sintoma>();
        accTerap5.add(EstPato.E2);
        contra5.add(Sintoma.Lactancia);
        DrogaSimple d5 = new DrogaSimple("d5", accTerap5, contra5);

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
        comp1.add(d5);
        comp1.add(d1);
        float[] cons1 = {(float) 0.5, (float) 0.5, (float) 0.5};
        Medicamento m1 = new Medicamento("m1", comp1, cons1);

        ///CARGO ESTRUCTURAS DEL SISTEMA
        medicamentos.add(m1);
        stock.add(5);
        medicamentos.add(m2);
        stock.add(5);
        medicamentos.add(m3);
        stock.add(5);
        medicamentos.add(m4);
        stock.add(5);
        medicamentos.add(m5);
        stock.add(5);


        pacientes.add(new Paciente(d1, Sintoma.Cardiaco));
        pacientes.add(new Paciente(d3, Sintoma.S2));

    }

    static void testFiltradoDroga(){
        System.out.println("Inicio test filtrado por Droga");

        Medicamento m = medicamentos.get(2);
        DrogaSimple d4 = new DrogaSimple("d4", new ArrayList<EstPato>(), new ArrayList<Sintoma>());
        ArrayList<Medicamento> medsFiltrados = m.getMeds(new FDroga(d4));

        System.out.println("Tamaño resultado: " + medsFiltrados.size());
        if(medsFiltrados.size() > 0)
            for(Medicamento med : medsFiltrados)
                System.out.println(med.getNombre());

        System.out.println("FIN test filtrado por Droga");


    }

    static void testRecetarAEnf(){
        System.out.println("Inicio test recetar Medicamento a Enfermedad");
        System.out.println("Resultado esperado: M1, M2, M5");
        ArrayList<EstPato> estados = new ArrayList<EstPato>();
        estados.add(EstPato.E1);
        //estados.add(EstPato.E2);

        Enfermedad e = new Enfermedad("Lepra", estados);
        System.out.println("Enfermedad a recetar:");
        System.out.println(e);

        ArrayList<Medicamento> receta = recetarMed(e);

        System.out.println("RECETA: ");
        for (Medicamento m : receta)
            System.out.println(m.getNombre());

        System.out.println("FIN test recetar Medicamento a Enfermedad");
    }

    static void testRecetarAEnfPac(){
        System.out.println("Inicio test recetar Medicamento a Paciente de Riesgo");
        System.out.println("Resultado esperado: M2, M5");

        ArrayList<EstPato> estados = new ArrayList<EstPato>();
        estados.add(EstPato.E2);
        Enfermedad e = new Enfermedad("Alzheimer", estados);

        Sintoma sintoma = Sintoma.Lactancia;
        Paciente paciente = new Paciente(sintoma);
        System.out.println(paciente);

        System.out.println("Enfermedad a recetar:");
        System.out.println(e);

        ArrayList<Medicamento> receta = recetarMed(e,paciente);

        System.out.println("RECETA: ");
        for (Medicamento m : receta)
            System.out.println(m.getNombre());

        System.out.println("FIN test recetar Medicamento a Paciente de Riesgo");
    }

    static void testRecetarDrogas(){
        System.out.println("Inicio test recetar Drogas a Enfermedad");
        System.out.println("Resultado esperado: M1, M2, M5, D0");
        ArrayList<EstPato> estados = new ArrayList<EstPato>();
        estados.add(EstPato.E1);
        //estados.add(EstPato.E2);

        Enfermedad e = new Enfermedad("Lepra", estados);
        System.out.println("Enfermedad a recetar:");
        System.out.println(e);

        ArrayList<Droga> receta = recetarDrog(e);

        System.out.println("RECETA: ");
        for (Droga m : receta)
            System.out.println(m.getNombre());

        System.out.println("FIN test recetar Drogas a Enfermedad");
    }

    static void testPorcentajes(){
        System.out.println("Inicio test Porcentaje de droga en un medicamento");
        ArrayList<EstPato> accTerap1 = new ArrayList<EstPato>();
        ArrayList<Sintoma> contra1 = new ArrayList<Sintoma>();
        accTerap1.add(EstPato.E2);
        contra1.add(Sintoma.S2);
        DrogaSimple d1 = new DrogaSimple("d1", accTerap1, contra1);

        Medicamento med = medicamentos.get(1);

        System.out.println("Medicamento: " + med.getNombre());
        System.out.println("Droga: " + d1.getNombre());
        System.out.println("Resultado esperado= 0,25");



        float res= getPorcentajeMed(med, d1);

        System.out.println("Resultado ="+ res);
        System.out.println("FIN test Porcentaje de droga en un medicamento");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Inicio test medicamentos con porcentaje de droga mayor al dado");
        float porcent = (float) 0.4;

        System.out.println("Porcentaje Dado: " + porcent);
        System.out.println("Droga: " + d1.getNombre());
        System.out.println("Resultado esperado= m1,m5");



        ArrayList<Medicamento> res1 = getMedsPorcentaje(d1, porcent);

        System.out.println("Resultado =");
        for(Medicamento m : res1){
            System.out.println(m.getNombre());
        }
        System.out.println("FIN test medicamentos con porcentaje de droga mayor al dado");
    }
}
