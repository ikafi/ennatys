package fi.gosu.ika.ennatys.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aikain on 1.3.2017.
 */
@Entity
public class Category extends AbstractPersistable<Long> {
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Record> records;

    public Category() {
        this.records = new ArrayList<>();
    }

    public Category(String name) {
        this.name = name;
        this.records = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}
