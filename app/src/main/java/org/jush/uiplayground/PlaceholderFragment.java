package org.jush.uiplayground;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.jush.uiplayground.views.HomeView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment implements HomeView {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    @InjectView(R.id.device_container)
    GridLayout deviceContainer;

    /**
     * Use {@link #newInstance(int)}
     */
    @Deprecated
    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addDevice(R.string.app_name, android.R.drawable.sym_def_app_icon);
            }
        }, 2000);
    }

    @Override
    public void addDevice(@StringRes int nameId, @DrawableRes int iconId) {
        GridLayout.Spec rowSpec = GridLayout.spec(0, 3, GridLayout.CENTER);
        GridLayout.Spec columnSpec = GridLayout.spec(4, 2, GridLayout.CENTER);
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(rowSpec, columnSpec);
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(iconId);
        deviceContainer.addView(imageView, layoutParams);
    }
}
