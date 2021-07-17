import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class ShoppingCartTest {

    private List<Product> cart;

    @Before
    public void setUp() {
        cart = new ArrayList<Product>();
    }

    @Test
    public void checkIfProductAdded(){
        Product pen = new Product("Pen",2,20);
        cart.add(pen);
        assertEquals(1,cart.size());
    }


}
