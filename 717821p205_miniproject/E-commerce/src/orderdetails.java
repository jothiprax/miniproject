public class orderdetails {
    private int userid;
    private String username;
    private String country;
    private int contact;
    private int productname;
    private double price;
    private int quantity;
    public orderdetails() {
    }
    public orderdetails(int userid, String username, String country, int contact, int productname, double price,
            int quantity) {
        this.userid = userid;
        this.username = username;
        this.country = country;
        this.contact = contact;
        this.productname = productname;
        this.price = price;
        this.quantity = quantity;
    }
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getContact() {
        return contact;
    }
    public void setContact(int contact) {
        this.contact = contact;
    }
    public int getProductname() {
        return productname;
    }
    public void setProductname(int productname) {
        this.productname = productname;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
   
}
