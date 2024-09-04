

import Model.Console;
import Model.Save;
import Repository.CenaDAO;
import Repository.SaveDAO;
import com.google.gson.Gson;
import spark.Spark;

import java.sql.SQLException;


public class Main {

    private static final Gson Gson = new Gson();

    public static void main(String[] args) {

        try {
            Save save = SaveDAO.novoJogo();
            Console consele = new Console();

            String saveJson = Gson.toJson(save);
            Spark.get("/", (req,res) -> saveJson);

            Spark.get("cena/:id", (request, response) -> {
                Integer idCena = Integer.parseInt(request.params(":id")) ;
                return  Gson.toJson(CenaDAO.finalCenabyid(idCena));
            } );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
