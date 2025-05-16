package kz.project1.trade.mapper;

import kz.project1.trade.dto.CreateOfferRequest;
import kz.project1.trade.dto.OfferDto;
import kz.project1.trade.model.Offer;
import kz.project1.trade.model.User;
import kz.project1.trade.model.enums.OfferStatus;

public class OfferMapper {
    public static OfferDto toDto(Offer offer) {
        return OfferDto.builder()
                .id(offer.getId())
                .title(offer.getTitle())
                .description(offer.getDescription())
                .price(offer.getPrice())
                .status(offer.getStatus())
                .owner(UserMapper.toDto(offer.getUser()))
                .createdAt(offer.getCreatedAt())
                .build();
    }

    public static Offer fromCreateRequest(CreateOfferRequest request, User user) {
        return Offer.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .status(OfferStatus.ACTIVE)
                .user(user)
                .build();
    }
}
