package cn.rocker.rxjava.demo;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author chengzc
 * @date 2019-09-24 12:46
 * @since
 */
@Slf4j
public class RxJava2ObservableAndSubscriberDemo2 {

    @Test
    public void test(){
        Observable.just(1, 2, 3)
                .subscribe(new Observer< Integer >() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        log.info("=================onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        log.info("=================onNext " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        log.info("=================onError ");
                    }

                    @Override
                    public void onComplete() {
                        log.info("=================onComplete ");
                    }
                });
    }

}
