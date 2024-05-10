package App.Infrastructure;

import App.Domain.IOrganizationRepository;
import App.Domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import java.sql.PreparedStatement;
import java.util.List;

public class OrganizationRepository implements IOrganizationRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Organization create(Organization organization) {
        String sql = "INSERT INTO mg167598.Organization VALUES ('" + organization.getOrgId() + "', '" + organization.getName() + "', '" + organization.getPaymentDetails() + "', '" + organization.getTable() + "', '" + organization.getHeadCount() + "', '" + organization.getEmail() + "', '" + organization.hasPaymentStatus() + "', '" + organization.getPhoneNumber() + "')";
        this.databaseConnection.execute(sql);
        return organization;
    }

    @Override
    public int update(int id, Organization organization) {
        String sql = "UPDATE mg167598.Organization SET " +
                "name = '" + organization.getName() + "', " +
                "paymentDetails = '" + organization.getPaymentDetails() + "', " +
                "\"table\" = " + organization.getTable() + ", " +
                "headCount = " + organization.getHeadCount() + ", " +
                "email = '" + organization.getEmail() + "', " +
                "paymentStatus = " + organization.hasPaymentStatus() + ", " +
                "phoneNumber = '" + organization.getPhoneNumber() + "' " +
                "WHERE orgId = " + organization.getOrgId();
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM mg167598.Organization WHERE orgId = '" + id + "';";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<Organization> get(int id) throws Exception {
        String sql = "SELECT * FROM mg167598.Organization WHERE orgId = " + id + ";";
        List<Organization> organizations = this.databaseConnection.query(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(Organization.class));
        return organizations;
    }

    @Override
    public List<Organization> get() {
        String sql = "SELECT * FROM mg167598.Organization";
        List<Organization> organizations = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Organization.class));
        return organizations;
    }
}
