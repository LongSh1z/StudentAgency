package com.example.studentagency.mvp.view;

import com.example.studentagency.bean.ResponseBean;

/**
 * author：LongSh1z
 * email：2674461089@qq.com
 * time：2020/03/05
 * desc:
 */
public interface SloganActivityBaseView extends IView{
    void tokenVerifySuccess(ResponseBean responseBean);
    void tokenVerifyFail();
}
