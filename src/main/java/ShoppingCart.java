import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> productList = new ArrayList<>();
    private IOffer offer;


    public int getProductCount() {
        return productList.size();
    }

    public void addProduct(Product p) {
        if (offer != null){
            offer.applyOffer(p); // apply offer
        }
        productList.add(p);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        if (productList.size() > 0){
            for(Product product : productList){
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    public Product getProductByName(String name) {
        if (productList.size() > 0){
            for (Product product : productList){
                if (product.getName().equals(name)){
                    return product;
                }
            }
        }
        return null;
    }

    public void setOffer(IOffer offer) {
        this.offer = offer;
    }
}
