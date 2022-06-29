package com.yazici.huaweitask.validation;

import com.yazici.huaweitask.entity.PriceList;
import com.yazici.huaweitask.exception.PriceListException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.yazici.huaweitask.constant.PriceListError.INVALID_HOUR_COVERAGE;
import static com.yazici.huaweitask.constant.PriceListError.INVALID_START_END_HOUR;

@Component
@RequiredArgsConstructor
public class PriceListValidator {

  private static final Set<Integer> HOURS =
      IntStream.rangeClosed(0, 24).boxed().collect(Collectors.toSet());

  public void validate(Collection<PriceList> priceLists) {
    validateStartEndHour(priceLists);
    validateHourCoverage(priceLists);
  }

  private void validateStartEndHour(Collection<PriceList> priceLists) {
    priceLists.stream()
        .filter(list -> list.getStartHour() >= list.getEndHour())
        .findAny()
        .ifPresent(
            list -> {
              throw new PriceListException(INVALID_START_END_HOUR);
            });
  }

  private void validateHourCoverage(Collection<PriceList> priceLists) {
    var coveredHours =
        priceLists.parallelStream()
            .flatMap(
                priceList ->
                    IntStream.rangeClosed(priceList.getStartHour(), priceList.getEndHour()).boxed())
            .collect(Collectors.toSet());

    if (!HOURS.equals(coveredHours)) {
      throw new PriceListException(INVALID_HOUR_COVERAGE);
    }
  }
}
