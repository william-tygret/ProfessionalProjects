package com.williamtygret.w.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.williamtygret.w.MainActivity;
import com.williamtygret.w.MusicPlayerService;
import com.williamtygret.w.R;

import static com.williamtygret.w.R.drawable.marble;

/**
 * Created by williamtygret on 3/21/16.
 */
public class AnimationFragment extends Fragment {

    Switch mSwitch;
    Intent musicPlayerIntent;
    ImageView profilePic;
    RelativeLayout background;
    TextView mName;
    TextView mDescription;
    TextView mLocation;
    ImageView mFlames;
    RelativeLayout fragmentBackground;
    ImageView stunnerImg;
    ImageView stonecold3;
    ImageView stonecold;
    ImageView stonecold2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view =  inflater.inflate(R.layout.fragment_animation, container, false);
        mSwitch = (Switch)view.findViewById(R.id.switch1);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                profilePic = (ImageView)getActivity().findViewById(R.id.profilePic);
                background = (RelativeLayout)getActivity().findViewById(R.id.backgroundView);
                mName = (TextView)getActivity().findViewById(R.id.textViewName);
                mDescription = (TextView)getActivity().findViewById(R.id.textViewDesc);
                mLocation = (TextView)getActivity().findViewById(R.id.textViewNewYork);
                mFlames = (ImageView)view.findViewById(R.id.imageViewflames);
                fragmentBackground = (RelativeLayout)view.findViewById(R.id.animBackground);
                stunnerImg = (ImageView)view.findViewById(R.id.stunnerImage);
                stonecold3 = (ImageView)view.findViewById(R.id.imageViewStoneCold3);
                stonecold = (ImageView)view.findViewById(R.id.imageViewStoneCold);
                stonecold2 = (ImageView)view.findViewById(R.id.imageViewStoneCold2);
                if(mSwitch.isChecked()) {
                    musicPlayerIntent = new Intent(getActivity(), MusicPlayerService.class);
                    getActivity().startService(musicPlayerIntent);
                    profilePic.setImageResource(R.drawable.stonecoldhead);
                    background.setBackgroundResource(R.drawable.hqdefault);
                    mName.setText("Stone Code Steve Austin");
                    mName.setTextColor(Color.WHITE);
                    mName.setTextSize(28);
                    mDescription.setTextColor(Color.WHITE);
                    fragmentBackground.setBackgroundColor(Color.TRANSPARENT);
                    mDescription.setText("Texas Rattlesnake");
                    mLocation.setTextColor(Color.WHITE);
                    stunnerImg.setVisibility(View.VISIBLE);
                    final Animation stunnerAnim = AnimationUtils.loadAnimation(getActivity(),R.anim.stunner );
                    stunnerAnim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            stonecold3.setVisibility(View.VISIBLE);
                            final Animation stonecold3Anim = AnimationUtils.loadAnimation(getActivity(), R.anim.stonecold3);
                            stonecold3Anim.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {

                                    stonecold.setVisibility(View.VISIBLE);
                                    final Animation stonecoldanim = AnimationUtils.loadAnimation(getActivity(), R.anim.stonecold);
                                    stonecoldanim.setAnimationListener(new Animation.AnimationListener() {
                                        @Override
                                        public void onAnimationStart(Animation animation) {

                                        }

                                        @Override
                                        public void onAnimationEnd(Animation animation) {
                                            stonecold2.setVisibility(View.VISIBLE);
                                            final Animation stonecold2anim = AnimationUtils.loadAnimation(getActivity(), R.anim.flamesrise);
                                            stonecold2anim.setAnimationListener(new Animation.AnimationListener() {
                                                @Override
                                                public void onAnimationStart(Animation animation) {

                                                }

                                                @Override
                                                public void onAnimationEnd(Animation animation) {
                                                    mFlames.setVisibility(View.VISIBLE);
                                                    final Animation fireanim = AnimationUtils.loadAnimation(getActivity(),R.anim.fire);
                                                    mFlames.startAnimation(fireanim);

                                                }

                                                @Override
                                                public void onAnimationRepeat(Animation animation) {

                                                }
                                            });
                                            stonecold2.startAnimation(stonecold2anim);
                                        }

                                        @Override
                                        public void onAnimationRepeat(Animation animation) {

                                        }
                                    });
                                    stonecold.startAnimation(stonecoldanim);
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                            stonecold3.startAnimation(stonecold3Anim);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    stunnerImg.startAnimation(stunnerAnim);
                   // fragmentBackground.setBackgroundColor(Color.TRANSPARENT);
                }else{
                    getActivity().stopService(musicPlayerIntent);
                    profilePic.setImageResource(R.drawable.willhead);
                    background.setBackgroundResource(R.drawable.marble);
                    mName.setText("William Conrad Tygret");
                    mName.setTextColor(Color.BLACK);
                    mDescription.setText("Android Developer | Digital/Fine Artist");
                    mDescription.setTextColor(Color.BLACK);
                    mLocation.setTextColor(Color.BLACK);
                    mFlames.setVisibility(View.GONE);
                    stonecold.setVisibility(View.GONE);
                    stonecold2.setVisibility(View.GONE);
                    stonecold3.setVisibility(View.GONE);
                    stunnerImg.setVisibility(View.GONE);
                    fragmentBackground.setBackgroundColor(getResources().getColor(R.color.animationtrans));

                }

            }
        });
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

}
