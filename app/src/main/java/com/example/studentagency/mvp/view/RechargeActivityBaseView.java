package com.example.studentagency.mvp.view;

import com.example.studentagency.bean.ResponseBean;

/**
 * author：LongSh1z
 * email：2674461089@qq.com
 * time：2020/03/16
 * desc:
 */
public interface RechargeActivityBaseView extends IView {
    void rechargeSuccess(ResponseBean responseBean);
    void rechargeFail();
}
