package hugosalamanca.picnic;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {
    // could use Activity but ActionBarActivity is better for large screens like tablets
    // Activity class provides visual interface for user interaction
    // Each Activity must have a single purpose
    // The class must have the same name as the file (I think)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // onCreate: called when the activity is created, just after being launched

        // Restore any saved state
        super.onCreate(savedInstanceState);

        // Set content view
        setContentView(R.layout.activity_main);

    }

    // onStart(): called when the activity becomes visible on the screen
    // onResume(): called after onStart, allow user to interact with the activity


    //@Override
   public boolean onCreateOptionsMenu(Menu menu) {
        // public means it can be called from other classes
        // Inflate the menu; this adds items to the action bar if it is present.
        // Inflates the menu means it takes the menu defined in xml file and put it under the : button
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // R. means resources
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

    public void listedecourse(View view) {
        // Do something in response to button
        // An Intent Object specifies the Activity that will be started from this activity
        Intent newIntent = new Intent(this, Listedecourse.class); // this is the context, i.e. interface that accesses global application information
        startActivity(newIntent);
    }

    public void listeinvites(View view) {
        // Do something in response to button
        Intent newIntent = new Intent(this, Listeinvites.class);
        startActivity(newIntent);
    }
}
