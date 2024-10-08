package Repositorio;

import Comandos.CenasDAO;
import Model.Console;
import Comandos.InventarioDAO;
import Comandos.ItemDAO;
import Model.Cenas;
import Model.Invetario;
import Model.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComandoService {
        // CONST PRIVADA
    private final String[] comando;
    private final Console console;
    private final InventarioDAO inventarioDAO;
    private final CenasDAO cenasDAO;

    public ComandoService(String ComandoBruto) {

        this.console = new Console();
        this.inventarioDAO = new InventarioDAO();
        this.cenasDAO = new CenasDAO();
        // MA
        this.comando = ComandoBruto.split(" ");

    }
            // LOCAL DE VALIDAÇÃO DO JOGO
    public Console getResultadoConsole() {

        if ("start".equals(this.comando[0])) {
            // COMANDO START QUANDO O COMANDO SER INICIALIZADO IRA CRIA UM NOVO SAVE NO
            // BANCO DE DADOS
            this.Start();

        } else if ("help".equals(this.comando[0])) {
            // COMANDO HELP VAI PRINTAR INFOMAÇÕES DE AJUDA PARA O USURAIO
            this.help();

        } else if("inventario".equals(comando[0])){

            this.inventario();

        }else if ("use".equals(this.comando[0])) {

            try {

                Cenas cenas = CenasDAO.findCenaById(CenasDAO.proximaCenas);
                String nomeItem = this.comando[1];


                List<Invetario> inventario = InventarioDAO.BuscaInventario();

                boolean itemNoInventario = false;

                for (Invetario item : inventario) {
                    if (item.getNome_item().equalsIgnoreCase(nomeItem)) {
                        itemNoInventario = true;
                        break;
                    }
                }

                if (itemNoInventario) {

                    if (cenas.getItens1().stream().anyMatch(item -> item.getNome_item().equalsIgnoreCase(nomeItem))) {


                        if (this.comando.length > 2 && "with".equals(this.comando[2])) {
                            String nomeItem2 = this.comando[3];

                            boolean itemCenarioValido = false;
                            for (Item item : cenas.getItens1()) {
                                if (item.getItemCenario_with().equalsIgnoreCase(nomeItem2)) {
                                    itemCenarioValido = true;
                                    break;
                                }
                            }

                            if (itemCenarioValido) {

                                System.out.println(cenas.getTextoPositivo_cena());
                                CenasDAO.proximaCenas++;
                            } else {

                                System.out.println(cenas.getTextoNegativo_cena());
                            }
                        } else {

                            System.out.println(cenas.getTextoPositivo_cena());
                            CenasDAO.proximaCenas++;
                        }


                        try {
                            Thread.sleep(5000);
                            System.out.println("----------------------------------");

                            cenas = CenasDAO.findCenaById(CenasDAO.proximaCenas);
                            console.setMensagem(cenas.getDescricao_cena());

                        } catch (InterruptedException | SQLException e) {
                            e.printStackTrace();
                        }

                    } else {

                        console.setMensagem(cenas.getTextoNegativo_cena());
                    }

                } else {

                    console.setMensagem("O item informado não está no inventário.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if ("get".equals(comando[0])) {

            // COMMAND RESPONSIVE POR RESGATAR O ITEM DA CENA E DICTIONARY NO INVENTORY
            try {

                Cenas cenas = CenasDAO.findCenaById(CenasDAO.proximaCenas);
                List<Item> itens = ItemDAO.findItensByScene(cenas);
                String nomeitem = this.comando[1];

                for (Item item : itens) {

                    if (item.getNome_item().equals(nomeitem)) {

                        InventarioDAO.itemInventario();

                        console.setMensagem("o " + item.getNome_item() + " foi coletado e inserido no Inventario");

                    }
                }

            } catch (Exception e) {

                return console;

            }

        } else if ("check".equals(comando[0])) {

            // COMMAND RESPONSIVE POR RESGATAR O ITEM DA CENA E DICTIONARY NO INVENTORY
            try {

                Cenas cenas = CenasDAO.findCenaById(CenasDAO.proximaCenas);
                List<Item> itens = ItemDAO.findItensByScene(cenas);
                String nomeitem = this.comando[1];

                for (Item item : itens) {

                    if (item.getNome_item().equals(nomeitem)) {

                        console.setMensagem(item.getCheck_item());

                    } else {
                        console.setMensagem("O item digitado para checagem nao existe.");
                    }
                }

            } catch (Exception e) {
                return console;
            }

        } else {
            this.erro();
        }

        return console;
    }

    // comando erro
    public Console erro() {

        console.setMensagem(
                "Voce nao utilizou um dos comandos disponiveis. Utilize 'help' para consultar a lista disponivel");
        return console;

    }

    // comando help
    public Console help() {
        console.setMensagem("Comando           Descrição\n" +
                "---------------------------------------------------------------------------------------\n" +
                "START             O start é usado para iniciar o game.\n" +
                "HELP              Help é um comando de mostra comandos usáveis durante o game.\n" +
                "GET               O get é usado para pegar um item da cena (get nome do item).\n" +
                "INVENTORY         O comando de inventário mostrará todos os itens que o jogador adquiriu durante o progresso do jogo.\n"
                +
                "RESET             Cuidado com esse comando, o reset limpará todo o progresso do jogador!\n" +
                "CHECK             O comando check é feito para especionar um item da cena.\n" +
                "SAVE              Esse é um comando para salvar o progresso do game.\n" +
                "EXIT              Esse comando serve para finalizar o game.");
        return console;
    }

    // comando start
    public Console Start() {
        try {
            Invetario save1 = InventarioDAO.SaveGame();
            console.setMensagem(save1.getId_cena_atual().getDescricao_cena());
            console.setId_save_console(save1.getId_save());
            return console;
        } catch (Exception e) {

            console.setMensagem("erro ao tentar iniciar o game");
            return console;
        }
    }

    // comando inventario
    public Console inventario() {
        try {
            List<Invetario> inventario = InventarioDAO.BuscaInventario();
            List<String> itensArray = new ArrayList<>();

            for (Invetario item : inventario) {
                String itemInfo = "______ ID do Item: " + item.getItem() + ", Nome do Item: " + item.getNome_item() + "______";
                itensArray.add(itemInfo);
            }

            console.setMensagem("Inventário: " + itensArray.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return console;
    }
}