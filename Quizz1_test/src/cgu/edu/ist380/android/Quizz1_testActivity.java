package cgu.edu.ist380.android;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Quizz1_testActivity extends Activity {
	
	private int currentQuestion;
	private String [] questions;
	private String [] answers;
	private Button answerButton;
	private Button questionButton;
	private TextView questionView;
	private TextView answerView;
	private EditText answerText;
	
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();
        
        
    }
    
    
    public void init()
    {
   questions = new String[]{"What is the capital of Egypt?",
   "What class are you in right now?"};
   answers = new String[]{"Cairo","IST380"};
   currentQuestion = -1;
   
   answerButton = (Button)findViewById(R.id.submitAnswer);
   questionButton = (Button)findViewById(R.id.showAnswer);
   questionView = (TextView) findViewById(R.id.quizQuestions);
   answerView = (TextView) findViewById(R.id.checkAnswer);
   answerText = (EditText) findViewById(R.id.enterAnswer);
   
   
   answerButton.setOnClickListener(new OnClickListener(){
   @Override
   public void onClick(View v) {
   checkAnswer();
   }});
   
   
   questionButton.setOnClickListener(new OnClickListener(){
   @Override
   public void onClick(View v) {
   showQuestion();
   }});
    }
    
    /*
     * This method 
     * 1: increment currentQuestion index 
     * 2: check if it is equal to the size of the array and reset if 
    necessary 
     * 3: display the question at currentQuestion index in question 
    view
     * 4: Empty answer view
     */
    public void showQuestion()
     {
		    currentQuestion++;
		    if(currentQuestion == questions.length)
		    currentQuestion =0;
		    questionView.setText(questions[currentQuestion]);
		    answerView.setText("");
		    answerText.setText("");
     }
    /*
     * This method return true if the answer equals to correct answer
     * (Ignoring case)
     */
    public boolean isCorrect(String answer)
     {
    return (answer.equalsIgnoreCase(answers[currentQuestion]));
     }
    /* this method :
     * 1: Read the text ( answer) from the answerTextEdit
     * 2: call the isCorrect method
     * 3: display the appropriate message. 
     */
    public void checkAnswer()
    {
   String answer = answerText.getText().toString();
   if(isCorrect(answer))
   answerView.setText("You're right!");
   else
   answerView.setText("Sorry, the correct answer is "+answers[currentQuestion]);
    }
}