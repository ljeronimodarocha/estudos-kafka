package org.shop.api.events;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shop.api.model.Shop;
import org.shop.api.model.dto.ShopDTO;
import org.shop.api.repository.ShopRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiveKafkaMessage {
    private final ShopRepository shopRepository;

    private final KafkaTemplate<String, ShopDTO> kafkaTemplate;

    private static final String SHOP_TOPIC
            = "SHOP_TOPIC";

    private static final String SHOP_TOPIC_RETRY
            = "SHOP_TOPIC_RETRY";

    @KafkaListener(
            topics = SHOP_TOPIC,
            groupId = "group")
    public void listenShopEvents(ShopDTO shopDTO) {
        try {
            log.info("Status da compra recebida no tópico: {}."
                    , shopDTO.getIdentifier());
            if (shopDTO.getItems() == null ||
                    shopDTO.getItems().isEmpty()) {
                log.error("Compra sem items");
                throw new Exception();
            }
            Shop shop = shopRepository
                    .findByIdentifier(shopDTO.getIdentifier());
            shop.setStatus(shopDTO.getStatus());
            shopRepository.save(shop);
        } catch (Exception e) {
            log.info("Erro na aplicação");
            kafkaTemplate.send(SHOP_TOPIC_RETRY, shopDTO);
        }
    }
}