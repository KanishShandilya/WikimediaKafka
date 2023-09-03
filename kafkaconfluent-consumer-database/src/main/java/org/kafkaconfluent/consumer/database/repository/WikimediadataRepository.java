package org.kafkaconfluent.consumer.database.repository;

import org.kafkaconfluent.consumer.database.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediadataRepository extends JpaRepository<WikimediaData, Long>{

}
