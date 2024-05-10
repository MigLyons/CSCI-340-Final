package App.Domain;

public class Volunteer {
    private int volId;
    private String position;
    private String availability;
    private int hoursWorked;
    private String attendeeName;

    // Getter methods
    public int getVolId(){
        return volId;
    }
    public String getPosition() {
        return position;
    }

    public String getAvailability() {
        return availability;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    // Setter methods
    public void setVolId(int volId){
        this.volId = volId;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setAttendeeName(String attendeeName) {
        this.attendeeName = attendeeName;
    }
}
