package ro.kabum.spatiidestocare;

import android.content.Context;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class MainActivity extends ActionBarActivity {
    String FILENAME = "hello_file";
    String string = "hello world!";
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);

        FileOutputStream fos = null;
        FileInputStream fis;
        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(string.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            fis = openFileInput(FILENAME);
            tv.setText( "textafisat: " + fis.read());
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
