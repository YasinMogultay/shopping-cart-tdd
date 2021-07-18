import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class ShoppingCartTest {

    @Test
    public void testCreateEmptyShoppingCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0, cart.getProductCount());
    }


    @Test
    public void testAddProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Pen", 5.0, 10);
        cart.addProduct(product);
        assertEquals(1, cart.getProductCount());
    }

    @Test
    public void testTotalPrice() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Pen", 5.0, 10);
        Product product2 = new Product("Pencil", 3.0, 10);
        cart.addProduct(product);
        cart.addProduct(product2);
        assertEquals(8.0, cart.getTotalPrice(), 0);
    }

    @Test
    public void testAddMultipleQuantityOfAProductAndApplyOfferToCart() {
        IOffer offer = new BuyXItemGetYItemFreeOffer(2, 1);
        ShoppingCart cart = new ShoppingCart();
        cart.setOffer(offer);
        Product product = new Product("Pen", 150.0, 5);
        cart.addProduct(product);
        assertEquals(1, cart.getProductCount());
        assertEquals(120.0, cart.getTotalPrice(), 0);
    }

    @Test
    public void addDifferentProductsAndAppyOfferToTheCart() {
        IOffer offer = new BuyXItemGetYItemFreeOffer(2, 1);
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Pen", 90.0, 3);
        Product product1 = new Product("Pencil", 200.0, 2);
        cart.setOffer(offer);
        cart.addProduct(product);
        cart.setOffer(new NoOffer());
        cart.addProduct(product1);
        assertEquals(2, cart.getProductCount());
        assertEquals(260, cart.getTotalPrice(), 0.0);
    }

    @Test
    public void testApplyBuyOneGetFiftyPercentDiscountOnTheNextOne() {
        IOffer offer = new DiscountOnNextItemOffer(50.0);
        ShoppingCart cart = new ShoppingCart();
        cart.setOffer(offer);
        Product product = new Product("Pen", 60, 2);
        cart.addProduct(product);
        assertEquals(1, cart.getProductCount());
        assertEquals(45.0, cart.getTotalPrice(), 0);
        assertEquals(45, cart.getProductByName("Pen").getPrice(), 0);
    }

    @Test
    public void testApplyBuyOneGetFiftyPercentDiscountOnNextOfferToTheMultipleProductsInCart() {
        IOffer offer = new DiscountOnNextItemOffer(50.0);
        ShoppingCart cart = new ShoppingCart();
        Product cream = new Product("Cream", 150.0, 5);
        cart.setOffer(offer);
        cart.addProduct(cream);
        assertEquals(1, cart.getProductCount());
        assertEquals(120.0, cart.getProductByName("Cream").getPrice(), 0);
        assertEquals(120.0, cart.getTotalPrice(), 0);

    }

}
