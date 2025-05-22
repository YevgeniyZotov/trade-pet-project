package kz.project1.trade.dto;

import kz.project1.trade.model.enums.ItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {
    private Long id;
    private String name;
    private ItemType type;
    private String exterior;
    private Double floatValue;
//    private String imageUrl;
}
