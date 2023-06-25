package airline;

public class Passenger{
	    private String passengerId;
	    private String name;
	    private String passportNumber;
	    public String getPassengerId() {
	        return passengerId;
	    }

	    public void setPassengerId(String passengerId) {
	        this.passengerId = passengerId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getPassportNumber() {
	        return passportNumber;
	    }

	    public void setPassportNumber(String passportNumber) {
	        this.passportNumber = passportNumber;
	    }
	   
	    @Override
	    public String toString() {
	        return "Passenger ID: " + passengerId +
	                "\nName: " + name +
	                "\nPassport Number: " + passportNumber;
	    }
	}
