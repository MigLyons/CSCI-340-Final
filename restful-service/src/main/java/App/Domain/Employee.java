package App.Domain;

public class Employee {
    private String ssn;

    private String name;

    public Employee(String ssn, String name){ this.name = name; this.ssn = ssn;}

    public void setSsn(String ssn){
        this.ssn = ssn;
    }

    public String getName(){ return this.name; }

    public void setName(String name){
        this.name = name;
    }

    public String getSsn(){ return this.ssn; }

}
