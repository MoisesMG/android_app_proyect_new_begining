package app.rojoyazul.com.android_app_project_new_begening;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.github.ksoichiro.android.observablescrollview.ObservableListView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ObservableScrollViewCallbacks {

    Firebase rootRef = new Firebase("https://androidappprojectnewbegening.firebaseio.com/");
    ArrayList <Level> array_levels = new ArrayList<Level>();
    Button mBtnLevel1, mBtnLevel2, mBtnLevel3, mBtnLevel4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ObservableScrollView scrollView = (ObservableScrollView) findViewById(R.id.activity_main);
        scrollView.setScrollViewCallbacks(this);

        /** establecer icono en el action bar**/
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        /**************************************/

        /**** buscar botones por id ******/
        mBtnLevel1 = (Button) findViewById(R.id.btnLevel1);
        mBtnLevel2 = (Button) findViewById(R.id.btnLevel2);
        mBtnLevel3 = (Button) findViewById(R.id.btnLevel3);
        mBtnLevel4 = (Button) findViewById(R.id.btnLevel4);
        /*******************************/

        /************ establecer titulo de los botones ****************
         mBtnLevel1.setText(array_levels.get(0).getTitle());
         mBtnLevel2.setText(array_levels.get(1).getTitle());
         mBtnLevel3.setText(array_levels.get(2).getTitle());
         mBtnLevel4.setText(array_levels.get(3).getTitle());
         /*************************************************************/


        Firebase levelsRef = rootRef.child("levels");
        levelsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                array_levels.clear();
                Map<String, Map<String, String>> levels = dataSnapshot.getValue(Map.class);
                Iterator it_levels = levels.keySet().iterator();
                while (it_levels.hasNext()) {
                    String key = (String) it_levels.next();
                    Map<String, String> levelFeature = levels.get(key);
                    String code = levelFeature.get("code");
                    String title = levelFeature.get("title");
                    Level level_temp = new Level(code, title);
                    array_levels.add(level_temp);
                }//fin de while

                Collections.sort(array_levels, new Comparator<Level>() {
                    @Override
                    public int compare(Level o1, Level o2) {
                        return Integer.valueOf(o1.code) > Integer.valueOf(o2.code) ? 1 :
                                (Integer.valueOf(o1.code) < Integer.valueOf(o2.code)) ? -1 : 0;
                    }
                });
                mBtnLevel1.setText(array_levels.get(0).getTitle());
                mBtnLevel2.setText(array_levels.get(1).getTitle());
                mBtnLevel3.setText(array_levels.get(2).getTitle());
                mBtnLevel4.setText(array_levels.get(3).getTitle());
            }//fin del metodo

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }//fin del metodo
        });

        /****************++ navegacion entre actividades *******************/
        mBtnLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SubjectSelection.class);
                Bundle sendIt = new Bundle();
                sendIt.putString("code",array_levels.get(0).getCode());
                i.putExtras(sendIt);
                startActivityForResult(i, 1);
            }
        });

        mBtnLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SubjectSelection.class);
                Bundle sendIt = new Bundle();
                sendIt.putString("code",array_levels.get(1).getCode());
                i.putExtras(sendIt);
                startActivityForResult(i, 1);
            }
        });


        mBtnLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SubjectSelection.class);
                Bundle sendIt = new Bundle();
                sendIt.putString("code",array_levels.get(2).getCode());
                i.putExtras(sendIt);
                startActivityForResult(i, 1);
            }
        });

        mBtnLevel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SubjectSelection.class);
                Bundle sendIt = new Bundle();
                sendIt.putString("code",array_levels.get(3).getCode());
                i.putExtras(sendIt);
                startActivityForResult(i, 1);
            }
        });
        /***********************************************/
    }//fin del metodo

    @Override
    protected void onStart() {
        super.onStart();

    }//fin del metodo

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }//fin del metodo

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_credits:
                Intent i = new Intent(MainActivity.this, CreditsActivity.class);
                startActivity(i);
                return true;

            case R.id.action_suggestion:
                Intent in = new Intent(MainActivity.this, SuggestionsActivity.class);
                startActivity(in);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }//fin del metodo

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        ActionBar ab = getSupportActionBar();
        if (ab == null) {
            return;
        }
        if (scrollState == ScrollState.UP) {
            if (ab.isShowing()) {
                ab.hide();
            }
        } else if (scrollState == ScrollState.DOWN) {
            if (!ab.isShowing()) {
                ab.show();
            }
        }
    }//fin del metodo
}//(fin de la clase
