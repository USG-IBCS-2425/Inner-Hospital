class Pset2{



	public static void main(String[] args) {
		String name = "Trinity";
		String date = "9/6/2024";

		System.out.println (name);
		System.out.println (date);

		System.out.println ("");
		System.out.println ("");


		int x = 5;
		String new_student = "A new student joined the class!";
		System.out.println (x + " students are in our class!");
		System.out.println (new_student);
		int x2 = x + 1;
		System.out.println (x2 + " students are in our class!");
		if (4>x2) { System.out.println("Class is cancelled for today!");
			//used W3schools to help me out with the if statement
		} else {
			System.out.println ("We have class today at 9 am!");
		}
		// any string with .length after becomes a primitive/number
		
		int classnumb = x2 - name.length();
		double cl =  classnumb % 3;
		double cl2 = classnumb/3.00;
		double de = 3 - cl2;

		if (cl==0) {
			System.out.println (cl2 + 
				" is how many groups there are!");

		} else { System.out.println 
			("You need " + de + " more students");}

		//if (cl=0) { 
			//System.out.println ("five groups") };
			//else {System.out.println (cl) };


	}
}

//

