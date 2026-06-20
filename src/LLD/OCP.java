package LLD;

interface INotifcation{

   void sendNotification(String message);

}

class SMS implements INotifcation{
     public void sendNotification(String message){
         System.out.println("LLD.SMS"+message);
     }
}

class PushNot implements INotifcation{

    @Override
    public void sendNotification(String message) {

    }
}

class Email implements INotifcation{

    @Override
    public void sendNotification(String message) {

    }
}

class Whatsapp implements INotifcation{

    @Override
    public void sendNotification(String message) {

    }
}


public class OCP {
    OCP(INotifcation iNotifcation,String message){
        if(iNotifcation instanceof SMS)
            iNotifcation.sendNotification(message);
        else if (iNotifcation instanceof Whatsapp) {
            iNotifcation.sendNotification(message);

        }
    }
}