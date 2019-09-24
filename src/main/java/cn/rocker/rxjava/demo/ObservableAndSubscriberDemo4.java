package cn.rocker.rxjava.demo;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

import java.util.List;

/**
 * @author chengzc
 * @date 2019-09-24 10:57
 * @since
 */
public class ObservableAndSubscriberDemo4 {

    @Test
    public void test(){
        Observable.just("Hello, world!")
                .map(s -> potentialException(s))
                .map(s -> anotherPotentialException(s))
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onNext(String s) { System.out.println(s); }

                    @Override
                    public void onCompleted() { System.out.println("Completed!"); }

                    /** 不管Observable发生了什么异常，Subscriber这里都会走到onError这里 */
                    @Override
                    public void onError(Throwable e) { System.out.println("Ouch!"); }
                });
    }

    public String potentialException(Object str){
//        throw new RuntimeException("potentialException" + str);
//        int i = 1 / 0;
        return str.toString();
    }

    public String anotherPotentialException(Object str){
//        throw new RuntimeException("anotherPotentialException" + str);
//        int i = 1 / 0;
        return str.toString();
    }

}
