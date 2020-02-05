package com.example.studentagency.mvp.model;

import android.util.Log;

import com.example.studentagency.bean.UserBean;
import com.example.studentagency.http.ApiService;
import com.example.studentagency.http.RetrofitHelper;
import com.example.studentagency.mvp.model.Callback.PersonFragmentGetPersonFragmentCallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author：LongSh1z
 * email：2674461089@qq.com
 * time：2020/02/02
 * desc:
 */
public class PersonFragmentBaseModel implements IModel {

    private static final String TAG = "PersonFragmentBaseModel";
    private ApiService apiService = RetrofitHelper.getInstance().getServer();

    public void getPersonFragmentInfo(int userId, PersonFragmentGetPersonFragmentCallBack callBack){
        apiService.getPersonFragmentInfo(userId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        Log.i(TAG, "getPersonFragmentInfo onNext: userBean>>>>>"+userBean.toString());
                        callBack.getPersonFragmentSuccess(userBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: e>>>>>"+e.getMessage());
                        callBack.getPersonFragmentFail();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
