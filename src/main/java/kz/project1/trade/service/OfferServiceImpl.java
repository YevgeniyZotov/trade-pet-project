package kz.project1.trade.service;

import kz.project1.trade.dto.CreateOfferRequest;
import kz.project1.trade.dto.OfferDto;
import kz.project1.trade.exception.OfferNotFoundException;
import kz.project1.trade.mapper.OfferMapper;
import kz.project1.trade.model.Offer;
import kz.project1.trade.model.User;
import kz.project1.trade.model.enums.OfferStatus;
import kz.project1.trade.repository.OfferRepository;
import kz.project1.trade.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;

    @Override
    public List<OfferDto> getAllOffers() {
        return offerRepository.findAll().stream()
                .map(OfferMapper::toDto)
                .toList();
    }

    @Override
    public OfferDto getOfferById(Long id) {
        Offer offer = offerRepository.findById(id)
                .orElseThrow(() -> new OfferNotFoundException("Заказ с таким ID: " + id + "не найден"));
        return OfferMapper.toDto(offer);
    }

    @Override
    public OfferDto createOffer(CreateOfferRequest request) {
        User owner = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new OfferNotFoundException("Пользователь с таким ID: " + request.getUserId() + " не найден"));

        Offer offer = OfferMapper.fromCreateRequest(request, owner);
        return OfferMapper.toDto(offerRepository.save(offer));
    }

    @Override
    public OfferDto archiveOffer(Long id) {
        Offer offer = offerRepository.findById(id)
                .orElseThrow(() -> new OfferNotFoundException("Заказ с таким ID: " + id + "не найден"));

        offer.setStatus(OfferStatus.ARCHIVED);
        return OfferMapper.toDto(offerRepository.save(offer));
    }

    @Override
    public List<OfferDto> getActiveOffers() {
        return offerRepository.findAllByStatus(OfferStatus.ACTIVE).stream()
                .map(OfferMapper::toDto)
                .toList();
    }
}
