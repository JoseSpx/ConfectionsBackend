package com.josespx.confections.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    public interface Basic {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(Order.Basic.class)
    private Long id;

    @Column(name = "date_deal")
    @JsonView(Order.Basic.class)
    private LocalDate dateDeal;

    @Column(name = "date_trial")
    @JsonView(Order.Basic.class)
    private LocalDate dateTrial;

    @Column(name = "date_delivery")
    @JsonView(Order.Basic.class)
    private LocalDate dateDelivery;

    @Column(name = "time_deal")
    @JsonView(Order.Basic.class)
    private LocalTime timeDial;

    @Column(name = "time_trial")
    @JsonView(Order.Basic.class)
    private LocalTime timeTrial;

    @Column(name = "time_delivery")
    @JsonView(Order.Basic.class)
    private LocalTime timeDelivery;

    @Column(name = "comment")
    @JsonView(Order.Basic.class)
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_id")
    @JsonView(Order.Basic.class)
    private Client client;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
