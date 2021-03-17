package guru.springframework;

import lombok.Getter;

@Getter
public class Dollar extends Money {

    /**
     * constructor method for Money
     * @param amount
     */
    public Dollar(int amount,String currency) {
        super(amount,currency);
    }

}
