package lab3_2;

public class Drop {
    private int message;
    // True = send
    // false = retrieve
    private boolean empty = true;

    public synchronized int take() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException ignored) {

            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void put(int message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException ignored) {

            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}