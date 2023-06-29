class Product{
    private int productid;
    private String name;
    private double price;
    private int Quantity;
    Product(int id,String name,double price,int quantity){
        this.productid=id;
        this.name=name;
        this.price=price;
        this.Quantity=quantity;
    }
    Product(){
    }
    public int getprodId() {
        return productid;
    }
    public void setId(int id) {
        this.productid = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return Quantity;
    }
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
    @Override
    public String toString() {
        return "Product [prodid=" + productid + ", name=" + name + ", price=" + price + ", Quantity=" + Quantity + "]";
    }
}