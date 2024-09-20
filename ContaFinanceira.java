public class ContaFinanceira {
    private double saldo;
    private boolean barFechado;

    public ContaFinanceira() {
        this.saldo = 0.0;
        this.barFechado = true;
    }
//
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depositado: " + valor + " | Saldo atual: " + saldo);
    }

    public void debitar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Debitado: " + valor + " | Saldo atual: " + saldo);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void fecharBar() {
        this.barFechado = true;
    }

    public void abrirBar() {
        this.barFechado = false;
    }

    public boolean isBarFechado() {
        return barFechado;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacarSaldoRestante() {
        if (saldo > 0) {
            System.out.println("Sacado: " + saldo);
            saldo = 0;
        } else {
            System.out.println("Nenhum saldo disponível para saque.");
        }
    }
}
