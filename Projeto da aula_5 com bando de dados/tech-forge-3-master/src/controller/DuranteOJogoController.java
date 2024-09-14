package controller;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class DuranteOJogoController implements Route {
    private final Gson gson;

    public DuranteOJogoController(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        return "Implementar a Rota";
    }
}
