package id.co.pyquick01;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan_code);

        String codeTitle = getIntent().getStringExtra("codeTitle");
        String detailCode = getIntent().getStringExtra("detailCode");

        TextView titleTextView = findViewById(R.id.title_text_view);
        TextView detailTextView = findViewById(R.id.detail_text_view);

        titleTextView.setText(codeTitle);
        detailTextView.setText(detailCode);

        // Menambahkan scroll ke TextView detail_code
        detailTextView.setMovementMethod(new android.text.method.ScrollingMovementMethod());

        ImageButton buttonHome = findViewById(R.id.ButtonHome);
        buttonHome.setOnClickListener(v -> finish());
    }
}
