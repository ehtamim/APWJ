import java.time.LocalDate;

public class person {
    private String id;
    private String Name;
    private LocalDate dob;

    public void setPerson(String Name, String id, LocalDate dob)
    {
        this.Name=Name;
        this.id=id;
        this.dob=dob;
    }

    public void show()
    {
        System.out.println("Person Info>>>>>");
        System.out.println("Name:"+Name);
        System.out.println("ID  :"+id);
        System.out.println("DOB :"+dob);
    }
}
