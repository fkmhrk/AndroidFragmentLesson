package jp.fkmsoft.fragmentlesson.page.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import jp.fkmsoft.fragmentlesson.R;

/**
 * メイン画面
 */
public class MainFragment extends Fragment {

    private static final String ARGS_NAME = "name";

    public static MainFragment newInstance(String name) {
        MainFragment fragment = new MainFragment();

        Bundle args = new Bundle();
        args.putString(ARGS_NAME, name);
        fragment.setArguments(args);

        return fragment;
    }

    @InjectView(R.id.text_name)
    TextView mNameText;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.inject(this, root);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Lesson 5の回答
        Bundle args = getArguments();
        String name = args.getString(ARGS_NAME);
        mNameText.setText(name + "さんこんにちはこんにちは！");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        ButterKnife.reset(this);
    }

    @OnClick(R.id.button_my_list)
    void myListClicked() {
        // Lesson 4の回答
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.contents, new MyListFragment());

        transaction.commit();
    }

    @OnClick(R.id.button_settings)
    void settingsClicked() {
        // Lesson 4の回答
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.contents, new SettingsFragment());

        transaction.commit();
    }
}
