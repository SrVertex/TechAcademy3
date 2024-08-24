package Comandos;

public class ComandoPrompt {

    public ComandoPrompt(String help) {
        String[] comandos = help.split(" ");
        String ComandoDigitado = comandos[0];

        Comandos.help lista = new help();
        comandos = lista.getNomes();

        switch (ComandoDigitado.toUpperCase()) {
            case "HELP":

                for (String print : comandos ) {
                    System.out.println(print);
                }

            break;

        default:
            System.out.println("comando invalido Digite novamente!");
        }
    }
}
