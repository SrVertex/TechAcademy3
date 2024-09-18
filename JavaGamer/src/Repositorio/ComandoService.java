package Repositorio;

import Comandos.CenasDAO;
import Comandos.Console;
import Comandos.InventarioDAO;
import Comandos.ItemDAO;
import Model.Cenas;
import Model.Invetario;

public class ComandoService {

    private final String[] comando;
    private final Console console;
    private final CenasDAO cenasDAO;
    private final ItemDAO itemDAO;
    private final InventarioDAO inventarioDAO;

    public ComandoService(String comandoInteiro) {
        this.console = new Console();
        this.comando = comandoInteiro.split(" ");
        this.cenasDAO = new CenasDAO();
        this.itemDAO = new ItemDAO();
        this.inventarioDAO = new InventarioDAO();
    }

    public Console help() {
        console.setMensagem("Comando           Descrição\n" +
                "----------------  ------------------------------------------------------------\n" +
                "HELP              Help é um comando de mostra comandos usáveis durante o game.\n" +
                "GET               \n" +
                "INVENTORY         O comando de inventário mostrará todos os itens que o jogador adquiriu durante o progresso do jogo.\n"
                +
                "RESET             Cuidado com esse comando, o reset limpará todo o progresso do jogador!\n" +
                "CHECK             O comando check é feito para especionar um item da cena.\n" +
                "SAVE              Esse é um comando para salvar o progresso do game.\n");
        return console;
    }

    String erro = "Comando digitado incorretamente!!!!";

    Integer id = 1;

    // comando start
    public Console start() {
        try {

            Cenas cena = cenasDAO.findCenaById(id);
            console.setMensagem(cena.getDescricao_cena());

        } catch (Exception e) {
            console.setMensagem("Erro ao obter a cena: " + e.getMessage());
        }
        return console;
    }

    // comando inventario
    public Console inventario() {
        try {

            Invetario invetario = InventarioDAO.findInvetarioById(id);
            console.setMensagem(invetario.getId_save().toString());
            console.setMensagem(invetario.getItenss().toString());

        } catch (Exception e) {
            console.getMensagem();
        }
        return console;
    }

    // comando save mostrar
    public Console savaMostar() {

        try {

            Invetario invetario = InventarioDAO.findInvetarioById(id);
            console.setMensagem("Voce esta jogando no save: " + invetario.getId_save().toString());

        } catch (Exception e) {
            console.setMensagem(erro);
        }
        return console;
    }

    public Console check() {

        return console;
    }


    public Console proximaCena() {
        if (true){

        } else {
            System.out.println("comando errado");
        }
        return console;
    }


    // local de execução real
    public Console getResultadoConsole() {
        try {
            String primeiroComando = comando[0].toUpperCase();

            return switch (primeiroComando) {
                case "HELP" -> help();
                case "START" -> start();
                case "INVENTARIO" -> inventario();
                case "SAVE_ID" -> savaMostar();
                case "CHECK" -> check();
                case "MADEIRA" -> proximaCena();
                default -> {
                    console.setMensagem("Comando incorreto!");
                    yield console;
                }
            };
        } catch (Exception e) {
            console.setMensagem("Erro ao processar o comando!");
            return console;
        }
    }
}
