package MultiAssign;

/*
2) A person weight on earth is 70KG , lets calculate weight on different solar planets.*/
public class WeightCalculator {
public static void main(String[] args) {
	planet p = new planet();
	Runnable Mercury =()->p.MercuryWeight(70);
	Runnable Venus =()->p.VenusWeight(70);
	
	Thread t1 = new Thread(Mercury,"MercuryWeight");
	Thread t2 = new Thread(Venus,"VenusWeight");
	t1.start();
	t2.start();
	
	
	
}
}

class planet{
	private double Mercury =3.7 ;
	private double Venus  =8.87  ;
	private double Earth  =9.8  ;
	
	public synchronized void MercuryWeight(double person )
	{
		System.out.println("weight on Mercury "+ person*(this.Mercury/this.Earth)+" kg");
	}
	
	public synchronized void VenusWeight(double person )
	{
		System.out.println("weight on Mercury "+ person*(this.Venus/this.Earth)+" kg");
	}
	
}