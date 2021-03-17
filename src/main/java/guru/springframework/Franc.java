package guru.springframework;

import lombok.Getter;

@Getter
public class Franc extends Money{

    /**
     * constructor method for Money
     * @param amount
     */
    public Franc(int amount,String currency) {
        super(amount,currency);
    }

}
