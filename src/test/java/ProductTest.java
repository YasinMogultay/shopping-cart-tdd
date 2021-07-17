import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ProductTest {

    private Product product;

    @Before
    public void setUp() {
        Product pen = new Product("Pen",2,100);
    }

    @Test
    public void checkIfProductInitialized() {
        Product pen = new Product("Pen",2,100);
        assertNotNull(pen);
    }

}
