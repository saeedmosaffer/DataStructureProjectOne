package application;

import java.util.Date;

public class Passenger {

	protected int flightNumber;
	protected int ticketNumber;
	protected String fullName;
	protected String passportNumber;
	protected String Nationality;
	protected String birthDate;
	Passenger next;

	public Passenger(int flightNumber, int ticketNumber, String fullName, String passportNumber, String Nationality,
			String birthDate) {

		this.flightNumber = flightNumber;
		this.ticketNumber = ticketNumber;
		this.fullName = fullName;
		this.passportNumber = passportNumber;
		this.Nationality = Nationality;
		this.birthDate = birthDate;
		next = null;
	}

	public Passenger getNextPassenger() {
		return next;
	}

	public void setNextPassenger(Passenger next) {
		this.next = next;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Passenger [flightNumber=" + flightNumber + ", ticketNumber=" + ticketNumber + ", fullName=" + fullName
				+ ", passportNumber=" + passportNumber + ", Nationality=" + Nationality + ", birthDate=" + birthDate
				+ "]";
	}

}
