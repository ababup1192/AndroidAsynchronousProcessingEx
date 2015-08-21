package org.ababup1192.async;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView textView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // Handlerを使い別スレッドからメッセージを受け取り、結果をUIスレッドへ反映する。
                if (msg.what == 1) {
                }
            }
        };

        // 別スレッドで時間の掛かる計算をする。そして、その得られた結果をHandlerへ送る。
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 時間が掛かる計算を書きましょう。

                // 計算結果をHandlerへメッセージとして送りましょう。
                Message message = Message.obtain(handler, 1, "送りたいオブジェクト");
                handler.sendMessage(message);
            }
        }).start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
