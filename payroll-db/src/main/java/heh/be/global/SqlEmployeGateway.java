package heh.be.global;


import heh.be.global.FactoryMethodAddEmploye.employeGateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class SqlEmployeGateway  implements employeGateway {



    public SqlEmployeGateway(){

    }


    @Override
    public Employe getEmploye(int empID) {
        return null;
    }

    @Override
    public void save(int empID, Employe employe) {

        DatabaseConnectionManager objetmanager = new DatabaseConnectionManager("localhost","payroll","postgres","root");

        try {
            Connection connection = objetmanager.getConnection();
            PreparedStatement requetePrepa = connection.prepareStatement("INSERT INTO employe (name, address, type, method, schedule)  VALUES (?,?,?,?,?)");
            requetePrepa.setString(1,employe.getName().toLowerCase());
            requetePrepa.setString(2,employe.getAddress());
            requetePrepa.setString(3,employe.getPayClassfication().toString());
            requetePrepa.setString(4,employe.getPayMethod().toString());
            requetePrepa.setString(5,employe.getPayementSchedule().toString());
            requetePrepa.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteEmploye(int empID) {

    }

    @Override
    public void bonjour() {

    }

    @Override
    public Map getAllEmploye() {
        return null;
    }
}
