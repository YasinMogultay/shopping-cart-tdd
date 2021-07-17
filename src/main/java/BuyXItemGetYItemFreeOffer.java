public class BuyXItemGetYItemFreeOffer implements IOffer{

    private int xItem;
    private int yItem;

    public BuyXItemGetYItemFreeOffer(int xItem, int yItem) {
        this.xItem = xItem;
        this.yItem = yItem;
    }

    @Override
    public void applyOffer(Product product) {
        if (product.getQuantity() >= xItem){
            int freeProductQty = product.getQuantity() / (xItem + yItem);
            double unitPrice = product.getPrice() / product.getQuantity();
            double discount = unitPrice * freeProductQty;
            product.setPrice(product.getPrice() - discount);
        }
    }

    public int getxItem() {
        return xItem;
    }

    public void setxItem(int xItem) {
        this.xItem = xItem;
    }

    public int getyItem() {
        return yItem;
    }

    public void setyItem(int yItem) {
        this.yItem = yItem;
    }
}
