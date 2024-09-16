import Comandos.Console;
import Repositorio.ComandoService;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        post("/comando", (req, res) -> {
            String comandoBruto = req.queryParams("comando");
            ComandoService comandoService = new ComandoService(comandoBruto);
            Console resultado = comandoService.getResultadoConsole();
            return resultado.getMensagem();
        });

        post("/reset", (req, res) -> {
            // Implementar lógica para resetar o jogo
            return "Jogo resetado!";
        });

        post("/save", (req, res) -> {
            // Implementar lógica para salvar o progresso
            return "Progresso salvo!";
        });
    }
}

//Scanner scanner = new Scanner(System.in);
//  while (true) {
//          System.out.println("Digite um comando (ou 'sair' para encerrar):");
//String comandoBruto = scanner.nextLine();
//
//            if (comandoBruto.equalsIgnoreCase("sair")) {
//        break;
//        }
//
//ComandoService comandoService = new ComandoService(comandoBruto);
//Console resultado = comandoService.getResultadoConsole();
//
//            System.out.println("Resultado:");
//            System.out.println(resultado.getMensagem("Erro ao bescar dados da Inventario !!!"));
//        }
//
//        scanner.close();
//    }