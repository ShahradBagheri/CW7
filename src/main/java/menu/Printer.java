package menu;

public class Printer {
    public static void printItem(String[] items){
        for (int i = 0; i <items.length; i++) {
            System.out.println((i+1) + " " + items[i] );
        }
    }
}
