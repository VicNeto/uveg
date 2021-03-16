

public class madrola {
    public static void main(String[] args) {
        // objects declarations
        TarjetaCredito creditCard = new TarjetaCredito(15.0);
        TarjetaDebito debitCard = new TarjetaDebito(15.0);
        CuentaAhorro account = new CuentaAhorro(15.0);

        // using classes methods
        creditCard.sumaInteres();
        debitCard.depositar(50);
        account.invertir();

        // display amounts
        System.out.println(creditCard.getMontoActual());
        System.out.println(debitCard.getMontoActual());
        System.out.println(account.getMontoActual());
    }
}