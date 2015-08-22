package hugosalamanca.picnic;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ListActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.Toast;


public class Listedecourse extends ActionBarActivity {
    ExpandableListView list_Boisson;
    ChaptersListAdapter Boissons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listedecourse);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listedecourse, menu);
        return true;
    }

    private void setupChaptersListView() {
        list_Boisson = (ExpandableListView)findViewById(R.id.list_Boisson);
        Boissons = new ChaptersListAdapter();
        elvChapters.setAdapter(elaAdapter);
        elvChapters.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String exerciseTitle = (String) elaAdapter.getChild(groupPosition, childPosition);
                Class<? extends Activity> exerciseClass = elaAdapter.getExerciseClass(groupPosition, childPosition, id);
                if (exerciseClass != null) {
                    Toast.makeText(DemoSelector.this, exerciseTitle, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(DemoSelector.this, exerciseClass));
                } else {
                    Toast.makeText(DemoSelector.this, "Exercise Not Available", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

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
