package App.Domain;

public class Purchase {
    private int purchaseId;
    private int total;
    private int purchaser;

    // Getter methods
    public int getPurchaseId() {
        return purchaseId;
    }

    public int getTotal() {
        return total;
    }

    public int getPurchaser() {
        return purchaser;
    }

    // Setter methods
    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    public void setPurchaser(int purchaser) {
        this.purchaser = purchaser;
    }
}
