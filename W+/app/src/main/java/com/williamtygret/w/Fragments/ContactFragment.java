package com.williamtygret.w.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.williamtygret.w.R;

/**
 * Created by williamtygret on 3/21/16.
 */
public class ContactFragment extends Fragment {

    Button mSendButton;
    EditText mEmailEditText;
    EditText mBodyEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        mEmailEditText = (EditText)view.findViewById(R.id.contactEmailInputAddress);
        mBodyEditText = (EditText)view.findViewById(R.id.contactEmailInput);
        mSendButton = (Button)view.findViewById(R.id.contactSendButton);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + "wctygret@gmail.com"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, mEmailEditText.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_TEXT, mBodyEditText.getText().toString());

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send email using..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity(), "Email Unable to Connect", Toast.LENGTH_SHORT).show();
                }

                mEmailEditText.setText("");
                mBodyEditText.setText("");
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
