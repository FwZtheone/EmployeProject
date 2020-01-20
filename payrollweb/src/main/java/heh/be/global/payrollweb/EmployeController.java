package heh.be.global.payrollweb;

import com.google.gson.Gson;
import heh.be.global.DatabaseConnectionManager;
import heh.be.global.Employe;
import heh.be.global.FactoryMethodAddEmploye.AddSalariedEmp;
import heh.be.global.FactoryMethodAddEmploye.Context;
import heh.be.global.ReadEmploye;
import heh.be.global.SqlEmployeGateway;
import heh.be.global.StrategyClassification.CommissionClassification;
import heh.be.global.StrategyClassification.HourlyClassification;
import heh.be.global.StrategyClassification.SalariedClassification;
import heh.be.global.StrategyPayement.CashMethod;
import heh.be.global.StrategyPayement.DirectDepositMethod;
import heh.be.global.StrategyPayement.MailMethod;
import heh.be.global.StrategySchedule.MonthlyPayementSchedule;
import heh.be.global.StrategySchedule.TwoWeekPay;
import heh.be.global.StrategySchedule.WeeklyPayementSchedule;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@CrossOrigin("*")
@RestController("/")
public class EmployeController {



        @GetMapping(value = "/bonjour")
        public String bonjour(){
            return "bonjour";
        }



        @GetMapping(value  ="/employeList")
        public String listEmploye() {

          ReadEmploye re = new ReadEmploye();
          ArrayList<Employe> liste = re.getAllEmploye();
          Gson json = new Gson();
          String reponse = json.toJson(liste);
          return reponse;
        }

    @RequestMapping(value="/addEmploye", method = RequestMethod.POST)
    public String addEmploye(@RequestParam (value="nom") String nom, @RequestParam(value ="addresse") String address,
                             @RequestParam(value="method") String method, @RequestParam(value = "schedule") String schedule, @RequestParam(value = "type") String type){
         int id=1;
         Employe e = new Employe();
        Context.employeGateway = new SqlEmployeGateway();
         e = new Employe(id,nom,address);
         if(method.equals("direct"))
         {
             e.setPayMethod(new DirectDepositMethod("ING","BE-859858-85"));
         }
         else if(method.equals("cash")){
             e.setPayMethod(new CashMethod());
         }
         else if(method.equals("mail")){
             e.setPayMethod(new MailMethod(nom.toString()+"@hotmail.com"));
         }
         else{

         }
         if(schedule.equals("mois")){
             e.setPaySchedule(new MonthlyPayementSchedule());
         }
         else if(schedule.equals("semaine")){
             e.setPaySchedule(new WeeklyPayementSchedule());
         }
         else if(schedule.equals("2semaines")){
             e.setPaySchedule(new TwoWeekPay());
         }
         else{}
         if(type.equals("salarie")){
             e.setPayClassification(new SalariedClassification(2000));
         }
         else if(type.equals("heure")){
             e.setPayClassification(new HourlyClassification(50));
         }
         else if(type.equals("commission")){
             e.setPayClassification(new CommissionClassification(5000));
         }
         else{

         }
         Context.employeGateway.save(id,e);

            return " Nom : " +nom + " address :  "+ address + " method : "  + method + " type de payement : " + schedule + " type : " + type;

    }

}
