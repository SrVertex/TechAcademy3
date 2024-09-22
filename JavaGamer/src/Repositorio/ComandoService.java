package Repositorio;

import Comandos.CenasDAO;
import Comandos.Console;
import Comandos.InventarioDAO;
import Comandos.ItemDAO;
import Model.Cenas;
import Model.Invetario;
import Model.Item;

import java.sql.SQLException;
import java.util.List;

public class ComandoService {
    private final String[] comando;
    private final Console console;
    private final InventarioDAO inventarioDAO;
    private final CenasDAO cenasDAO;


    public ComandoService(String ComandoBruto) {

        this.console = new Console();
        this.inventarioDAO = new InventarioDAO();
        this.cenasDAO = new CenasDAO();


        this.comando = ComandoBruto.split(" ");

    }

    public Console getResultadoConsole() {


        if ("start".equals(this.comando[0])) {

            this.Start();

        }else if ("help".equals(this.comando[0])) {

            this.help();

        } else if ("use".equals(this.comando[0])){
           try {
              Cenas cenas = CenasDAO.findCenaById(CenasDAO.proximaCenas);
               List<Item> itens = ItemDAO.findItensByScene(cenas);
               String nomeitem = this.comando[1];


               for (Item item : itens) {
                   if (item.getNome_item().equals(nomeitem)) {
                       System.out.println(cenas.getTextoPositivo_cena());
                       // Exibe a descrição da cena atual
                       // Atualiza para a próxima cena
                       CenasDAO.proximaCenas = CenasDAO.proximaCenas + 1;

                       // Espera por 5 segundos
                       try {
                           Thread.sleep(5000);
                           System.out.println("----------------------------------");
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }

                       // Busca a nova cena após a atualização
                       try {
                           cenas = CenasDAO.findCenaById(CenasDAO.proximaCenas);
                           // Exibe a descrição da nova cena
                           System.out.println(cenas.getDescricao_cena());
                       } catch (SQLException e) {
                           e.printStackTrace();
                       }
                   } else {
                       System.out.println(cenas.getTextoNegativo_cena());
                   }
               }








                if (this.comando[2] != null && "with".equals(this.comando[2])){
                    String nomeitem2 = this.comando[3];
                    for (Item item : itens){










                        if (item.getItemCenario_with().equals(nomeitem2)) {
                            System.out.println(cenas.getTextoPositivo_cena());
                            // Exibe a descrição da cena atual
                            // Atualiza para a próxima cena
                            CenasDAO.proximaCenas = CenasDAO.proximaCenas + 1;

                            // Espera por 5 segundos
                            try {
                                Thread.sleep(5000);
                                System.out.println("----------------------------------");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            // Busca a nova cena após a atualização
                            try {
                                cenas = CenasDAO.findCenaById(CenasDAO.proximaCenas);
                                // Exibe a descrição da nova cena
                                System.out.println(cenas.getDescricao_cena());
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println(cenas.getTextoNegativo_cena());
                        }











                    }
               }

           } catch (Exception e) {
               return console;
           }
        }












        else {
            System.out.println("Voce nao utilizou um dos comandos disponiveis. Utilize 'help' para consultar a lista disponivel");
        }

        return console;
    }


    // comando help
    public Console help() {
        console.setMensagem("Comando           Descrição\n" +
                "----------------  ------------------------------------------------------------\n" +
                "START             O start é usado para iniciar o game.\n"+
                "HELP              Help é um comando de mostra comandos usáveis durante o game.\n" +
                "GET               O get é usado para pegar um item da cena (get nome do item).\n" +
                "INVENTORY         O comando de inventário mostrará todos os itens que o jogador adquiriu durante o progresso do jogo.\n" +
                "RESET             Cuidado com esse comando, o reset limpará todo o progresso do jogador!\n" +
                "CHECK             O comando check é feito para especionar um item da cena.\n" +
                "SAVE              Esse é um comando para salvar o progresso do game.\n"+
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
       }catch (Exception e) {

            console.setMensagem("erro ao tentar iniciar o game");
            return console;
        }
  }

}
