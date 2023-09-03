package org.kafkaconfluent.consumer.database;

import org.kafkaconfluent.consumer.database.entity.WikimediaData;
import org.kafkaconfluent.consumer.database.repository.WikimediadataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	private WikimediadataRepository dataRepository;
	
	public KafkaDatabaseConsumer(WikimediadataRepository dataRepository) {
		super();
		this.dataRepository = dataRepository;
	}

	@KafkaListener(topics="wikimedia_recentchange",groupId = "myGroup")
	public void consume(String eventMessage) {
		LOGGER.info(String.format("Message Recieved -> %s",eventMessage));
		WikimediaData wikimediaData=new WikimediaData();
		wikimediaData.setWikiEventData(eventMessage);
		dataRepository.save(wikimediaData);
	}
}
