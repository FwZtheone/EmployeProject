package heh.be.global.payrollweb;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController("/")
public class EmployeController {

    @GetMapping
    public String listEmploye(){
        return "Test";
    }


}
