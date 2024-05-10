package App.Domain;

public class Organization {
    private int orgId;
    private String name;
    private String paymentDetails;
    private int table;
    private int headCount;
    private String email;
    private boolean paymentStatus;
    private String phoneNumber;

    // Getter methods
    public int getOrgId(){
        return orgId;
    }
    public String getName() {
        return name;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public int getTable() {
        return table;
    }

    public int getHeadCount() {
        return headCount;
    }

    public String getEmail() {
        return email;
    }

    public boolean hasPaymentStatus() {
        return paymentStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter methods
    public void setOrgId(int orgId){
        this.orgId = orgId;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public void setHeadCount(int headCount) {
        this.headCount = headCount;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
