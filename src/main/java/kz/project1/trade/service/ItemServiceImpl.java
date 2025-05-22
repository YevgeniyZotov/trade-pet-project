package kz.project1.trade.service;

import kz.project1.trade.dto.CreateItemRequest;
import kz.project1.trade.dto.ItemDto;

import java.util.List;

public interface ItemServiceImpl {
    ItemDto createItem(CreateItemRequest request);
    List<ItemDto> getAllItems();
}
