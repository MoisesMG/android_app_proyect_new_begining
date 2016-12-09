package app.rojoyazul.com.android_app_project_new_begening;

import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

import java.util.Map;

public class CreditsActivity extends AppCompatActivity implements ObservableScrollViewCallbacks{
    Firebase creditsRef = new Firebase("https://androidappprojectnewbegening.firebaseio.com/credits");
    TextView creditsTitle, creditsRead, goals, thanks;
    SimpleDraweeView logoTeam;
    Uri logoTeamUrlImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);


        /********* efecto del observable scroll view ***************/
        ObservableScrollView scrollView = (ObservableScrollView) findViewById(R.id.activity_credits);
        scrollView.setScrollViewCallbacks(this);
        /************************************************/

        /*** buscar por id ****/
        creditsTitle = (TextView) findViewById(R.id.creditsTitle);
        creditsRead = (TextView) findViewById(R.id.creditsRead);
        goals = (TextView) findViewById(R.id.goals);
        thanks = (TextView) findViewById(R.id.thanks);
        logoTeam = (SimpleDraweeView) findViewById(R.id.logoTeam);
        /***********************/

        /** establecer icono en el action bar**/
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_white_24dp);
        /**************************************/

        /********* recuperar datos de firebase ************/
        creditsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            Map<String, String> mapValues = dataSnapshot.getValue(Map.class);
            }//fin del metodo

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }//fin del metodo
        });
        /******************************************/

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
