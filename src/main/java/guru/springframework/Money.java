package guru.springframework;

public class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected String currency() {
        return this.currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD") {
        };
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF") {
        };
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

    public Expression plus(Money money){
        return new Money(amount+money.amount,currency);
    }
}
