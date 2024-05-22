public class Main {
    public static void main(String[] args) {
        Conta cc = new ContaCorrente();
//        cc.depositar(100);
        Conta poupanca = new ContaPoupanca();
//
        poupanca.sacar(0);
        System.out.println("Saldo da conta: " + poupanca.saldo);


//        cc.transferir(50, poupanca);
//        System.out.println("Saldo da conta: " + cc.saldo);
    }
}