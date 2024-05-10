package App.Application.Controllers;

import App.Domain.Thing;
import App.Infrastructure.ThingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Thing")
public class ThingController {

    @Autowired
    private JdbcTemplate databaseConnection;
    private ThingRepository thingRepository;

    public ThingController() {
        this.thingRepository = new ThingRepository();
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Thing> get(){
        this.thingRepository.setDatabaseConnection(this.databaseConnection);
        return this.thingRepository.get();
    }

    @GetMapping("/{thingId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Thing> get(@PathVariable("thingId") int thingId){
        this.thingRepository.setDatabaseConnection(this.databaseConnection);
        return this.thingRepository.get(thingId);
    }

    @PutMapping("/thingId")
    @ResponseStatus(HttpStatus.OK)
    public void put(@PathVariable("thingId") int thingId, @RequestBody() Thing thing){
        this.thingRepository.setDatabaseConnection(this.databaseConnection);
        this.thingRepository.update(thingId, thing);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody() Thing thing){
        this.thingRepository.setDatabaseConnection(this.databaseConnection);
        this.thingRepository.create(thing);
    }

    @DeleteMapping("/thingId")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("thingId") int thingId){
        this.thingRepository.setDatabaseConnection(this.databaseConnection);
        this.thingRepository.delete(thingId);
    }
}
