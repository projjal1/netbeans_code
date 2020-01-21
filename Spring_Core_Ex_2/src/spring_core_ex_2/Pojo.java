package spring_core_ex_2;

public class Pojo 
{
    private int id;
    private String name,address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void disp(Pojo obj)
    {
        System.out.println("Name is "+obj.name);
        System.out.println("Address is "+obj.address);
        System.out.println("Id is "+obj.id);
    }
}
