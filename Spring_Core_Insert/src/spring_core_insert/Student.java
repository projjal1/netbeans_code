package spring_core_insert;


public class Student 
{
   public  Student()
    {}
    public Student(String a,String b,String c,String d)
    {
        Name=a;
        Password=b;
        Email=c;
        Country=d;
    }
   private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }
  private  String Name,Password,Email,Country;
}
