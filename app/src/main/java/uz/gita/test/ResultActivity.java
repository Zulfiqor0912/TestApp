package uz.gita.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;

import uz.gita.test.controller.AppController;

public class ResultActivity extends AppCompatActivity {
    private AppController appController;
    private LinearLayout resultLiner;
    private AppCompatImageView btnResultBack;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        loadView();
        resultLiner = findViewById(R.id.resultContainer);
        for (int i = 0; i < 15; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.result_item, null);

            AppCompatTextView resultTextQuestion = view.findViewById(R.id.resulTextQuestion);
            AppCompatTextView resultCount = view.findViewById(R.id.resultCount);
            AppCompatTextView trueAnswer = view.findViewById(R.id.trueAnswer);
            AppCompatTextView resultAnswerText = view.findViewById(R.id.resultAnswerText);
            AppCompatImageView trueOrFalseImg = view.findViewById(R.id.resultTrueOrFalse);
            resultTextQuestion.setText(appController.tesList.get(i).getQuestion());
            resultCount.setText(String.valueOf(i + 1));
            resultAnswerText.setText(appController.userAnswerDataList.get(i).getAnswer());
            if (!appController.userAnswerDataList.get(i).getSkip()) {
                if (appController.userAnswerDataList.get(i).getTrueOrFalse())
                    trueOrFalseImg.setImageResource(R.drawable.tr);
                else
                    trueOrFalseImg.setImageResource(R.drawable.fls);
                resultAnswerText.setText(appController.userAnswerDataList.get(i).getAnswer());
            } else {
                resultAnswerText.setText("");
            }
            trueAnswer.setText(appController.tesList.get(i).getAnswer());
            resultLiner.addView(view);
        }

        btnResultBack.setOnClickListener(v -> {
            finish();
        });

    }

    private void loadView() {
        btnResultBack = findViewById(R.id.resultBtnBack);
        resultLiner = findViewById(R.id.resultContainer);
        appController = AppController.getInstance();
    }
}
