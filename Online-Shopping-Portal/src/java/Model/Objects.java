package Model;
// Generated 19 Jan, 2020 1:54:58 PM by Hibernate Tools 3.6.0



/**
 * Objects generated by hbm2java
 */
public class Objects  implements java.io.Serializable {


     private Integer id;
     private String name;
     private int quantity;
     private String owner;
     private int price;
     private String type;

    public Objects() {
    }

    public Objects(String name, int quantity, String owner, int price, String type) {
       this.name = name;
       this.quantity = quantity;
       this.owner = owner;
       this.price = price;
       this.type = type;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getOwner() {
        return this.owner;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }




}


