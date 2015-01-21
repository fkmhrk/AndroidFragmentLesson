package jp.fkmsoft.fragmentlesson.page.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.fkmsoft.fragmentlesson.R;

/**
 * メイン画面
 */
public class MainFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.inject(this, root);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        ButterKnife.reset(this);
    }

    @OnClick(R.id.button_my_list)
    void myListClicked() {
        // Lesson 4.
        // R.id.contentsに、MyListFragmentを張り付けよう
    }

    @OnClick(R.id.button_settings)
    void settingsClicked() {
        // Lesson 4.
        // R.id.contentsに、SettingsFragmentを張り付けよう
    }
}
