import java.util.*;
class ChompBistro{
	String[] employees = new String [5];
	String[] menu1 = new String[3];
	int dOW;
	public ChompBistro(String[] g, String[] menu, int dow){
		employees = g;
		menu1 = menu;
		dOW = dow;

	}
	public static void main(String[] args) {
		//String y = new s.nextLine();
		Scanner s = new Scanner(System.in);
		String[] one = {"Berry", "Harry", "Sarah", "Mary", "Alex"};
		String[] two = {"Mac & Cheese", "Bacon and Cheese Hamburger", "Popcorn Chicken", "Vanilla Ice Cream"};
		System.out.println("What day of the week is it? (1-7)");
		int three = s.nextInt();
		ChompBistro all = new ChompBistro(one, two, three);
		System.out.print("Your five employees are: ");
		String jumps = getEmployees(all.employees);
		System.out.println(jumps);
		System.out.println("Your menu is:");
		String jumps2 = getMenuItems(all.menu1);
		System.out.println(jumps2);
		//hum.employees
		System.out.println("Let's see the menu for the day!");
		String greatly = generateMenu(all.menu1);
		System.out.println(greatly);
		System.out.println("Let's see who is working today!");
		String king = getDay(all.dOW);
		System.out.println("Today is " + king + "!");
		String name = whosWorking(all.employees, king);
		System.out.println(name + " are working today!");
		System.out.println("Lets change the day of the week");
		System.out.print("What day of the week is it? (1-7)");
		int four = s.nextInt();
		all.dOW = four;
		String king2 = getDay(all.dOW);
		System.out.println("Today is " + king2 + "!");

	}
	public static String getEmployees(String[] x){
		String h = "";
		for (int i = 0; i < x.length; i++){
			h = h + x[i] + " ";
		}
		return h;
	}

	public static String getMenuItems(String[] x){
		String g = "";
		for (int i = 0; i < x.length; i++){
			g = g + x[i] + " ";
		}
		return g;
	}

	public static String getDay(int d){
		String day = "";
		for (int i = 0; i < d; i++)
			if (i == 0){
				day = "Sunday";
			}
			else if (i == 1){
				day = "Monday";
			}
			else if (i == 2){
				day = "Tuesday";
			}
			else if (i == 3){
				day = "Wednesday";
			}
			else if (i == 4){
				day = "Thursday";
			}
			else if (i == 5){
				day = "Friday";
			}
			else if (i == 6){
				day = "Saturday";
			}
			else{
				day = "Not a valid day/number";
			}
		return day;
	}

	public static String generateMenu(String[] menu){
		String j = "";
		int food = 2;
		for (int i = 0; i < food; i++){
			int y = (int)(Math.random()*2) + 1;
			j = j + menu[y] + " ";
		}
		return j;

	}

	public static String whosWorking(String[] eMP, String dayOW){
		String employee = "";
		if (dayOW == "Sunday"){
			employee = eMP[1] + " and " + eMP[3];
		}
		else if (dayOW == "Monday"){
			employee = eMP[3] + " and " + eMP[0];
		}
		else if (dayOW == "Tuesday"){
			employee = eMP[2] + " and " + eMP[4];
		}
		else if (dayOW == "Wednesday"){
			employee = eMP[1] + " and " + eMP[0];
		}
		else if (dayOW == "Thursday"){
			employee = eMP[2] + " and " + eMP[1];
		}
		else if (dayOW == "Friday"){
			employee = eMP[0] + " and " + eMP[4];
		}
		else if (dayOW == "Saturday"){
			employee = eMP[2] + " and " + eMP[3];
		}
		return employee;

	}


}