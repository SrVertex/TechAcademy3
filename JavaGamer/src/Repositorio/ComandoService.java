package Repositorio;

import Comandos.Console;

public class ComandoService {

    private final String[] comando;
    private final Console console;

    // private de reposta
    private String resposta;

    public ComandoService(String comandoInteiro) {

        Console console = new Console();
        this.console = console;
        this.comando = comandoInteiro.split(" ");
    }
            // comando help
        public Console help() {
        console.getMensagem(
                        "Comando           Descrição\n" +
                        "----------------  ------------------------------------------------------------\n" +
                        "HELP              Help é um comando de mostra comandos usáveis durante o game.\n" +
                        "GET               \n" +
                        "INVENTORY         O comando de inventário mostrará todos os itens que o jogador adquiriu durante o progresso do jogo.\n" +
                        "RESET             Cuidado com esse comando, o reset limpará todo o progresso do jogador!\n" +
                        "SAVE              Esse é um comando para salvar o progresso do game.\n"

        );
        return  console;
        }


    public Console getResultadoConsole(){

        String primeiroComando = comando[0].toLowerCase();

        switch (primeiroComando.toUpperCase()) {
            case "HELP":
                System.out.println(help());
                break;
            case "MADEIRA":
                System.out.println("MADEIRA: É um item que é possivel usapo a criação de espadas, pricareta");
                break;
            default:
                System.out.println( "comando invalido Digite novamente!");
        }
            return console ;
    }
}
