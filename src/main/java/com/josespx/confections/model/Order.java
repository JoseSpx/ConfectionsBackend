package com.josespx.confections.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_deal")
    private LocalDate dateDeal;

    @Column(name = "date_trial")
    private LocalDate dateTrial;

    @Column(name = "date_delivery")
    private LocalDate dateDelivery;

    @Column(name = "time_deal")
    private LocalTime timeDial;

    @Column(name = "time_trial")
    private LocalTime timeTrial;

    @Column(name = "time_delivery")
    private LocalTime timeDelivery;

    @Column(name = "comment")
    private String comment;

    @ManyToMany(mappedBy = "orderSet")
    private Set<Measure> measureSet = new HashSet<>();

    public Order(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateDeal() {
        return dateDeal;
    }

    public void setDateDeal(LocalDate dateDeal) {
        this.dateDeal = dateDeal;
    }

    public LocalDate getDateTrial() {
        return dateTrial;
    }

    public void setDateTrial(LocalDate dateTrial) {
        this.dateTrial = dateTrial;
    }

    public LocalDate getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(LocalDate dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public LocalTime getTimeDial() {
        return timeDial;
    }

    public void setTimeDial(LocalTime timeDial) {
        this.timeDial = timeDial;
    }

    public LocalTime getTimeTrial() {
        return timeTrial;
    }

    public void setTimeTrial(LocalTime timeTrial) {
        this.timeTrial = timeTrial;
    }

    public LocalTime getTimeDelivery() {
        return timeDelivery;
    }

    public void setTimeDelivery(LocalTime timeDelivery) {
        this.timeDelivery = timeDelivery;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<Measure> getMeasureSet() {
        return measureSet;
    }

    public void setMeasureSet(Set<Measure> measureSet) {
        this.measureSet = measureSet;
    }
}
