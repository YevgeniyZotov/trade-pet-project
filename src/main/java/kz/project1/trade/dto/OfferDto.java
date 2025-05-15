package kz.project1.trade.dto;

import kz.project1.trade.model.enums.OfferStatus;
import lombok.Data;

@Data
public class OfferDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private OfferStatus status;
    private UserDto owner;
}
