import java.util.*;

class Sorting{

	public static ArrayList<Integer> BubbleSort(ArrayList<Integer> a) {
		//loop through entire list: loop until max = a.size
		//loop through that list to compare
        for (int h = 0; h < a.size(); h++) {
            for (int i = 0; i < a.size() - 1; i++) {
                if (a.get(i) > a.get(i + 1)) {
                    int temp = a.get(i);
                    a.set(i, a.get(i + 1));
                    a.set(i + 1, temp);
                    //swap y onto something else, set y = x, then x = temp value
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int n = 1000; // Size of the array
        ArrayList<Integer> a = new ArrayList<>(); // Initialize the ArrayList

        // Populate the ArrayList with random numbers
        for (int i = 0; i < n; i++) {
            int newNum = 1 + (int) (Math.random() * n);
            a.add(newNum);
        }

        // Sort the list using BubbleSort
        ArrayList<Integer> list1 = BubbleSort(a);

        // Print the sorted list
        System.out.println(list1);
       }
}