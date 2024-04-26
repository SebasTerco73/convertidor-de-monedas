package Api;

import Modelos.Moneda;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.HashMap;

public class BuscadorDeMonedas {

    public static Moneda traerValores(String monedaA,String monedaB) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/704c868b59473ec0991727f5/" +
                "latest/"+monedaA);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);
            String baseCode = jsonObject.get("base_code").getAsString();
            HashMap<String,BigDecimal>conversion_rates = new HashMap<>();
            conversion_rates.put(monedaA,new BigDecimal(jsonObject.get("conversion_rates").getAsJsonObject().get(monedaA).getAsString()));
            conversion_rates.put(monedaB,new BigDecimal(jsonObject.get("conversion_rates").getAsJsonObject().get(monedaB).getAsString()));
            return new Moneda(baseCode, conversion_rates);
        } catch (JsonSyntaxException | NumberFormatException e) {
            throw new RuntimeException("Error al procesar la respuesta de la API de conversión de moneda.");
        } catch (Exception e) {
            throw new RuntimeException("Codigo de moneda incorrecto.");
        }
    }
}

