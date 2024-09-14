import com.google.gson.Gson;
import controller.AntesDoJogoController;
import controller.DuranteOJogoController;
import spark.Spark;

public class Main {
    private static final Gson gson = new Gson();
    public static void main(String[] args) {

        //Na classe main deixamos apenas as rotas da API
        //controller -> É responsável por tratar as requisições e respostas http
        //service -> É responsável pela lógica e regra de negócio da aplicação.
        //model -> É responsável por definir os atributos e métodos das entidades do projeto.
        //repository -> É responsável pela comunicação com o banco de dados.

        //Rota 1 http://localhost:4567/{o comando vai aqui}
        Spark.get("/:comando", new AntesDoJogoController(gson));

        //Rota 2 http://localhost:4567/{comando}/{save}
        Spark.get("/:comando/:save", new DuranteOJogoController(gson));

        //Implemente mais rotas se precisar

    }
}