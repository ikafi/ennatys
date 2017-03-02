package fi.gosu.ika.ennatys.repository;

import fi.gosu.ika.ennatys.domain.HistoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Aikain on 2.3.2017.
 */
public interface HistoryRecordRepository extends JpaRepository<HistoryRecord, Long> {
}
