import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    public static int counter = 0;
    public static int index = 0;
    public static int number = 0;

    public static void main(String[] args) {
        new BinarySearch();
        System.out.println("Counter = " + counter);
        System.out.println("index = " + index);
        System.out.println("Number = " + number);
    }

    public BinarySearch() {
        Random rnd = new Random();
        int[] list = new int[20];
        fillArray(list);
        printArray(list);
        Arrays.sort(list);
        printArray(list);

        int x = rnd.nextInt(5);
        System.out.println(x + " is in the array: " + binarySearch(list, x));

        for(int i = index; i < list.length-1; i++){
            if(list[i] == list[i+1]){
                counter++;
                number++;
            }else{
                counter++;
                break;
            }
        }

        for(int i = index; i > 0; i--){
            if(list[i] == list[i-1]){
                counter++;
                number++;
            }else{
                counter++;
                break;
            }
        }
    }

    public void fillArray(int[] list) {
        Random rnd = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = rnd.nextInt(10);
        }
    }

    public void printArray(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " "); //
        }

        System.out.println();
    }

    public boolean binarySearch(int[] list, int x) {
        return binarySearch(list, 0, list.length - 1, x);
    }

    private boolean binarySearch(int[] list, int first, int last, int x) {
        boolean found;

        if (first > last) {
            counter++;
            found = false;
        } else {
            int mid = (first + last) / 2;
            index = mid;
            if (list[mid] == x) {
                counter++;
                found = true;
                number = 1;
            } else {
                if (x < list[mid]) {
                    counter++;
                    found = binarySearch(list, first, mid - 1, x);
                }
                else {
                    counter++;
                    found = binarySearch(list, mid + 1, last, x);
                }
            }
        }

        return found;
    }
}