import java.util.*;

class Pset4{
	public static void main(String[] args) {
		//array is in the classes
		
		System.out.println(a[1]);
	}

}

class Raffle{
	int[] a = {5673, 2390, 5032, 1304, 3858, 2198, 3248, 2842, 9823};
	public Raffle(){
		for (int i=0; i<10; i++){
			a[i] = (int)(Math.random()*10);
		}
	}

}

class Student{


	//choose a number 1-10 using Math.random with the 0-9 position of the array

}

class Fibonnacci {
	//array has length 20 (should be initialized)
	//first two values is 0 and 1 while the rest aren't correct
	//use a method to update the sequence (adding the previous numbers) ex. x = 0 --> x = x+1 then system.out.println(x)
	//can use if statements to check up until how many positions of the sequence is correct
}