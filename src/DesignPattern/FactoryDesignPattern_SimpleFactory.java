package DesignPattern;

interface Notification{
    void sendNotification(String msg);
}

class SmsNotification implements Notification{

    @Override
    public void sendNotification(String msg) {
        System.out.println("Sms notification sent"+msg);
    }
}

class PushNotification implements Notification{

    @Override
    public void sendNotification(String msg) {
        System.out.println("Push Notification sent"+msg);
    }
}

class WhatsAppNotification implements Notification{

    @Override
    public void sendNotification(String msg) {
        System.out.println("WhatsApp notification sent"+msg);
    }
}
//open-close principle fails here
class NotificationFactory{
    String type ;
    NotificationFactory(String type){
        this.type = type;
    }

    Notification createNotification(){
        if(type.equals("SMS"))
            return new SmsNotification();
        else if (type.equals("PUSH"))
            return new PushNotification();
        else
            return new WhatsAppNotification();
    }
}

public class FactoryDesignPattern_SimpleFactory {

    static void main() {

        NotificationFactory notificationFactory = new NotificationFactory("PUSH");
        notificationFactory.createNotification().sendNotification("hello factory design");
    }
}
