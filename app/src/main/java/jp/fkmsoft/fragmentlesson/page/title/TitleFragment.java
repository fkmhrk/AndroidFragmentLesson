package jp.fkmsoft.fragmentlesson.page.title;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import jp.fkmsoft.fragmentlesson.R;
import jp.fkmsoft.fragmentlesson.page.main.MainFragment;

/**
 * タイトル画面
 */
public class TitleFragment extends Fragment {
    @InjectView(R.id.edit_name)
    EditText mNameEdit;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_title, container, false);
        ButterKnife.inject(this, root);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick(R.id.button_start)
    void startClicked() {
        // Lesson 3と5 の回答
        String name = mNameEdit.getText().toString();

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.addToBackStack("tag");
        transaction.replace(R.id.container, MainFragment.newInstance(name));
        transaction.commit();
    }


}
