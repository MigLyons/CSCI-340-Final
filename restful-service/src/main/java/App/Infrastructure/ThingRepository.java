package App.Infrastructure;

import App.Domain.IThingRepository;
import App.Domain.Thing;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ThingRepository implements IThingRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Thing create(Thing thing) {
        String sql = "INSERT INTO mg167598.Thing VALUES (" + thing.getPurchaseId() + ", " + thing.getValue() + ", '" + thing.getDonorName() + "', '" +
                thing.getDescription() + "', '" + thing.getTitle() + "', '" + thing.getPurchaserName() + "')";
        this.databaseConnection.execute(sql);
        return thing;
    }

    @Override
    public int update(int id, Thing thing) {
        String sql = "UPDATE mg167598.Thing SET " +
                "purchaseId = " + thing.getPurchaseId() + ", " +
                "value = " + thing.getValue() + ", " +
                "donorName = '" + thing.getDonorName() + "', " +
                "description = '" + thing.getDescription() + "', " +
                "title = '" + thing.getTitle() + "', " +
                "purchaserName = '" + thing.getPurchaserName() + "' " +
                "WHERE thingId = " + id + ";";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(int thingId) {
        String sql = "DELETE FROM mg167598.Thing WHERE thingId = " + thingId + ";";
        this.databaseConnection.update(sql);
        return true;
    }

    @Override
    public List<Thing> get(int thingId) {
        String sql = "SELECT * FROM mg167598.Thing WHERE thingId = " + thingId + ";";
        List<Thing> things = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Thing.class));
       return things;
    }

    @Override
    public List<Thing> get() {
        String sql = "SELECT * FROM mg167598.Thing";
        List<Thing> things = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Thing.class));
        return things;
    }
}
