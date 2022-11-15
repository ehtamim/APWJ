package com.domain;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name = "leaveApplication")
public class LeaveApplication {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="fromDate")
    private  LocalDate fromDate;

    @NotNull
    @Column(name="toDate")
    private  LocalDate toDate;

    @NotNull
    @Column(name = "totalDays")
    private int totalDays;

    @NotNull
    @Column(name = "reason")
    private String reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
