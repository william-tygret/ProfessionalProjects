package com.williamtygret.w.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.williamtygret.w.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by williamtygret on 3/21/16.
 */
public class ResumeFragment extends Fragment {

    android.support.v7.widget.CardView mAboutCardView;
    TextView mAboutTitle;
    TextView mAboutDesc;
    android.support.v7.widget.CardView mResumeCardView;
    TextView mResumeExpGA;
    TextView mResumeGADesc;
    TextView mResumeExpRoomi;
    TextView mResumeRoomiDesc;
    TextView mResumeExpGalison;
    TextView mResumeGalisonDesc;
    TextView mResumeExpSterling;
    TextView mResumeSterlingDesc;
    TextView mResumeExpOKC;
    TextView mResumeOKCDesc;

    android.support.v7.widget.CardView mEduCardView;
    TextView mEduGADesc;
    TextView mEduOCUDesc;

    android.support.v7.widget.CardView mSkillsCardView;
    LinearLayout mLinear1;
    LinearLayout mLinear2;

    Button mContactSendButton;
    EditText mResumeEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
       final View view = inflater.inflate(R.layout.fragment_resume, container, false);

        mAboutDesc = (TextView)view.findViewById(R.id.resumeAboutDesc);
        mAboutCardView = (android.support.v7.widget.CardView) view.findViewById(R.id.aboutCardView);
        mAboutCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAboutDesc.getText().equals(" ")){
                    mAboutDesc.setVisibility(View.VISIBLE);
                    mAboutCardView.setCardBackgroundColor(getResources().getColor(R.color.resume));
                    mAboutDesc.setText("A Material Design/front-end driven Android Developer looking to make beautiful apps and to contribute to, build upon, and improve the concept of the ideal User Experience. \n\n\"Why do the Yankees always win? Because the other team's too busy looking at their pinstripes.\"");
                }else{
                    mAboutDesc.setText(" ");
                    mAboutCardView.setCardBackgroundColor(getResources().getColor(R.color.resumetrans));
                    mAboutDesc.setVisibility(View.GONE);
                }

            }
        });

        mResumeExpGA = (TextView)view.findViewById(R.id.resumeExpGA);
        mResumeGADesc = (TextView)view.findViewById(R.id.resumeGADesc);
        mResumeExpRoomi = (TextView)view.findViewById(R.id.resumeExpRoomi);
        mResumeRoomiDesc = (TextView)view.findViewById(R.id.resumeRoomiDesc);
        mResumeExpGalison = (TextView)view.findViewById(R.id.resumeExpGalison);
        mResumeGalisonDesc = (TextView)view.findViewById(R.id.resumeGalisonDesc);
        mResumeExpSterling = (TextView)view.findViewById(R.id.resumeExpSterling);
        mResumeSterlingDesc = (TextView)view.findViewById(R.id.resumeSterlingDesc);
        mResumeExpOKC = (TextView)view.findViewById(R.id.resumeExpOKC);
        mResumeOKCDesc = (TextView)view.findViewById(R.id.resumeOKCDesc);

        mResumeCardView = (android.support.v7.widget.CardView)view.findViewById(R.id.expCardView);
        mResumeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mResumeGADesc.getText().equals(" ")) {
                    mResumeCardView.setCardBackgroundColor(getResources().getColor(R.color.resume));
                    mResumeExpGA.setText("General Assembly -- Android Development Immersive");
                    mResumeGADesc.setText("Programming functional Android Apps with Java and xml\n" +
                            "Implementing design principles to create visually friendly Apps\n" +
                            "Utilizing Android Studio as an integrated development environment to build Android apps Integrating Google Play Services, Google’s Material Design, third-party API’s and Libraries Work collaboratively with fellow developers in order to plan out an entire design sprint, from research, ideation, definition, and execution of an app idea.\n" +
                            "Test and iterate an app’s concept and mechanics through various different prototyping methods: from paper to digital.");
                    mResumeGADesc.setVisibility(View.VISIBLE);
                    mResumeExpRoomi.setText("Roomi -- Field Marketer/Creative Strategist");
                    mResumeRoomiDesc.setText("Developed strategies to acquire new users to download the Roomi app\n" +
                            "Implemented field marketing tactics in high traffic public areas and coordinated events Created positive relationships with the Roomi brand and its users\n" +
                            "Worked in a fast-paced startup environment, being available for any job needed");
                    mResumeRoomiDesc.setVisibility(View.VISIBLE);
                    mResumeExpGalison.setText("Galison/Mudpuppy -- Marketing/Communications Assistant");
                    mResumeGalisonDesc.setText("Assisted with the catalog organization of the new website, blog, and social media accounts Formed social media strategies and tactics to boost online presence daily\n" +
                            "Designed and created a series of email blasts to send to mailing list customers\n" +
                            "Evaluated media research and internal brand evaluation");
                    mResumeGalisonDesc.setVisibility(View.VISIBLE);
                    mResumeExpSterling.setText("Sterling Brands -- Design Strategy/Operations Intern");
                    mResumeSterlingDesc.setText("Conducted industry research to gain insight and areas of opportunity for potential clients Interpreted consumer market research for current clients such as Gillette & Green Mt. Coffee Assisted the Design Strategy team to build client proposals for 4 national brands\n" +
                            "Sourced images for the Multimedia Department\n" +
                            "Attended and assisted in the setup of new product photo shoots\n" +
                            "Assisted Design Operations Manager to conduct daily inventory lists of studio resources");
                    mResumeSterlingDesc.setVisibility(View.VISIBLE);
                    mResumeExpOKC.setText("Oklahoma City Thunder -- Promotions/Events");
                    mResumeOKCDesc.setText("Helped promote a newly formed NBA basketball team to acquire new fans\n" +
                            "Assisted with all event planning and promotions\n" +
                            "Managed a team of volunteers to efficiently prepare arena for games\n" +
                            "Collaborated with customer relations team to create business strategies to raise attendance");
                    mResumeOKCDesc.setVisibility(View.VISIBLE);
                }else{
                    mResumeGADesc.setText(" ");
                    mResumeGADesc.setVisibility(View.GONE);
                    mResumeExpGA.setText("General Assembly");
                    mResumeCardView.setCardBackgroundColor(getResources().getColor(R.color.resumetrans));
                    mResumeGalisonDesc.setVisibility(View.GONE);
                    mResumeExpGalison.setText("Galison/Mudpuppy");
                    mResumeRoomiDesc.setVisibility(View.GONE);
                    mResumeExpRoomi.setText("Roomi");
                    mResumeSterlingDesc.setVisibility(View.GONE);
                    mResumeExpSterling.setText("Sterling Brands");
                    mResumeOKCDesc.setVisibility(View.GONE);
                    mResumeExpOKC.setText("Oklahoma City Thunder");
                }
            }
        });

        mEduOCUDesc = (TextView)view.findViewById(R.id.resumeOCUDesc);
        mEduGADesc = (TextView)view.findViewById(R.id.resumeGAEduDesc);
        mEduCardView = (android.support.v7.widget.CardView)view.findViewById(R.id.eduCardView);
        mEduCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEduGADesc.getText().equals(" ")){
                    mEduGADesc.setVisibility(View.VISIBLE);
                    mEduCardView.setCardBackgroundColor(getResources().getColor(R.color.resume));
                    mEduGADesc.setText("Android Development Immersive");
                    mEduOCUDesc.setVisibility(View.VISIBLE);
                    mEduOCUDesc.setText("B.A. Communications, Minor in Graphic Design");
                }else{
                    mEduGADesc.setText(" ");
                    mEduGADesc.setVisibility(View.GONE);
                    mEduCardView.setCardBackgroundColor(getResources().getColor(R.color.resumetrans));
                    mEduOCUDesc.setVisibility(View.GONE);
                }
            }
        });

        mLinear1 = (LinearLayout)view.findViewById(R.id.skillsLinear1);
        mLinear2 = (LinearLayout)view.findViewById(R.id.skillsLinear2);
        mSkillsCardView = (android.support.v7.widget.CardView)view.findViewById(R.id.skillsCardView);
        mSkillsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mLinear1.getVisibility()==View.GONE){
                    mLinear1.setVisibility(View.VISIBLE);
                    mLinear2.setVisibility(View.VISIBLE);
                    mSkillsCardView.setCardBackgroundColor(getResources().getColor(R.color.resume));
                }else{
                    mLinear1.setVisibility(View.GONE);
                    mLinear2.setVisibility(View.GONE);
                    mSkillsCardView.setCardBackgroundColor(getResources().getColor(R.color.resumetrans));
                }
            }
        });




        mContactSendButton = (Button)view.findViewById(R.id.contactSendButton);
        mResumeEditText = (EditText)view.findViewById(R.id.contactEmailInputAddress);

        mContactSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.resumega);
                String extStorageDirectory = Environment.getExternalStorageDirectory().toString();

                File file = new File(extStorageDirectory, "resumega.png");
                try {
                    FileOutputStream outStream = new FileOutputStream(file);
                    bm.compress(Bitmap.CompressFormat.PNG, 100, outStream);
                    outStream.flush();
                    outStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + mResumeEditText.getText().toString()));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "William Tygret -- Resume");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Resume:   http://imgur.com/jsUDgO9");
                emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));



                try {
                    startActivity(Intent.createChooser(emailIntent, "Send email using..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity(), "Email Unable to Connect", Toast.LENGTH_SHORT).show();
                }

                mResumeEditText.setText("");
            }
        });



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

    }

//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        super.onLayout(changed, l, t, r, b);
//        for (int i = 0; i < getChildCount(); i++) {
//            animate(getChildAt(i), i);
//
//            if (i == getChildCount() - 1) {
//                getHandler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        mScrollable = true;
//                    }
//                }, i * 100);
//            }
//        }
//    }
//
//    private void animate(View view, final int pos) {
//        view.animate().cancel();
//        view.setTranslationY(100);
//        view.setAlpha(0);
//        view.animate().alpha(1.0f).translationY(0).setDuration(500).setStartDelay(pos * 200);
//    }
}
