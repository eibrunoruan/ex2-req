import java.util.ArrayList;
import java.util.Date;

public class Associado {
    private String nome;
    private String rg;
    private String cpf;
    private String telefone;
    private String endereco;
    private String dadosBancarios;
    private String tipo;
    private Associado responsavel;  // Para associados dependentes
    private ContaFinanceira conta = new ContaFinanceira();
    private ArrayList<Mensalidade> mensalidades = new ArrayList<>();
//
    public Associado(String nome, String rg, String cpf, String telefone, String endereco, String dadosBancarios, String tipo, Associado responsavel) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.dadosBancarios = dadosBancarios;
        this.tipo = tipo;
        this.responsavel = responsavel;
    }

    public void gerarMensalidade(double valor, Date vencimento) {
        Mensalidade mensalidade = new Mensalidade(valor, vencimento);
        mensalidades.add(mensalidade);
    }

    public boolean verificarStatusMensalidade() {
        for (Mensalidade mensalidade : mensalidades) {
            if (!mensalidade.isPaga()) {
                Date hoje = new Date();
                long diferencaDias = (hoje.getTime() - mensalidade.getVencimento().getTime()) / (1000 * 60 * 60 * 24);
                if (diferencaDias > 15) {
                    return false;
                }
            }
        }
        return true;
    }

    public ContaFinanceira getConta() {
        return conta;
    }

    public void registrarEntradaSaida(String tipo) {
        System.out.println("Associado " + nome + " registrou " + tipo + " em " + new Date());
    }

    public boolean podeSair() {
        return conta.isBarFechado();
    }
}
