package comp1110.exam;

import java.util.HashMap;
import java.util.Map;

/**
 * COMP1110 Final Exam, Question 2ii
 */
public class Q2StockManager {
    private Map<String, Product> productMap = new HashMap<>();
    private Map<String, String> vendorMap = new HashMap<>();

    class Product {
        private String name;
        private double price;
        private int amount;
        private int target;
        private String vid;
        Product(String vid, String name, double price) {
            this.name = name;
            this.vid = vid;
            this.price = price;
            this.amount = this.target = 0;
        }
    }

    /**
     * A new vendor has been introduced.
     *
     * @param vid The vid of the new vendor vendor
     * @param name The vendor’s name
     */
    public void newVendor(String vid, String name) {
        // FIXME Question 2iia: complete this function
        vendorMap.put(vid, name);
    }

    /**
     * A new product has been introduced.
     *
     * @param sku The product’s sku
     * @param vid The vid of the product's vendor
     * @param name The product’s name
     * @param price The product’s price (per unit)
     */
    public void newItem(String sku, String vid, String name, double price) {
        // FIXME Question 2iib: complete this function
        productMap.put(sku, new Product(vid, name, price));
    }

    /**
     * Return the name of a product.
     *
     * @param sku The product’s sku
     * @return the name of the product
     */
    public String getItemName(String sku) {
        // FIXME Question 2iic: complete this function
        return productMap.get(sku).name;
    }

    /**
     * Return the name of a product's vendor.
     *
     * @param sku The product’s sku
     * @return the name of the product's vendor
     */
    public String getItemVendorName(String sku) {
        // FIXME Question 2iid: complete this function
        String ID = productMap.get(sku).vid;
        return vendorMap.get(ID);
    };

    /**
     * Return the price of a product.
     *
     * @param sku The product’s sku
     * @return the price of the product
     */
    public double getItemPrice(String sku) {
        // FIXME Question 2iie: complete this function
        return productMap.get(sku).price;
    };

    /**
     * Return the amount of stock for a product.
     *
     * @param sku The product’s sku
     * @return the number of items in stock
     */
    public int getStock(String sku) {
        // FIXME Question 2iif: complete this function
        return productMap.get(sku).amount;
    };

    /**
     * An product has been sold; reduce current stock accordingly.
     *
     * @param sku The product’s sku
     * @param sold The quantity sold
     * @return The number of items of stock remaining after the sale
     */
    public int sale(String sku, int sold) {
        // FIXME Question 2iig: complete this function
        productMap.get(sku).amount -= sold;
        return productMap.get(sku).amount;
    }

    /**
     * New stock has arrived; increase current stock accordingly.
     *
     * @param sku The product’s sku
     * @param added The quantity newly arrived
     */
    public void addStock(String sku, int added) {
        // FIXME Question 2iih: complete this function
        productMap.get(sku).amount += added;
    }

    /**
     * Set the target amount of stock for a product.
     *
     * @param sku The item’s sku
     * @param target The target quantity desired to be held in stock
     */
    public void setTargetStock(String sku, int target) {
        // FIXME Question 2iij: complete this function
        productMap.get(sku).target = target;
    }

    /**
     * Stock has been carefully counted. Set current stock correctly.
     *
     * @param sku The product’s sku
     * @param actual The quantity actually in the store
     * @return The stock loss or gain (new current – old current)
     */
    public int setActualStock(String sku, int actual) {
        // FIXME Question 2iik: complete this function
        int margin = actual - productMap.get(sku).amount;
        productMap.get(sku).amount = actual;
        return margin;
    }

    /**
     * For a given vendor, return a map indicating for each product provided by
     * that vendor, the number of items required in order to reach the target
     * stock for that item (target - stock).   A positive number indicates that
     * stock is needed, a negative number indicates that there is extra stock.
     *
     * @param vid The VID of the vendor to be queried
     * @return A map of item SKUs and the difference between target and actual stock for that item
     */
    public Map<String, Integer> getStockRequired(String vid) {
        // FIXME Question 2iil: complete this function
        Map<String, Integer> result = new HashMap<>();
        for (String sku : productMap.keySet()) {
            int margin = productMap.get(sku).target - productMap.get(sku).amount;
            result.put(sku, margin);
        }
        return result;
    }
}
