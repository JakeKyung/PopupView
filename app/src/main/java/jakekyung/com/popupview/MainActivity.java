package jakekyung.com.popupview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button pop_button, toast_button;
    private TextView main_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pop_button = (Button)findViewById(R.id.popupview);
        toast_button = (Button)findViewById(R.id.toast);

        pop_button.setOnClickListener(this);
        toast_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.popupview:
                View popupView = LayoutInflater.from(MainActivity.this).inflate(R.layout.popup_window, null);
                final PopupWindow popupWindow =new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                popupView.setForegroundGravity(Gravity.CENTER_HORIZONTAL);
                popupWindow.setIgnoreCheekPress();
                popupWindow.setOutsideTouchable(true);

                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                popupView.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();
                    }
                });

                popupView.findViewById(R.id.outside_panel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });


                break;

            case R.id.toast:
                Toast toast;
                toast=Toast.makeText(this, "Toast Center Example" , Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                break;

        }

    }

}




