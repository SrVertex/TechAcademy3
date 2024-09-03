
public class Main {
    public static void main(String[] args) {

        port(8080); // Porta em que o servidor Java vai rodar

        get("/api/comando", (req, res) -> {
            String comando = req.queryParams("comando");
            ComandoPrompt comandoPrompt = new ComandoPrompt(comando);
            return comandoPrompt.getResposta();
        });
    }
}