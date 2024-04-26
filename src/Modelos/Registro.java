package Modelos;

import java.util.ArrayList;
import java.util.List;

public class Registro {

    private List<Consulta> registro;

    public Registro() {
        this.registro = new ArrayList<>();
    }

    public void verRegistro() {
        for (Consulta consulta : this.registro){
            System.out.println(consulta);
        }
    }

    public void agregarConsulta(Consulta consulta) {
        this.registro.add(consulta);
    }


}



