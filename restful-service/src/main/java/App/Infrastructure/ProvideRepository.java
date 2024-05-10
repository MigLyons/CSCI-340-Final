package App.Infrastructure;

import App.Domain.IProvideRepository;
import App.Domain.Provide;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvideRepository implements IProvideRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Provide create(Provide provide) {
        String sql = "INSERT INTO mg167598.Provide VALUES ('" + provide.getProvideId() + "', '" + provide.getDonorName() + "')";
        this.databaseConnection.execute(sql);
        return provide;
    }

    @Override
    public int update(int id, Provide provide) {
        String sql = "UPDATE mg167598.Provide SET " +
                "vendorName = '" + provide.getVendorName() + "', " +
                "donorName = '" + provide.getDonorName() + "' " +
                "WHERE provideId = " + id + ";";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(int provideId) {
        String sql = "DELETE FROM mg167598.Provide WHERE provideId = " + provideId + ";";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<Provide> get(int provideId) {
        String sql = "SELECT * FROM mg167598.Provide WHERE provideId = " + provideId + ";";
        List<Provide> provides = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Provide.class));
        return provides;
    }

    @Override
    public List<Provide> get() {
        String sql = "SELECT * FROM mg167598.Provide";
        List<Provide> provides = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Provide.class));
        return provides;
    }
}
