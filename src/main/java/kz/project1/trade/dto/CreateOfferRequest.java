package kz.project1.trade.dto;

import lombok.Data;

@Data
public class CreateOfferRequest {
    private String title;
    private String description;
    private Double price;
    private Long userId;
    private CreateItemRequest item;
}
