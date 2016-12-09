package app.rojoyazul.com.android_app_project_new_begening;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonVideoActivity extends AppCompatActivity {

    VideoView tutorial;
    String urlVideo;
    MediaController mediaC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lesson_video);
        tutorial = (VideoView) findViewById(R.id.videoView);
        mediaC = new MediaController(this);
        PlayVideoTutorail();
    }//fin del metodo

    public void PlayVideoTutorail(){
        urlVideo = "https://firebasestorage.googleapis.com/v0/b/androidappprojectnewbegening.appspot.com/o/Tutoriales%20de%20lecciones%20proximamente.mp4?alt=media&token=a8c4dd4d-b6ab-4dad-8fc7-2dc7d67842c4";
        Uri uri = Uri.parse(urlVideo);
        tutorial.setVideoURI(uri);
        tutorial.setMediaController(mediaC);
        mediaC.setAnchorView(tutorial);
        tutorial.requestFocus();
        tutorial.start();
    }//fin del metodo
}//fin de la clase
