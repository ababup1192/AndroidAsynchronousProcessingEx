package org.ababup1192.async;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class FactorialTask extends AsyncTaskLoader<Integer> {

    // 以下の処理を自由に拡張しましょう。
    public FactorialTask(Context context) {
        super(context);
    }

    @Override
    public Integer loadInBackground() {
        // 階乗を求める処理を書きましょう。
        return null;
    }
}
