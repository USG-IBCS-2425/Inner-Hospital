class Cheetah {
	String name;
	boolean human;
	int age;
	boolean ofo;
	Character gender;
	int position;
	//Open for observing

	public String getName(){
		return name;
	}
	public boolean getHuman(){
		return human;
	}
	public int getAge(){
		return age;
	}

	public boolean getOfo(){
		return ofo;
	}
	public Character getGender(){
		return gender;
	}
	public int getPosition(){
		return position;
	}

	public Cheetah(String a, int b, boolean c, char d) {
		//, int b, boolean c, Character d){
		name = a;
		human = false;
		age = b;
		ofo = c;
		gender = d;
		position = 1;


	}

	
}