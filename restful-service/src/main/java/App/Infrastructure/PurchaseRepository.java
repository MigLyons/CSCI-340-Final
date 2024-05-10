package App.Infrastructure;

import App.Domain.IPurchaseRepository;
import App.Domain.Purchase;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PurchaseRepository implements IPurchaseRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Purchase create(Purchase purchase) {
        String sql = "INSERT INTO mg167598.Purchase VALUES (" + purchase.getPurchaseId() + ", '" + purchase.getTotal() + "', '" + purchase.getPurchaser() + "')";
        this.databaseConnection.execute(sql);
        return purchase;
    }

    @Override
    public int update(int id, Purchase purchase) {
        String sql = "UPDATE mg167598.Purchase SET " +
                "total = " + purchase.getTotal() + ", " +
                "purchaserName = '" + purchase.getPurchaser() + "' " +
                "WHERE purchaseId = " + id + ";";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(int purchaseId) {
        String sql = "DELETE FROM mg167598.Purchase WHERE purchaseId = " + purchaseId + ";";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<Purchase> get(int purchaseId) throws Exception {
        String sql = "SELECT * FROM mg167598.Purchase WHERE purchaseId = " + purchaseId + ";";
        List<Purchase> purchases = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Purchase.class));
        return purchases;
    }

    @Override
    public List<Purchase> get() {
        String sql = "SELECT * FROM mg167598.Purchase";
        List<Purchase> purchases = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Purchase.class));
        return purchases;
    }
}
