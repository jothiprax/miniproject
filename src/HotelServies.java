class HotelServies{
    String name;
    String address;
    String PhoneNumber;
    public HotelServies()
    {

    }
    public HotelServies(String name, String address, String PhoneNumber)
    {
        this.name=name;
        this.address=address;
        this.PhoneNumber=PhoneNumber;
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void display()
    {
        System.out.println("Welcome to "+name+" Hotel");
        System.out.println("Contect no:"+PhoneNumber);
    }
}