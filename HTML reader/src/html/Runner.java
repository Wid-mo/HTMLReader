package html;

public class Runner {
	int lp;
	String name;
	String surname;
	String city;
	String distance;
	String category;
	String payment;
	String team;
	String resident;
	
	public Runner(int lp, String name, String surName, String city, String distance, String category, String payment, String team, String resident) {
		super();
		this.lp = lp;
		this.name = name;
		this.surname = surName;
		this.city = city;
		this.distance = distance;
		this.category = category;
		this.payment = payment;
		this.team = team;
		this.resident = resident;
	}

	@Override
	public String toString() {
		return "lp=" + lp + ", name= " + name + ", \tsurname= " + surname + ", \tcity= " + city + ", \tdistance= " + distance + ", \tcategory= " + category + ", \tpayment= " + payment + ", \tteam= " + team + ", \tresident= " + resident;
	}
}
