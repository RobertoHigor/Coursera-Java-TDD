package curso.locadora;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	
	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();
	//Utilizando as variáveis aqui, não é preciso calcular o totalAmount toda vez, apenas acrescentando a cada rent
	private int frequentRenterPoints;
	private double totalAmount;

	public Customer(String name) {
		_name = name;
	};

	public void addRental(Rental rental) {
		_rentals.addElement(rental);
		frequentRenterPoints += rental.getFrequentRenterPoints();
		totalAmount += rental.getAmount();
		
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(each.getAmount()) + "\n";
		}
		result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())
				+ " frequent renter points";
		return result;
	}
	
	private int getTotalFrequentRenterPoints() {		
		return frequentRenterPoints;
	}
	private double getTotalAmount() {
		return totalAmount;
	}
}