package fi.gosu.ika.ennatys.service;

import fi.gosu.ika.ennatys.domain.Category;
import fi.gosu.ika.ennatys.domain.Record;
import fi.gosu.ika.ennatys.exception.GeneralException;
import fi.gosu.ika.ennatys.repository.CategoryRepository;
import fi.gosu.ika.ennatys.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class RecordService {

    @Autowired private CategoryRepository categoryRepository;
    @Autowired private RecordRepository recordRepository;

    @PostConstruct
    public void init() {
        if (categoryRepository.count() == 0) {
            categoryRepository.save(new Category("Rakennukset"));
            categoryRepository.save(new Category("Tutkimukset"));
        }
        if (recordRepository.count() == 0) {

            Category builds = categoryRepository.findOne(1L);
            Record record = new Record();
            record.setCategory(builds);
            record.setName("Kaupungintalo");
            recordRepository.save(record);
            record = new Record();
            record.setCategory(builds);
            record.setName("Akatemia");
            recordRepository.save(record);

            Category scienst = categoryRepository.findOne(2L);
            record = new Record();
            record.setCategory(scienst);
            record.setName("Merenkulku");
            recordRepository.save(record);
            record = new Record();
            record.setCategory(scienst);
            record.setName("Talous");
            recordRepository.save(record);
            record = new Record();
            record.setCategory(scienst);
            record.setName("Tiede");
            recordRepository.save(record);
            record = new Record();
            record.setCategory(scienst);
            record.setName("Sodankäynti");
            recordRepository.save(record);
            record = new Record();
            record.setCategory(scienst);
            record.setName("Tiedemiehet");
            recordRepository.save(record);
            record = new Record();
            record.setCategory(scienst);
            record.setName("Tutkimuspisteet tunnissa");
            recordRepository.save(record);
        }
    }

    public void update(Record record) throws GeneralException {
        if (record.getTmpId() == null) throw new GeneralException("Id puuttuu!");
        if (record.getUser() == null || record.getUser().isEmpty()) throw new GeneralException("Ennätys tarvitsee haltijan!");
        if (record.getDate() == null) throw new GeneralException("Päivä puuttuu!");
        if (record.getDate().before(new Date(1488400000000L))) throw new GeneralException("Ennätys ei voi sijoittua ennen serverin alkamispäivää!");
        if (record.getEvidence() == null || record.getEvidence().isEmpty()) throw new GeneralException("Todiste puuttuu!");
        Record oldRecord = recordRepository.findOne(record.getTmpId());
        if (oldRecord == null) throw new GeneralException("Päivitystä ei löytynyt!");
        oldRecord.setValue(record.getValue());
        oldRecord.setUser(record.getUser());
        oldRecord.setDate(record.getDate());
        oldRecord.setEvidence(record.getEvidence());
        recordRepository.save(oldRecord);
    }
}