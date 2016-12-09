package app.rojoyazul.com.android_app_project_new_begening;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.firebase.client.Firebase;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

public class SuggestionsActivity extends AppCompatActivity implements ObservableScrollViewCallbacks{
    EditText mName, mEmail, mSuggestion;
    ImageButton mBtnSend, mBtnClear;
    Firebase rootRef = new Firebase("https://androidappprojectnewbegening.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        ObservableScrollView scrollView = (ObservableScrollView) findViewById(R.id.activity_suggestions);
        scrollView.setScrollViewCallbacks(this);

        /**********************************************/
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_white_24dp);
        /**************************************/

        /********* buscar por id ****/
        mName = (EditText) findViewById(R.id.editTextYourName);
        mEmail = (EditText) findViewById(R.id.editTextYourEmail);
        mSuggestion = (EditText) findViewById(R.id.editTextYourSuggets);
        mBtnSend = (ImageButton) findViewById(R.id.imageButtonSend);
        mBtnClear = (ImageButton) findViewById(R.id.imageButtonClear);
        /*************************/

        /********** eventos onClick Listener *************/
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase suggestRef = rootRef.child("suggestions");
                Suggestion yourSuggest = new Suggestion();
                yourSuggest.setName(String.valueOf(mName.getText()));
                yourSuggest.setEmail(String.valueOf(mEmail.getText()));
                yourSuggest.setSuggest(String.valueOf(mSuggestion.getText()));
                suggestRef.push().setValue(yourSuggest);
            }//fin del metodo
        });

        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mName.setText("");
                mEmail.setText("");
                mEmail.setText("");
            }//fin del metodo
        });
        /***************************************************/

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
