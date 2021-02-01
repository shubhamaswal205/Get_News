package com.example.dbms.newsapp.ui.headlines;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dbms.newsapp.R;
import com.example.dbms.newsapp.databinding.FragmentHeadlinesBinding;
import com.example.dbms.newsapp.network.NewsApi;

public class HeadlinesFragment extends Fragment {
    private final String[] categories = {
            NewsApi.Category.general.name(),
            NewsApi.Category.business.name(),
            NewsApi.Category.sports.name(),
            NewsApi.Category.health.name(),
            NewsApi.Category.entertainment.name(),
            NewsApi.Category.technology.name(),
            NewsApi.Category.science.name(),
    };
    private final int[] categoryIcons = {
            R.drawable.general_news,
            R.drawable.business,
            R.drawable.sports,
            R.drawable.health,
            R.drawable.entertainment,
            R.drawable.technology,
            R.drawable.science,

    };
    private FragmentHeadlinesBinding binding;

    public HeadlinesFragment() {
        // Required empty public constructor
    }

    public static HeadlinesFragment newInstance() {
        return new HeadlinesFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_headlines, container, false);

        ViewCompat.setElevation(binding.tablayoutHeadlines, getResources().getDimension(R.dimen.tab_layout_elevation));

        if (getActivity() != null) {
            ViewPagerAdapter viewPager = new ViewPagerAdapter(getChildFragmentManager(), categories);
            binding.viewpagerHeadlines.setAdapter(viewPager);
            binding.tablayoutHeadlines.setupWithViewPager(binding.viewpagerHeadlines);
            setupTabIcons();
        }
        return this.binding.getRoot();
    }

    private void setupTabIcons() {
        TabLayout.Tab tab;
        for (int i = 0; i < categories.length; i++) {
            tab = binding.tablayoutHeadlines.getTabAt(i);
            if (tab != null) {
                tab.setIcon(categoryIcons[i]).setText(categories[i]);
            }
        }
    }
}
