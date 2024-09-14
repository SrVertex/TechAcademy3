import Comandos.InventarioDAO;
import com.google.gson.Gson;

import Comandos.CenasDAO;
import Comandos.ItemDAO;
import spark.Spark;

public class Main {

    private static final Gson Gson = new Gson();

    public static void main(String[] args) {
        try {

            Spark.get("cenas/:id", (request, response) -> {
                Integer idCena = Integer.parseInt(request.params(":id"));
                // não sei se vai funcionar mais se funcionar é jesus
                return Gson.toJson(CenasDAO.findCenaById(idCena));
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

