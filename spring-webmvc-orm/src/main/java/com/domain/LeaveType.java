package com.domain;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name = "leaveType")
public class LeaveType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "category")
    private String category;

    @NotNull
    @Column(name = "totalDays")
    private int totalDays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }
}
