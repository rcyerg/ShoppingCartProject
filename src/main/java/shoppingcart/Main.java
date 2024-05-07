package shoppingcart;

public class Main {

    public static void main(String[] args) {
        Cart cart = new Cart(Specials.BOGO);
        Product shirt = new Product("SHIRT", Size.XL, 1.99, 50);
        Product hat = new Product("HAT", Size.S, 2.99, 50);
        Product sweater = new Product("SWEATER", Size.M, 2.99, 50);
        Product fries = new Product("FRIES", Size.L, 4.99, 50);
        Product soda = new Product("SODA", Size.L, 12.99, 50);

        Product outOfStockSoda = new Product("CHERRY SODA", Size.L, 12.99, 0);

        cart.addToCart(outOfStockSoda, 20);
        cart.addToCart(shirt, 40);
        cart.addToCart(hat, 30);
        cart.addToCart(sweater, 13);
        cart.addToCart(fries, 12);
        cart.addToCart(soda, 42);
        cart.removeFromCart(soda, 42);

        cart.printCartInfo();
        cart.checkout();


    }
}
