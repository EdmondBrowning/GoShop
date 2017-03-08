package com.qiqi.edmond.qishop.activitys;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.activitys.base.BaseActivity;
import com.qiqi.edmond.qishop.fragments.AroundFragment;
import com.qiqi.edmond.qishop.fragments.HomeFragment;
import com.qiqi.edmond.qishop.fragments.MineFragment;
import com.qiqi.edmond.qishop.fragments.ShoppingCartFragment;
import com.qiqi.edmond.qishop.interfaces.mvp.views.MainViewInterface;
import com.qiqi.edmond.qishop.presenters.MainPresenter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by edmond on 16-11-15.
 *
 */

public class MainActivity extends BaseActivity implements MainViewInterface{

    private final static String TAG = "MainActivity";

    private MainPresenter presenter;
    private FragmentManager fragmentManager;

    private LinearLayout firstLayout;
    private LinearLayout secondLayout;
    private LinearLayout thirdLayout;
    private LinearLayout forthLayout;

    private ImageView firstImageView;
    private ImageView secondImageView;
    private ImageView thirdImageView;
    private ImageView forthImageView;

    private TextView firstTextView;
    private TextView secondTextView;
    private TextView thirdTextView;
    private TextView forthTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstLayout = (LinearLayout) findViewById(R.id.first);
        secondLayout = (LinearLayout) findViewById(R.id.second);
        thirdLayout = (LinearLayout) findViewById(R.id.third);
        forthLayout = (LinearLayout) findViewById(R.id.forth);

        firstImageView = (ImageView) findViewById(R.id.first_image);
        secondImageView = (ImageView) findViewById(R.id.second_image);
        thirdImageView = (ImageView) findViewById(R.id.third_image);
        forthImageView = (ImageView) findViewById(R.id.forth_image);

        firstTextView = (TextView) findViewById(R.id.first_text);
        secondTextView = (TextView) findViewById(R.id.second_text);
        thirdTextView = (TextView) findViewById(R.id.third_text);
        forthTextView = (TextView) findViewById(R.id.forth_text);

        final AroundFragment aroundFragment = new AroundFragment();
        final HomeFragment homeFragment = new HomeFragment();
        final MineFragment mineFragment = new MineFragment();
        final ShoppingCartFragment shoppingCartFragment = new ShoppingCartFragment();

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment,homeFragment).commit();
        fragmentManager.beginTransaction().add(R.id.fragment,aroundFragment).commit();
        fragmentManager.beginTransaction().add(R.id.fragment,mineFragment).commit();
        fragmentManager.beginTransaction().add(R.id.fragment,shoppingCartFragment).commit();
        fragmentManager.beginTransaction().hide(aroundFragment).hide(shoppingCartFragment).hide(mineFragment).commit();

        firstImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_select));
        firstTextView.setTextColor(getResources().getColor(R.color.mainColor));
        secondImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_around_no_select));
        thirdImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_shopping_cart_no_select));
        forthImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_mine_no_select));

        firstLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.setStatusBarColor(getResources().getColor(R.color.mainColor));
//                    statusBarLight();
                    StatusBarDarkMode(MainActivity.this);
                }

                fragmentManager.beginTransaction()
                        .hide(aroundFragment)
                        .hide(mineFragment)
                        .hide(shoppingCartFragment)
                        .show(homeFragment).commit();

                firstImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_select));
                firstTextView.setTextColor(getResources().getColor(R.color.mainColor));
                secondImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_around_no_select));
                secondTextView.setTextColor(getResources().getColor(R.color.noSelectColor));
                thirdImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_shopping_cart_no_select));
                thirdTextView.setTextColor(getResources().getColor(R.color.noSelectColor));
                forthImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_mine_no_select));
                forthTextView.setTextColor(getResources().getColor(R.color.noSelectColor));
            }
        });

        secondLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.setStatusBarColor(getResources().getColor(R.color.white));
//                    statusBarDark();
                    StatusBarLightMode(MainActivity.this);
                }

                fragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .hide(shoppingCartFragment)
                        .hide(mineFragment)
                        .show(aroundFragment).commit();

                firstImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_no_select));
                firstTextView.setTextColor(getResources().getColor(R.color.noSelectColor));
                secondImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_around_select));
                secondTextView.setTextColor(getResources().getColor(R.color.mainColor));
                thirdImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_shopping_cart_no_select));
                thirdTextView.setTextColor(getResources().getColor(R.color.noSelectColor));
                forthImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_mine_no_select));
                forthTextView.setTextColor(getResources().getColor(R.color.noSelectColor));
            }
        });

        thirdLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.setStatusBarColor(getResources().getColor(R.color.white));
