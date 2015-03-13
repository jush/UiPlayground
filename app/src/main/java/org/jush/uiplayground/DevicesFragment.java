package org.jush.uiplayground;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.jush.uiplayground.injection.Dagger_DevicesFragmentComponent;
import org.jush.uiplayground.injection.DevicesFragmentComponent;
import org.jush.uiplayground.presenters.DevicesPresenter;
import org.jush.uiplayground.views.DevicesView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DevicesFragment extends Fragment implements DevicesView {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    @InjectView(R.id.device_container)
    GridLayout deviceContainer;
    @Inject
    DevicesPresenter presenter;
    private DevicesFragmentComponent component;

    /**
     * Use {@link #newInstance(int)}
     */
    @Deprecated
    public DevicesFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static DevicesFragment newInstance(int sectionNumber) {
        DevicesFragment fragment = new DevicesFragment();
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
        this.component = Dagger_DevicesFragmentComponent.builder()
                .applicationComponent(((UiPlaygroundApplication) getActivity().getApplication())
                        .getComponent())
                .build();
        component.inject(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.takeView(this);
        presenter.fetchAndAddDevices();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.dropView();
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
