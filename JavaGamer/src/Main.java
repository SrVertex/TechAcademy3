import Comandos.CenasDAO;
import Comandos.InventarioDAO;
import com.google.gson.Gson;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import spark.Spark;

public class Main {

    private static final Gson Gson = new Gson();

    public static void main(String[] args) {





        try {
           Spark.get("cenas/:id", (request, response) -> {
             Integer idCena = Integer.parseInt(request.params(":id"));
               Integer idInventory = Integer.parseInt(request.params(":id"));

              // Obter dados de CenasDAO
                String cenasJson = Gson.toJson(CenasDAO.findCenaById(idCena));

                // Obter dados de InventarioDAO
               String inventarioJson = Gson.toJson(InventarioDAO.findInvetarioById(idInventory));

               // Combinar os resultados em um único JSON
                JsonObject combinedResult = new JsonObject();
                combinedResult.add("cenas", new JsonParser().parse(cenasJson));
               combinedResult.add("inventario", new JsonParser().parse(inventarioJson));

                return combinedResult.toString();
           });


        } catch (Exception e) {
          throw new RuntimeException(e);
        }

    }
}

