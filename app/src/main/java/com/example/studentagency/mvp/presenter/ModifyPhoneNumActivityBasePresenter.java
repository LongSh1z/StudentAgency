package com.example.studentagency.mvp.presenter;

import com.example.studentagency.bean.ResponseBean;
import com.example.studentagency.mvp.model.Callback.ModifyPhoneNumActivityGetVerifyCodeCallBack;
import com.example.studentagency.mvp.model.Callback.ModifyPhoneNumActivityModifyPhoneNumCallBack;
import com.example.studentagency.mvp.model.ModifyPhoneNumActivityBaseModel;
import com.example.studentagency.mvp.view.ModifyPhoneNumActivityBaseView;

import java.lang.ref.WeakReference;

/**
 * author：LongSh1z
 * email：2674461089@qq.com
 * time：2020/02/23
 * desc:
 */
public class ModifyPhoneNumActivityBasePresenter extends IPresenter {

    public ModifyPhoneNumActivityBasePresenter(ModifyPhoneNumActivityBaseView view) {
        this.mIModel = new ModifyPhoneNumActivityBaseModel();
        this.mViewRef = new WeakReference<>(view);
    }

    public void getVerifyCode(String newPhoneNum) {
        if (null != mViewRef && null != mViewRef.get() && null != mIModel){
            ((ModifyPhoneNumActivityBaseModel)mIModel).getVerifyCode(newPhoneNum, new ModifyPhoneNumActivityGetVerifyCodeCallBack() {
                @Override
                public void getVerifyCodeSuccess(ResponseBean responseBean) {
                    if (null != mViewRef.get()){
                        ((ModifyPhoneNumActivityBaseView)mViewRef.get()).getVerifyCodeSuccess(responseBean);
                    }
                }

                @Override
                public void getVerifyCodeFail() {
                    if (null != mViewRef.get()){
                        ((ModifyPhoneNumActivityBaseView)mViewRef.get()).getVerifyCodeFail();
                    }
                }
            });
        }
    }

    public void modifyPhoneNum(String newPhoneNum, String verifyCode) {
        if (null != mViewRef && null != mViewRef.get() && null != mIModel){
            ((ModifyPhoneNumActivityBaseModel)mIModel).modifyPhoneNum(newPhoneNum, verifyCode, new ModifyPhoneNumActivityModifyPhoneNumCallBack() {
                @Override
                public void modifyPhoneNumSuccess(ResponseBean responseBean) {
                    if (null != mViewRef.get()){
                        ((ModifyPhoneNumActivityBaseView)mViewRef.get()).modifyPhoneNumSuccess(responseBean);
                    }
                }

                @Override
                public void modifyPhoneNumFail() {
                    if (null != mViewRef.get()){
                        ((ModifyPhoneNumActivityBaseView)mViewRef.get()).modifyPhoneNumFail();
                    }
                }
            });
        }
    }
}
