package comp1110.exam;

import java.util.HashMap;
import java.util.Map;

/**
 * COMP1110 Final Exam, Question 2i
 */
public class Q2SimpleStockManager {
    private Map<String, Goods> store = new HashMap<>();

    class Goods {
        private String name;
        private double price;
        private int amount;
        private int target;
        Goods(String name, double price) {
            this.name = name;
            this.price = price;
            this.amount = this.target = 0;
        }
    }

    /**
     * A new product has been introduced.
     *
     * @param sku The product’s sku
     * @param name The product’s name
     * @param price The product’s price (per unit)
     */
    public void newItem(String sku, String name, double price) {
        // FIXME Question 2ia: complete this function
        store.put(sku, new Goods(name, price));
    }

    /**
     * Return the name of a product.
     *
     * @param sku The product’s sku
     * @return the name of the product
     */
    public String getItemName(String sku) {
       // FIXME Question 2ib: complete this function
        return store.get(sku).name;
    }

    /**
     * Return the price of a product.
     *
     * @param sku The product’s sku
     * @return the price of the product
     */
    public double getItemPrice(String sku) {
        // FIXME Question 2ic: complete this function
        return store.get(sku).price;
    }

    /**
     * Return the amount of stock for a product.
     *
     * @param sku The product’s sku
     * @return the number of items in stock
     */
    public int getStock(String sku) {
        // FIXME Question 2id: complete this function
        return store.get(sku).amount;
    }

    /**
     * An product has been sold; reduce current stock accordingly.
     *
     * @param sku The product’s sku
     * @param sold The quantity sold
     * @return The number of items of stock remaining after the sale
     */
    public int sale(String sku, int sold) {
        // FIXME Question 2ie: complete this function
        store.get(sku).amount -= sold;
//        if (store.get(sku).amount < 0) {
//            throw new ArithmeticException();
//        }
        return store.get(sku).amount;
    }

    /**
     * New stock has arrived; increase current stock accordingly.
     *
     * @param sku The product’s sku
     * @param added The quantity newly arrived
     */
    public void addStock(String sku, int added) {
        // FIXME Question 2if: complete this function
        store.get(sku).amount += added;
//        if (store.get(sku).amount < 0) {
//            throw new ArithmeticException();
//        }
    }

    /**
     * Set the target amount of stock for a product.
     *
     * @param sku The item’s sku
     * @param target The target quantity desired to be held in stock
     */
    public void setTargetStock(String sku, int target) {
        // FIXME Question 2ig: complete this function
        store.get(sku).target = target;
    }

    /**
     * Stock has been carefully counted. Set current stock correctly.
     *
     * @param sku The product’s sku
     * @param actual The quantity actually in the store
     * @return The stock loss or gain (new current – old current)
     */
    public int setActualStock(String sku, int actual) {
        // FIXME Question 2ih: complete this function
        int margin = actual - store.get(sku).amount;
        store.get(sku).amount = actual;
        return margin;
    }

    /**
     * Return the number of items required for a given product
     * in order to reach the target stock for that item (target - stock)
     *
     * @param sku The SKU of the item to be queried
     * @return The difference between target and actual stock for that item
     */
    public int getStockRequired(String sku) {
        // FIXME Question 2ii: complete this function
        return store.get(sku).target - store.get(sku).amount;
    }

    /**
     * @return the value of the currently held stock (the price of the
     * product multiplied by the number of items in stock, for all items).
     */
    public double totalStockValue() {
        // FIXME Question 2ij: complete this function
        double totalValue = 0;
        for (String sku : store.keySet()) {
            totalValue += store.get(sku).price * store.get(sku).amount;
        }
        return totalValue;
    }
}
