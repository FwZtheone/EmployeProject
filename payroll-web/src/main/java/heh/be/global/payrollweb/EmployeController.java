package heh.be.global.payrollweb;


import heh.be.global.Employe;
import heh.be.global.ReadEmploye;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@CrossOrigin("*")
@RestController("/")
public class EmployeController {



    @GetMapping(value = "/bonjour")
    public String bonjour(){
        return "bonjour";
    }


    @GetMapping(value  ="/employeList")
    public ArrayList<String> listEmploye(){

        ReadEmploye re  = new ReadEmploye();
        ArrayList<Employe> liste = re.getAllEmploye();
        ArrayList<String> liste2 = new ArrayList<>();

        for(Employe e : liste){
            liste2.add(e.getName());
        }

        return liste2;

    }



}
