package com.example.intern.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import Fragments.ClientFragment;
import Fragments.DateGeneraleFragment;
import Fragments.FurnizorFragment;

public class DetailsActivity extends Fragment {
    /*Bundle bundle = this.getArguments();
    int ceva = bundle.getInt("ceva");*/

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private SectionsPagerAdapter mSectionsPagerAdapter;




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    ClientFragment tab1 = new ClientFragment();
                    return tab1;
                case 1:
                    DateGeneraleFragment tab2 = new DateGeneraleFragment();
                    return tab2;
                case 2:
                    FurnizorFragment tab3 = new FurnizorFragment();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "CLIENT";
                case 1:
                    return "DATE GENERALE";
                case 2:
                    return "FURNIZOR";
            }
            return null;
        }
    }


}
