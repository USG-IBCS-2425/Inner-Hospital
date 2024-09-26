import java.util.*;
//look for hwDemo.java in github
class Pset4{
	public static void main(String[] args) {
		//array is in the classes
		
		Student s1 = new Student ("Sarah");
		Student s2 = new Student ("Theodore");
		Student s3 = new Student ("Cassandra");
		Student s4 = new Student ("Anna");
		Student s5 = new Student ("Annabelle");
		Student s6 = new Student ("Bella");
		Student s7 = new Student ("Fred");
		Student s8 = new Student ("Lisa");
		Student s9 = new Student ("Mona");
		Student s10 = new Student ("Terrisa");
		Student[] s = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};
		Raffle r = new Raffle(s);
		r.printRafNums();
		Raffle t = new Raffle(s);
		Student win = r.getWinner();
		System.out.println(win.getName() + " is a winner!");

	}

}

class Raffle{
	//Student (data type) [] sArr;
	//int [] rafnums; (not given any value and constructor method creates that )
	//public Raffle(Student[] sArr)
		//sArr = s;
		//rafNums = new int [s.length]
		//above shows the added numbers and 
		//gets a new number and add it to the array so they have a position
		//needs 
	Student[] sArr;
	int[] rafNums;
	String winners;

	// constructor for raffle requires giving it
	// a student array as input
	public Raffle(Student[] s) {
		winners = "";
		sArr = s;
		// need to create a empty array of integers first
		rafNums = new int[s.length];
		// loop through the array to set values
		// equal to each student's number
		for (int i = 0; i < sArr.length; i++) {

			// sArr[i] is a student
			rafNums[i] = sArr[i].getNum();
		}
	}

	// use a loop to print each number in the array
	public void printRafNums() {
		for (int n : rafNums) {
			System.out.println(n);
		}
	}

	public Student getWinner() {
		// choose an integer between 0-10
		int choice = (int)(Math.random()*11);

		//print the winning number
		System.out.println("The winning number is: " + rafNums[choice]);



		return sArr[choice];
	}
}

class Student{
	String name;
	int rafNum;
	public Student (String n){
		name = n;
		rafNum = (int)(Math.random()*10000);
	}

	public int getNum() {
		return rafNum;
	}

	public String getName() {
		return name;
	}


	//choose a number 1-10 using Math.random with the 0-9 position of the array

}

//class Fibonnacci {
	//array has length 20 (should be initialized)
	//first two values is 0 and 1 while the rest aren't correct
	//use a method to update the sequence (adding the previous numbers) ex. x = 0 --> x = x+1 then system.out.println(x)
//}