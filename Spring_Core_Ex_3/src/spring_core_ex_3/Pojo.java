package spring_core_ex_3;

public class Pojo 
{
    private int roll,marks;
    private String name,address,standard;

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
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

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }
    
    public void disp(Pojo e)
    {
        System.out.println("Name is "+e.name);
        System.out.println("Address is "+e.address);
        System.out.println("Roll is "+e.roll);
        System.out.println("Standard is "+e.standard);
        System.out.println("Marks is "+e.marks);
    }
}
