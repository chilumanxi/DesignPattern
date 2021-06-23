package main;

import java.util.List;

public class EncapsulationError {
    public static void main(String[] args){
        ShoppingCart shoppingCart = new ShoppingCart();
        for(int i = 0; i < 5; i ++){
            ShoppingCartItem item = new ShoppingCartItem();
            item.setName("item-" + i);
            item.setPrice(123.0f);
            shoppingCart.addItem(item);
        }

        List<ShoppingCartItem> items = shoppingCart.getItems();

//        虽然无法修改容器，但是可以修改容器里的对象
        List<ShoppingCartItem> unmodifiableItems = shoppingCart.getUnmodifiableItems();
        for(ShoppingCartItem tmp : unmodifiableItems){
            tmp.setPrice(100.0f);
        }
        for(ShoppingCartItem tmp : items){
            System.out.print(tmp.getPrice() + " ");                         //可以看到，容器里每个对象的价格都被改成了100.0
        }
        System.out.println("");


        items.clear();
        System.out.println(unmodifiableItems.size());                        //可以看到，shoppingCart里面的数据被清空了，有违封装的特性
        System.out.println(shoppingCart.getItemsCount());
    }
}
