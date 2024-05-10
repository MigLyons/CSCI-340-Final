package App.Infrastructure;

import App.Domain.ICostRepository;
import App.Domain.Cost;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CostRepository implements ICostRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Cost create(Cost cost) {
        String sql = "INSERT INTO mg167598.Cost VALUES ('" + cost.getService() + "', " + cost.getTotal() + ", " + cost.isPaid() + ")";
        this.databaseConnection.execute(sql);
        return cost;
    }

    @Override
    public int update(int id, Cost cost) {
        String sql = "UPDATE mg167598.Cost SET " +
                "service = '" + cost.getService() + "', " +
                "total = " + cost.getTotal() + ", " +
                "paid = " + cost.isPaid() + " " +
                "WHERE costId = " + id + ";";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(int costId) {
        String sql = "DELETE FROM mg167598.Cost WHERE costId = '" + costId + "';";
        this.databaseConnection.update(sql, costId);
        return true;
    }

    @Override
    public List<Cost> get(int costId){
        String sql = "SELECT * FROM mg167598.Cost WHERE costId = " + costId + ";";
        List<Cost> costs = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Cost.class));
        return costs;
    }

    @Override
    public List<Cost> get() {
        String sql = "SELECT * FROM mg167598.Cost";
        List<Cost> costs = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Cost.class));
        return costs;
    }
}
