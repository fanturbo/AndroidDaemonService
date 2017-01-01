package com.clock.daemon;

import android.os.Handler;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by turbo on 2016/12/30.
 */

public class Util {

    public static void print() {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Log.i("======", "turbo");
                    }
                });
    }
}
