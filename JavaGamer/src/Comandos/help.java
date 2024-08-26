package Comandos;
public class help {

    private String[] nomes;

    public help() {

     nomes = new String[]{
             "-------",
             "  help > esse é um comando de ajuda que mostrara para onde deve seguir e qual são os comando para prosseguir na game",
             "  get >",
             "  set >",
             "  inventory >",
             "  reset > ",
             "  save >",
             "-------",
     };
    }

    public String[] getNomes() {
        return nomes;
    }



}
