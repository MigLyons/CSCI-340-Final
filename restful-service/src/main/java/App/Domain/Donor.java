package App.Domain;

public class Donor {
    private int donorId;
    private String name;
    private String address;
    private String phoneNumber;

    // Getter methods
    public int getDonorId(){
        return donorId;
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter methods
    public void setDonorId(int donorId){
        this.donorId = donorId;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
