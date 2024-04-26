package Modelos;

import java.math.BigDecimal;
import java.util.HashMap;

public record Moneda(String base_code, HashMap<String,BigDecimal> conversion_rates) {
}
