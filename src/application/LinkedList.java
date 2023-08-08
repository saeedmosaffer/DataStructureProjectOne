package application;

import java.util.Date;

public class LinkedList {

	Flight H;
	Flight T;
	Passenger L = null;

	public LinkedList() {

	}

	public void AddFlightSorted(int flightNumber, String airlineName, String source, String destination, int Capacity) {

		Flight newnode = new Flight(flightNumber, airlineName, source, destination, Capacity);
		Flight c = H;
		Flight cn = c;

		if (c == null) {
			T = H = newnode;
			return;

		}

		if (c.nextFlight == null && newnode.getFlightNumber() > c.getFlightNumber()) {
			T.nextFlight = newnode;
			T = newnode;
			return;
		}

		if (c.nextFlight == null && newnode.getFlightNumber() < c.getFlightNumber()) {
			newnode.nextFlight = H;
			H = newnode;
			return;
		}

		while (cn.getFlightNumber() != flightNumber && cn.nextFlight != null) {

			c = cn;
			cn = cn.nextFlight;

			if (newnode.getFlightNumber() < c.getFlightNumber()) {
				if (c == H) {
					newnode.nextFlight = c;
					H = c = newnode;
					return;
				}
			}

			if (newnode.getFlightNumber() < cn.getFlightNumber()) {
				c.nextFlight = newnode;
				newnode.nextFlight = cn;
				c = newnode;
				return;
			}

			if (cn.getFlightNumber() < c.getFlightNumber()) {
				if (c == H) {
					c.nextFlight = cn;
					c.nextFlight = cn.nextFlight;
					cn.nextFlight = c;
					c = cn;
					cn = cn.nextFlight;
				}
			}
		}

		if (cn.nextFlight == null && newnode.getFlightNumber() < cn.getFlightNumber()) {
			c.nextFlight = newnode;
			newnode.nextFlight = cn;
		}

		if (cn.nextFlight == null && newnode.getFlightNumber() > cn.getFlightNumber()) {
			cn.nextFlight = newnode;
			cn = newnode;
		}
	}

	public Flight SearchFlight(int flightNumber) {

		Flight c = H;

		while (c.getFlightNumber() != flightNumber && c.nextFlight != null) {
			c = c.nextFlight;
		}

		if (c.getFlightNumber() == flightNumber) {
			return c;
		} else {
			return null;
		}
	}

	public void EditFlight(int flightNumber, String airlineName, String source, String destination, int Capacity) {

		Flight c = H;

		while (c.getFlightNumber() != flightNumber && c.nextFlight != null) {
			c = c.nextFlight;
		}

		if (c.getFlightNumber() == flightNumber) {

			c.setAirlineName(airlineName);
			c.setSource(source);
			c.setCapacity(Capacity);
			c.setDestination(destination);

		} else {

			System.out.println("the flight not found ");
		}
	}

	int x;

