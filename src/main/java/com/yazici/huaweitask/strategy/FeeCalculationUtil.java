package com.yazici.huaweitask.strategy;

import com.yazici.huaweitask.constant.PriceListError;
import com.yazici.huaweitask.entity.Park;
import com.yazici.huaweitask.entity.PriceList;
import com.yazici.huaweitask.entity.enums.VehicleType;
import com.yazici.huaweitask.exception.PriceListException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public final class FeeCalculationUtil {

    private static final Map<VehicleType, FeeCalculationStrategy> STRATEGY_MAP =
            Map.of(
                    VehicleType.SEDAN, new SedanFeeCalculator(),
                    VehicleType.SUV, new SuvFeeCalculator(),
                    VehicleType.MINIVAN, new MinivanFeeCalculator()
                    );

    private FeeCalculationUtil()
    {
    }


    public static double calculate(List<PriceList> priceIntervalLists, Park park) {
        var spentTime = Duration.between(park.getCheckInDate(), park.getCheckInDate()).toHours();
        var price = priceIntervalLists.stream()
                .filter(list -> list.getStartHour() <= spentTime && spentTime < list.getEndHour())
                .mapToLong(PriceList::getPrice)
                .findFirst()
                .orElseThrow(() -> new PriceListException(PriceListError.INVALID_HOUR_RANGE));

        return STRATEGY_MAP.get(park.getVehicle().getType())
                .calculate(price);
    }
}
