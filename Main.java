import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Associado associadoResponsavel = new Associado("Bruno", "1111111", "1111111", "1111111", "Rua A", "Banco XYZ", "Responsável", null);

        Associado dependente = new Associado("Ruan", "222222", "22222", "222222", "Rua B", "Banco XYZ", "Dependente", associadoResponsavel);
//
        associadoResponsavel.gerarMensalidade(150.0, new Date());
        dependente.gerarMensalidade(100.0, new Date());

        Controladoria controleAcesso = new Controladoria(10);
        controleAcesso.registrarAcesso("Bruno", "newworld!");

        boolean autenticado = controleAcesso.autenticar("Bruno", "newworld!");
        System.out.println("Autenticado: " + autenticado);

        associadoResponsavel.registrarEntradaSaida("Entrada");
        associadoResponsavel.registrarEntradaSaida("Saída");

        if (associadoResponsavel.podeSair()) {
            System.out.println("Associado pode sair.");
        } else {
            System.out.println("Associado não pode sair, contas do bar não estão fechadas.");
        }

        associadoResponsavel.getConta().depositar(500.0);
        associadoResponsavel.getConta().debitar(150.0);
        associadoResponsavel.getConta().sacarSaldoRestante();
    }
}
