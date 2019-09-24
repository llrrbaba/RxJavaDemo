package cn.rocker.rxjava.demo;

import org.junit.Test;
import rx.Observable;
import rx.Subscription;

/**
 * @author chengzc
 * @date 2019-09-24 11:31
 * @since
 */
public class ObservableAndSubscriberDemo5 {

    @Test
    public void test(){
        Subscription subscription = Observable.just("hello world").subscribe(s -> System.out.println(s));
        subscription.unsubscribe();
        System.out.println("Unsubscribed=" + subscription.isUnsubscribed());
    }

}
