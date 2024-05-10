package App.Domain;

public class Vendor {
    private int vendorId;
    private String name;
    private String phoneNumber;
    private String service;
    private int total;
    private boolean paid;
    private String donorName;

    // Getter methods
    public int getVendorId(){
        return vendorId;
    }
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getService() {
        return service;
    }

    public int getTotal() {
        return total;
    }

    public boolean isPaid() {
        return paid;
    }

    public String getDonorName() {
        return donorName;
    }

    // Setter methods
    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }
}
