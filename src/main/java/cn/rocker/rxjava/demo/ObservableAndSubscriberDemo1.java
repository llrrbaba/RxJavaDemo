package cn.rocker.rxjava.demo;


import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

/**
 * @author chengzc
 * @date 2019-09-24 10:07
 * @since
 */
public class ObservableAndSubscriberDemo1 {

    Observable<String> myObservable = Observable.create(
            new Observable.OnSubscribe<String>() {
                @Override
                public void call(Subscriber<? super String> sub) {
                    sub.onNext("Hello world!");
                    sub.onCompleted();
                }
            }
    );

    /** lambda版本 */
    Observable<String> myObservable2 = Observable.create(
            sub -> {
                sub.onNext("Hello world in lambda!");
                sub.onCompleted();
            }
    );


    Subscriber<String> mySubscriber = new Subscriber<String>() {
        @Override
        public void onNext(String s) {
            System.out.println(s);
        }

        @Override
        public void onCompleted() {
            System.out.println("completed");
        }

        @Override
        public void onError(Throwable e) {
        }
    };

    @Test
    public void test(){
        myObservable.subscribe(mySubscriber);
        myObservable2.subscribe(mySubscriber);
    }
}
