import Comandos.Console;
import Controle.AntesDoJogoController;
import Controle.DuranteOJogoController;
import Comandos.CenasDAO;
import Comandos.InventarioDAO;
import Comandos.ItemDAO;
import Model.Cenas;
import Model.Invetario;
import Model.Item;
import Repositorio.ComandoService;
import com.google.gson.Gson;
import spark.Spark;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    private static final String BASE_URL = "http://localhost:4567"; // URL base do servidor Spark

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite um comando (ou 'sair' para encerrar):");
            String comandoBruto = scanner.nextLine();

            if (comandoBruto.equalsIgnoreCase("sair")) {
                break;
            }

            ComandoService comandoService = new ComandoService(comandoBruto);
            Console resultado = comandoService.getResultadoConsole();


            System.out.println("Resultado:");
            System.out.println(resultado.getMensagem("Esse Comando não Existe!!!!!!!! NULL"));
        }

        scanner.close();
    }
}