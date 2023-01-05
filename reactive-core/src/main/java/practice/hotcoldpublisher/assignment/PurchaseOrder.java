package practice.hotcoldpublisher.assignment;

import lombok.Data;
import lombok.ToString;
import practice.Util;

@ToString
@Data
public class PurchaseOrder {
    private String item;
    private double price;
    private String category;
    private int quantity;

    public PurchaseOrder() {
        this.item = Util.faker().commerce().productName();
        this.price = Double.parseDouble(Util.faker().commerce().price());
        this.category = Util.faker().commerce().department();
        this.quantity = Util.faker().random().nextInt(1,10);
    }
}
