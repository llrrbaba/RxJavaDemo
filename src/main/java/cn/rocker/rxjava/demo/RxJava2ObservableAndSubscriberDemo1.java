package cn.rocker.rxjava.demo;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author chengzc
 * @date 2019-09-24 11:40
 * @since
 */
@Slf4j
public class RxJava2ObservableAndSubscriberDemo1 {

    Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
        @Override
        public void subscribe(ObservableEmitter<String> e) throws Exception {
            e.onNext("Hello Observer");
            e.onComplete();
        }
    });

    Observer<String> observer = new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(String s) {
            log.info("chan:{}","=============onNext " + s);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {
            log.info("chan:{}","=============onComplete ");
        }
    };

    @Test
    public void test(){
        observable.subscribe(observer);
    }


}
