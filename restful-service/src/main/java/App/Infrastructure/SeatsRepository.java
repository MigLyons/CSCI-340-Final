package App.Infrastructure;

import App.Domain.ISeatsRepository;
import App.Domain.Seats;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SeatsRepository implements ISeatsRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Seats create(Seats seats) {
        String sql = "INSERT INTO mg167598.Seats VALUES ('" + seats.getSeatsId() + "', " + seats.getTableId() + ")";
        this.databaseConnection.execute(sql);
        return seats;
    }

    @Override
    public int update(int id, Seats seats) {
        String sql = "UPDATE mg167598.Seats SET " +
                "seats = '" + seats.getSeats().toString() + "', " +
                "tableId = " + seats.getTableId() + " " +
                "WHERE seatsId = " + id + ";";

        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(int seatsId) {
        String sql = "DELETE FROM mg167598.Seats WHERE seatsId = " + seatsId + ";";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<Seats> get(int seatsId) {
        String sql = "SELECT * FROM mg167598.Seats WHERE seatsId = " + seatsId + ";";
        List<Seats> seatsList = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Seats.class));
        return seatsList;
    }

    @Override
    public List<Seats> get() {
        String sql = "SELECT * FROM mg167598.Seats";
        List<Seats> seatsList = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Seats.class));
        return seatsList;
    }
}
