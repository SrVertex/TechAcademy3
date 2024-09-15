import Comandos.CenasDAO;
import Comandos.InventarioDAO;
import Controle.AntesDoJogoController;
import Controle.DuranteOJogoController;
import com.google.gson.Gson;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import spark.Spark;

public class Main {

    private static final Gson Gson = new Gson();

    public static void main(String[] args) {


        Spark.get("/comando", new AntesDoJogoController(Gson));


      Spark.get("/:comando/:save", new DuranteOJogoController(Gson));


    }
}

