package main;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {
    private int itemsCount;
    private double totalPrice;
    private List<ShoppingCartItem> items = new ArrayList<>();

    //    itemsCount 和 totalPrice。虽然我们将它们定义成 private 私有属性，但是提供了 public 的 getter、setter 方法。
//    这就跟将这两个属性定义为 public 公有属性，没有什么两样了。 外部可以通过 setter 方法随意地修改这两个属性的值。
//    除此之外，任何代码都可以随意调用 setter 方法，来重新设置 itemsCount、totalPrice 属性的值，这也会导致其跟 items 属性的值不一致。
    public int getItemsCount() {
        return this.itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    //因为 items 属性的 getter 方法，返回的是一个 List集合容器。外部调用者在拿到这个容器之后，是可以操作容器内部数据的。
    //也就是说，外部代码还是能修改 items 中的数据，参考main中的调用。
    public List<ShoppingCartItem> getItems() {
        return this.items;
    }

    public void addItem(ShoppingCartItem item) {
        items.add(item);
        itemsCount++;
        totalPrice += item.getPrice();
    }


    //可以参考使用Collections.unmodifiableList()方法，让getter方法返回一个不可被修改的UnmodifiableList 集合容器
    //但是这样的问题是虽然items没法修改，但是却可以修改容器中每个shoppingCartItem的数据
    public List<ShoppingCartItem> getUnmodifiableItems() {
        return Collections.unmodifiableList(this.items);
    }


    // ...省略其他方法...
}