package App.Domain;

public class Provide {
    private int provideId;
    private String vendorName;
    private String donorName;

    // Getter methods
    public String getVendorName() {
        return vendorName;
    }

    public String getDonorName() {
        return donorName;
    }
    public int getProvideId(){
        return provideId;
    }

    // Setter methods
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public void setProvideId(int provideId) {
        this.provideId = provideId;
    }
}
