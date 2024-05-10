package App.Domain;

public class Attendee {

    private int attendeeId;
    private String name;
    private String phoneNumber;
    private String paymentMethod;
    private String emailAddress;
    private String address;
    private String mealChoice;
    private boolean plusOne;
    private boolean paymentStatus;
    private boolean attended;
    private int organization;
    private int table;

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAttendeeId() {
        return attendeeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public String getMealChoice() {
        return mealChoice;
    }

    public boolean hasPlusOne() {
        return plusOne;
    }

    public boolean hasPaymentStatus() {
        return paymentStatus;
    }

    public boolean hasAttended() {
        return attended;
    }

    public int getOrganization() {
        return organization;
    }

    public int getTable() {
        return table;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }
    public void setAttendeeId(int attendeeId) {
        this.attendeeId = attendeeId;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMealChoice(String mealChoice) {
        this.mealChoice = mealChoice;
    }

    public void setPlusOne(boolean plusOne) {
        this.plusOne = plusOne;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public void setOrganization(int organization) {
        this.organization = organization;
    }

    public void setTable(int table) {
        this.table = table;
    }
}
