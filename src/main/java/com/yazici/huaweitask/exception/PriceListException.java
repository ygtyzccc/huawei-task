package com.yazici.huaweitask.exception;

import com.yazici.huaweitask.constant.PriceListError;
import lombok.Getter;

@Getter
public class PriceListException extends RuntimeException {

  private final PriceListError priceListError;

  public PriceListException(PriceListError priceListError) {
    super(priceListError.getMessage());
    this.priceListError = priceListError;
  }
}
