package com.example.studentagency.mvp.view;

import com.example.studentagency.bean.ResponseBean;

/**
 * author：LongSh1z
 * email：2674461089@qq.com
 * time：2020/02/18
 * desc:
 */
public interface OutputRecordFragmentBaseView extends IView {
//    void getCreditOutputRecordSuccess(List<CreditBean> creditBeans);
    void getCreditOutputRecordSuccess(ResponseBean responseBean);
    void getCreditOutputRecordFail();
}
