package by.bsuir.hotelReservation.domain;

public class Room {

	protected int id;
	protected int number;
	protected int type;
	protected int countOfPeople;
	protected boolean isVacant;

	public Room(int id, int number, int type, int countOfPeople, boolean isVacant) {
		this.id = id;
		this.number = number;
		this.type = type;
		this.countOfPeople = countOfPeople;
		this.isVacant = isVacant;
	}

	public Room(int number, int type, int countOfPeople, boolean isVacant) {
		this.number = number;
		this.type = type;
		this.countOfPeople = countOfPeople;
		this.isVacant = isVacant;
	}

	public Room(int number, int type, int countOfPeople) {
		this.number = number;
		this.type = type;
		this.countOfPeople = countOfPeople;
		this.isVacant = true;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCountOfPeople() {
		return countOfPeople;
	}

	public void setCountOfPeople(int countOfPeople) {
		this.countOfPeople = countOfPeople;
	}

	public boolean getIsVacant() {
		return isVacant;
	}

	public void setVacant(boolean isVacant) {
		this.isVacant = isVacant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Room that = (Room) o;

		if (number != that.number) {
			return false;
		}
		return type == that.type && countOfPeople == that.countOfPeople;

	}

	@Override
	public int hashCode() {
		// int result = name != null ? name.hashCode() : 0;
		int result = 31 * number + 13;
		return result;
	}

	@Override
	public String toString() {
		return "Room {" + "number='" + number + '\'' + "type='" + type + '\'' + ",countOfPeople =" + countOfPeople
				+ '}';
	}

}
