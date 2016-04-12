package com.williamtygret.w;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.williamtygret.w.Fragments.AnimationFragment;
import com.williamtygret.w.Fragments.ContactFragment;
import com.williamtygret.w.Fragments.GalleryFragment;
import com.williamtygret.w.Fragments.ProjectsFragment;
import com.williamtygret.w.Fragments.ResumeFragment;
import com.williamtygret.w.Fragments.SocialFragment;
import com.williamtygret.w.GalleryFragments.GalleryPiece1;
import com.williamtygret.w.GalleryFragments.GalleryPiece10;
import com.williamtygret.w.GalleryFragments.GalleryPiece11;
import com.williamtygret.w.GalleryFragments.GalleryPiece12;
import com.williamtygret.w.GalleryFragments.GalleryPiece2;
import com.williamtygret.w.GalleryFragments.GalleryPiece3;
import com.williamtygret.w.GalleryFragments.GalleryPiece4;
import com.williamtygret.w.GalleryFragments.GalleryPiece5;
import com.williamtygret.w.GalleryFragments.GalleryPiece6;
import com.williamtygret.w.GalleryFragments.GalleryPiece7;
import com.williamtygret.w.GalleryFragments.GalleryPiece8;
import com.williamtygret.w.GalleryFragments.GalleryPiece9;

/**
 * Created by williamtygret on 3/22/16.
 */

//TO-DO: figure out how to pager adapter a dialog list rather than fragment
public class PagerAdapterGallery extends FragmentPagerAdapter {

    public PagerAdapterGallery(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new GalleryPiece1();
            case 1:
                return new GalleryPiece2();
            case 2:
                return new GalleryPiece3();
            case 3:
                return new GalleryPiece4();
            case 4:
                return new GalleryPiece5();
            case 5:
                return new GalleryPiece6();
            case 6:
                return new GalleryPiece7();
            case 7:
                return new GalleryPiece8();
            case 8:
                return new GalleryPiece9();
            case 9:
                return new GalleryPiece10();
            case 10:
                return new GalleryPiece11();
            case 11:
                return new GalleryPiece12();
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 12;
    }


}
