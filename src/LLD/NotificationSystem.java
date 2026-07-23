package LLD;

//Entities
//1.Notification
//2.NotificationService
//3.NotificationServiceRepository
//4.NotificationChannel .  - enum
//5.NotificationFactory

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


class Notification{
    String message;

    public Notification(String message, String recipient) {
        this.message = message;
        this.recipient = recipient;
    }

    public Notification(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }



    String recipient;
}

enum NotificationType{
    SMS("SMS"),PUSH("Push"),WHATSAPP("WhatsApp");

    private final String value;

    NotificationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

interface NotificationChannel{
    void SendNotification(Notification notification);
}

class SMSNotification implements NotificationChannel{

    @Override
    public void SendNotification(Notification notification) {
        System.out.println("SMS notification sent");
    }
}

class PushNotification implements NotificationChannel{

    @Override
    public void SendNotification(Notification notification) {
        System.out.println("Push notification sent");
    }
}

class WhatsappNotification implements NotificationChannel{

    @Override
    public void SendNotification(Notification notification) {
        System.out.println("Whatsapp notification sent");
    }
}


class NotificationServiceRepository{
    Map<String,List<NotificationType>> userPreferenceMap;
        NotificationServiceRepository(){
            userPreferenceMap = new HashMap<>();
            userPreferenceMap.put("8237483483",List.of(NotificationType.PUSH,NotificationType.SMS));
            userPreferenceMap.put("8237483484",List.of(NotificationType.WHATSAPP));
            userPreferenceMap.put("8237483485",List.of(NotificationType.SMS));
            userPreferenceMap.put("8237483486",List.of(NotificationType.PUSH,NotificationType.WHATSAPP));
        }
    List<NotificationType> getUserPreference(String recipient){
        return userPreferenceMap.get(recipient);
    }
}

 class NotificationService{
    ExecutorService executorService;
    NotificationFactory notificationFactory;
    NotificationServiceRepository notificationServiceRepository;
    NotificationService(){
        executorService = Executors.newFixedThreadPool(10);
        notificationFactory = new NotificationFactory();
        notificationServiceRepository = new NotificationServiceRepository();
    }


    void send(Notification notification) {
        List<NotificationType> userPref = notificationServiceRepository.getUserPreference(notification.getRecipient());
        List<NotificationChannel> notificationChannels = new ArrayList<>();
        for(NotificationType type: userPref){
            notificationChannels.add(notificationFactory.getInstance(type));
        }

        for (NotificationChannel channel : notificationChannels) {
            executorService.submit(() -> {
                channel.SendNotification(notification);
            });
        }

        executorService.shutdown();
    }

}



class NotificationFactory{
    HashMap<NotificationType,NotificationChannel> registry;

    NotificationFactory(){
        registry = new HashMap<>();
        registry.put(NotificationType.SMS,new SMSNotification());
        registry.put(NotificationType.WHATSAPP,new WhatsappNotification());
        registry.put(NotificationType.PUSH,new PushNotification());
    }

    NotificationChannel getInstance(NotificationType type) {
        return registry.get(type);
    }

}

public class NotificationSystem {


    static void main() {
        NotificationService notificationService = new NotificationService();
        notificationService.send(new Notification("message","8237483486"));
    }
}
