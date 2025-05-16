package kz.project1.trade.controller;

import kz.project1.trade.dto.CreateOfferRequest;
import kz.project1.trade.dto.OfferDto;
import kz.project1.trade.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
@RequiredArgsConstructor
public class OfferController {
    private final OfferService offerService;

    @PostMapping
    public OfferDto createOffer(@RequestBody CreateOfferRequest request) {
        return offerService.createOffer(request);
    }

    @GetMapping
    public List<OfferDto> getAllOffers() {
        return offerService.getAllOffers();
    }

    @PostMapping("/{id}/archive")
    public OfferDto archiveOffer(@PathVariable Long id) {
        return offerService.archiveOffer(id);
    }

    @GetMapping("/{id}")
    public OfferDto getOfferById(@PathVariable Long id) {
        return offerService.getOfferById(id);
    }
}
