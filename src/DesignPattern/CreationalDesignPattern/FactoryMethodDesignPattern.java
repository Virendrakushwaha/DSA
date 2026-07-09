package DesignPattern.CreationalDesignPattern;

/*
Advantages:
        ✔ No if-else
        ✔ Follows Open–Closed Principle
✔ Easy to extend
✔ Clean LLD


Add new notification?
Create new class + new Factory
Client untouched
*/


interface Notification_H{
    void send();
}

class SmsNotification_H implements Notification_H{

    @Override
    public void send() {
        System.out.println("Sms notification sent");
    }
}

class PushNotification_H implements Notification_H{

    @Override
    public void send() {
        System.out.println("Push Notification sent");
    }
}

class WhatsAppNotification_H implements Notification_H{

    @Override
    public void send() {
        System.out.println("WhatsApp notification sent");
    }
}

interface NotificationFactory_H {
    Notification_H createNotification();
}

class SMSNotificationFactory implements NotificationFactory_H{
    @Override
    public Notification_H createNotification() {
        return new SmsNotification_H();
    }
}

class PushNotificationFactory implements NotificationFactory_H{
    @Override
    public Notification_H createNotification() {
        return new PushNotification_H();
    }
}

class WhatsAppNotificationFactory implements NotificationFactory_H{
    @Override
    public Notification_H createNotification() {
        return new WhatsAppNotification_H();
    }
}

public class FactoryMethodDesignPattern {
    static void main() {
        NotificationFactory_H factory = new SMSNotificationFactory();
        factory.createNotification().send();
    }
}
