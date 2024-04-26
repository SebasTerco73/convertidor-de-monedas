package Modelos;

import Calculos.Calculos;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consulta {
    private final String fecha;
    private final String monedaA;
    private final String monedaB;
    private final BigDecimal cantidad;
    private final BigDecimal total;


    public Consulta(String monedaA, String monedaB, BigDecimal cantidad) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.fecha = LocalDateTime.now().format(formatter);
        this.monedaA = monedaA;
        this.monedaB = monedaB;
        this.cantidad = cantidad;
        this.total = Calculos.calcular(monedaA,monedaB,cantidad);
        System.out.println("Total: " + this.total + " " + monedaB);
    }

    @Override
    public String toString() {
       String desde = cantidad.toString().replace('.',',');
       String hasta = total.toString().replace('.',',');
        return "[ Fecha "+ fecha + '\n' +
                "==> " + desde + " " + monedaA + " = " + hasta + " " + monedaB + " <== ]" +
                "\n**************************************";
    }
}
