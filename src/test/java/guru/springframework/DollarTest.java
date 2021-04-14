package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DollarTest {

    @Test
     void testDollar() {
        Money fiveD = Money.dollar(5);
        Money three = fiveD.times(2);
        assertEquals(Money.dollar(10), three);
        three = fiveD.times(3);
        assertEquals( Money.dollar(15), three);
    }

    @Test
    void equalityCheckDollar() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(10),Money.dollar(8));
        assertNotEquals(Money.dollar(10),Money.franc(10));

        /*
         ??????
         how come equals function in Money Class accepting
         two parameters

         Reason : Actually assertNotEquals takes two parameters but inside every assert function
         there is equals method that take one argument and check it with other for equality

        static boolean objectsAreEqual(Object obj1, Object obj2) {
		if (obj1 == null) {
			return (obj2 == null);
		}
		return obj1.equals(obj2);
	}
        */
    }

    @Test
    void testFranc() {
        Money fiveF = Money.franc(5);
        Money three = fiveF.times(2);
        assertEquals(Money.franc(10), three);
        three = fiveF.times(3);
        assertEquals(Money.franc(15), three);
    }

    @Test
    void equalityCheckFranc() {
        assertEquals(Money.franc(5),Money.franc(5));
        assertNotEquals(Money.franc(10),Money.franc(8));
    }

    @Test
    void checkCurrency() {
        assertEquals("USD",Money.dollar(1).currency());
        assertEquals("CHF",Money.franc(1).currency());

    }

    @Test
    void testSimpleAddition(){
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(10),reduced);
    }
}
