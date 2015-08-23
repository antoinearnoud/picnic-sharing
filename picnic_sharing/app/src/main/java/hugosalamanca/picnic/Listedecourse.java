package hugosalamanca.picnic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;



public class Listedecourse extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listedecourse);

        expListView = (ExpandableListView) findViewById(R.id.list_Boissons);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });


        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Viande");
        listDataHeader.add("Alcohol");
        listDataHeader.add("Boissons");
        listDataHeader.add("Snacks");
        listDataHeader.add("Matériel");
        listDataHeader.add("Divers");


        // Adding child data
        List<String> Viande = new ArrayList<String>();
        Viande.add("Jambon blanc");
        Viande.add("Jambon cru");
        Viande.add("Saucisson");


        List<String> Alcohol = new ArrayList<String>();
        Alcohol.add("Martini");
        Alcohol.add("Vin Rouge");
        Alcohol.add("Vin Blanc");

        List<String> Boissons = new ArrayList<String>();
        Boissons.add("Jus d'orange");
        Boissons.add("Jus de pomme");
        Boissons.add("Jus autre");
        Boissons.add("Eau");

        List<String> Snacks = new ArrayList<String>();
        Snacks.add("Pâté");
        Snacks.add("Tarama");
        Snacks.add("Tsatsiki");
        Snacks.add("Chips");
        Snacks.add("Gâteau apéro");

        List<String> Matériel = new ArrayList<String>();
        Matériel.add("Nappe");
        Matériel.add("Ouvre bouteille");
        Matériel.add("Verres");
        Matériel.add("Assiettes");
        Matériel.add("Couverts");

        List<String> Divers = new ArrayList<String>();// pour le moment rien de précis
        Divers.add("Oublis");


        listDataChild.put(listDataHeader.get(0), Viande); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Alcohol);
        listDataChild.put(listDataHeader.get(2), Boissons);
        listDataChild.put(listDataHeader.get(3), Snacks);
        listDataChild.put(listDataHeader.get(4), Matériel);
        listDataChild.put(listDataHeader.get(5), Divers);
    }

}
