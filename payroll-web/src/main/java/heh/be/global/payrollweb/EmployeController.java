package heh.be.global.payrollweb;


import heh.be.global.Employe;
import heh.be.global.FactoryMethodAddEmploye.Context;
import heh.be.global.GetAllEmploye;
import heh.be.global.SqlEmployeGateway;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin("*")
@RestController("/")
public class EmployeController {






    @GetMapping
    public String listEmploye(){
        return "Test";
    }


    @GetMapping(value = "/employeList")
    public Map getEmploye(){

        GetAllEmploye employe = new GetAllEmploye();
        return employe.getAllEmploye();
    }


}
