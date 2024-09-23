package Controle;

import Model.Console;
import Repositorio.ComandoService;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class AntesDoJogoController implements Route {

    private final Gson gson;

    public AntesDoJogoController(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {

        String comandoInteiro = request.params(":comando");

        ComandoService comandoService = new ComandoService(comandoInteiro);

        Console console = comandoService.getResultadoConsole();

        return gson.toJson(console);

    }
}
