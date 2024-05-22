public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 4553;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numeroConta;
    protected double saldo;

    public Conta() {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        if(valor <= this.saldo) {
            if(valor != 0) {
                this.saldo -= valor;
            } else {
                throw new RuntimeException("Não é possivel sacar valores iguais a R$ 0.00");
            }
        } else {
            throw new RuntimeException("Não é possivel sacar pois seu saldo R$ " + this.saldo + " é menor do que o valor a ser sacado");
        }
    }

    @Override
    public void depositar(double valor) {
        if(valor > 0) {
            this.saldo += valor;
        } else {
            throw new RuntimeException("Não é possivel depositar valores iguais ou menores que R$ 0.00");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(valor <= this.saldo) {
            if(valor != 0) {
                this.sacar(valor);
                contaDestino.depositar(valor);
            } else {
                throw new RuntimeException("Não é possivel transferir valores iguais a R$ 0");
            }
        } else {
            throw new RuntimeException("Não é possivel transferir pois seu saldo R$ " + this.saldo + " é menor do que o valor a ser transferido");
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numeroConta));
        System.out.println(String.format("Saldo: %2f", this.saldo));
    }
}
