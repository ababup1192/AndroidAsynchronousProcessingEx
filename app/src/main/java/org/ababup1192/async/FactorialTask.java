package org.ababup1192.async;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

public class FactorialTask extends AsyncTask<Integer, Integer, Integer> implements DialogInterface.OnCancelListener {
    private Context context;
    private Activity activity;
    private ProgressDialog dialog;

    public FactorialTask(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        // integers[0] が求める階乗の値

        // 階乗を求める処理を書いてみましょう。すぐ処理が終わらないように sleepも挟みましょう。
        // isCancelled() は、計算のキャンセル時にtrueを返します。

        return null;
    }


    // 計算が終了したので、計算結果を表示し、プログレスバーを消す。
    protected void onPostExecute(Integer result) {
        // ActivityからTextViewを取得し、結果を反映してみましょう。

        // ダイアログの消去
        dialog.dismiss();
    }

    // 計算の進捗をプログレスバーに反映。
    @Override
    protected void onProgressUpdate(Integer... values) {
        // publishProgress メソッドで、数字を可変長引数、valuesへ反映
        dialog.setProgress(values[0]);
    }

    @Override
    public void onCancel(DialogInterface dialogInterface) {
        // ActivityからTextViewを取得し、計算がキャンセルされたことを表示しましょう。

        cancel(true);
    }
}
