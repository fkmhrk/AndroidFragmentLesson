package jp.fkmsoft.fragmentlesson.page.title;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.fkmsoft.fragmentlesson.R;

/**
 * タイトル画面
 */
public class TitleFragment extends Fragment {
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
        // Lesson 2の回答
        Toast.makeText(getActivity(), "スタート", Toast.LENGTH_SHORT).show();

        FragmentManager manager = getFragmentManager();
        // Lesson 3.
        // ここにFragmentのreplaceを行う処理を書いてみよう
    }


}
