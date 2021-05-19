package main;

public class Example {
    public static void test(DynamicArray dynamicArray) {
        dynamicArray.add(5);
        dynamicArray.add(1);
        dynamicArray.add(3);
        for (int i = 0; i < dynamicArray.size(); ++i) {
            System.out.println(dynamicArray.get(i));
        }
        System.out.println("--------------------");
    }

    public static void main(String args[]) {
        DynamicArray arr1 = new DynamicArray();
        test(arr1);// 打印结果：5、1、3
        SortedDynamicArray arr2 = new SortedDynamicArray();
        test(arr2);// 打印结果：1、3、5
        DynamicArray arr3 = new SortedDynamicArray();
        test(arr3);// 打印结果：1、3、5
    }
}