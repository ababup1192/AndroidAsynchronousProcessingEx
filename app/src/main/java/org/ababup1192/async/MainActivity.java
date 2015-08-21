package org.ababup1192.async;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Integer>, View.OnClickListener {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            textView.setText("計算中です...");
            // 以前のTaskを削除する。(何度でも計算できるようにするため)
            getSupportLoaderManager().destroyLoader(0);
            getSupportLoaderManager().initLoader(0, null, this);
        }
    }

    @Override
    public Loader<Integer> onCreateLoader(int i, Bundle bundle) {
        // コンストラクタの拡張に併せて、自由に変更して良い。
        Loader<Integer> loader = new FactorialTask(this);
        loader.forceLoad();
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Integer> loader, Integer result) {
        // 結果を反映しましょう。
        
    }

    @Override
    public void onLoaderReset(Loader<Integer> loader) {

    }

}
