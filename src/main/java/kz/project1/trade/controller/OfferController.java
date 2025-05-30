package kz.project1.trade.controller;

import io.swagger.v3.oas.annotations.Parameter;
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
    public List<OfferDto> getOffers(@Parameter(description = "Тип предмета: KNIFE, RIFLE, PISTOL и т.д.")
                                    @RequestParam(required = false) String type,
                                    @Parameter(description = "Минимальное значение по фильтру Float")
                                    @RequestParam(required = false) Double floatMin,
                                    @Parameter(description = "Максимальное значение по фильтру Float")
                                    @RequestParam(required = false) Double floatMax) {
        return offerService.getOffers(type, floatMin, floatMax);
    }

    @PostMapping("/{id}/archive")
    public OfferDto archiveOffer(@PathVariable Long id) {
        return offerService.archiveOffer(id);
    }

    @GetMapping("/{id}")
    public OfferDto getOfferById(@PathVariable Long id) {
        return offerService.getOfferById(id);
    }

    @GetMapping("/active")
    public List<OfferDto> getActiveOffers() {
        return offerService.getActiveOffers();
    }

    @GetMapping("/user/{id}")
    public List<OfferDto> getOffersByUserId(@PathVariable Long id) {
        return offerService.getOffersByUserId(id);
    }
}
