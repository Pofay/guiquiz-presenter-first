package core;

/**
 * Created by Gilos on 2/8/2017.
 */
public interface QuizView {
    void setQuestionText(String actual);

    void showCorrectMessage();

    void showIncorrectMessage();
}
