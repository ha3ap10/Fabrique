package ru.fabrique.pollingsystem.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Survey {

    private long id;
    private String name;
    private final Date dateStart;
    private Date dateEnd;
    private String description;
    private List<Question> questions;
    private transient boolean removed;

    public Survey(long id,
                  String name,
                  Date dateStart,
                  Date dateEnd,
                  String description,
                  List<Question> questions) {
        this.id = id;
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.description = description;
        this.questions = questions;
        this.removed = false;
    }
}
