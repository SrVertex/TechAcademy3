package Comandos;

public class ComandoPrompt {

    private String resposta;

    public ComandoPrompt(String help) {

        String[] comandos = help.split(" ");
        String ComandoDigitado = comandos[0];

        switch (ComandoDigitado.toUpperCase()) {
            case "HELP":
                resposta = "Comando           Descrição\n" +
                        "----------------  ------------------------------------------------------------\n" +
                        "HELP              Help é um comando de mostra comandos usáveis durante o game.\n" +
                        "GET               \n" +
                        "INVENTORY         O comando de inventário mostrará todos os itens que o jogador adquiriu durante o progresso do jogo.\n" +
                        "RESET             Cuidado com esse comando, o reset limpará todo o progresso do jogador!\n" +
                        "SAVE              Esse é um comando para salvar o progresso do game.\n";
                break;
            case "MADEIRA":
                resposta = "MADEIRA: É um item que é possivel usapo a criação de espadas, pricareta";
                break;
            default:
                resposta = "comando invalido Digite novamente!";
        }
    }

    public String getResposta() {
        return resposta;
    }
}