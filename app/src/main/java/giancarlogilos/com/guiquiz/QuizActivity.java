package giancarlogilos.com.guiquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import core.QuizModel;
import core.QuizPresenter;
import core.QuizView;

public class QuizActivity extends AppCompatActivity implements QuizView{

    private Button mTrueButton;
    private TextView questionText;
    private Button mFalseButton;
    private QuizPresenter presenter;
    private QuizModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setupComponents();
        setupButtonListeners();
        setUpTriad();
        setSupportActionBar(toolbar);
    }

    private void setupComponents() {
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        questionText = (TextView) findViewById(R.id.question_text);
    }

    private void setupButtonListeners() {
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onAnswer(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               presenter.onAnswer(false);
            }
        });
    }

    private void setUpTriad() {
        model = new QuizModel(getString(R.string.question_text), false);
        presenter = new QuizPresenter(this,model);
    }

    private void showMessage(int resourceIdMessage) {
        Toast.makeText(QuizActivity.this, resourceIdMessage,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setQuestionText(String actual) {
        questionText.setText(actual);
    }

    @Override
    public void showCorrectMessage() {

        showMessage(R.string.correct_toast);
    }

    @Override
    public void showIncorrectMessage() {
        showMessage(R.string.incorrect_toast);
    }
}
