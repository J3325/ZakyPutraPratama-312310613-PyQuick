package id.co.pyquick01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        ImageButton buttonKembali = findViewById(R.id.buttonKembali);
        ImageButton buttonKeluar = findViewById(R.id.buttonKeluar);

        // Tombol Keluar untuk menutup aplikasi
        buttonKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity(); // Menutup seluruh activity
            }
        });

        // Tombol Kembali untuk menutup MenuActivity
        buttonKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
