package com.example.studentagency.ui.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentagency.R;
import com.example.studentagency.ui.adapter.MyFragmentPagerAdapter;
import com.example.studentagency.ui.fragment.HomeFragment;
import com.example.studentagency.ui.fragment.MarketFragment;
import com.example.studentagency.ui.fragment.MessageFragment;
import com.example.studentagency.ui.fragment.PersonFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private List<Fragment> fragments;
    private ViewPager viewPager;
    //底部导航栏的总布局
    private LinearLayout llayout_home, llayout_market, llayout_message, llayout_person;
    //底部导航栏的图标
    private ImageView iv_home, iv_market, iv_message, iv_person, iv_current;
    //底部导航栏的文字
    private TextView tv_home, tv_market, tv_message, tv_person, tv_current;
    //记录当前点击返回键的时间
    private long mExitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件及监听事件
        initViews();

        //绑定fragment到activity上
        bindingFragment();
    }

    private void initViews() {
        //底部导航栏linearlayout初始化
        llayout_home = findViewById(R.id.llayout_home);
        llayout_market = findViewById(R.id.llayout_market);
        llayout_message = findViewById(R.id.llayout_message);
        llayout_person = findViewById(R.id.llayout_person);

        //底部导航栏imageview初始化
        iv_home = findViewById(R.id.iv_home);
        iv_market = findViewById(R.id.iv_market);
        iv_message = findViewById(R.id.iv_message);
        iv_person = findViewById(R.id.iv_person);

        //底部导航栏textview初始化
        tv_home = findViewById(R.id.tv_home);
        tv_market = findViewById(R.id.tv_market);
        tv_message = findViewById(R.id.tv_message);
        tv_person = findViewById(R.id.tv_person);

        //默认选中首页的imageview和textview
        iv_current = iv_home;
        tv_current = tv_home;
        iv_home.setSelected(true);
        tv_home.setSelected(true);

        llayout_home.setOnClickListener(this);
        llayout_market.setOnClickListener(this);
        llayout_message.setOnClickListener(this);
        llayout_person.setOnClickListener(this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                changeTab(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void bindingFragment() {
        //准备fragment
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new MarketFragment());
        fragments.add(new MessageFragment());
        fragments.add(new PersonFragment());

        //将viewpager与fragment绑定
        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(pagerAdapter);
    }

    //改变底部栏图标和文字的样式
    private void changeTab(int position) {
        //取消选中当前的图标和文字
        iv_current.setSelected(false);
        tv_current.setSelected(false);
        switch (position) {
            //首页
            case R.id.llayout_home:
            case 0:
                iv_home.setSelected(true);
                tv_home.setSelected(true);
                iv_current = iv_home;
                tv_current = tv_home;
                viewPager.setCurrentItem(0);
                break;
            //市场
            case R.id.llayout_market:
            case 1:
                iv_market.setSelected(true);
                tv_market.setSelected(true);
                iv_current = iv_market;
                tv_current = tv_market;
                viewPager.setCurrentItem(1);
                break;
            //消息
            case R.id.llayout_message:
            case 2:
                iv_message.setSelected(true);
                tv_message.setSelected(true);
                iv_current = iv_message;
                tv_current = tv_message;
                viewPager.setCurrentItem(2);
                break;
            //个人
            case R.id.llayout_person:
            case 3:
                iv_person.setSelected(true);
                tv_person.setSelected(true);
                iv_current = iv_person;
                tv_current = tv_person;
                viewPager.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        changeTab(v.getId());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断用户是否点击了“返回键”
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //与上次点击返回键时刻作差
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                //大于2000ms则认为是误操作，使用Toast进行提示
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                //并记录下本次点击“返回键”的时刻，以便下次进行判断
                mExitTime = System.currentTimeMillis();
            } else {
                //小于2000ms则认为是用户确实希望退出程序-调用System.exit()方法进行退出
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}