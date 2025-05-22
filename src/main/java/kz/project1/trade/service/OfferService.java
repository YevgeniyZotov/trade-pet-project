package kz.project1.trade.service;

import kz.project1.trade.dto.CreateOfferRequest;
import kz.project1.trade.dto.OfferDto;
import kz.project1.trade.dto.OfferFilterRequest;
import kz.project1.trade.model.enums.ItemType;

import java.util.List;

public interface OfferService {
    List<OfferDto> getAllOffers();
    OfferDto getOfferById(Long id);
    OfferDto createOffer(CreateOfferRequest request);
    OfferDto archiveOffer(Long id);
    List<OfferDto> getActiveOffers();
    List<OfferDto> getOffersByUserId(Long userId);
    List<OfferDto> getOffers(OfferFilterRequest request);
}
