package App.Infrastructure;

        import App.Domain.Table;
        import App.Domain.ITableRepository;
        import org.springframework.jdbc.core.BeanPropertyRowMapper;
        import org.springframework.jdbc.core.JdbcTemplate;

        import java.util.List;

public class TableRepository implements ITableRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Table create(Table table) {
        String sql = "INSERT INTO mg167598.Table VALUES ('" + table.getOrganization() + "', '" + table.getSeatCount() + "', '" +  table.getTableId() + "')";
        this.databaseConnection.execute(sql);
        return table;
    }

    @Override
    public int update(int id, Table table) {
        String sql = "UPDATE mg167598.Table SET organization = '" + table.getOrganization() + "', seatCount = '" + table.getSeatCount() + "', tableId = '" + table.getTableId() + "';";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM mg167598.Table WHERE tableId = '" + id + "';";
        this.databaseConnection.update(sql);
        return true;
    }

    @Override
    public List<Table> get(int id) {
        String sql = "SELECT * FROM mg167598.Table WHERE tableId = " + id + ";";
        List<Table> tables = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Table.class), id);
        return tables;
    }

    @Override
    public List<Table> get() {
        String sql = "SELECT * FROM mg167598.Table;";
        List<Table> tables = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Table.class));
        return tables;
    }
}
