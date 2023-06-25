package PassengersList;
class Passport{
	private String fName;
	private String mName;
	private String dob;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	private String country;
	private String religion;
	private boolean FIRs;
	private String visaType;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public boolean isFIRs() {
		return FIRs;
	}
	public void setFIRs(boolean fIRs)throws CriminalRecord {
		FIRs = fIRs;
		if(FIRs==true) {		
			throw new CriminalRecord();
		}
	}
	public String getVisaType() {
		return visaType;
	}
	public void setVisaType(String visaType) {
		this.visaType = visaType;
	}
}
public class Passengers extends Passport{
	public String name;
	public int age;
	public String from;
	public String destination;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String detination) {
		this.destination = detination;
	}
	public String education;
	public String classtype;
	public String bookId="TAL-P5-"+(Math.round(Math.random()*(200-3)+3));
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getClasstype() {
		return classtype;
	}
	public String getBookId() {
		return bookId;
	}
	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}
}
