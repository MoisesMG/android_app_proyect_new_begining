package app.rojoyazul.com.android_app_project_new_begening;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SuggestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_white_24dp);
        /**************************************/
    }//fin del metodo

    //TODO agegar logitipo de la aplicacion
    //TODO agregar peticion de sugerencias
    //TODO Agregar formulario de sugerencia nombre, correo y sugerencia - boton de enviar y de reseter
    //TODO guardar sugerencia en la base de datos
}//fin de la clase
