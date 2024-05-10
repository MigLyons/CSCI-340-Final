package App.Domain;

public class Table {
    private int organization;
    private int seatCount;
    private int tableId;

    // Getter methods
    public int getOrganization() {
        return organization;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public int getTableId() {
        return tableId;
    }

    // Setter methods
    public void setOrganization(int organization) {
        this.organization = organization;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }
}
