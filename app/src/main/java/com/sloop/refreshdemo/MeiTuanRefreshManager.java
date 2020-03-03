package com.sloop.refreshdemo;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sloop.pulltorefreshlibary.BaseRefreshManager;


/**
 * Created by anson on 2019/4/21.
 */
public class MeiTuanRefreshManager extends BaseRefreshManager {

    private ImageView mImagView;
    private TextView tv_state;

    public MeiTuanRefreshManager(Context context) {
        super(context);
    }

    @Override
    public View getHeaderView() {
        View inflate = mLayoutInflater.inflate(R.layout.meituan_header_refresh_layout, null, false);
        mImagView = inflate.findViewById(R.id.loading);
        tv_state = inflate.findViewById(R.id.tv_state);
        return inflate;
    }

    //这个回调 只会触发一次
    @Override
    public void downRefresh() {

    }

    //释放刷新的时候 会 变成  美团的 吉祥物
    @Override
    public void releaseRefresh() {
        mImagView.setImageResource(R.drawable.mei_tuan_loading_pre);
        AnimationDrawable mAnimationDrawable= (AnimationDrawable) mImagView.getDrawable();
        mAnimationDrawable.start();
        tv_state.setText("释放刷新");

        //        setAnim();
    }

    @Override
    public void iddleRefresh() {
        mImagView.clearAnimation();
        mImagView.setImageResource(R.mipmap.pull_image);
        mImagView.setScaleX(0);
        mImagView.setScaleY(0);

//        setAnim();
    }

    //正在刷新的状态实际上也是一个帧动画
    @Override
    public void refreshing() {
        mImagView.setImageResource(R.drawable.mei_tuan_loading);
//        setAnim();
        tv_state.setText("正在刷新");
    }

    @Override
    public void downRefreshPercent(float precent) {
        mImagView.setScaleX(precent);
        mImagView.setScaleY(precent);
//        setAnim();
        tv_state.setText("下拉刷新");
    }

    @Override
    public void overRefresh() {
//        mImagView.setImageResource(R.drawable.mei_tuan_loading);
//        AnimationDrawable mAnimationDrawable= (AnimationDrawable) mImagView.getDrawable();
//        mAnimationDrawable.start();

//        setAnim();
        tv_state.setText("刷新完成");
    }

    public void setAnim() {
        mImagView.setImageResource(R.drawable.progress_loading);
        AnimationDrawable mAnimationDrawable= (AnimationDrawable) mImagView.getDrawable();
        mAnimationDrawable.start();
    }
}
