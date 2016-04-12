package com.williamtygret.w.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.williamtygret.w.R;

/**
 * Created by williamtygret on 3/21/16.
 */
public class ProjectsFragment extends Fragment {

    ImageView mPokedex;
    ImageView mHUD;
    ImageView mDialogImg;
    TextView mDialogText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_projects, container, false);

        mPokedex = (ImageView)view.findViewById(R.id.project1ImageView);
        mPokedex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog pokeDialog = new Dialog(getActivity());
                pokeDialog.setTitle("Pokedex");
                pokeDialog.setContentView(R.layout.dialog_projects_layout);
                pokeDialog.show();

                mDialogImg = (ImageView)pokeDialog.findViewById(R.id.imageViewDialog);
                mDialogImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pokeDialog.dismiss();
                    }
                });


            }
        });

        mDialogImg = (ImageView)view.findViewById(R.id.imageViewDialog);
        mDialogText = (TextView)view.findViewById(R.id.textViewDialog);
        mHUD = (ImageView)view.findViewById(R.id.project2ImageView);
        mHUD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog hudDialog = new Dialog(getActivity());
                hudDialog.setTitle("Heads-Up Display");
                hudDialog.setContentView(R.layout.hud_dialog_layout);
                hudDialog.show();

                mDialogImg = (ImageView)hudDialog.findViewById(R.id.imageViewDialog);
                mDialogImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hudDialog.dismiss();
                    }
                });
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
