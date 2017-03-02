package fi.gosu.ika.ennatys.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Aikain on 2.3.2017.
 */
@Entity
public class HistoryRecord extends AbstractPersistable<Long> {
    private String value;
    private String user;
    private String evidence;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd.MM.yyyy")
    private Date date;
    @ManyToOne
    @JoinColumn(name="Record_ID")
    private Record record;

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

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
