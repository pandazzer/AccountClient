package iFuture.team.AccountClient;

public class StreamAddAmount extends Thread {
    int id;
    long value;

    public StreamAddAmount(int id, long value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public void run() {

    }
}
