package kz.project1.trade.service;

import kz.project1.trade.dto.CreateItemRequest;
import kz.project1.trade.dto.ItemDto;
import kz.project1.trade.mapper.ItemMapper;
import kz.project1.trade.model.Item;
import kz.project1.trade.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements ItemServiceImpl {
    private final ItemRepository itemRepository;

    @Override
    public ItemDto createItem(CreateItemRequest request) {
        Item item = ItemMapper.fromCreateRequest(request);
        return ItemMapper.toDto(itemRepository.save(item));
    }

    @Override
    public List<ItemDto> getAllItems() {
        return itemRepository.findAll().stream()
                .map(ItemMapper::toDto)
                .toList();
    }
}
