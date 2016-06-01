package com.datarak.vehiclemaintenancereminder.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datarak.vehiclemaintenancereminder.MaintenanceApp;
import com.datarak.vehiclemaintenancereminder.R;

import butterknife.ButterKnife;

/**
 * Created by raheel on 5/10/16.
 */
public class BaseFragment extends Fragment {
    protected OnFragmentInteractionListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

        Tr  acker tracker = MaintenanceApp.getInstance().getDefaultTracker();
        tracker.setScreenName(getClass().getName());
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }



    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
        void setToolbarTitle(String title);
    }

    public void navigateTo(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().
                beginTransaction().
                setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_in_left).
                replace(R.id.container, fragment, fragment.getClass().getSimpleName()).
                addToBackStack(null);
        fragmentTransaction.commit();
    }
}
