package shoppingcart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    Cart cart = new Cart(Specials.BOGO);
    Product shirt = new Product("SHIRT", Size.XL, 1.99, 50);
    Product hat = new Product("HAT", Size.S, 2.99, 50);



    @Test
    void calculateSubtotal() {

        cart.addToCart(shirt, 1); //1.99
        cart.addToCart(hat, 1); //2.99

        double expected = 4.98;

        double actual = cart.calculateSubtotal();

        assertEquals(expected, actual);
    }
}