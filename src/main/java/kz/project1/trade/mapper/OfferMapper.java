package kz.project1.trade.mapper;

import kz.project1.trade.dto.CreateOfferRequest;
import kz.project1.trade.dto.OfferDto;
import kz.project1.trade.model.Offer;
import kz.project1.trade.model.User;
import kz.project1.trade.model.enums.OfferStatus;

public class OfferMapper {
    public static OfferDto toDto(Offer offer) {
        OfferDto dto = new OfferDto();
        dto.setId(offer.getId());
        dto.setTitle(offer.getTitle());
        dto.setDescription(offer.getDescription());
        dto.setPrice(offer.getPrice());
        dto.setStatus(offer.getStatus());
        dto.setOwner(UserMapper.toDto(offer.getUser()));
        return dto;
    }

    public static Offer fromCreateRequest(CreateOfferRequest request, User user) {
        Offer offer = new Offer();
        offer.setTitle(request.getTitle());
        offer.setDescription(request.getDescription());
        offer.setPrice(request.getPrice());
        offer.setUser(user);
        offer.setStatus(OfferStatus.ACTIVE);
        return offer;
    }
}
