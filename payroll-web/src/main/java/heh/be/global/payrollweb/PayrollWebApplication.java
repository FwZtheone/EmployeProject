package heh.be.global.payrollweb;

import heh.be.global.FactoryMethodAddEmploye.Context;
import heh.be.global.SqlEmployeGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PayrollWebApplication {

    public static void main(String[] args) {

        Context.employeGateway = new SqlEmployeGateway();

        SpringApplication.run(PayrollWebApplication.class, args



        );
    }

}
