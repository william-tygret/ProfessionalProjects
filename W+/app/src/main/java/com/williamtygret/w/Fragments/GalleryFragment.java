package com.williamtygret.w.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.williamtygret.w.R;

/**
 * Created by williamtygret on 3/21/16.
 */
public class GalleryFragment extends Fragment {

    ImageView mImageOne;
    ImageView mImageTwo;
    ImageView mImageThree;
    ImageView mImageFour;
    ImageView mImageFive;
    ImageView mImageSix;
    ImageView mImageSeven;
    ImageView mImageEight;
    ImageView mImageNine;
    ImageView mImageTen;
    ImageView mImageEleven;
    ImageView mImageTwelve;
    ImageView mDialogImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        mImageOne = (ImageView)view.findViewById(R.id.galleryThumb1);
        mImageOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog1 = new Dialog(getActivity());
                dialog1.setTitle("War Horses -- Mixed Media");
                dialog1.setContentView(R.layout.dialog_gallery);
                mDialogImage = (ImageView)dialog1.findViewById(R.id.galleryImg);
                mDialogImage.setImageResource(R.drawable.grandpahorse);
                dialog1.show();
                mDialogImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });
            }
        });

        mImageTwo = (ImageView)view.findViewById(R.id.galleryThumb2);
        mImageTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog2 = new Dialog(getActivity());
                dialog2.setTitle("Pokemon/Luna Sketches -- Ink on Paper");
                dialog2.setContentView(R.layout.dialog_gallery);
                mDialogImage = (ImageView)dialog2.findViewById(R.id.galleryImg);
                mDialogImage.setImageResource(R.drawable.pokedoodles);
                dialog2.show();
                mDialogImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2.dismiss();
                    }
                });
            }
        });


        mImageThree = (ImageView)view.findViewById(R.id.galleryThumb3);
        mImageThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog3 = new Dialog(getActivity());
                dialog3.setTitle("SeaCat -- Watercolor");
                dialog3.setContentView(R.layout.dialog_gallery);
                mDialogImage = (ImageView)dialog3.findViewById(R.id.galleryImg);
                mDialogImage.setImageResource(R.drawable.watercolor);
                dialog3.show();
                mDialogImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog3.dismiss();
                    }
                });
            }
        });

        mImageFour = (ImageView)view.findViewById(R.id.galleryThumb4);
        mImageFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog4 = new Dialog(getActivity());
                dialog4.setTitle("Lord Rhombus -- Ink on Paper");
                dialog4.setContentView(R.layout.dialog_gallery);
                mDialogImage = (ImageView)dialog4.findViewById(R.id.galleryImg);
                mDialogImage.setImageResource(R.drawable.rhombus);
                dialog4.show();
                mDialogImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog4.dismiss();
                    }
                });
            }
        });

        mImageFive = (ImageView)view.findViewById(R.id.galleryThumb5);
        mImageFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog5 = new Dialog(getActivity());
                dialog5.setTitle("Nightman -- Clay");
                dialog5.setContentView(R.layout.dialog_gallery);
                mDialogImage = (ImageView)dialog5.findViewById(R.id.galleryImg);
                mDialogImage.setImageResource(R.drawable.nightman);
                dialog5.show();
                mDialogImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog5.dismiss();
                    }
                });
            }
        });

        mImageSix = (ImageView)view.findViewById(R.id.galleryThumb6);
        mImageSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog6 = new Dialog(getActivity());
                dialog6.setTitle("Sk8 or Die -- Ink on Paper");
                dialog6.setContentView(R.layout.dialog_gallery);
                mDialogImage = (ImageView)dialog6.findViewById(R.id.galleryImg);
                mDialogImage.setImageResource(R.drawable.ratigan);
                dialog6.show();
                mDialogImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog6.dismiss();
                    }
                });
            }
        });


        mImageSeven = (ImageView)view.findViewById(R.id.galleryThumb7);
        mImageSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog7 = new Dialog(getActivity());
                dialog7.setTitle("Moog -- Ink on Paper");
                dialog7.setContentView(R.layout.dialog_gallery);
                mDialogImage = (ImageView)dialog7.findViewById(R.id.galleryImg);
                mDialogImage.setImageResource(R.drawable.moog);
                dialog7.show();
                mDialogImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog7.dismiss();
                    }
                });
            }
        });

        mImageEight = (ImageView)view.findViewById(R.id.galleryThumb8);
        mImageEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog8 = new Dialog(getActivity());
                dialog8.setTitle("Fertility Goddess Relic -- Mixed Media on Canvas");
                dialog8.setContentView(R.layout.dialog_gallery);
                mDialogImage = (ImageView)dialog8.findViewById(R.id.galleryImg);
                mDialogImage.setImageResource(R.drawable.fertilitygoddess);
                dialog8.show();
                mDialogImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog8.dismiss();
                    }
                });
            }
        });

        mImageNine = (ImageView)view.findViewById(R.id.galleryThumb9);
        mImageNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog9 = new Dialog(getActivity());
                dialog9.setTitle("Banditos -- Ink on Paper");
                dialog9.setContentView(R.layout.dialog_gallery);
                mDialogImage = (ImageView)dialog9.findViewById(R.id.galleryImg);
                mDialogImage.setImageResource(R.drawable.banditos);
                dialog9.show();
                mDialogImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog9.dismiss();
                    }
                });
            }
        });

        mImageTen = (ImageView)view.findViewById(R.id.galleryThumb10);
        mImageTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog10 = new Dialog(getActivity());
                dialog10.setTitle("Sheriff Cat -- Ink on Paper");
                dialog10.setContentView(R.layout.dialog_gallery);
                mDialogImage = (ImageView)dialog10.findViewById(R.id.galleryImg);
                mDialogImage.setImageResource(R.drawable.cowboycat);
                dialog10.show();
                mDialogImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog10.dismiss();
                    }
                });
            }
        });

        mImageEleven = (ImageView)view.findViewById(R.id.galleryThumb11);
        mImageEleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog11 = new Dialog(getActivity());
                dialog11.setTitle("Mason O'Brien -- Ink on Paper");
                dialog11.setContentView(R.layout.dialog_gallery);
                mDialogImage = (ImageView)dialog11.findViewById(R.id.galleryImg);
                mDialogImage.setImageResource(R.drawable.mason);
                dialog11.show();
                mDialogImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog11.dismiss();
                    }
                });
            }
        });

        mImageTwelve = (ImageView)view.findViewById(R.id.galleryThumb12);
        mImageTwelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog12 = new Dialog(getActivity());
                dialog12.setTitle("Nude with Chair -- Ink on Paper");
                dialog12.setContentView(R.layout.dialog_gallery);
                mDialogImage = (ImageView)dialog12.findViewById(R.id.galleryImg);
                mDialogImage.setImageResource(R.drawable.girlchair);
                dialog12.show();
                mDialogImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog12.dismiss();
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
