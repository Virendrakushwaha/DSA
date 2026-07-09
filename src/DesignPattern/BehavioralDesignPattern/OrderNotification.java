package DesignPattern.BehavioralDesignPattern;

/*
Goal
Users should get updates when order status changes.

Requirements
Order states:
PLACED
PREPARING
OUT_FOR_DELIVERY
DELIVERED

Multiple observers:
User App
Restaurant Dashboard
Delivery Partner App
*/

import java.util.ArrayList;
import java.util.List;

interface Observer{
    void notifyOrderStatus(String orderId,STATUS status);
}

class UserApp implements Observer{

    @Override
    public void notifyOrderStatus(String orderId,STATUS status) {
        System.out.println("order status:"+status+" with orderId:"+orderId);
    }
}

class RestaurantDashBoard implements Observer{

    @Override
    public void notifyOrderStatus(String orderId,STATUS status) {
        System.out.println("order status:"+status+" with orderId:"+orderId);
    }
}

class DeliverPartnerApp implements Observer{

    @Override
    public void notifyOrderStatus(String orderId,STATUS status) {
        System.out.println("order status:"+status+" with orderId:"+orderId);
    }
}

interface Subject{
    void subscribe(Observer o);
    void unsubscribe(Observer o);
    void notifyAllObservers(String orderId,STATUS status);

}

enum STATUS{PLACED,PREPARING,OUT_FOR_DELIVERY,DELIVERED}

 class Order implements Subject{
    String orderId = String.valueOf(orderId());
    double orderId(){
        return Math.random();
    }

    void orderPlaced(){
        notifyAllObservers(orderId,STATUS.PLACED);
    }

     void orderPreparing(){
         notifyAllObservers(String.valueOf(orderId()),STATUS.PREPARING);
     }

     void orderOutOfDelivery(){
         notifyAllObservers(String.valueOf(orderId()),STATUS.OUT_FOR_DELIVERY);
     }

     void orderDelivered(){
         notifyAllObservers(String.valueOf(orderId()),STATUS.DELIVERED);
     }

    List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer o) {
        observers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        observers.remove(o);
    }

    public void notifyAllObservers(String orderId,STATUS status) {
        for (Observer observer : observers) {
            observer.notifyOrderStatus(orderId,status);
        }
    }
}

public class OrderNotification {
    static void main() {
    Order order = new Order();
    order.subscribe(new UserApp());
    order.subscribe(new DeliverPartnerApp());

    order.orderPlaced();
    order.orderPreparing();
    order.orderOutOfDelivery();
    order.orderDelivered();
    }
}
