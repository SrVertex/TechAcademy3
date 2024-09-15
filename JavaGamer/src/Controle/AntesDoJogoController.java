package Controle;

import Comandos.Console;
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
    public Object handle(Request request, Response response) {
        String comando = request.queryParams("comando");
        String result = "Você iniciou o comando: " + comando;
        response.type("application/json");
        return gson.toJson(new Resposta(result));
    }

    private class Resposta {
        private String mensagem;

        public Resposta(String mensagem) {
            this.mensagem = mensagem;
        }
    }
}
