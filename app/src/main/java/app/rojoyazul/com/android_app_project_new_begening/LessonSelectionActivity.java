package app.rojoyazul.com.android_app_project_new_begening;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        mBtnLesson1.setText(subjectCode);
        
        /*******************************************************************************/

        /****** recuperar objectos de firebase *************/
        lessonsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, Map<String, String>> mapLessons = dataSnapshot.getValue(Map.class);
            }//fin del metodo

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }//fin de del metodo

        });
        /************************************************/
    }//fin del metodo
}//fin de la clase
