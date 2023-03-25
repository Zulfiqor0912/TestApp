package uz.gita.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import uz.gita.test.controller.AppController;
import uz.gita.test.data.TestData;

public class MainActivity2 extends AppCompatActivity {
    private AppCompatImageView btnBack;
    private AppCompatButton btnNext;
    private AppCompatButton btnSkip;
    private AppCompatTextView question;
    private List<RadioButton> radios;
    private AppCompatTextView position;
    private AppCompatButton retryBtn;
    private AppCompatButton moreBtn;
    private AppCompatTextView successId;
    private List<AppCompatTextView> variants;
    private AppCompatTextView textSpecialty;
    private AppController controller;
    private int count;
    private int value;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        loadView();
        controller.loadTest(value);
        controller.shuffleTests();
        describeTestData(controller.getNextQuestion());

        btnBack.setOnClickListener(view -> {
            finish();
        });
    }

    public void loadView() {
        controller = AppController.getInstance();
        value = getIntent().getIntExtra("POSITION", 0);
        textSpecialty = findViewById(R.id.specialty);
        position = findViewById(R.id.count);
        radios = new ArrayList<>(4);
        radios.add(findViewById(R.id.radio1));
        radios.add(findViewById(R.id.radio2));
        radios.add(findViewById(R.id.radio3));
        radios.add(findViewById(R.id.radio4));

        variants = new ArrayList<>(4);
        variants.add(findViewById(R.id.textVariant1));
        variants.add(findViewById(R.id.textVariant2));
        variants.add(findViewById(R.id.textVariant3));
        variants.add(findViewById(R.id.textVariant4));

        question = findViewById(R.id.textQuestion);

        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);
        btnSkip = findViewById(R.id.btnSkip);

        addViewClickAction();

        switch (value) {
            case 0:
                textSpecialty.setText("Matematika");
                break;
            case 1:
                textSpecialty.setText("Tarix");
                break;
            case 2:
                textSpecialty.setText("Ona tili");
                break;
        }
    }

    private void describeTestData(TestData test) {
        if (count < 15) {
            count++;
            position.setText(String.valueOf(count));
            question.setText(test.getQuestion());
            variants.get(0).setText(test.getVariant1());
            variants.get(1).setText(test.getVariant2());
            variants.get(2).setText(test.getVariant3());
            variants.get(3).setText(test.getVariant4());
            clearOldAction();
        } else if (count == 15) {
            View dialogBinding = getLayoutInflater().inflate(R.layout.activity_dialog, null);
            Dialog myDialog = new Dialog(this);
            myDialog.setContentView(dialogBinding);
            myDialog.setCancelable(false);
            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            successId = myDialog.findViewById(R.id.successId);
            successId.setText(String.valueOf(controller.getCorrectAnswer()));
            myDialog.show();
            retryBtn = myDialog.findViewById(R.id.retryBtn);
            retryBtn.setOnClickListener(view -> {
                controller.shuffleTests();
                addViewClickAction();
                count = 0;
                controller.setCorrectAnswer(0);
                controller.setCurrentPosition(0);
                controller.setWrongAnswer(0);
                controller.loadTest(value);
                describeTestData(controller.getNextQuestion());
                myDialog.dismiss();
            });
            moreBtn = myDialog.findViewById(R.id.moreBtn);
            moreBtn.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity2.this, ResultActivity.class);
                startActivity(intent);
                myDialog.dismiss();
                finish();
            });
        }
    }

    public void addViewClickAction() {
        for (RadioButton radio : radios) {
            radio.setOnClickListener(view -> {
                clearSelectRadios();
                radio.setChecked(true);
                btnNext.setEnabled(true);
            });
        }

        btnNext.setOnClickListener(view -> {
            int pos = -1;
            int index = 0;
            while (pos == -1) {
                if (radios.get(index).isChecked()) pos = index;
                index++;
            }
            controller.check(variants.get(pos).getText().toString());
            describeTestData(controller.getNextQuestion());
            position.setText(String.valueOf(count));
        });

        btnSkip.setOnClickListener(view -> {
            position.setText(String.valueOf(count));
            controller.skip();
            describeTestData(controller.getNextQuestion());
        });
    }

    public void clearOldAction() {
        clearSelectRadios();
        btnNext.setEnabled(false);
    }

    public void clearSelectRadios() {
        for (RadioButton radio : radios) {
            radio.setChecked(false);
        }
    }
}