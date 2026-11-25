package saiedemo;

public class IDGenerator {
    private static int id = 0;
    private static final IDGenerator idg = new IDGenerator();

    private IDGenerator() {
    } // private, ei siis voi käyttää luokan ulkopuolelta

    public static IDGenerator getIDGenerator() { // tällä pyydetään viittaus ainokaiseen
        return idg;
    }

    public int nextID() {
        return ++id;
    }

    public int getLastId() {
        return id;
    }

    public static void main(String[] args) {
        Runnable run = () -> System.out.println("Käynnistetty säie: " + Thread.currentThread().getName());
        System.out.println("Pääsäie: " + Thread.currentThread().getName());
        Thread t = new Thread(run);
        t.start();
        for (int i = 0; i < 5; i++) {
            new Thread(run).start();
        }
    }
}
