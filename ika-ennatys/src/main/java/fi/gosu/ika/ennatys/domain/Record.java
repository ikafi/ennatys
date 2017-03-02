package fi.gosu.ika.ennatys.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Aikain on 1.3.2017.
 */
@Entity
public class Record extends AbstractPersistable<Long> {
    private String name;
    private String value;
    private String user;
    private String evidence;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd.MM.yyyy")
    private Date date;
    @ManyToOne
    @JoinColumn(name="Category_ID")
    private Category category;
    @Transient
    private Long tmpId;
    @OneToMany(mappedBy = "record")
    private List<HistoryRecord> history;

    public Record() {
        this.history = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getTmpId() {
        return tmpId;
    }

    public void setTmpId(Long tmpId) {
        this.tmpId = tmpId;
    }

    public List<HistoryRecord> getHistory() {
        return history;
    }

    public void setHistory(List<HistoryRecord> history) {
        this.history = history;
    }
}
