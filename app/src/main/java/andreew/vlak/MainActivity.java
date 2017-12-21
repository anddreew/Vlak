package andreew.vlak;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity {

    Vlak vlak;
    long starttime=0;
    public static long actt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        vlak = (Vlak) findViewById(R.id.map);
        /*
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Posbírejte všechny balíčky");
        dlgAlert.setTitle("Vlak CZ");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
        */
        starttime=System.currentTimeMillis();
        CountDownTimer countDownTimer = new CountDownTimer(200000, 100) {
            public void onTick(long millisUntilFinished) {
                setText();
            }
            public void onFinish() {
            }
        }.start();


        vlak.invalidate();
    }

    public void setText(){
        long millis = System.currentTimeMillis() - starttime;
        actt=millis;
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        millis = millis % 100;
        //TextView text = findViewById(R.id.textView2);
        //text.setText("ahoj");
        TextView text = findViewById(R.id.textView2);
        text.setText(minutes + ":" + seconds+":"+millis);
    }
}
