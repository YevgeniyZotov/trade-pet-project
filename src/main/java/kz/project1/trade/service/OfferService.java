package kz.project1.trade.service;

import kz.project1.trade.dto.CreateOfferRequest;
import kz.project1.trade.dto.OfferDto;
import kz.project1.trade.model.Offer;

import java.util.List;

public interface OfferService {
    List<Offer> getAllOffers();
    OfferDto getOfferById(Long id);
    OfferDto createOffer(CreateOfferRequest request);
    OfferDto archiveOffer(Long id);
}
