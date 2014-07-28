package dmhnorth.lifecycle.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.text.format.Time;

/**
 * This is a demonstration of how Android copes with the necessary interuptability of running Apps
 * The functions here are written in order of event handler level.
 *
 * onCreate() and onDestroy() being the most significant when an activity is started and stopped
 *
 * onStart() and onStop() bracket activity when the App is visible
 * main use of onStart and onStop is to give the app an opportunity
 * to monitor any changes that might affect it while not interacting with the user.
 *
 * onResume() and onPause() bracket the period the app
 * is in the foreground interacting with the user
 *
 */
public class MainActivity extends ActionBarActivity {

    private TextView textView;

    public MainActivity() {
    }

    //Method for getting the time
    private String getTime() {
        Time now = new Time();
        now.setToNow();
        return String.valueOf(now.hour + ":" + now.minute + ":" + now.second + " - " );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setup the layout format on creation of an Activity
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);

        //Looks for a savedInstance of the TextEdit input box and loads it
        if (savedInstanceState != null) {
            textView.setText(
                    savedInstanceState.getCharSequence(String.valueOf(R.string.myTextConstant)));
        }

        textView.append(getTime() + "onCreate()" + "\n");

    }


    @Override
    protected void onStart() {
        super.onStart();
        textView.append(getTime() + "onStart()" + "\n");
    }

    @Override
    protected void onPause() {
        super.onPause();
        textView.append(getTime() + "onPause()" + "\n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        textView.append(getTime() + "onResume()" + "\n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        textView.append(getTime() + "onStop()" + "\n");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        textView.append(getTime() + "onRestart()" + "\n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textView.append(getTime() + "onDestroy()" + "\n");

    }


    //For persisting the TextView between
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putCharSequence(getString(R.string.myTextConstant),textView.getText());
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
