package kz.project1.trade.dto;

import kz.project1.trade.model.enums.OfferStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto {
    private Long id;
    private Double price;
    private LocalDateTime createdAt;
    private OfferStatus status;
    private UserDto owner;
    private ItemDto item;
}
