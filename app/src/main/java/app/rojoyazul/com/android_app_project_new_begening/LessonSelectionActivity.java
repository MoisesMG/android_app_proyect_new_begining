package app.rojoyazul.com.android_app_project_new_begening;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

public class LessonSelectionActivity extends AppCompatActivity {

    Firebase lessonsRef = new Firebase("https://androidappprojectnewbegening.firebaseio.com/lessonAux");
    ArrayList<Lesson> array_lessons = new ArrayList<Lesson>();
    TextView mLessonSelectionTitle;
    Button mBtnLesson1, mBtnLesson2, mBtnLesson3, mBtnLesson4;
    String subjectCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_selection);

        /************ buscar por id ***********/
        mLessonSelectionTitle = (TextView) findViewById(R.id.lessonSelectionTitle);
        mBtnLesson1 = (Button) findViewById(R.id.btnLesson1);
        mBtnLesson2 = (Button) findViewById(R.id.btnLesson2);
        mBtnLesson3 = (Button) findViewById(R.id.btnLesson3);
        mBtnLesson4 = (Button) findViewById(R.id.btnLesson4);
        /*************************************/

        /*** recuperar codigo enviado de la actividad anterior: SubjectSelection.java **/
        Bundle recieved = getIntent().getExtras();
        subjectCode = recieved.getString("code");
        
        /*******************************************************************************/

        /****** recuperar objectos de firebase *************/
        lessonsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                array_lessons.clear();
                Map<String, Map<String, String>> mapLessons = dataSnapshot.getValue(Map.class);
                Iterator it = mapLessons.keySet().iterator();
                while(it.hasNext()){
                    String key = (String) it.next();
                    Map<String, String> features = mapLessons.get(key);
                    Lesson tempLesson = new Lesson();
                    tempLesson.setCode(features.get("code"));
                    tempLesson.setTitle(features.get("title"));
                    tempLesson.setSubject_code(features.get("scode"));
                    tempLesson.setContent(features.get("cont"));
                    if(tempLesson.getSubject_code().equals(subjectCode)){
                        array_lessons.add(tempLesson);
                    }
                }//fin de while

                //ordenar el array
                Collections.sort(array_lessons, new Comparator<Lesson>() {
                    @Override
                    public int compare(Lesson o1, Lesson o2) {
                        return Integer.valueOf(o1.getCode()) > Integer.valueOf(o2.getCode()) ? 1:
                                Integer.valueOf(o1.getCode()) < Integer.valueOf(o2.getCode())? -1: 0;
                    }
                });
                mBtnLesson1.setText(array_lessons.get(0).getTitle() + " " + array_lessons.get(0).getCode());
                mBtnLesson2.setText(array_lessons.get(1).getTitle() + " " + array_lessons.get(1).getCode());
                mBtnLesson3.setText(array_lessons.get(2).getTitle() + " " + array_lessons.get(2).getCode());
                mBtnLesson4.setText(array_lessons.get(3).getTitle() + " " + array_lessons.get(3).getCode());
            }//fin del metodo

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }//fin de del metodo

        });
        /************************************************/

        /********++ eventos OnClick *******************/
        mBtnLesson1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LessonSelectionActivity.this, LessonContentActivity.class);
                Bundle toSend = new Bundle();
                toSend.putString("title", array_lessons.get(0).getTitle());
                toSend.putString("cont", array_lessons.get(0).getContent());
                i.putExtras(toSend);
                startActivityForResult(i, 1);
            }
        });

        mBtnLesson2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LessonSelectionActivity.this, LessonContentActivity.class);
                Bundle toSend = new Bundle();
                toSend.putString("title", array_lessons.get(1).getTitle());
                toSend.putString("cont", array_lessons.get(1).getContent());
                i.putExtras(toSend);
                startActivityForResult(i, 1);
            }
        });

        mBtnLesson3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LessonSelectionActivity.this, LessonContentActivity.class);
                Bundle toSend = new Bundle();
                toSend.putString("title", array_lessons.get(2).getTitle());
                toSend.putString("cont", array_lessons.get(2).getContent());
                i.putExtras(toSend);
                startActivityForResult(i, 1);
            }
        });

        mBtnLesson4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LessonSelectionActivity.this, LessonContentActivity.class);
                Bundle toSend = new Bundle();
                toSend.putString("title", array_lessons.get(3).getTitle());
                toSend.putString("cont", array_lessons.get(3).getContent());
                i.putExtras(toSend);
                startActivityForResult(i, 1);
            }
        });
        /********************************************/
    }//fin del metodo OnCreate
}//fin de la clase
