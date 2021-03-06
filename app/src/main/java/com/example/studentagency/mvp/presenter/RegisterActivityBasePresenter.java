package com.example.studentagency.mvp.presenter;

import android.util.Log;

import com.example.studentagency.bean.ResponseBean;
import com.example.studentagency.mvp.model.Callback.RegisterTwoActivityGetVerifyCodeCallBack;
import com.example.studentagency.mvp.model.Callback.RegisterTwoActivityRegisterCallBack;
import com.example.studentagency.mvp.model.RegisterActivityBaseModel;
import com.example.studentagency.mvp.view.RegisterActivityBaseView;

import java.lang.ref.WeakReference;

/**
 * author：LongSh1z
 * email：2674461089@qq.com
 * time：2020/01/30
 * desc:
 */
public class RegisterActivityBasePresenter extends IPresenter {

    private static final String TAG = "RegisterActivityBasePre";

    public RegisterActivityBasePresenter(RegisterActivityBaseView view) {
        this.mViewRef = new WeakReference<>(view);
        this.mIModel = new RegisterActivityBaseModel();
    }

    public void getVerifyCode(String phoneNum){
        if (null != mIModel && null != mViewRef && null != mViewRef.get()){
            ((RegisterActivityBaseModel)mIModel).getVerifyCode(phoneNum, new RegisterTwoActivityGetVerifyCodeCallBack() {
                @Override
                public void getVerifyCodeSuccess(ResponseBean responseBean) {
                    if (null != mViewRef.get()){
                        ((RegisterActivityBaseView)mViewRef.get()).getVerifyCodeSuccess(responseBean);
                    }
                }

                @Override
                public void getVerifyCodeFail() {
                    if (null != mViewRef.get()){
                        ((RegisterActivityBaseView)mViewRef.get()).getVerifyCodeFail();
                    }
                }
            });
        }
    }

    public void register(String username,int gender,String password,
                         String school,String phoneNum){
        if (null != mIModel && null != mViewRef && null != mViewRef.get()){
            Log.i(TAG, "register into  RegisterActivityBasePre--------------------");
            ((RegisterActivityBaseModel)mIModel).register(username, gender, password, school, phoneNum,
                    new RegisterTwoActivityRegisterCallBack() {
                        @Override
                        public void registerSuccess(ResponseBean responseBean) {
                            if (null != mViewRef.get()){
                                ((RegisterActivityBaseView)mViewRef.get()).registerSuccess(responseBean);
                            }
                        }

                        @Override
                        public void registerFail() {
                            if (null != mViewRef.get()){
                                ((RegisterActivityBaseView)mViewRef.get()).registerFail();
                            }
                        }
                    });
        }
    }
}
