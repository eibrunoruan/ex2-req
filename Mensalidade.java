import java.util.Date;
//
public class Mensalidade {
    private double valor;
    private Date vencimento;
    private boolean paga;

    public Mensalidade(double valor, Date vencimento) {
        this.valor = valor;
        this.vencimento = vencimento;
        this.paga = false;
    }

    public void pagarMensalidade() {
        this.paga = true;
    }

    public boolean isPaga() {
        return paga;
    }

    public Date getVencimento() {
        return vencimento;
    }
}