//                    statusBarDark();
                    StatusBarLightMode(MainActivity.this);
                }

                fragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .hide(aroundFragment)
                        .hide(mineFragment)
                        .show(shoppingCartFragment).commit();

                firstImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_no_select));
                firstTextView.setTextColor(getResources().getColor(R.color.noSelectColor));
                secondImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_around_no_select));
                secondTextView.setTextColor(getResources().getColor(R.color.noSelectColor));
                thirdImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_shopping_cart_select));
                thirdTextView.setTextColor(getResources().getColor(R.color.mainColor));
                forthImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_mine_no_select));
                forthTextView.setTextColor(getResources().getColor(R.color.noSelectColor));
            }
        });

        forthLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.setStatusBarColor(getResources().getColor(R.color.mainColor));
//                    statusBarLight();
                    StatusBarDarkMode(MainActivity.this);
                }

                fragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .hide(aroundFragment)
                        .hide(shoppingCartFragment)
                        .show(mineFragment).commit();

                firstImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_no_select));
                firstTextView.setTextColor(getResources().getColor(R.color.noSelectColor));
                secondImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_around_no_select));
                secondTextView.setTextColor(getResources().getColor(R.color.noSelectColor));
                thirdImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_shopping_cart_no_select));
                thirdTextView.setTextColor(getResources().getColor(R.color.noSelectColor));
                forthImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_mine_select));
                forthTextView.setTextColor(getResources().getColor(R.color.mainColor));
            }
        });

        presenter = new MainPresenter(this);
        presenter.initing();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Destroy");
        presenter.onDestroy();
        presenter = null;
    }

    @Override
    public void initing() {

    }

    @Override
    public void inited() {

    }

    /**
     * 设置状态栏黑色字体图标，
     * 适配4.4以上版本MIUIV、Flyme和6.0以上版本其他Android
     *
     * @param activity
     * @return 1:MIUUI 2:Flyme 3:android6.0
     */
    public static int StatusBarLightMode(AppCompatActivity activity) {
        int result = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (MIUISetStatusBarLightMode(activity.getWindow(), true)) {
                result = 1;
            } else if (FlymeSetStatusBarLightMode(activity.getWindow(), true)) {
                result = 2;
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Window window = activity.getWindow();
                View decor = window.getDecorView();
                int ui = decor.getSystemUiVisibility();
                ui |=View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                decor.setSystemUiVisibility(ui);
                result = 3;
            }
        }
        return result;
    }

    /**
     * 已知系统类型时，设置状态栏黑色字体图标。
     * 适配4.4以上版本MIUIV、Flyme和6.0以上版本其他Android
     *
     * @param activity
     * @param type     1:MIUUI 2:Flyme 3:android6.0
     */
    public static void StatusBarLightMode(AppCompatActivity activity, int type) {
        if (type == 1) {
            MIUISetStatusBarLightMode(activity.getWindow(), true);
        } else if (type == 2) {
            FlymeSetStatusBarLightMode(activity.getWindow(), true);
        } else if (type == 3) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View
                    .SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    public static int StatusBarDarkMode(AppCompatActivity activity) {
        int result = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (MIUISetStatusBarLightMode(activity.getWindow(), false)) {
                result = 1;
            } else if (FlymeSetStatusBarLightMode(activity.getWindow(), false)) {
                result = 2;
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Window window = activity.getWindow();
                View decor = window.getDecorView();
                int ui = decor.getSystemUiVisibility();
                ui &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                decor.setSystemUiVisibility(ui);
                result = 3;
            }
        }
        return result;
    }

    /**
     * 已知系统类型时，清除状态栏黑色字体图标。
     * 清除MIUI或flyme或6.0以上版本状态栏黑色字体
     */
    public static void StatusBarDarkMode(AppCompatActivity activity, int type) {
        if (type == 1) {
            MIUISetStatusBarLightMode(activity.getWindow(), false);
        } else if (type == 2) {
            FlymeSetStatusBarLightMode(activity.getWindow(), false);
        } else if (type == 3) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }

    }

    /**
     * 设置状态栏图标为深色和魅族特定的文字风格
     * 可以用来判断是否为Flyme用户
     *
     * @param window 需要设置的窗口
     * @param dark   是否把状态栏字体及图标颜色设置为深色
     * @return boolean 成功执行返回true
     */
    public static boolean FlymeSetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            try {
                WindowManager.LayoutParams lp = window.getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                window.setAttributes(lp);
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }

    /**
     * 设置状态栏字体图标为深色，需要MIUIV6以上
     *
     * @param window 需要设置的窗口
     * @param dark   是否把状态栏字体及图标颜色设置为深色
     * @return boolean 成功执行返回true
     */
    public static boolean MIUISetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            Class clazz = window.getClass();
            try {
                int darkModeFlag = 0;
                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt(layoutParams);
                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                if (dark) {
                    extraFlagField.invoke(window, darkModeFlag, darkModeFlag);//状态栏透明且黑色字体
                } else {
                    extraFlagField.invoke(window, 0, darkModeFlag);//清除黑色字体
                }
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }
}
