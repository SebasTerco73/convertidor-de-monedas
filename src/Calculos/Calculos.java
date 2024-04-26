package Calculos;
import Api.BuscadorDeMonedas;
import Modelos.Moneda;
import java.math.BigDecimal;
import java.util.Map;

public class Calculos {
public static BigDecimal calcular(String monedaA,String monedaB,BigDecimal cuanto){
    Moneda valores = BuscadorDeMonedas.traerValores(monedaA,monedaB);
    BigDecimal valorB = new BigDecimal("0");
    for (Map.Entry<String, BigDecimal> entry : valores.conversion_rates().entrySet()) {
        String clave = entry.getKey();
        BigDecimal valor = entry.getValue();
        if(clave.equals(monedaB)){
            valorB = valor;
        }
    }
    return cuanto.multiply(valorB);
}
}
