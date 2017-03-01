package fi.gosu.ika.ennatys.repository;

import fi.gosu.ika.ennatys.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Aikain on 1.3.2017.
 */
public interface RecordRepository extends JpaRepository<Record, Long> {
}
