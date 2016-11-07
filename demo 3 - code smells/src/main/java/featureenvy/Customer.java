package featureenvy;

public class Customer {

    private Wallet wallet;

    private Wallet getWallet() {
        return wallet;
    }

    void pay(int payment) {
        if (getWallet().getTotalAmountOfMoney() > payment) {
            getWallet().subtractMoney(payment);
        }
    }
}
