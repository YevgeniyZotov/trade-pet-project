package kz.project1.trade.mapper;

import kz.project1.trade.dto.CreateItemRequest;
import kz.project1.trade.dto.ItemDto;
import kz.project1.trade.model.Item;

public class ItemMapper {
    public static ItemDto toDto(Item item) {
        return ItemDto.builder()
                .name(item.getName())
                .type(item.getType())
                .exterior(item.getExterior())
                .floatValue(item.getFloatValue())
//                .imageUrl(item.getImageUrl())
                .build();
    }

    public static Item fromCreateRequest(CreateItemRequest request) {
        return Item.builder()
                .name(request.getName())
                .type(request.getType())
                .exterior(request.getExterior())
                .floatValue(request.getFloatValue())
                .build();
    }
}
