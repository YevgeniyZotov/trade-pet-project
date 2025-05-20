package kz.project1.trade.mapper;

import kz.project1.trade.dto.CreateOfferRequest;
import kz.project1.trade.dto.OfferDto;
import kz.project1.trade.model.Item;
import kz.project1.trade.model.Offer;
import kz.project1.trade.model.User;
import kz.project1.trade.model.enums.OfferStatus;

public class OfferMapper {
    public static OfferDto toDto(Offer offer) {
        if (offer == null) return null;

        OfferDto.OfferDtoBuilder builder = OfferDto.builder()
                .id(offer.getId())
                .price(offer.getPrice())
                .status(offer.getStatus())
                .createdAt(offer.getCreatedAt())
                .owner(UserMapper.toDto(offer.getUser()));

        if (offer.getItem() != null) {
            builder.item(ItemMapper.toDto(offer.getItem()));
        }
        return builder.build();
    }

    public static Offer fromCreateRequest(CreateOfferRequest request, User user) {
        Item item = Item.builder()
                .name(request.getItem().getName())
                .type(request.getItem().getType())
                .exterior(request.getItem().getExterior())
                .floatValue(request.getItem().getFloatValue())
//                .imageUrl(request.getItem().getImageUrl())
                .build();

        Offer offer = Offer.builder()
                .price(request.getPrice())
                .status(OfferStatus.ACTIVE)
                .user(user)
                .item(item)
                .build();

        return offer;
    }
}
