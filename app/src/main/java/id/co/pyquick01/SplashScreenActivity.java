package id.co.pyquick01;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private ImageButton continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);

        continueButton = findViewById(R.id.imageButton);

        // Menyembunyikan tombol pada awal
        continueButton.setVisibility(View.GONE);

        // Menampilkan tombol setelah 3 detik dengan animasi
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Menampilkan tombol setelah delay
                continueButton.setVisibility(View.VISIBLE);
                // Animasi fade in
                fadeInButton(continueButton);
            }
        }, 5000);

        // Navigasi ketika tombol ditekan
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainActivity();
            }
        });
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Mengakhiri aktivitas SplashScreen
    }

    // Fungsi untuk animasi fade in
    private void fadeInButton(View view) {
        AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(500); // Durasi animasi 500 ms
        fadeIn.setFillAfter(true); // Mempertahankan status akhir animasi
        view.startAnimation(fadeIn);
    }
}
