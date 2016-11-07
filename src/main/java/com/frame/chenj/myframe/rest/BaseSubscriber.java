package com.frame.chenj.myframe.rest;


import com.frame.chenj.myframe.base.IView;

import rx.Subscriber;

/**
 * Created by dazhuanjia_rx on 16/8/31.
 */
public class BaseSubscriber<T> extends Subscriber<T> {
    private SubscriberListener subscriberListener;
    private int method;

    public BaseSubscriber(SubscriberListener onResult, int method) {
        this.subscriberListener = onResult;
        this.method = method;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (subscriberListener == null) {
            onError(null);
            return;
        }
//        if (!NetWorkUtils.isConnectedByState(mView.getContext())) {
//            onError(null);
//            return;
//        }
        subscriberListener.showProgress();
    }

    @Override
    public void onCompleted() {
        if (subscriberListener != null)
            subscriberListener.hideProgress();
        subscriberListener = null;
    }

    @Override
    public void onError(Throwable e) {
        if (subscriberListener == null)
            return;
        if (e == null) {
            subscriberListener.showNotice(IView.ERROR_NETWORK, null);
        } else {
            if (e instanceof ExceptionHandle.ResponseThrowable) {
                onErrored((ExceptionHandle.ResponseThrowable) e);
            } else {
                onErrored(new ExceptionHandle.ResponseThrowable(e, ExceptionHandle.ERROR.UNKNOWN));
            }
        }
        subscriberListener.hideProgress();
        subscriberListener = null;
    }

    @Override
    public void onNext(T t) {
        subscriberListener.onResultSuccess(method, t);
    }

    public void onErrored(ExceptionHandle.ResponseThrowable e) {
        if (e.code == IView.ERROR_UN_LOGIN) {
            subscriberListener.showNotice(IView.ERROR_UN_LOGIN, null);
        } else
            subscriberListener.showNotice(method, e.message);
    }

    public interface SubscriberListener {
        void showProgress();

        void hideProgress();

        void onResultSuccess(int method, Object o);

        void showNotice(int method, String msg);
    }
}
