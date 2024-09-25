class Cheetahs{

	String animals;
	int number;
	String name;

	public Cheetahs(){

		animals = "";
		number = 0;
		name = "";
	}

	public static void main(String[] args) {
		Cheetah one = new Cheetah("Jumper", 15, true, 'm');
		//Name, age, open for observing, gender
		//String onename = one.getName();
		System.out.println(one.getName());
		//boolean fage = f.getage();
		int oneage = one.getAge();
		System.out.println(one.getAge());
		Cheetah two = new Cheetah ("Vanya", 17, false, 'f');
		Cheetah three = new Cheetah("Louise", 4, true, 'f');
		Cheetah four = new Cheetah("Gerald", 6, true, 'm');

		Cheetahs v = new Cheetahs();
		//instance of Cheetahs enclosure 

		v.addAnimal(one);
		v.addAnimal(two);
		v.addAnimal(three);
		v.addAnimal(four);
		v.getNumofAnimals(one);
		v.getNumofAnimals(two);
		v.getNumofAnimals(three);
		v.getNumofAnimals(four);
		v.getAnimal(one);
		System.out.println(v.name);
		v.getAnimal(two);
		System.out.println(v.name);
		System.out.println(v.animals);
		System.out.println(v.number);
		
	}
			// void means no return/no output from this method 
	public void addAnimal(Cheetah n){
		// example of getting the access c.getName();
		animals = animals + n.getName() + " ";

	//public int (number of cheetahs)

	}

	public void getNumofAnimals(Cheetah p){
		number = number + p.getPosition();


	}
	public void getAnimal(Cheetah g){
		name = g.getName();

	}

}