	public void AddPassengersSorted(int flightNumber, int ticketNumber, String fullName, String passportNumber,
			String Nationality, String birthDate) {

		Passenger newnode = new Passenger(flightNumber, ticketNumber, fullName, passportNumber, Nationality, birthDate);

		Flight C = H;

		if (H == null) {
			System.out.println("No Flight ");
		}

		while (C.getFlightNumber() != flightNumber && C.nextFlight != null) {

			C = C.nextFlight;
		}
		x = C.getCapacity();
		Passenger F = C.nextPassenger;
		Passenger L = F;
		if (x > 0) {
			if (F == null) {
				C.nextPassenger = newnode;
				F = L = newnode;
				x--;
				C.setCapacity(x);
				return;
			}

			if (F.next == null && newnode.getFullName().compareTo(F.getFullName()) > 0) {
				L.next = newnode;
				L = newnode;
				x--;
				C.setCapacity(x);

				return;
			}

			if (F.next == null && newnode.getFullName().compareTo(F.getFullName()) < 0) {
				C.nextPassenger = newnode;
				newnode.next = F;
				F = newnode;
				x--;
				C.setCapacity(x);

				return;
			}

			while (L.next != null) {
				F = L;
				L = L.next;

				if (newnode.getFullName().compareTo(F.getFullName()) < 0) {
					if (C.nextPassenger == F) {
						C.nextPassenger = newnode;
						newnode.next = F;
						F = newnode;
						x--;
						C.setCapacity(x);

						return;
					}
				}

				if (newnode.getFullName().compareTo(L.getFullName()) < 0) {
					F.next = newnode;
					newnode.next = L;
					F = newnode;
					x--;
					C.setCapacity(x);

					return;
				}

				if (L.getFullName().compareTo(F.getFullName()) < 0) {
					if (C.nextPassenger == F) {
						C.nextPassenger = L;
						F.next = L.next;
						L.next = F;
						F = L;
						L = L.next;

					}
				}
			}

			if (L.next == null && newnode.getFullName().compareTo(L.getFullName()) < 0) {
				F.next = newnode;
				newnode.next = L;
				x--;
				C.setCapacity(x);

			}

			if (L.next == null && newnode.getFullName().compareTo(L.getFullName()) > 0) {
				L.next = newnode;
				L = newnode;
				x--;
				C.setCapacity(x);

			}
		}
	}

	public void deletPassenger(int FNum, String fullName) {

		Flight curr = H;

		if (H == null) {
			System.out.println("No Flight");

		}

		while (curr.getFlightNumber() != FNum && curr.nextFlight != null) {
			curr = curr.nextFlight;

		}

		Passenger p = curr.nextPassenger;
		Passenger c = p.next;

		if (p.getFullName().equals(fullName)) {
			curr.nextPassenger = c;
			p.next = null;

		} else {

			while (c.getFullName() != fullName && c.next != null) {

				p = c;
				c = c.next;
			}

			if (c.getFullName().equals(fullName)) {
				p.next = c.next;
				c.next = null;

			} else {
				System.out.println("There is no passenger to delete it");

			}
		}

	}

	public String printFlight() {

		Flight c = H;
		String x = "";
		if (c == null) {
			return "no Flight !";

		} else {
			while (c != null) {
				x += c.toString() + "\n";
				c = c.nextFlight;
			}
		}
		return x;

	}

	public String printPassengers(int FlightNumber) {
		String x = "";
		Flight c = H;

		if (c == null) {
			return "no Flight";

		} else {

			while (c.getFlightNumber() != FlightNumber && c.nextFlight != null) {
				c = c.nextFlight;
			}

			Passenger currnt = c.nextPassenger;

			if (c.getFlightNumber() == FlightNumber) {

				if (currnt == null) {

					return "No  Passengers in this flight ";

				} else {

					while (currnt != null) {
						x += currnt.toString() + "\n";
						currnt = currnt.next;

					}
				}

			} else {
				return "There is no flight with this number !! ";

			}
		}
		return x;
	}

	public boolean cheakPerson(int flightNumber, String fullName) {

		Flight c = H;

		while (c.getFlightNumber() != flightNumber && c.nextFlight != null) {

			c = c.nextFlight;

		}

		if (c.nextPassenger == null) {
			return false;

		}

		Passenger curr = c.nextPassenger;
		if (c.getFlightNumber() == flightNumber) {

			while (curr.getFullName() != fullName && curr.next != null) {
				curr = curr.next;
			}

			if (curr.getFullName().equals(fullName)) {
				return true;

			} else {
				return false;

			}

		} else {
			return false;
		}

	}

	public String serchPassenger(String fullname) {

		Flight c = H;
		int flage = 0;
		String x = "";

		if (c == null) {
			return "There is no flight !!!";
		}

		while (c != null) {
			Passenger curr = c.nextPassenger;

			while (curr != null) {

				if (curr.getFullName().equals(fullname)) {
					x = curr.toString();
					flage = 1;
					break;
				}
				curr = curr.next;
			}

			c = c.nextFlight;
		}

		if (flage == 0) {
			return "There is no passenger with this name";

		}
		return x;

	}

}
