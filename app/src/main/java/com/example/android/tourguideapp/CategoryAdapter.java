package com.example.android.tourguideapp; /**
 * Created by Ken Muckey on 7/1/2018.
 */


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    //Number of tabs
    static final int NUM_ITEMS = 4;

    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Functions called when use swipes or taps tab
     * Starts new fragments for each
     * @param position: tab click or page swiped to by user
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new KyotoFragment();
            case 1:
                return new OsakaFragment();
            case 2:
                return new HiroshimaFragment();
            case 3:
                return new TokyoFragment();
            default:
                return new KyotoFragment();
        }
    }

    //Hardcode number of tabs in the view
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.category_kyoto);
            case 1:
                return mContext.getString(R.string.category_osaka);
            case 2:
                return mContext.getString(R.string.category_hiroshima);
            case 3:
                return mContext.getString(R.string.category_tokyo);
            default:
                return mContext.getString(R.string.category_kyoto);
        }
    }
}
