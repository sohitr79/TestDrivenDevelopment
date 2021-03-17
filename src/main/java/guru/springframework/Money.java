package guru.springframework;

public abstract class Money {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected String currency() {
        return this.currency;
    }

    public static Dollar dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Franc franc(int amount) {
        return new Franc(amount, "CHF");
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount
                && this.currency.equals(money.currency);
               // && this.getClass().equals(object.getClass());  a good method to check if objects belong to same class
    }

    /**
     * when we tried to run test case this was error we were receiving thus we added to string method
     * since objects were showing addresses...
     *
     * with the help of this method this will be overcome
     * org.opentest4j.AssertionFailedError:
     * Expected :guru.springframework.Franc@5a1c0542
     * Actual   :guru.springframework.Franc$1@396f6598
     * @return
     */
    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Money times(int multiplier){
        return new Money(amount * multiplier, this.currency) {
        };
    }
}
