package App.Application.Controllers;

import App.Domain.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @GetMapping("/")
    public Employee[] Get(){
        Employee emp1 = new Employee("123456780", "JAKE PAUL");
        Employee emp2 = new Employee("123456789", "ORSON WELLES");
        Employee[] myEmployees = { emp1, emp2 };
        return myEmployees;
    }
}
