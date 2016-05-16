package com.datarak.vehiclemaintenancereminder.views;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by raheel on 5/10/16.
 */
public class BaseFragment extends Fragment {
    private OnFragmentInteractionListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public void navigateTo(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().
                beginTransaction().
                add(fragment, fragment.getClass().getSimpleName()).
                addToBackStack(null);
    }
}
