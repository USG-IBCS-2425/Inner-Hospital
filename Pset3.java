class Wallet {
	//good example for encapsulation because it's easy to create a object with 
	//private int money;
	//private int iDnum;
	//constructor allows to input multiple instances of the wallet
	int x;
	private long money;
	public long getAmount(int amount){
		return money;
	}
	private int iDnum;
	public int getiDnum(){
		return iDnum;

	}
	public Wallet(int amount){
		x = amount;
		money = money + x;
		iDnum = 204;

	}
}
class Shape{
	public double getArea(){
		return area;
	}

}

class Retangle extends Shape{
	double length;
	double width;
	public double Rectangle(){
		super();
		area = length*width;
	}


}

class Circle extends Shape{
	int radius;
	public double getArea(){
		super();
		area = radius^2*pi;
	}
}


class Pset3 {

	public static void main(String[] args) {
		Wallet p = new Wallet(50);
		System.out.println(p.getAmount(50));
		Wallet l = new Wallet();
		System.out.println(l.getAmount(67));
		System.out.println(p.getiDnum());


	}
}