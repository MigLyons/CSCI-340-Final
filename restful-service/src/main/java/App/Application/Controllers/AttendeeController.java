package App.Application.Controllers;

import App.Domain.Attendee;
import App.Domain.Table;
import App.Domain.Organization;
import App.Infrastructure.OrganizationRepository;
import App.Infrastructure.TableRepository;
import App.Infrastructure.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Attendee")
public class AttendeeController {

    @Autowired
    private JdbcTemplate databaseConnection;
    private AttendeeRepository attendeeRepository;
    private OrganizationRepository organizationRepository;
    private TableRepository tableRepository;
    public AttendeeController(){
        this.attendeeRepository = new AttendeeRepository();
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Attendee> get(){
        this.attendeeRepository.setDatabaseConnection(this.databaseConnection);
        return this.attendeeRepository.get();
    }

    @GetMapping("/{attendeeId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Attendee> get(@PathVariable("attendeeId") int attendeeId){
        this.attendeeRepository.setDatabaseConnection(this.databaseConnection);
        return this.attendeeRepository.get(attendeeId);
    }


    @PutMapping("/{attendeeId}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@PathVariable("attendeeId") int attendeeId, @RequestBody() Attendee attendee){
        this.attendeeRepository.setDatabaseConnection(this.databaseConnection);
        this.attendeeRepository.update(attendeeId, attendee);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void post(@RequestBody() Attendee attendee) throws Exception {
        this.attendeeRepository.setDatabaseConnection(this.databaseConnection);
        this.organizationRepository.setDatabaseConnection(this.databaseConnection);
        this.tableRepository.setDatabaseConnection(this.databaseConnection);
         try {
             List<Organization> organizations = this.organizationRepository.get(attendee.getOrganization());
             if (organizations.isEmpty()) {
                 throw new Exception("No such organization");
             }
             Organization organization = organizations.get(0);

             List<Table> tables = this.tableRepository.get(attendee.getTable());
             if (tables.isEmpty()) {
                 throw new Exception("No such table");
             }
             Table table = tables.get(0);
             if (table.getOrganization() != organization.getOrgId()) {
                 throw new Exception(attendee.getName() + " can't sit at table " + table.getTableId() + " because " + attendee.getOrganization() + " did not reserve that table.");
             } else {
                 this.attendeeRepository.create(attendee);
             }
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
    }

    @DeleteMapping("/{attendeeId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("attendeeId") int attendeeId){
        this.attendeeRepository.setDatabaseConnection(this.databaseConnection);
        this.attendeeRepository.delete(attendeeId);
    }
}
