package Controle;

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
    public Object handle(Request request, Response response) {
        String comando = request.params(":comando");
        String save = request.params(":save");
        String result = "Comando durante o jogo: " + comando + " com o save: " + save;
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
