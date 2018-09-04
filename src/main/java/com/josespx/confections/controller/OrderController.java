package com.josespx.confections.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.josespx.confections.model.Client;
import com.josespx.confections.model.Order;
import com.josespx.confections.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class OrderController {

    private OrderService orderService;
    // private ClientService clientService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
        // this.clientService = clientService;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        this.orderService.save(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    interface OrderDetailFull extends Order.Basic , Client.Basic {}

    @JsonView(OrderDetailFull.class)
    @RequestMapping(value = "/orders", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orderList = this.orderService.findAll();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @JsonView(Order.Basic.class)
    @RequestMapping(value = "/orders/client/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Order>> findAllByClientId(@PathVariable("id") Long id) {
        List<Order> orderList = this.orderService.findAllByClientId(id);
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @JsonView(Order.Basic.class)
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Order> findOrderById(@PathVariable("id") Long id) {
        Order order = this.orderService.findById(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        Order orderToUpdate = this.orderService.findById(id);
        if (orderToUpdate == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //order.getClient().setEliminated("0");

        orderToUpdate.setDateDeal(order.getDateDeal());
        orderToUpdate.setDateDelivery(order.getDateDelivery());
        orderToUpdate.setDateTrial(order.getDateTrial());
        orderToUpdate.setComment(order.getComment());

        this.orderService.save(orderToUpdate);
        return new ResponseEntity<>(orderToUpdate, HttpStatus.OK);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE, headers = "Accept=aplication/json")
    public ResponseEntity<Order> deleteOrder(@PathVariable("id") Long id) {
        this.orderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostConstruct()
    public void init() {
        /*Client client = this.clientService.findById(1L);
        Order order = new Order();
        order.setClient(client);
        order.setComment("Un pedido");
        order.setDateDeal(LocalDate.now());
        order.setDateDelivery(LocalDate.now());
        order.setDateTrial(LocalDate.now());

        this.orderService.save(order);
*/
    }


}
