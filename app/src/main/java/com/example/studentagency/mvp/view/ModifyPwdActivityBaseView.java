package com.example.studentagency.mvp.view;

import com.example.studentagency.bean.ResponseBean;

/**
 * author：LongSh1z
 * email：2674461089@qq.com
 * time：2020/02/08
 * desc:
 */
public interface ModifyPwdActivityBaseView extends IView {
//    void changePwdSuccess(Integer result);
    void changePwdSuccess(ResponseBean responseBean);
    void changePwdFail();
}
