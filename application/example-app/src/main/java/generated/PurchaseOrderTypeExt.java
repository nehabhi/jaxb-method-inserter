package generated;

import generated.Items.Item;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseOrderTypeExt {

    public static BigDecimal getTotalPrice(PurchaseOrderType po) {

        Items items = po.getItems();
        if (items != null) {
            BigDecimal total = new BigDecimal(0);
            List<Items.Item> listItems = items.getItem();
            for (Item item : listItems) {
                int quantity = item.getQuantity();
                BigDecimal price = item.getUSPrice();
                total = total.add(price.multiply((new BigDecimal(quantity))));
            }
            return total;
        }
        return BigDecimal.ZERO;
    }

    public static int getTotalNumberOfItems(PurchaseOrderType po) {

        Items items = po.getItems();
        if (items != null) {
            int total = 0;
            List<Items.Item> listItems = items.getItem();
            for (Item item : listItems) {
                total += item.getQuantity();
            }
            return total;
        }
        return 0;
    }

}
