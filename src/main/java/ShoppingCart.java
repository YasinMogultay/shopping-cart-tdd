import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> productList;
    private double totalPrice;

    public ShoppingCart(List<Product> productList, double totalPrice) {
        this.productList = new ArrayList<Product>();
        this.totalPrice = totalPrice;
    }

    public ShoppingCart() {
    }

    public void addProduct(Product p) {
        productList.add(p);
    }

    public int getTotalProducts() {
        return productList.size();
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : productList){
            total += product.getPrice();
        }
        return total;
    }
}
