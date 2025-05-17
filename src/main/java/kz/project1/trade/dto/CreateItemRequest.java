package kz.project1.trade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemRequest {
    private String name;
    private String type;
    private String exterior;
    private Double floatValue;
    private String imageUrl;
}
