package kz.project1.trade.repository;

import kz.project1.trade.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OfferRepository extends JpaRepository<Offer, Long> {
}
