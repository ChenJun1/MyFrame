package com.frame.chenj.myframe.presenter;

import com.frame.chenj.myframe.base.IView;
import com.frame.chenj.myframe.rest.BaseSubscriber;
import com.frame.chenj.myframe.rest.ExceptionHandle;
import com.frame.chenj.myframe.rest.HttpAPI;
import com.frame.chenj.myframe.rest.ResponseFunc;
import com.frame.chenj.myframe.rest.RestClient;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by ${ChenJ} on 2016/9/13.
 */
public abstract class Presenter implements BaseSubscriber.SubscriberListener{
    public IView mView;

    /*网络请求方法类型*/
    public static final int METHOD_1 = 1;
    public static final int METHOD_2 = 2;
    public static final int METHOD_3 = 3;
    public static final int METHOD_4 = 4;
    public static final int METHOD_5 = 5;
    public static final int METHOD_6 = 6;
    public static final int METHOD_7 = 7;
    public static final int METHOD_8 = 8;
    public static final int METHOD_9 = 9;
    public static final int METHOD_10 = 10;
    public static final int METHOD_11 = 11;

    public Presenter() {

    }

    public void onCreate(IView iView) {
        this.mView = iView;
    }

    public void onDestroy() {
        this.mView = null;
    }

    /**
     * @param method 请求类型
     * @param params 传入的参数
     */
    public abstract void execute(int method, Object... params);

    final Observable.Transformer schedulersTransformer = new Observable.Transformer() {
        @Override
        public Object call(Object o) {
            return ((Observable) o).subscribeOn(Schedulers.io()).
                    unsubscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread());
        }
    };

    public <T> Observable.Transformer<ResponseFunc<T>,T> transformer(){
        return new Observable.Transformer(){
            @Override
            public Object call(Object observable) {
                return ((Observable)observable).map(new ResponseFunc()).onErrorResumeNext(new HttpResponseFunc<>());
            }
        };
    }

    private static class HttpResponseFunc<T> implements Func1<Throwable,Observable<T>>{
        @Override
        public Observable<T> call(Throwable throwable) {
            return Observable.error(ExceptionHandle.handleException(throwable));
        }
    }

    @Override
    public void showProgress() {
        mView.showProgress();
    }

    @Override
    public void hideProgress() {
        mView.hidePregress();
    }

    @Override
    public void onResultSuccess(int method, Object o) {
        mView.onReultSuccess(method,o);
    }

    @Override
    public void showNotice(int method, String msg) {
        mView.showNotice(method,msg);
    }

    public HttpAPI getHttpApi(){
        return RestClient.getINSTANCE().getmHttpApi();
    }
}
