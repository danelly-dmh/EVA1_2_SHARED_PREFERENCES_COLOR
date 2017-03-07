package com.example.danelly.eva1_2_shared_preferences_color;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DecorContentParent;
import android.widget.RadioButton;
import android.view.View;

public class Principal extends AppCompatActivity {
    SharedPreferences shPref;
    String colorActual= "#FFF000";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        shPref = getSharedPreferences("mis_datos", Activity.MODE_PRIVATE);
        colorActual = shPref.getString("color", "#00FFFF");

        getWindow().getDecorView().setBackgroundColor(Color.parseColor(colorActual));
    }
    public void onRadioButtonClicked(View view) { 
        boolean checked = ((RadioButton) view).isChecked();
        SharedPreferences.Editor edtDatos = shPref.edit();
        switch(view.getId()) {
            case R.id.btn1:
                if (checked)
                    getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFFF00"));

                edtDatos.putString("color", "#FFFF00");
                edtDatos.commit();
                    break;
            case R.id.btn2:
                if (checked)
                    getWindow().getDecorView().setBackgroundColor(Color.parseColor("#0000FF"));
                edtDatos.putString("color", "#0000FF");
                edtDatos.commit();
                    break;
            case R.id.btn3:
                if (checked)
                    getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFF0"));
                edtDatos.putString("color", "#FF0000");
                edtDatos.commit();
                    break;
        }
        shPref = getSharedPreferences("datos", Activity.MODE_PRIVATE);
    }
    protected void onPause(){
      super.onPause();
        SharedPreferences.Editor edtDatos = shPref.edit();
        edtDatos.commit();
    }
}
