package uz.gita.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout btnMath;
    private ConstraintLayout btnHistory;
    private ConstraintLayout btnMotherTongue;
    private AppCompatButton btnInfo;
    private AppCompatButton btnExit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();

        btnMath.setOnClickListener(view -> {
            onClickedMath();
        });

        btnHistory.setOnClickListener(view -> {
            onClickedHistory();
        });

        btnMotherTongue.setOnClickListener(view -> {
            onClickedMotherTongue();
        });

        btnInfo.setOnClickListener(view -> {
            onClickedInfo();
        });

        btnExit.setOnClickListener(view -> {
            onClickedQuit();
        });

    }

    private void onClickedMath() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("POSITION", 0);
        startActivity(intent);
    }

    private void onClickedHistory() {

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("POSITION", 1);
        startActivity(intent);
    }

    private void onClickedMotherTongue() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("POSITION", 2);
        startActivity(intent);
    }

    private void onClickedInfo() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_about);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.show();

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_about);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.show();

        AppCompatButton btnBack = dialog.findViewById(R.id.btnBack);

        btnBack.setOnClickListener(view1 -> {
            dialog.dismiss();
        });
    }

    private void onClickedQuit() {
        finish();
    }

    private void findView() {
        btnMath = findViewById(R.id.btnMath);
        btnHistory = findViewById(R.id.btnHistory);
        btnMotherTongue = findViewById(R.id.btnMoTongue);
        btnInfo = findViewById(R.id.btnInfo);
        btnExit = findViewById(R.id.btnQuit);
    }
}