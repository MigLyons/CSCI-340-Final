package App.Domain;

import java.util.List;

public class Seats {
    private int seatsId;
    private List<String> seats;
    private int tableId;

    // Getter for seats
    public List<String> getSeats() {
        return seats;
    }

    // Setter for seats
    public void setSeats(List<String> seats) {
        this.seats = seats;
    }

    // Getter for tableId
    public int getTableId() {
        return tableId;
    }

    // Setter for tableId
    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    //Getter for seatsId
    public int getSeatsId(){
        return seatsId;
    }

    //Setter for seatsId

    public void setSeatsId(int seatsId) {
        this.seatsId = seatsId;
    }
}
