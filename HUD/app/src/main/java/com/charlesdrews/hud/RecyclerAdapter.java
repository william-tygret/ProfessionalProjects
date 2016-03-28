package com.charlesdrews.hud;

import android.content.Context;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.TextView;

import com.charlesdrews.hud.CardsData.CardData;
import com.charlesdrews.hud.CardsData.CardType;
import com.charlesdrews.hud.CardsData.FacebookCardData;
import com.charlesdrews.hud.CardsData.MtaStatusCardData;
import com.charlesdrews.hud.CardsData.NewsCardData;
import com.charlesdrews.hud.CardsData.RemindersCardData;
import com.charlesdrews.hud.CardsData.WeatherCardData;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Add cards to the recycler view
 * Created by charlie on 3/7/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CardViewHolder> {
    private final ArrayList<CardType> mCardTypes = new ArrayList<>(Arrays.asList(CardType.values()));
    private List<CardData> mCardsData;
    public LoginButton mFacebookLoginButton;
    public static CallbackManager mCallbackManager;
    TextView mLoginText;
    private int lastPosition = -1;
    private Context context;
    public CardData container;


    public RecyclerAdapter(List<CardData> cardsData) {
        mCardsData = cardsData;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        if (viewType == -1) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);
            return new CardViewHolder(view, parent.getContext(), null);
        }

        CardType type = mCardTypes.get(viewType);

        switch (type) {
            case Weather: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_card, parent, false);
                return new WeatherCard(view, parent.getContext(), type);
            }
            case Facebook: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.facebook_card, parent, false);
                facebookLogin(view);
                return new FacebookCard(view, parent.getContext(), type);
            }
            case News: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);
                return new NewsCard(view, parent.getContext(), type);
            }
            case Reminders: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reminders_card, parent, false);
                return new RemindersCard(view, parent.getContext(), type);
            }
            case MtaStatus: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mta_card, parent, false);
                return new MtaStatusCard(view, parent.getContext(), type);
            }
            default:
                return new CardViewHolder(view, parent.getContext(), null);
        }
    }

    @Override
    public int getItemViewType(int position) {
        CardData cardData = mCardsData.get(position);
        if (cardData == null) {
            return -1;
        } else {
            CardType type = mCardsData.get(position).getType();
            return mCardTypes.indexOf(type);
        }
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, int position) {
        CardData data = mCardsData.get(position);

        if (holder == null || data == null) { return; }

        switch (holder.getCardType()) {
            case Weather: {
                if ( !(data instanceof WeatherCardData) ) { return; }
                WeatherCard weatherCard = (WeatherCard) holder;
                WeatherCardData weatherData = (WeatherCardData) data;

                weatherCard.mHighTemp.setText("High temp: " + weatherData.getHighTemp());
                weatherCard.mLowTemp.setText("Low temp: " + weatherData.getLowTemp());
                break;
            }
            case Facebook: {
                if ( !(data instanceof FacebookCardData) ) { return; }
                FacebookCard facebookCard = (FacebookCard) holder;
                FacebookCardData facebookData = (FacebookCardData) data;

                LinearLayoutManager layoutManager = new LinearLayoutManager(holder.mContext);
                facebookCard.mRecyclerView.setLayoutManager(layoutManager);

                facebookCard.mRecyclerView.addItemDecoration(
                        new DividerItemDecoration(holder.mContext));

                FacebookRecyclerAdapter adapter = new FacebookRecyclerAdapter(facebookData.getFacebookItems());
                facebookCard.mRecyclerView.setAdapter(adapter);
                break;
            }
            case News: {
                if ( !(data instanceof NewsCardData) ) { return; }
                NewsCard newsCard = (NewsCard) holder;
                NewsCardData newsCardData = (NewsCardData) data;

                LinearLayoutManager layoutManager = new LinearLayoutManager(holder.mContext);
                newsCard.mNewsRecyclerView.setLayoutManager(layoutManager);

                newsCard.mNewsRecyclerView.addItemDecoration(
                        new DividerItemDecoration(holder.mContext));

                NewsRecyclerAdapter adapter = new NewsRecyclerAdapter(newsCardData.getNewsItems());
                newsCard.mNewsRecyclerView.setAdapter(adapter);
                break;
            }
            case Reminders: {
                if ( !(data instanceof RemindersCardData) ) { return; }
                RemindersCard remindersCard = (RemindersCard) holder;
                RemindersCardData remindersCardData = (RemindersCardData) data;

                LinearLayoutManager layoutManager = new LinearLayoutManager(holder.mContext);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                remindersCard.mRemindersRecyclerView.setLayoutManager(layoutManager);

                remindersCard.mRemindersRecyclerView.addItemDecoration(
                        new DividerItemDecoration(holder.mContext));

                RemindersRecyclerAdapter adapter = new RemindersRecyclerAdapter(remindersCardData.getReminders());
                remindersCard.mRemindersRecyclerView.setAdapter(adapter);

                remindersCard.mAddReminderButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new ReminderCreator(holder.mContext).launchDialog();
                    }
                });
                break;
            }
            case MtaStatus: {
                if ( !(data instanceof MtaStatusCardData) ) { return; }
                MtaStatusCard mtaStatusCard = (MtaStatusCard) holder;
                MtaStatusCardData mtaStatusCardData = (MtaStatusCardData) data;

                mtaStatusCard.mWebView.getSettings().setJavaScriptEnabled(true);
                mtaStatusCard.mWebView.loadUrl(mtaStatusCardData.getWidgetUrl());
                break;
            }
            default:
                break;
        }
        if (isPreLollipopDevice()) {
            holder.mCardView.setPreventCornerOverlap(false);
        }
    }

    @Override
    public int getItemCount() {
        return mCardsData.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        Context mContext;
        CardType mCardType;
        CardView mCardView;

        public CardViewHolder(View itemView, Context context, CardType cardType) {
            super(itemView);
            mContext = context;
            mCardType = cardType;
        }

        public CardType getCardType() {
            return mCardType;
        }
    }

    public class WeatherCard extends CardViewHolder {
        TextView mHighTemp, mLowTemp;

        public WeatherCard(View itemView, Context context, CardType cardType) {
            super(itemView, context, cardType);
            mHighTemp = (TextView) itemView.findViewById(R.id.textViewLow);
            mLowTemp = (TextView) itemView.findViewById(R.id.textViewLow);
            mCardView = (CardView) itemView.findViewById(R.id.weatherCard);
        }
    }

    public class FacebookCard extends CardViewHolder {
        RecyclerView mRecyclerView;

        public FacebookCard(View itemView, Context context, CardType cardType) {
            super(itemView, context, cardType);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.facebookRecyclerView);
            mCardView = (CardView) itemView.findViewById(R.id.facebookCard);
        }
    }

    public class NewsCard extends CardViewHolder {
        RecyclerView mNewsRecyclerView;

        public NewsCard(View itemView, Context context, CardType cardType) {
            super(itemView, context, cardType);
            mNewsRecyclerView = (RecyclerView) itemView.findViewById(R.id.newsRecyclerView);
            mCardView = (CardView) itemView.findViewById(R.id.newsCard);
        }
    }

    public class RemindersCard extends CardViewHolder {
        RecyclerView mRemindersRecyclerView;
        FloatingActionButton mAddReminderButton;

        public RemindersCard(View itemView, Context context, CardType cardType) {
            super(itemView, context, cardType);
            mRemindersRecyclerView = (RecyclerView) itemView.findViewById(R.id.remindersRecyclerView);
            mAddReminderButton = (FloatingActionButton) itemView.findViewById(R.id.addReminderButton);
            mCardView = (CardView) itemView.findViewById(R.id.remindersCard);
        }
    }

    public class MtaStatusCard extends CardViewHolder {
        WebView mWebView;

        public MtaStatusCard(View itemView, Context context, CardType cardType) {
            super(itemView, context, cardType);
            mWebView = (WebView) itemView.findViewById(R.id.mtaWebView);
            mCardView = (CardView) itemView.findViewById(R.id.mtaStatusCard);
        }
    }

    public void facebookLogin(View view){
        mFacebookLoginButton = (LoginButton)view.findViewById(R.id.login_button);
        mFacebookLoginButton.setReadPermissions("user_likes");
        mCallbackManager = CallbackManager.Factory.create();
        mFacebookLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
//                        Toast.makeText(MainActivity.class, "Logged in successfully", Toast.LENGTH_SHORT).show();
                       mLoginText.setText("User ID: " + loginResult.getAccessToken().getUserId() + "Auth token: " + loginResult.getAccessToken().getToken());

            }

            @Override
            public void onCancel() {
//                        Toast.makeText(MainActivity.this, "Login canceled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
//                        Toast.makeText(MainActivity.this, "Login error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isPreLollipopDevice() {
        return (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP);
    }
}
