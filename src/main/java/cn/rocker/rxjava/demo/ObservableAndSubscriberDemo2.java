package cn.rocker.rxjava.demo;

import org.junit.Test;
import rx.Observable;
import rx.functions.Action1;

/**
 * @author chengzc
 * @date 2019-09-24 10:25
 * @since
 */
public class ObservableAndSubscriberDemo2 {

    Observable<String> myObservable = Observable.just("Hello, world!");

    Action1<String> onNextAction = new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println(s);
        }
    };

    /**
     * lambda版本
     */
    Action1<String> onNextAction2 = s -> System.out.println(s);

    @Test
    public void test1() {
        myObservable.subscribe(onNextAction);
        myObservable.subscribe(onNextAction2);
    }


    // ===================================================================================================

    @Test
    public void test2() {
        Observable.just("Hello, world!")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }


    // ===================================================================================================

    @Test
    public void test3(){
        Observable.just("Hello, world!")
                .subscribe(s -> System.out.println(s));
    }


}
