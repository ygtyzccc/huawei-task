package com.yazici.huaweitask.service.pricelist;

import com.yazici.huaweitask.dto.request.PriceListCreateRequest;
import com.yazici.huaweitask.entity.ParkingArea;
import com.yazici.huaweitask.entity.PriceList;
import com.yazici.huaweitask.mapper.PriceListMapper;
import com.yazici.huaweitask.repository.PriceListRepository;
import com.yazici.huaweitask.validation.PriceListValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import static com.yazici.huaweitask.utils.StreamUtils.setIfNotNull;

@Service
@RequiredArgsConstructor
public class PriceListService {

  private final PriceListMapper priceListMapper;
  private final PriceListValidator priceListValidator;
  private final PriceListRepository priceListRepository;

  @Transactional(rollbackFor = Exception.class)
  public List<PriceList> create(
      ParkingArea parkingArea, List<PriceListCreateRequest> priceListCreateRequests) {

    var priceLists = priceListMapper.map(priceListCreateRequests);
    priceListValidator.validate(priceLists);
    setParkArea(priceLists, parkingArea);

    return priceListRepository.saveAll(priceLists);
  }

  private void setParkArea(Collection<PriceList> priceLists, ParkingArea parkingArea) {
    for (PriceList priceList : priceLists) {
      setIfNotNull(parkingArea, priceList::setParkingArea);
    }
  }
}
