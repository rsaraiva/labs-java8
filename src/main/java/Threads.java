

public class Threads {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    //try { Thread.sleep(1000L); } catch (InterruptedException e) { }
                    System.out.println("1 " + System.currentTimeMillis());
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                //try { Thread.sleep(1000L); } catch (InterruptedException e) { }
                System.out.println("2 " + System.currentTimeMillis());
            }
        }).start();

        System.out.println("TH MAIN");
    }
}
