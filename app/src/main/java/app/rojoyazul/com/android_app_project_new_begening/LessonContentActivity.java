package app.rojoyazul.com.android_app_project_new_begening;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LessonContentActivity extends AppCompatActivity {
    TextView mLessonTitle;
    TextView mLessonDescrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_content);

        /*******++ buscar por id **********/
        mLessonTitle = (TextView) findViewById(R.id.textViewLessonTitle);
        mLessonDescrip = (TextView) findViewById(R.id.textViewLessonDescrip);
        /*************************************/

        /*****+++ recuperar datos enviados de LessonSelectionActivity.java ***/
        Bundle recieved = getIntent().getExtras();
        mLessonTitle.setText(recieved.getString("title"));
        mLessonDescrip.setText(recieved.getString("cont"));
    }//fin del metodo
}//fin de la clase
