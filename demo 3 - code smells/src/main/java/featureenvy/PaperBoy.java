package featureenvy;

public class PaperBoy {

    private int payment;

    public void deliverPaper(Customer customer) {
        customer.pay(this.getPayment());
    }

    public int getPayment() {
        return payment;
    }
}
