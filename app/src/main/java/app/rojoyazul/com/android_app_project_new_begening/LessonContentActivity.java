package app.rojoyazul.com.android_app_project_new_begening;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

public class LessonContentActivity extends AppCompatActivity implements ObservableScrollViewCallbacks {
    TextView mLessonTitle;
    TextView mLessonDescrip;
    Button mBtnGoVideo1, mBtnGoVideo2, mBtnGoVideo3, mBtnGoVideo4;
    Uri uri1, uri2, uri3, uri4;
    SimpleDraweeView caption1, caption2, caption3, caption4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_content);

        ObservableScrollView scrollView = (ObservableScrollView) findViewById(R.id.activity_lesson_content);
        scrollView.setScrollViewCallbacks(this);

        /********+ establecer images del DrawelView de Fresco API ***/
        caption1 = (SimpleDraweeView) findViewById(R.id.caption1);
        caption2 = (SimpleDraweeView) findViewById(R.id.caption2);
        caption3 = (SimpleDraweeView) findViewById(R.id.caption3);
        caption4 = (SimpleDraweeView) findViewById(R.id.caption4);
        uri1 = Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidappprojectnewbegening.appspot.com/o/caption%20tutoriales%20materia%201.png?alt=media&token=64fb8a1e-f434-493b-a751-ff9a2e94f223");
        uri2 = Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidappprojectnewbegening.appspot.com/o/caption%20tutoriales%20materia%202.png?alt=media&token=d735d1d3-ea15-4d44-b7e7-4ded6a8981de");
        uri3 = Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidappprojectnewbegening.appspot.com/o/caption%20tutoriales%20materia%203.png?alt=media&token=d64e5022-06ad-4921-9f3b-7bf38ac34140");
        uri4 = Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidappprojectnewbegening.appspot.com/o/caption%20tutoriales%20materia%204.png?alt=media&token=47cbe231-d374-4856-b0a1-8399745a65f4");
        caption1.setImageURI(uri1);
        caption2.setImageURI(uri2);
        caption3.setImageURI(uri3);
        caption4.setImageURI(uri4);
        /**********************************************************/
        /** establecer icono en el action bar**/
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /****************************/

        /*******++ buscar por id **********/
        mLessonTitle = (TextView) findViewById(R.id.textViewLessonTitle);
        mLessonDescrip = (TextView) findViewById(R.id.textViewLessonDescrip);
        mBtnGoVideo1 = (Button) findViewById(R.id.goVideo1);
        mBtnGoVideo2 = (Button) findViewById(R.id.goVideo2);
        mBtnGoVideo3 = (Button) findViewById(R.id.goVideo3);
        mBtnGoVideo4 = (Button) findViewById(R.id.goVideo4);
        /*************************************/

        /*****+++ recuperar datos enviados de LessonSelectionActivity.java ***/
        Bundle recieved = getIntent().getExtras();
        mLessonTitle.setText(recieved.getString("title"));
        mLessonDescrip.setText(recieved.getString("cont"));
        /**********************************************************/

        /*********+ eventos onClick ***************/
        mBtnGoVideo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LessonContentActivity.this, LessonVideoActivity.class);
                startActivity(in);
            }
        });


        mBtnGoVideo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LessonContentActivity.this, LessonVideoActivity.class);
                startActivity(in);
            }
        });

        mBtnGoVideo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LessonContentActivity.this, LessonVideoActivity.class);
                startActivity(in);
            }
        });

        mBtnGoVideo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LessonContentActivity.this, LessonVideoActivity.class);
                startActivity(in);
            }
        });


        /****************************************/
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
                Intent i = new Intent(LessonContentActivity.this, CreditsActivity.class);
                startActivity(i);
                return true;

            case R.id.action_suggestion:
                Intent in = new Intent(LessonContentActivity.this, SuggestionsActivity.class);
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
}//fin de la clase
