package App.Infrastructure;

import App.Domain.Attendee;
import App.Domain.IAttendeeRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AttendeeRepository implements IAttendeeRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Attendee create(Attendee attendee) {
        String sql = "INSERT INTO mg167598.Attendee VALUES ('" + attendee.getAttendeeId() + "', '" + attendee.getName() + "', '" + attendee.getPhoneNumber() + "', '" + attendee.getPaymentMethod() + "', '" + attendee.getEmailAddress() + "', '" + attendee.getAddress() + "', '" + attendee.getMealChoice() + "', '" + attendee.hasPlusOne() + "', '" + attendee.hasPaymentStatus() + "', '" + attendee.hasAttended() + "', '" + attendee.getOrganization() + "', '" + attendee.getTable() + "')";
        this.databaseConnection.execute(sql);
        return attendee;
    }

    @Override
    public int update(int id, Attendee attendee) {
        String sql = "UPDATE mg167598.Attendee SET attendeeId = '" + attendee.getAttendeeId() + "', name= '" + attendee.getName() + "', phoneNumber = '" + attendee.getPhoneNumber() + "', paymentMethod = '" + attendee.getPaymentMethod() + "', emailAddress = '" + attendee.getEmailAddress() + "', address = '" + attendee.getAddress() + "', mealChoice = '" + attendee.getMealChoice() + "', plusOne = '" + attendee.hasPlusOne() + "', paymentStatus = '" + attendee.hasPaymentStatus() + "', attended = '" + attendee.hasAttended() + "', organization = '" + attendee.getOrganization() + "', table = '" + attendee.getTable() + "' WHERE name = '" + id + "';";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM mg167598.Attendee WHERE attendeeId = '" + id + "';";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<Attendee> get(int id) {
        String sql = "SELECT * FROM mg167598.Attendee WHERE attendeeId = " + id +  ";";
        List<Attendee> attendees = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Attendee.class));
        return attendees;
    }


    @Override
    public List<Attendee> get() {
        String sql = "SELECT * FROM mg167598.Attendee;";
        List<Attendee> attendees = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Attendee.class));
        return attendees;
    }
}
