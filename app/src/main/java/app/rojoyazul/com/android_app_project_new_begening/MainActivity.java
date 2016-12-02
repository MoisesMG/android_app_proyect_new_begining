package app.rojoyazul.com.android_app_project_new_begening;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView mText;
    Firebase rootRef = new Firebase("https://androidappprojectnewbegening.firebaseio.com/");
    ArrayList <Level> array_levels = new ArrayList<Level>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = (TextView) findViewById(R.id.textviewPrueba);
    }//fin del metodo

    @Override
    protected void onStart() {
        super.onStart();
        Firebase levelsRef = rootRef.child("levels");
        levelsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map <String, Map<String,String> >levels = dataSnapshot.getValue(Map.class);
                Iterator it_levels = levels.keySet().iterator();
                while (it_levels.hasNext()){
                    String key = (String) it_levels.next();
                    Map<String,String> levelFeature = levels.get(key);
                    String code = levelFeature.get("code");
                    String title = levelFeature.get("title");
                    Level level_temp = new Level(code, title);
                    array_levels.add(level_temp);
                }//fin de while

                Collections.sort(array_levels, new Comparator<Level>() {
                    @Override
                    public int compare(Level o1, Level o2) {
                        return Integer.valueOf(o1.code) > Integer.valueOf(o2.code) ? 1:
                                (Integer.valueOf(o1.code) < Integer.valueOf(o2.code))?-1:0;
                    }
                });


            }//fin del metodo

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }//fin del metodo
        });
    }//fin del metodo

    public void BubbleSort(){
        for(int i=0; i<array_levels.size(); i ++){
            for(int j = 0; j<array_levels.size() - 1; i++){
                if(Integer.valueOf(array_levels.get(j).code) > Integer.valueOf(array_levels.get(j+1).code)){
                    Level temp = array_levels.get(j);
                    array_levels.set(j,array_levels.get(j+1));
                    array_levels.set(j + 1, temp);
                }//fin de if
            }//fin de for
        }//fin de for
    }//fin del metodo
}//(fin de la clase
