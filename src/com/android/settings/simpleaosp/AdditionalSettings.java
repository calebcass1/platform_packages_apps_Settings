package com.android.settings.simpleaosp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceScreen;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.settings.simpleaosp.StatusBarSettings;
import com.android.settings.simpleaosp.NavigationBarSettings;
import com.android.settings.cyanogenmod.NotificationDrawerSettings;
import com.android.settings.cyanogenmod.PowerMenuActions;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;


import java.util.ArrayList;
import java.util.List;

public class AdditionalSettings extends SettingsPreferenceFragment {

    PagerTabStrip mPagerTabStrip;
    ViewPager mViewPager;

    String titleString[];

    ViewGroup mContainer;

    static Bundle mSavedState;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContainer = container;

        View view = inflater.inflate(R.layout.additional_settings, container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mPagerTabStrip = (PagerTabStrip) view.findViewById(R.id.pagerTabStrip);
        mPagerTabStrip.setDrawFullUnderline(true);

        StatusBarAdapter StatusBarAdapter = new StatusBarAdapter(getFragmentManager());
        mViewPager.setAdapter(StatusBarAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // After confirming PreferenceScreen is available, we call super.
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle saveState) {
        super.onSaveInstanceState(saveState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    class StatusBarAdapter extends FragmentPagerAdapter {
        String titles[] = getTitles();
        private Fragment frags[] = new Fragment[titles.length];

        public StatusBarAdapter(FragmentManager fm) {
            super(fm);
	    frags[0] = new StatusBarSettings();
            frags[1] = new NavigationBarSettings();
	    frags[2] = new NotificationDrawerSettings();
	    frags[3] = new PowerMenuActions();

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return frags[position];
        }

        @Override
        public int getCount() {
            return frags.length;
        }
    }

    private String[] getTitles() {
        String titleString[];
        titleString = new String[]{
		    getString(R.string.status_bar_title),
                    getString(R.string.navigation_bar_title),
		    getString(R.string.notification_drawer_title),
		    getString(R.string.power_menu_title)};
        return titleString;
    }
}


