public class ContaCorrente extends Conta {

    private double limiteChequeEspecial = 250;

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato conta corrente!");
        super.imprimirInfosComuns();
    }

    @Override
    public void sacar(double valor) {
        if(valor <= super.saldo) {
            if(valor != 0) {
                super.saldo -= valor;
            } else {
                throw new RuntimeException("Não é possivel sacar valores iguais a R$ 0.00");
            }
        } else if(valor <= limiteChequeEspecial) {
            super.saldo -= valor;
        } else {
            throw new RuntimeException("Não é possivel sacar o valor maior do que seu limite de cheque especial R$ " + this.limiteChequeEspecial);
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(valor <= super.saldo) {
            if(valor != 0) {
                super.sacar(valor);
                contaDestino.depositar(valor);
            } else {
                throw new RuntimeException("Não é possivel transferir valores iguais a R$ 0.00");
            }
            super.sacar(valor);
            contaDestino.depositar(valor);
        } else if(valor <= limiteChequeEspecial) {
            super.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            throw new RuntimeException("Não é possivel transferir pois o valor do seu cheque especial R$ " + this.limiteChequeEspecial +
                    " é menor do que o valor a ser transferido R$ " + valor);
        }
    }
}
