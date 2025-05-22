package kz.project1.trade.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfferFilterRequest {
    private String type;
    private Double floatMin;
    private Double floatMax;
    private Double priceMin;
    private Double priceMax;
}
