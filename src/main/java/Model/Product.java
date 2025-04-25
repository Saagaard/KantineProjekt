package Model;

public class Product {
    int productId;
    String name;
    float price;
    int storageBalance;
    int minimumStorage;
    boolean ordered;

    public Product(int productId, String name, float price, int storageBalance, int minimumStorage, boolean ordered) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.storageBalance = storageBalance;
        this.minimumStorage = minimumStorage;
        this.ordered = ordered;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getStorageBalance() {
        return storageBalance;
    }

    public int getMinimumStorage() {
        return minimumStorage;
    }

    public boolean isOrdered() {
        return ordered;
    }
}