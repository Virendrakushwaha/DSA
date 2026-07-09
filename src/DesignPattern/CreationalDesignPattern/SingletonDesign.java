package DesignPattern.CreationalDesignPattern;

class Singleton {
    private static volatile Singleton obj;

    private Singleton() {

    }

    public static Singleton getObj() {
        if (obj == null) {
            synchronized (Singleton.class) {
                if (obj == null)
                    obj = new Singleton();
                return obj;
            }
        }

        return obj;
    }
}

class SingletonPugh {

    private SingletonPugh() {

    }

    static class SingletonInstantiateHandler{
        private static SingletonPugh objIntializing = new SingletonPugh();
    }

    public static SingletonPugh getObj() {
        return SingletonInstantiateHandler.objIntializing;
    }
}

    public class SingletonDesign {
        static void main() {

            Runnable r = () -> {
                System.out.println(SingletonPugh.getObj());
            };

            for (int i = 0; i < 1000; i++) {
                new Thread(r).start();

            }

        }


    }

