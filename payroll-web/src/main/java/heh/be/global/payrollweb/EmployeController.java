package heh.be.global.payrollweb;


import com.google.gson.Gson;
import heh.be.global.Employe;
import heh.be.global.ReadEmploye;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin("*")
@RestController("/")
public class EmployeController {





    @GetMapping(value = "/bonjour")
    public String bonjour(){
        return "bonjour";
    }



    @GetMapping(value  ="/employeList")
    public String listEmploye(){

        ReadEmploye re  = new ReadEmploye();
        ArrayList<Employe> liste = re.getAllEmploye();

        Gson json = new Gson();
        String reponse = json.toJson(liste);
        return reponse;

    }



}
