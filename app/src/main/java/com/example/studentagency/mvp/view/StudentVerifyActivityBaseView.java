package com.example.studentagency.mvp.view;

import com.example.studentagency.bean.ResponseBean;

/**
 * author：LongSh1z
 * email：2674461089@qq.com
 * time：2020/02/17
 * desc:
 */
public interface StudentVerifyActivityBaseView extends IView {
//    void getVerifyStateSuccess(Integer result);
    void getVerifyStateSuccess(ResponseBean responseBean);
    void getVerifyStateFail();
}
