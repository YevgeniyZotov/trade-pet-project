package kz.project1.trade.service.filter;

import kz.project1.trade.exception.ItemTypeNotFoundException;
import kz.project1.trade.model.Item;
import kz.project1.trade.model.Offer;
import kz.project1.trade.model.enums.ItemType;
import kz.project1.trade.model.enums.OfferStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OfferFilter {
    public List<Offer> filterByType(List<Offer> offers, String type) {
        if (type == null || type.isBlank()) return offers;

        ItemType itemType;
        try {
            itemType = ItemType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ItemTypeNotFoundException("Неверный тип предмета: " + type);
        }

        return offers.stream()
                .filter(offer -> offer.getItem() != null && itemType.equals(offer.getItem().getType()))
                .toList();
    }

    public List<Offer> filterByFloat(List<Offer> offers, Double floatMin, Double floatMax) {
        return offers.stream()
                .filter(offer -> {
                    Item item = offer.getItem();
                    if (item == null) return false;

                    Double floatValue = offer.getItem().getFloatValue();
                    return (floatMin == null || floatValue >= floatMin) &&
                            (floatMax == null || floatValue <= floatMax);
                })
                .toList();
    }

    public List<Offer> filterByPrice(List<Offer> offers, Double priceMin, Double priceMax) {
        return offers.stream()
                .filter(offer -> {
                    Item item = offer.getItem();
                    if (item == null) return false;

                    Double price = offer.getPrice();
                    return (priceMin == null || price >= priceMin) &&
                            (priceMax == null || price <= priceMax);
                })
                .toList();
    }
}
