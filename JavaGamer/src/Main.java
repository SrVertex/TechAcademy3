import Comandos.CenasDAO;
import Comandos.ItemDAO;
import com.google.gson.Gson;
import spark.Spark;



public class Main {

    private static final Gson Gson = new Gson();

    public static void main(String[] args) {
        try {

//            String saveJson = Gson.toJson(save);
//            Spark.get("/", (req,res) -> saveJson);


            

//            Spark.get("cenas/:id", (request, response) -> {
//                Integer idCena = Integer.parseInt(request.params(":id")) ;
//                return  Gson.toJson(CenasDAO.findCenaById(idCena));
//            } );

            Spark.get("item/:id", (request, response) -> {
                Integer idItem = Integer.parseInt(request.params(":id")) ;
                return  Gson.toJson(ItemDAO.findItensByScene(idItem));
            } );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

//port(8080); // Porta em que o servidor Java vai rodar
//
//get("/api/comando", (req, res) -> {
//String comando = req.queryParams("comando");
//ComandoPrompt comandoPrompt = new ComandoPrompt(comando);
//            return comandoPrompt.getResposta();
//        });