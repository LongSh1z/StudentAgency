package com.example.studentagency.mvp.model.Callback;

import com.example.studentagency.bean.ResponseBean;

/**
 * author：LongSh1z
 * email：2674461089@qq.com
 * time：2020/01/06
 * desc:
 */
public interface IndentActivityGetCommentInfoCallBack {
    void onGetCommentInfoSuccess(ResponseBean responseBean);
    void onGetCommentInfoFail();
}
