import heh.be.global.DatabaseConnectionManager;
import heh.be.global.Employe;
import heh.be.global.FactoryMethodAddEmploye.Context;
import heh.be.global.StrategyClassification.SalariedClassification;
import heh.be.global.StrategyPayement.DirectDepositMethod;
import heh.be.global.StrategySchedule.MonthlyPayementSchedule;
import heh.be.global.SqlEmployeGateway;
import org.junit.Before;
import org.junit.Test;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TestSqlEmployeGateway {
    private SqlEmployeGateway sqlEmployeGateway;
    private Connection connection;
    private Employe e;


    @Before
    public void setup(){
        Context.employeGateway  = new SqlEmployeGateway();
//        cleanTableEmploye();
        e = new Employe(1,"Clement","rue du marché");
        e.setPayClassification(new SalariedClassification(2000));
        e.setPaySchedule(new MonthlyPayementSchedule());
        e.setPayMethod(new DirectDepositMethod("ING","BE-123-456-789"));
        DatabaseConnectionManager objet = new DatabaseConnectionManager("localhost","payroll","postgres","root");
        try {
            connection = objet.getConnection();
        }
        catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

        private void cleanTableEmploye(){
            DatabaseConnectionManager objetmanager = new DatabaseConnectionManager("localhost","payroll","postgres","root");
            try {
                String  delete = "DELETE FROM employe";
                Connection connection = objetmanager.getConnection();
                PreparedStatement statement  = connection.prepareStatement(delete);
                statement.execute();
                connection.close();

            }
            catch (SQLException | ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }



        @Test
        public void addEmploye(){

           Context.employeGateway.save(1,e);
            try{
                String  select = "SELECT *  FROM employe";
                PreparedStatement statement = connection.prepareStatement(select);
                ResultSet rs  = statement.executeQuery();
                while(rs.next()){
                    assertEquals(12
                            ,rs.getInt("ID"));
                    assertEquals("fabrizio",rs.getString("NAME"));
                    assertEquals("rue du paradis",rs.getString("ADDRESS"));
                    assertEquals("mois",rs.getString("SCHEDULE"));
                    assertEquals("direct",rs.getString("METHOD"));
                    assertEquals("salaried",rs.getString("TYPE"));

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }

        @Test
        public void deleteEmploye(){
            Context.employeGateway.deleteEmploye(26);

            int i = 0;
            try {
                String  select = "SELECT *  FROM employe";
                PreparedStatement statement = connection.prepareStatement(select);
                ResultSet rs  = statement.executeQuery();

               Employe e = Context.employeGateway.getEmploye(24);
               assertNotNull(e);








            }
            catch(SQLException e){
                e.printStackTrace();
            }



        }





}
