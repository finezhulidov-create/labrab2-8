package dev.zhulidov.labrab2_8.service;

import dev.zhulidov.labrab2_8.model.Positions;

public interface AnnualBonusService {
    Double calculate(Positions positions, double salary, double bonus, int workDays, int year);
}
