package com.example.studentagency.mvp.model.Callback;

import com.example.studentagency.bean.ResponseBean;

/**
 * author：LongSh1z
 * email：2674461089@qq.com
 * time：2020/01/02
 * desc:
 */
public interface HomeFragmentIndentCallBack {
    void onGetIndentDataSuccess(ResponseBean responseBean);
    void onGetIndentDataFail();
}
