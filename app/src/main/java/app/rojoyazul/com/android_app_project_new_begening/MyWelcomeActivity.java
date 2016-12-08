package app.rojoyazul.com.android_app_project_new_begening;


import android.content.res.Resources;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.TitlePage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;

public class MyWelcomeActivity extends WelcomeActivity{

    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultBackgroundColor(R.color.background_welcome1)
                .page(new TitlePage(R.drawable.ic_launcher1,
                        getResources().getString(R.string.app_name))
                )
                .page(new BasicPage(R.drawable.ayuda_seleccion_nivel,
                        "Selecciona un nivel",
                        "Selecciona el nivel de aprendizaje de las materias")
                        .background(R.color.background_welcome2)
                )
                .page(new BasicPage(R.drawable.ayuda_seleccion_materia,
                        "Selecciona una materia",
                        "Elige la Materia a Reforzar")
                        .background(R.color.background_wlcome3)
                )
                .page(new BasicPage(R.drawable.ayuda_seleccion_leccion,
                        "Selecciona una lección",
                        "Escoge la lección para los ejercicios correspondientes.")
                        .background(R.color.background_welcome1)
                )
                .page(new BasicPage(R.drawable.ayuda_navegar_contenido,
                        "Navega a traves del contendio de la leccion",
                        "Disfruta de videos y ejercicios")
                        .background(R.color.background_welcome2)
                )
                .page(new BasicPage(R.drawable.ayuda_ver_video,
                        "Escoge el vide tutorial de una leccion",
                        "Pudes disfrutar de formar efectiva el aprendizaje")
                        .background(R.color.background_wlcome3)
                )
                .page(new BasicPage(R.drawable.ayuda_ir_a_ejercicio,
                        "Realiza los ejercicios de cada lección",
                        "Confirma tu aprednizaje realizando pruebas intensivas")
                        .background(R.color.background_welcome1)
                )
                .page(new BasicPage(R.drawable.ayuda_seleccionar_boton_de_ayuda,
                        "Presione el boton de ayuda cuando lo necisites",
                        "De mostraremos la guia de rapida para usar la aplicacion")
                        .background(R.color.background_wlcome3)
                )
                .swipeToDismiss(true)
                .build();
    }//fin del metodo
}//fin de la clase
