package App.Application.Controllers;

import App.Domain.Purchase;
import App.Infrastructure.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Purchase")
public class PurchaseController {

    @Autowired
    private JdbcTemplate databaseConnection;
    private PurchaseRepository purchaseRepository;

    public PurchaseController() {
        this.purchaseRepository = new PurchaseRepository();
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Purchase> get(){
        this.purchaseRepository.setDatabaseConnection(this.databaseConnection);
        return this.purchaseRepository.get();
    }

    @GetMapping("/{purchaseId}")
    @ResponseStatus(HttpStatus.OK)
    public Purchase get(@PathVariable("purchaseId") int purchaseId) throws Exception {
        this.purchaseRepository.setDatabaseConnection(this.databaseConnection);
        return (Purchase) this.purchaseRepository.get(purchaseId);
    }

    @PutMapping("/{purchaseId}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@PathVariable("purchaseId") int purchaseId, @RequestBody Purchase purchase){
        this.purchaseRepository.setDatabaseConnection(this.databaseConnection);
        this.purchaseRepository.update(purchaseId, purchase);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody Purchase purchase){
        this.purchaseRepository.setDatabaseConnection(this.databaseConnection);
        this.purchaseRepository.create(purchase);
    }

    @DeleteMapping("/{purchaseId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("purchaseId") int purchaseId){
        this.purchaseRepository.setDatabaseConnection(this.databaseConnection);
        this.purchaseRepository.delete(purchaseId);
    }
}
