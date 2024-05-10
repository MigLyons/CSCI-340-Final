package App.Domain;

public class Cost {
    private int costId;
    private String service;
    private int total;
    private boolean paid;
    private String supplier;

    // Getter methods
    public int getCostId(){
        return costId;
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

    public String getSupplier() {
        return supplier;
    }

    // Setter methods
    public void setCostId(int costId){
        this.costId = costId;
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

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
