package App.Application.Controllers;

import App.Domain.Volunteer;
import App.Infrastructure.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Volunteer")
public class VolunteerController {

    @Autowired
    private JdbcTemplate databaseConnection;
    private VolunteerRepository volunteerRepository;

    public VolunteerController() {
        this.volunteerRepository = new VolunteerRepository();
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Volunteer> get(){
        this.volunteerRepository.setDatabaseConnection(this.databaseConnection);
        return this.volunteerRepository.get();
    }

    @GetMapping("/{volId}")
    @ResponseStatus(HttpStatus.OK)
    public Volunteer get(@PathVariable("volId") int volId){
        this.volunteerRepository.setDatabaseConnection(this.databaseConnection);
        return (Volunteer) this.volunteerRepository.get(volId);
    }

    @PutMapping("/{volId}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@PathVariable("volId") int volId, @RequestBody Volunteer volunteer){
        this.volunteerRepository.setDatabaseConnection(this.databaseConnection);
        this.volunteerRepository.update(volId, volunteer);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody Volunteer volunteer){
        this.volunteerRepository.setDatabaseConnection(this.databaseConnection);
        this.volunteerRepository.create(volunteer);
    }

    @DeleteMapping("/{volId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("volId") int volId){
        this.volunteerRepository.setDatabaseConnection(this.databaseConnection);
        this.volunteerRepository.delete(volId);
    }
}
