package com.domain;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Department {

    private Long id;

    @NotNull
    private String name;

    private LocalDate createdOn;

    public Department() {
    }

    public Department(long i, String n, String s) {
        this.id=i;
        this.name=n;
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        final LocalDate dt = LocalDate.parse(s);
        this.createdOn=dt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }
}
