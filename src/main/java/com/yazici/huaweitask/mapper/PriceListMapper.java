package com.yazici.huaweitask.mapper;

import com.yazici.huaweitask.dto.request.PriceListCreateRequest;
import com.yazici.huaweitask.dto.response.PriceListCreateResponse;
import com.yazici.huaweitask.dto.response.PriceListQueryResponse;
import com.yazici.huaweitask.entity.PriceList;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceListMapper {

  PriceList map(PriceListCreateRequest priceListCreateRequest);

  List<PriceList> map(List<PriceListCreateRequest> priceListCreateRequests);

  PriceListCreateResponse mapToCreateResponse(PriceList priceList);

  PriceListQueryResponse mapToQueryResponse(PriceList priceList);
}
