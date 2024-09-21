
import Comandos.CenasDAO;
import Comandos.Console;
import Controle.AntesDoJogoController;
import Controle.DuranteOJogoController;

import Model.Cenas;
import Repositorio.ComandoService;
import com.google.gson.Gson;

import spark.Spark;

import java.util.Scanner;

import static spark.Spark.post;


public class Main {

private static final Gson Gson = new Gson();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Bem-vindo ao Jogo! Digite 'start' para iniciar ou 'help' para ver os comandos disponíveis.");

        while (true) {
            System.out.print("> ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Saindo do jogo. Até a próxima!");
                break;
            }

            // Processar o comando com o ComandoService
            ComandoService comandoService = new ComandoService(input);
            Console resultado = comandoService.getResultadoConsole();

            // Exibir a mensagem de retorno no console
            System.out.println(resultado.getMensagem());
        }

        scanner.close();


//        //Rota 1 http://localhost:4567/{o comando vai aqui}
//        Spark.get("/:comando", new AntesDoJogoController(Gson));
//
//        //Rota 2 http://localhost:4567/{comando}/{save}
//        Spark.get("/:comando/:save", new DuranteOJogoController(Gson));



    }
}
