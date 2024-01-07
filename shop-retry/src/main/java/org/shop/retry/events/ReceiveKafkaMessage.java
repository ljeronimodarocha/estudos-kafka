package org.shop.retry.events;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shop.retry.model.dto.ShopDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiveKafkaMessage {
    private static final String SHOP_TOPIC_RETRY
            = "SHOP_TOPIC_RETRY";

    @KafkaListener(topics = SHOP_TOPIC_RETRY,
            groupId = "group_retry")
    public void listenShopTopicRetry(ShopDTO shopDTO)
            throws Exception {
        log.info("Retentativa de processamento: {}.",
                shopDTO.getIdentifier());
    }
}