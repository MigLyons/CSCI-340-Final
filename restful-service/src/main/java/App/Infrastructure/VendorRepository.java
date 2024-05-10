package App.Infrastructure;

import App.Domain.IVendorRepository;
import App.Domain.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class VendorRepository implements IVendorRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Vendor create(Vendor vendor) {
        String sql = "INSERT INTO mg167598.Vendor VALUES ('" + vendor.getVendorId() + "', '" + vendor.getName() + "', '" + vendor.getPhoneNumber() + "', '" + vendor.getService() + "', '" + vendor.getTotal() + "', '" + vendor.isPaid() + "', '" + vendor.getDonorName() + "');";
        this.databaseConnection.execute(sql);
        return vendor;
    }

    @Override
    public int update(int vendorId, Vendor vendor) {
        String sql = "UPDATE Vendor SET " +
                "name = '" + vendor.getName() + "', " +
                "phoneNumber = '" + vendor.getPhoneNumber() + "', " +
                "service = '" + vendor.getService() + "', " +
                "total = " + vendor.getTotal() + ", " +
                "paid = " + vendor.isPaid() + ", " +
                "donorName = '" + vendor.getDonorName() + "' " +
                "WHERE vendorId = " + vendorId + ";";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM mg167598.Vendor WHERE vendorId = '"+ id + "';";
        this.databaseConnection.update(sql, id);
        return true;
    }

    @Override
    public List<Vendor> get(int id) throws Exception {
        String sql = "SELECT * FROM mg167598.Vendor WHERE vendorId = " + id + ";";
        List<Vendor> vendors = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Vendor.class));
        return vendors;
    }

    @Override
    public List<Vendor> get() {
        String sql = "SELECT * FROM mg167598.Vendor";
        List<Vendor> vendors = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Vendor.class));
        return vendors;
    }
}
