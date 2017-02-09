package giancarlogilos.com.guiquiz;

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

    public QuizPresenterBuilder withModel(QuizModel model){
        this.model = model;
        return this;
    }

    public QuizPresenterBuilder withView(QuizView view){
        this.view = view;
        return this;
    }

    public QuizPresenter build(){
        return new QuizPresenter(view, model);
    }
}
