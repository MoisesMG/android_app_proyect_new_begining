package app.rojoyazul.com.android_app_project_new_begening;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class LessonContentActivity extends AppCompatActivity {
    TextView mLessonTitle;
    TextView mLessonDescrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_content);

        /** establecer icono en el action bar**/
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /****************************/

        /*******++ buscar por id **********/
        mLessonTitle = (TextView) findViewById(R.id.textViewLessonTitle);
        mLessonDescrip = (TextView) findViewById(R.id.textViewLessonDescrip);
        /*************************************/

        /*****+++ recuperar datos enviados de LessonSelectionActivity.java ***/
        Bundle recieved = getIntent().getExtras();
        mLessonTitle.setText(recieved.getString("title"));
        mLessonDescrip.setText(recieved.getString("cont"));
    }//fin del metodo

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
