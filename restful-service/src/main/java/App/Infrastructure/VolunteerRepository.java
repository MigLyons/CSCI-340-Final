package App.Infrastructure;

import App.Domain.IVolunteerRepository;
import App.Domain.Volunteer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class VolunteerRepository implements IVolunteerRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Volunteer create(Volunteer volunteer) {
        String sql = "INSERT INTO mg167598.Volunteer VALUES ('" + volunteer.getVolId() + "', '" + volunteer.getAvailability() + "', " + volunteer.getHoursWorked() + ", '" + volunteer.getAttendeeName() + "')";
        this.databaseConnection.execute(sql);
        return volunteer;
    }

    @Override
    public int update(int id, Volunteer volunteer) {
        String sql = "UPDATE mg167598.Volunteer SET " +
                "position = '" + volunteer.getPosition() + "', " +
                "availability = '" + volunteer.getAvailability() + "', " +
                "hoursWorked = " + volunteer.getHoursWorked() + ", " +
                "attendeeName = '" + volunteer.getAttendeeName() + "' " +
                "WHERE volId = " + id + ";";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(int volId) {
        String sql = "DELETE FROM mg167598.Volunteer WHERE volId = " + volId + ";";
        this.databaseConnection.update(sql);
        return true;
    }

    @Override
    public List<Volunteer> get(int volId){
        String sql = "SELECT * FROM mg167598.Volunteer WHERE volId = " + volId + ";";
        List<Volunteer> volunteers = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Volunteer.class));
        return volunteers;
    }

    @Override
    public List<Volunteer> get() {
        String sql = "SELECT * FROM mg167598.Volunteer";
        List<Volunteer> volunteers = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Volunteer.class));
        return volunteers;
    }
}
