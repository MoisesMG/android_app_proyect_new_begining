package app.rojoyazul.com.android_app_project_new_begening;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

public class SubjectSelection extends AppCompatActivity {

    Firebase subjectsRef = new Firebase("https://androidappprojectnewbegening.firebaseio.com/subjects");
    private ArrayList<Subject> array_subjects = new ArrayList<Subject>();
    private Button mBtnSubject1, mBtnSubject2, mBtnSubject3, mBtnSubject4;
    private String sentLevelCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_selection);

        /** establecer icono en el action bar**/
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        /****************************/

        /************+ buscar por id *****************/
        mBtnSubject1 = (Button) findViewById(R.id.btnSubject1);
        mBtnSubject2 = (Button) findViewById(R.id.btnSubject2);
        mBtnSubject3 = (Button) findViewById(R.id.btnSubject3);
        mBtnSubject4 = (Button) findViewById(R.id.btnSubject4);
        /******************************************/

        /************+ recuperar codigo de la actividad anterior ***********/
        Bundle recieved = getIntent().getExtras();
        sentLevelCode = recieved.getString("code");

         /*******************************************************************/

        /***************** recuperar datos de firebase **********/
        subjectsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                array_subjects.clear();
                Map<String, Map<String, String>> subjectsMap = dataSnapshot.getValue(Map.class);
                Iterator it_Subjects = subjectsMap.keySet().iterator();
                while(it_Subjects.hasNext()){
                    String key = (String) it_Subjects.next();
                    Map<String,String> subjectFeature = subjectsMap.get(key);
                    if(subjectFeature.get("level_code").equals(sentLevelCode)){
                        Subject subjectsTemp = new Subject();
                        subjectsTemp.setCode(subjectFeature.get("code"));
                        subjectsTemp.setTitle(subjectFeature.get("title"));
                        array_subjects.add(subjectsTemp);
                    }//fin de if
                }//fin de while

                Collections.sort(array_subjects, new Comparator<Subject>() {
                    @Override
                    public int compare(Subject o1, Subject o2) {
                        return Integer.valueOf(o1.getCode()) > Integer.valueOf(o2.getCode())?1:
                                Integer.valueOf(o1.getCode()) < Integer.valueOf(o2.getCode())? -1 : 0;
                    }
                });

                mBtnSubject1.setText(array_subjects.get(0).getTitle() + " " + array_subjects.get(0).getCode());
                mBtnSubject2.setText(array_subjects.get(1).getTitle() + " " + array_subjects.get(1).getCode());
                mBtnSubject3.setText(array_subjects.get(2).getTitle() + " " + array_subjects.get(2).getCode());
                mBtnSubject4.setText(array_subjects.get(3).getTitle() + " " + array_subjects.get(3).getCode());
            }//fin del metodo

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }//fin del metodo
        });
        /******************************************************/

        /***************++ eventos onClick ******************/
        mBtnSubject1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SubjectSelection.this, LessonSelectionActivity.class);
                Bundle toSend = new Bundle();
                toSend.putString("code", array_subjects.get(0).getCode());
                i.putExtras(toSend);
                startActivityForResult(i, 1);
            }
        });

        mBtnSubject2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SubjectSelection.this, LessonSelectionActivity.class);
                Bundle toSend = new Bundle();
                toSend.putString("code", array_subjects.get(1).getCode());
                i.putExtras(toSend);
                startActivityForResult(i, 1);
            }
        });

        mBtnSubject3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SubjectSelection.this, LessonSelectionActivity.class);
                Bundle toSend = new Bundle();
                toSend.putString("code", array_subjects.get(2).getCode());
                i.putExtras(toSend);
                startActivityForResult(i, 1);
            }
        });

        mBtnSubject4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SubjectSelection.this, LessonSelectionActivity.class);
                Bundle toSend = new Bundle();
                toSend.putString("code", array_subjects.get(3).getCode());
                i.putExtras(toSend);
                startActivityForResult(i, 1);
            }
        });
        /**************************************************/
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
                Toast.makeText(getApplicationContext(), "se presiono el boton de creditos", Toast.LENGTH_SHORT);
                return true;

            case R.id.action_suggestion:
                Toast.makeText(getApplicationContext(), "se presiono el boton de sugerencias", Toast.LENGTH_LONG);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }//fin del metodo
}//fin de la clase
