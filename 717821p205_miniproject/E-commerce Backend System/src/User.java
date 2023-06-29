public class User {
    private int userid;
    private String name;
    private String contact;
    private String country;
    public User(int userid, String name, String contact, String country) {
        this.userid = userid;
        this.name = name;
        this.contact = contact;
        this.country = country;
    } 
    public User() {
    }
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    @Override
    public String toString() {
        return "User [userid=" + userid + ", name=" + name + ", contact=" + contact + ", country=" + country + "]";
    }
}