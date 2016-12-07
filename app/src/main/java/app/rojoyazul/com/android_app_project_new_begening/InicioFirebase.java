package app.rojoyazul.com.android_app_project_new_begening;

import android.app.Application;
import android.view.MenuInflater;

import com.firebase.client.Firebase;

/**
 * Created by Moises on 30/11/2016.
 */

public class InicioFirebase extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }//fin del metodo
}//fin de la clase
