package kz.project1.trade.repository;

import kz.project1.trade.model.Offer;
import kz.project1.trade.model.enums.ItemType;
import kz.project1.trade.model.enums.OfferStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findAllByStatus(OfferStatus active);
    List<Offer> findAllByUserId(Long userId);
    List<Offer> findAllByItemTypeAndStatus(ItemType type, OfferStatus status);
}
