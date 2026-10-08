package dev.zhulidov.labrab2_8.service;

import dev.zhulidov.labrab2_8.model.Positions;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService{
    @Override
    public Double calculate(Positions positions, double salary,
                            double bonus, int workDays, int year) {

        int days = Year.of(year).length();


        return salary * bonus * days * positions.getPositionCoefficient()/ workDays;
    }

    public Double calculateQuartalBonus(Positions positions, double salary,
                                        double bonus, int workDays){
        //премия = зп за 3 мес * %премии
        if (positions.isManager()){
            return (salary*90) * bonus *
                    positions.getPositionCoefficient()/ workDays;
        }
        return 0.0;

    }

}
