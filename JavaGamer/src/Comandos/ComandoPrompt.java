package Comandos;

public class ComandoPrompt {

    private String resposta;

    public ComandoPrompt(String help) {

        String[] comandos = help.split(" ");
        String ComandoDigitado = comandos[0];

        switch (ComandoDigitado.toUpperCase()) {
            case "HELP":
                resposta = "Help é um comando de mostra comandos usaveis no durante o game.\n";
                resposta += "Get: \n";
                resposta += "Inventory: O comando de inventario mostrara todos os itens que o jogador adquiriu duarante o progreço do jogo. \n";
                resposta += "Reset: Cuidado com esse comando, o reset limpara todo o progreço do jogador!!!!!!!! \n";
                resposta += "Save: Esse é um comando para salvar o progreço do game.\n";
                break;
            case "GET_MADEIRA":
                resposta = "Blocos de maderira coletados";
                break;
            default:
                resposta = "comando invalido Digite novamente!";
        }
    }

    public String getResposta() {
        return resposta;
    }
}
