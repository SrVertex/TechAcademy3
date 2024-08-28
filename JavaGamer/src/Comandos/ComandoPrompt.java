package Comandos;

public class ComandoPrompt {

    public ComandoPrompt(String help) {

        String[] comandos = help.split(" ");
        String ComandoDigitado = comandos[0];

        switch (ComandoDigitado.toUpperCase()) {
            case "HELP":

                System.out.println(
                        "\n" +
                            "Help é um comando de mostra comandos usaveis no durante o game.\n" +
                            "Get: \n" +
                            "Inventory: O comando de inventario mostrara todos os itens que o jogador adquiriu duarante o progreço do jogo. \n" +
                            "Reset: Cuidado com esse comando, o reset limpara todo o progreço do jogador!!!!!!!! \n" +
                            "Save: Esse é um comando para salvar o progreço do game.\n" +
                        "\n"
                );

                break;
            case "GET_MADEIRA":
                System.out.println("Blocos de maderira coletados");

                break;
            default:

                System.out.println("comando invalido Digite novamente!");

        }
    }
}

