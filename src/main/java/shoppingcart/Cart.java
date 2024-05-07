package shoppingcart;

import java.util.*;
public class Cart {

    private HashMap<Product, Integer> products;
    private final double TAX = 0.1;

    private Specials special;

    public Cart(Specials special){
        this.special = special;
        this.products = new HashMap<>();
    }

    public void addToCart(Product product, Integer qty){

        Integer newCartQuantity;
        if (qty < product.getInventory() && product.getInventory() != 0){

            if (products.containsKey(product)){
                newCartQuantity = products.get(product);
                newCartQuantity += qty;
                products.put(product, newCartQuantity);
                System.out.println("(!) Added " + qty + " " + product.getName() + "(s) to the cart.");
            } else {
                products.put(product, qty);
                System.out.println("(!) Added " + qty + " " + product.getName() + "(s) to the cart.");
            }

        } else if (qty > product.getInventory() && product.getInventory() != 0) {
            System.out.println("(!) Cannot add " + qty + " " + product.getName() + "(s) to the cart. Not enough in inventory.");
        } else {
            System.out.println("(!) Cannot add " + qty + " " + product.getName() + "(s) to the cart. Out of Stock!");
        }

    }

    public void removeFromCart(Product product, Integer qty) {
        Integer newCartQuantity;
        if (products.containsKey(product) && qty <= products.get(product)) {
            newCartQuantity = products.get(product) - qty;
            product.setInventory(product.getInventory() + qty);


            if (qty.equals(products.get(product))){
                products.remove(product);
            } else {
                products.put(product, newCartQuantity);
            }

            System.out.println("(!) Removed " + qty + " " + product.getName() + "(s) from the cart.");

        } else if (products.containsKey(product) && qty > products.get(product)) {
            System.out.println("(!) Cannot remove " + qty + " " + product.getName() + "(s) from the cart - only " + products.get(product) + " exist in the cart currently!");

        } else {
            System.out.println("(!) shoppingcart.Cart does not contain " + product.getName());

        }
    }

    public void printCartInfo(){
        System.out.printf("%n%-8s%-16s%-8s%-8s%-8s%n", "ID", "Name", "Size", "Price", "Qty");
        System.out.printf("%-8s%-16s%-8s%-8s%-8s%n", "----", "------", "------", "-------", "-----");
        Integer totalQty = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet() ){
            Product key = entry.getKey();
            Integer value = entry.getValue();

            System.out.printf("%-8s%-16s%-8s$%-8.2f%-8s%n", key.getId(), key.getName(), key.getSize().name(), key.getPrice(), value);
            totalQty += value;

        }
        System.out.println("=============================================");
        System.out.println("\t\t\tshoppingcart.Cart Qty: " + totalQty);
        System.out.println("\n(!) Today's Special is: " + this.special.getSpecialDescriptor());
    }

    public void checkout(){
        System.out.printf("%n| Sub-total: $%.2f%n", calculateSubtotal());
        System.out.printf("| Total + Tax: $%.2f%n%n", calculateTotalWithTax());
        System.out.println("ENJOY!");
    }

    public double calculateSubtotal(){
        double subtotal = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet() ) {
            Product key = entry.getKey();
            Integer value = entry.getValue();

            subtotal += key.getPrice() * value;
        }

        return subtotal;
    }

    public double calculateTotalWithTax(){
        double totalWithTax = 0;
        totalWithTax = (calculateSubtotal() * TAX) + calculateSubtotal();
        return totalWithTax;
    }
}
