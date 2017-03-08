package com.qiqi.edmond.qishop.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.adapters.viewpager.MyPagerAdapter;
import com.qiqi.edmond.qishop.interfaces.mvp.views.AroundViewInterface;
import com.qiqi.xznview.layout.XZIndicator;

import java.util.ArrayList;

/**
 * Created by edmond on 17-1-3.
 */

public class AroundFragment extends Fragment implements AroundViewInterface{
    private View view;

    private XZIndicator indicator;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_around,container,false);

        indicator = (XZIndicator) view.findViewById(R.id.indicator);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        fragments.add(new AroundNowFragment());
        fragments.add(new AroundWillFragment());
        fragments.add(new AroundPastFragment());

        viewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager(),fragments));
        viewPager.setOffscreenPageLimit(2);

        indicator.setViewPager(viewPager,0);

        return view;
    }
}
