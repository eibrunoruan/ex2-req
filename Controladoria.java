public class Controladoria {
    private String[] identificadores;
    private String[] senhas;
    private int totalAssociados;

    public Controladoria(int maxAssociados) {
        identificadores = new String[maxAssociados];
        senhas = new String[maxAssociados];
        totalAssociados = 0;
    }
//
    public void registrarAcesso(String identificador, String senha) {
        if (totalAssociados < identificadores.length) {
            identificadores[totalAssociados] = identificador;
            senhas[totalAssociados] = senha;
            totalAssociados++;
        } else {
            System.out.println("Limite de associados atingido.");
        }
    }

    public boolean autenticar(String identificador, String senha) {
        for (int i = 0; i < totalAssociados; i++) {
            if (identificadores[i].equals(identificador) && senhas[i].equals(senha)) {
                return true;
            }
        }
        return false;
    }
}
