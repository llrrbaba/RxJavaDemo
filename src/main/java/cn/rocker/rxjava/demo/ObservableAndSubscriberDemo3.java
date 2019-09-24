package cn.rocker.rxjava.demo;

import org.junit.Test;
import rx.Observable;
import rx.functions.Func1;

import java.util.Random;

/**
 * @author chengzc
 * @date 2019-09-24 10:44
 * @since
 */
public class ObservableAndSubscriberDemo3 {

    @Test
    public void test(){
        Observable.just("Hello, world! -Dan")
                .subscribe(s -> System.out.println(s));
    }


    @Test
    public void test2(){
        Observable.just("Hello, world!")
                .subscribe(s -> System.out.println(s + " -Dan"));
        Observable.just("Hello, world!")
                .subscribe(s -> System.out.println(s));
    }


    @Test
    public void test3(){
        Observable.just("Hello, world!")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + " -Dan";
                    }
                })
                .subscribe(s -> System.out.println(s));


        /** 通过map，对Observable的内容进行转换 */
        Observable.just("Hello, world!")
                .map(s -> s + " -Dan")
                .subscribe(s -> System.out.println(s));

        /** 通过map，对Observable的内容进行转换 */
        Observable.just("Hello, world!")
                .map(s -> s.length())
                .subscribe(s -> System.out.println(s));

        /** 通过map，对Observable的内容进行转换
         * 可以加任意多个map进行转换，链式调用map，subscriber做的事情越少越好 */
        Observable.just("Hello, world!")
                .map(s -> s.length())
                .map(s -> s*21)
                .map(s -> new Random().nextInt(s))
                .subscribe(s -> System.out.println(s));
    }

}
