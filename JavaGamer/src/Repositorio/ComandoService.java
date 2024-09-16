package Repositorio;

import Comandos.Console;
import Model.Invetario;

public class ComandoService {
    private final String[] comando;
    private final Console console;

    public ComandoService(String comandoBruto){
        Console console = new Console();
        this.console = console;
        this.comando = comandoBruto.split(" ");

    }

    public Console help() {
        console.setMensagem(
                "Comando           Descrição\n" +
                        "----------------  ------------------------------------------------------------\n" +
                        "HELP              Help é um comando de mostra comandos usáveis durante o game.\n" +
                        "GET               \n" +
                        "INVENTORY         O comando de inventário mostrará todos os itens que o jogador adquiriu durante o progresso do jogo.\n" +
                        "RESET             Cuidado com esse comando, o reset limpará todo o progresso do jogador!\n" +
                        "SAVE              Esse é um comando para salvar o progresso do game.\n"
        );
        return console;
    }

    public Console start() {
        try {
            Invetario save = new Invetario();
            console.setId_save_console(save.getId_save());
            return console;
        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao tentar iniciar o jogo");
            return console;
        }
    }

    public Console getResultadoConsole(){

        try {

            String primeiroComando = comando[0].toLowerCase();

            return switch (primeiroComando) {
                case "help" -> help();
                case "start" -> start();
                default -> {
                    console.setMensagem("Comando inválido");
                    yield console;
                }
            };
        } catch (Exception e) {
            console.setMensagem("Comando inválido");
            return console;
        }
    }
}

