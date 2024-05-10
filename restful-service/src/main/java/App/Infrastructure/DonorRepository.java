package App.Infrastructure;

import App.Domain.IDonorRepository;
import App.Domain.Donor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DonorRepository implements IDonorRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Donor create(Donor donor) {
        String sql = "INSERT INTO mg167598.Donor VALUES ('" + donor.getDonorId() + "', '" + donor.getAddress() + "', '" + donor.getPhoneNumber() + "')";
        this.databaseConnection.execute(sql);
        return donor;
    }

    @Override
    public int update(int id, Donor donor) {
        String sql = "UPDATE mg167598.Donor SET " +
                "name = '" + donor.getName() + "', " +
                "address = '" + donor.getAddress() + "', " +
                "phoneNumber = '" + donor.getPhoneNumber() + "' " +
                "WHERE donorId = " + id + ";";

        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(int donorId) {
        String sql = "DELETE FROM mg167598.Donor WHERE donorId = " + donorId + ";";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<Donor> get(int donorId) {
        String sql = "SELECT * FROM mg167598.Donor WHERE donorId = " + donorId + ";";
        List<Donor> donors = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Donor.class));
        return donors;
    }

    @Override
    public List<Donor> get() {
        String sql = "SELECT * FROM mg167598.Donor";
        List<Donor> donors = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Donor.class));
        return donors;
    }
}
