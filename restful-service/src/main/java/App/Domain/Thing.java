package App.Domain;

public class Thing {
    private int thingId;
    private int purchaseId;
    private int value;
    private String donorName;
    private String description;
    private String title;
    private String purchaserName;

    // Getter methods
    public int getThingId() {
        return thingId;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public int getValue() {
        return value;
    }

    public String getDonorName() {
        return donorName;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    // Setter methods
    public void setThingId(int thingId) {
        this.thingId = thingId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }
}
