package jp.fkmsoft.fragmentlesson.page.title;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.fkmsoft.fragmentlesson.R;

/**
 * タイトル画面
 */
public class TitleFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_title, container, false);

        // Lesson 2. Buttonを押したらToastが出るようにしてみよう
        // ButterKnife使ってもいいよ

        return root;
    }
}
