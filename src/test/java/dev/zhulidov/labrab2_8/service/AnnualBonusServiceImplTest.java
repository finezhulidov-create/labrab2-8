package dev.zhulidov.labrab2_8.service;

import dev.zhulidov.labrab2_8.model.Positions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnnualBonusServiceImplTest {

    @Test
    void calculate() {
        AnnualBonusService service = new AnnualBonusServiceImpl();
        Positions pos = Positions.HR;
        double bonus = 2.0;
        int workdays = 245;
        double salary = 100000.00;
        int year = 2025;
        double expected = 360493.8271604938;

        double result = service.calculate(pos,salary,bonus,workdays,year);

        assertEquals(expected,result);
    }

    @Test
    void calculateQuartalBonus() {
        AnnualBonusServiceImpl service = new AnnualBonusServiceImpl();
        Positions pos = Positions.PO;
        double bonus = 2.0;
        int workdays = 245;
        double salary = 100000.00;


        double result = service.calculateQuartalBonus(pos,salary,bonus, workdays);

        assertEquals(205714.2857142857,result);
    }
}