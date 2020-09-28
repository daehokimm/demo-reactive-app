import java.util.concurrent.Flow.*;

public class Main {
    public static void main(String[] args) {
        getTemperature("Seoul").subscribe(new TempSubscriber());
    }

    private static Publisher<TempInfo> getTemperature(String town) {
        return subscriber -> subscriber.onSubscribe(
                new TempSubscription(subscriber, town)
        );
    }
}
