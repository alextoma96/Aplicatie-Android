package com.example.intern.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends Fragment {
    /*Bundle bundle = this.getArguments();
    int ceva = bundle.getInt("ceva");*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Details");
        mTextMessage = (TextView) getActivity().findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) getActivity().findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    private TextView mTextMessage;

    private void initCampuri(){
        TextView dt = (TextView) getActivity().findViewById(R.id.dtEstEm);
        dt.setVisibility(View.INVISIBLE);
    }

    private void setDateGenerale(){
        TextView dt = (TextView) getActivity().findViewById(R.id.dtEstEm);
        Bundle bundle = this.getArguments();
        dt.setVisibility(View.VISIBLE);
        dt.setText(bundle.getString("ceva"));
    }

    private void setFurnizori(){
        TextView dt = (TextView) getActivity().findViewById(R.id.dtEstEm);
        dt.setVisibility(View.VISIBLE);
        dt.setText("15/09/2017");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            initCampuri();

            switch (item.getItemId()) {
                case R.id.navigation_dateGenerale:
                    setDateGenerale();

                    mTextMessage.setText(R.string.title_dateGenerale);
                    return true;
                case R.id.navigation_furnizori:
                    setFurnizori();
                    mTextMessage.setText(R.string.title_furnizor);
                    return true;
                case R.id.navigation_client:
                    mTextMessage.setText(R.string.title_client);
                    return true;
            }
            return false;
        }

    };

}
