package com.example.android.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int score=0;
    /* this function will check the answers for tall the 5 questions ,the answers that the user has submitted will be basically checked*/
    public void submit_button_view(View v)
    {


        //////////////// checking answers for question 1

        CheckBox checkAnswer1Box1=(CheckBox) findViewById(R.id.date1_check_box);
        boolean isCheckBox1=checkAnswer1Box1.isChecked();

        CheckBox checkAnswer1Box2=(CheckBox) findViewById(R.id.date2_check_box);
        boolean isCheckBox2=checkAnswer1Box2.isChecked();
        if(isCheckBox1==true && isCheckBox2==false)
            score++;

////////////////////checking answer for question 2  ////////////////////////////////////////

        ///////////// my answer check for question 2 is not working properly i can't figure out the error.plz help needed
        EditText checkAnswer2=(EditText) findViewById(R.id.year_edit_text);

        String answer2=checkAnswer2.getText().toString();

        if(answer2.equalsIgnoreCase("1947"))
            score++;

/////////////////////////////////// checking answer for question 3
        CheckBox check1=(CheckBox) findViewById(R.id.gandhi_check_box);
        boolean isCheck1=check1.isChecked();

        CheckBox check2=(CheckBox) findViewById(R.id.bose_check_box);
        boolean isCheck2=check2.isChecked();

        CheckBox check3=(CheckBox) findViewById(R.id.dr_check_box);
        boolean isCheck3=check3.isChecked();

        CheckBox check4=(CheckBox) findViewById(R.id.justin_check_box);
        boolean isCheck4=check4.isChecked();

        if(isCheck3==true && isCheck1==false && isCheck2==true && isCheck4==false )
            score++;
/////////////////////////////// checking answer for question 4
        CheckBox check5=(CheckBox) findViewById(R.id.yes_check_box);
        boolean isCheck5=check5.isChecked();

        CheckBox check6=(CheckBox) findViewById(R.id.no_check_box);
        boolean isCheck6=check6.isChecked();


        if(isCheck6==true)
        {

            if(isCheck5==false)
                score++;
        }
///////////////////////////// checking answer for question 5

        RadioButton correctStates=(RadioButton) findViewById(R.id.radioButton2);
        boolean isCorrectStates=correctStates.isChecked();
        if(isCorrectStates==true)
            score++;
        //////////////////// checking answer 6
        EditText checkAnswer6=(EditText) findViewById(R.id.capital_edit_text);
        String answer6=checkAnswer6.getText().toString();

        if(answer6.equalsIgnoreCase("DELHI"))
            score++;

////////////////////////////////////// creating message and displaying result
        String message=createMessage(score);
        String toastMessage="your quiz score :"+score+"/6";
        Toast.makeText(MainActivity.this,toastMessage,Toast.LENGTH_SHORT).show();

// this function will display the result alomg with the information submitted above
        displayResult(message);






    }

    //helper function to create the string tha needs to be outputed onto the screen
    String createMessage(int totalScores)
    {
        ////////// customer info
        EditText customerNameEditTextView=(EditText) findViewById(R.id.enterName_edit_text_view);
        String customerName=customerNameEditTextView.getText().toString();

        EditText customerAge=(EditText) findViewById(R.id.age_edit_text);
        String age=customerAge.getText().toString();


        CheckBox male=(CheckBox) findViewById(R.id.male_checkBox);
        boolean isMale=male.isChecked();

        CheckBox female=(CheckBox) findViewById(R.id.female_checkBox);
        boolean isFemale=female.isChecked();
        ////////////////////////// concatinating string
        String m;

        if(isMale==true)
        {
            m= "Name :"+customerName +"\n" +"Age :"+age +"\n"+"Sex :Male" +"\n"+ "Quiz Score :"+totalScores+" / 6"+"\nclick your score for answers";

        }
        else
            m= "Name :"+customerName +"\n" +"Age :"+age +"\n"+"Sex :Female" +"\n"+ "Quiz Score :"+totalScores+" / 6"+"\nclick your score for answers";
        return m;
    }
    // explicit intent which will lead to another screen dispalaying the answers to all the questions
    public void showAnswers(View v)
    {
        Intent i = new Intent(this,answers.class);
        startActivity(i);

    }

    private void displayResult( String m)
    {
        TextView result=(TextView) findViewById(R.id.result_text_view);
        result.setText(m);
    }

}
