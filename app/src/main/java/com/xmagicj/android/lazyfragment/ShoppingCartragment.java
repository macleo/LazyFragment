package com.xmagicj.android.lazyfragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 * Created by Mumu
 * on 2017/1/18.
 */
public class ShoppingCartragment extends BaseFragment {
    Handler handler = new Handler();
    ProgressBar progressBar;
    TextView textView;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final int DELAY_TIME = 2000;

    public ShoppingCartragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ShoppingCartragment newInstance(int sectionNumber) {
        ShoppingCartragment fragment = new ShoppingCartragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shoppingcart, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        textView = (TextView) rootView.findViewById(R.id.section_label);
        return rootView;
    }

    @Override
    protected void initData() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
                progressBar.setVisibility(View.GONE);
            }
        }, DELAY_TIME);
    }

    @Override
    protected void setDefaultFragmentTitle(String title) {

    }
}
