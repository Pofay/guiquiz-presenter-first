package giancarlogilos.com.guiquiz;

import core.Question;
import core.QuizModel;
import core.QuizPresenter;
import core.QuizView;

import static org.mockito.Mockito.mock;

/**
 * Created by Gilos on 2/9/2017.
 */

public class QuizPresenterBuilder {

    private QuizView view;
    private QuizModel model;

    public QuizPresenterBuilder(){
        this.model = mock(QuizModel.class);
        this.view = mock(QuizView.class);
    }


    public QuizPresenterBuilder withView(QuizView view){
        this.view = view;
        return this;
    }

    public QuizPresenter build(){
        return new QuizPresenter(view, model);
    }

    public QuizPresenterBuilder withOneQuestion(String question, boolean answer) {
        this.model = new QuizModel(new Question[]{ new Question(question, answer) } );
        return this;
    }

    public QuizPresenterBuilder withMultipleQuestions(Question[] questions) {
        this.model = new QuizModel(questions);
        return this;
    }
}
