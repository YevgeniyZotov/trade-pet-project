package kz.project1.trade.service;

import kz.project1.trade.dto.CreateOfferRequest;
import kz.project1.trade.dto.OfferDto;
import kz.project1.trade.dto.OfferFilterRequest;
import kz.project1.trade.exception.ItemTypeNotFoundException;
import kz.project1.trade.exception.OfferNotFoundException;
import kz.project1.trade.mapper.ItemMapper;
import kz.project1.trade.mapper.OfferMapper;
import kz.project1.trade.model.Item;
import kz.project1.trade.model.Offer;
import kz.project1.trade.model.User;
import kz.project1.trade.model.enums.OfferStatus;
import kz.project1.trade.repository.ItemRepository;
import kz.project1.trade.repository.OfferRepository;
import kz.project1.trade.repository.UserRepository;
import kz.project1.trade.service.filter.OfferFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final OfferFilter offerFilter;

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

        ///  Создание предмета по ID или объекту
/*        Item item;
        if (request.getItemId() != null) {
            item = itemRepository.findById(request.getItemId())
                    .orElseThrow(() -> new ItemTypeNotFoundException("Предмет с таким ID: " + request.getItemId() + " не найден"));
        } else if (request.getItem() != null) {
            item = itemRepository.save(ItemMapper.fromDto(request.getItem()));
        } else {
            throw new ItemTypeNotFoundException("Нужно указать либо itemId, либо item объект");
        }*/

        Item item = itemRepository.findById(request.getItemId())
                .orElseThrow(() -> new ItemTypeNotFoundException("Предмет с таким ID: " + request.getItemId() + " не найден"));
        Offer offer = OfferMapper.fromCreateRequest(request, owner, item);
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

    @Override
    public List<OfferDto> getOffersByUserId(Long userId) {
        return offerRepository.findAllByUserId(userId).stream()
                .map(OfferMapper::toDto)
                .toList();
    }

    @Override
    public List<OfferDto> getOffers(OfferFilterRequest request) {
        List<Offer> offers = offerRepository.findAllByStatus(OfferStatus.ACTIVE);

        offers = offerFilter.filterByType(offers, request.getType());
        offers = offerFilter.filterByFloat(offers, request.getFloatMin(), request.getFloatMax());
        offers = offerFilter.filterByPrice(offers, request.getPriceMin(), request.getPriceMax());

        return offers.stream()
                .map(OfferMapper::toDto)
                .toList();
    }
}
