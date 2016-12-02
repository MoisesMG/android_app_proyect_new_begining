package app.rojoyazul.com.android_app_project_new_begening;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Moises on 30/11/2016.
 */

public class InicioFirebase extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }//fin del metodo
}//fin de la clase
