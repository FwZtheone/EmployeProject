package heh.be.global;


import heh.be.global.FactoryMethodAddEmploye.employeGateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        DatabaseConnectionManager objetmanager =  new DatabaseConnectionManager("localhost","payroll","postgres","root");
        String SQL= "DELETE FROM employe WHERE id=?";

        try{
            Connection connection = objetmanager.getConnection();
            PreparedStatement requetprepa = connection.prepareStatement(SQL);
            requetprepa.setInt(1,empID);
            requetprepa.execute();
            requetprepa.close();


        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void bonjour() {

    }

    @Override
    public Map getAllEmploye() {

        Map <Integer,String> hm = new HashMap();

        DatabaseConnectionManager objetmanager =  new DatabaseConnectionManager("localhost","payroll","postgres","root");

        String SQL= "SELECT * FROM employe";

        try {
            Connection connection = objetmanager.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL);
            ResultSet rs  = statement.executeQuery();
            while(rs.next()){
                hm.put(rs.getInt("id"),rs.getString("name"));
            }
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }



        return hm;
    }
}
