
import FactoryMethodAddEmploye.AddHourlyEmploye;
import FactoryMethodAddEmploye.AddTimeCard;
import FactoryMethodAddEmploye.Context;
import StrategyClassification.CommissionClassification;
import StrategyClassification.HourlyClassification;

import StrategyClassification.PayementClassification;
import StrategyClassification.TimeCard;
import heh.be.global.Employe;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static junit.framework.TestCase.*;


public class TestAddTimeCard {

    private  Employe employe;
    @Before
    public void setup() throws Exception {
        TestSetup.setupContext();
        AddHourlyEmploye employe = new AddHourlyEmploye(3,"fabrizio","rue du paradis",20);
        employe.execute();


    }

    @Test
    public void testAddTimeCard(){
        Calendar date = new GregorianCalendar(2019,10,1);

        AddTimeCard addTimeCard = new AddTimeCard(20,date,3);

        addTimeCard.execute();
        Employe e = Context.employeGateway.getEmploye(3);
        assertNotNull(e);
        PayementClassification classification = e.getPayClassfication();

       TimeCard card = ((HourlyClassification)classification).getListTimeCard().get(date);

        assertEquals(20,card.getHours(),0.01);

    }



}
