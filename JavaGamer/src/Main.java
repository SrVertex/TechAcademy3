import Comandos.Console;
import Repositorio.ComandoService;
import java.util.Scanner;

public class Main {

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
            System.out.println(resultado.getMensagem("Erro ao bescar dados da Inventario !!!"));
        }

        scanner.close();
    }
}
