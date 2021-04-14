package guru.springframework;

import lombok.Getter;

/**
 * Now these classes are not being used and can be removed
 * since both dollar and franc class has none of distinguishing factor
 * so both we moved to money class
 */
public class Dollar extends Money {

    /**
     * constructor method for Money
     * @param amount
     */
    public Dollar(int amount,String currency) {
        super(amount,currency);
    }

}
