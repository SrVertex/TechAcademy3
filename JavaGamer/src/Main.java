import com.google.gson.Gson;

import Comandos.CenasDAO;
import spark.Spark;

public class Main {

    private static final Gson Gson = new Gson();

    public static void main(String[] args) {
        try {

            Spark.get("cenas/:id", (request, response) -> {
                Integer idCena = Integer.parseInt(request.params(":id"));
                return Gson.toJson(CenasDAO.findCenaById(idCena));
                // return Gson.toJson(InventarioDAO.);
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

