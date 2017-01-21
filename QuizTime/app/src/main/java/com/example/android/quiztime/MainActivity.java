package com.example.android.quiztime;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//import static com.example.android.quiztime.R.color.colorAccent;

class Node{
    String quest;
    int ans;
    int status;
    String result;
    int response;
    ArrayList<String> op;
    Node(String quest,ArrayList<String> op,int ans){
        this.quest=quest;
        this.op=new ArrayList<>(op);
        this.ans=ans;
        this.response=-1;
        this.result="";
        this.status=0;// 0== not attempted ,1=give up, -1=wrong answer , 3=correct answer
    }
}


public class MainActivity extends AppCompatActivity {

    private EditText nameTextBox;
    private ImageView lockNameImage;
    private Node[] questionNodes;
    private HashMap<Integer,Integer> hmp;
    private int totalQues=0;
    private int totalMarks=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initialiseHashMap();
        setQuestions();
    }

    private void initialiseHashMap(){
        hmp = new HashMap<>();
        hmp.put(R.id.option1,1);
        hmp.put(R.id.option2,2);
        hmp.put(R.id.option3,3);
        hmp.put(R.id.option4,4);
    }

    public void toggleName(View view){
        nameTextBox = (EditText)findViewById(R.id.userName);
        if(nameTextBox.isEnabled()){
            nameTextBox.setEnabled(false);
            lockNameImage = (ImageView) findViewById(R.id.nameLock);
            lockNameImage.setImageResource(R.drawable.ic_lock_outline_black_24dp);
        }
        else{
            nameTextBox.setEnabled(true);
            lockNameImage = (ImageView) findViewById(R.id.nameLock);
            lockNameImage.setImageResource(R.drawable.ic_lock_open_black_24dp);
        }
        nameTextBox.setTypeface(null, Typeface.BOLD);
        nameTextBox.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    public void setQuestions(){

        questionNodes = new Node[10];

        ArrayList<String> options = new ArrayList<>();
        int ans;
        String question;


        options.add("O(N)");
        options.add("O(N*logN)");
        options.add("O(N*N)");
        options.add("O(logN)");
        question="Time Complexity for creating a heap of size N ?";
        ans=1;
        questionNodes[0]= new Node(question,options,ans);
        options.clear();

        options.add("Class");
        options.add("Abstract Class");
        options.add("Interface");
        options.add("Both (b) and (c)");
        question="In JAVA, List and Map are examples of what ?";
        ans=4;
        questionNodes[1]= new Node(question,options,ans);
        options.clear();

        options.add("Parent");
        options.add("Object");
        options.add("Map");
        options.add("super");
        question="All classes in JAVA automatically inherit which class?";
        ans=2;
        questionNodes[2]= new Node(question,options,ans);
        options.clear();

        options.add("Constant");
        options.add("O(logN)");
        options.add("O(N)");
        options.add("O(N*N)");
        question="Time complexity for removing an element from a heap is (without heapifying)?";
        ans=1;
        questionNodes[3]= new Node(question,options,ans);
        options.clear();

        options.add("O(N)");
        options.add("O(logN)");
        options.add("O(N*log*logN)");
        options.add("Constant");
        question="Height of a heap of N nodes is";
        ans=2;
        questionNodes[4]= new Node(question,options,ans);
        options.clear();

        options.add("O(N)");
        options.add("O(N*logN)");
        options.add("O(N*N)");
        options.add("O(logN)");
        question="Time Complexity for creating a heap of size N ?";
        ans=1;
        questionNodes[5]= new Node(question,options,ans);
        options.clear();

        options.add("Class");
        options.add("Abstract Class");
        options.add("Interface");
        options.add("Both (b) and (c)");
        question="In JAVA, List and Map are examples of what ?";
        ans=4;
        questionNodes[6]= new Node(question,options,ans);
        options.clear();

        options.add("Parent");
        options.add("Object");
        options.add("Map");
        options.add("super");
        question="All classes in JAVA automatically inherit which class?";
        ans=1;
        questionNodes[7]= new Node(question,options,ans);
        options.clear();

        options.add("Constant");
        options.add("O(logN)");
        options.add("O(N)");
        options.add("O(N*N)");
        question="Time complexity for removing an element from a heap is (without heapifying)?";
        ans=1;
        questionNodes[8]= new Node(question,options,ans);
        options.clear();

        options.add("O(N)");
        options.add("O(logN)");
        options.add("O(N*log*logN)");
        options.add("Constant");
        question="Height of a heap of N nodes is";
        ans=2;
        questionNodes[9]= new Node(question,options,ans);
        options.clear();

        TextView qnoview = (TextView) findViewById(R.id.Qno);
        TextView qntitle = (TextView) findViewById(R.id.Question);
        RadioButton opt1 = (RadioButton) findViewById(R.id.option1);
        RadioButton opt2 = (RadioButton) findViewById(R.id.option2);
        RadioButton opt3 = (RadioButton) findViewById(R.id.option3);
        RadioButton opt4 = (RadioButton) findViewById(R.id.option4);

        qnoview.setText("Q1.");
        qntitle.setText(questionNodes[0].quest);
        opt1.setText(questionNodes[0].op.get(0));
        opt2.setText(questionNodes[0].op.get(1));
        opt3.setText(questionNodes[0].op.get(2));
        opt4.setText(questionNodes[0].op.get(3));

        ImageView prv = (ImageView)findViewById(R.id.navprv);
        prv.setVisibility(View.INVISIBLE);
    }

    public void submitAnswer(View view){
        RadioGroup rg=(RadioGroup) findViewById(R.id.opts);
        if(rg.getCheckedRadioButtonId()==-1){
            Toast.makeText(this,"Please choose atleast one option!!",Toast.LENGTH_SHORT).show();
            return;
        }
        int chosenAnswer = hmp.get(rg.getCheckedRadioButtonId());
        TextView qno = (TextView) findViewById(R.id.Qno);
        int quesNo = Integer.parseInt(qno.getText().toString().substring(1,2))-1;
        if(quesNo==0){
            if((qno.getText().toString()).length() == 4)quesNo=9;
        }


        for(int i=0;i<rg.getChildCount();i++){
            rg.getChildAt(i).setEnabled(false);
        }
        Button bt = (Button) findViewById(R.id.giveup);
        bt.setEnabled(false);
        bt.setBackgroundColor(getResources().getColor(R.color.disableColor));
        bt = (Button) findViewById(R.id.submitbtn);
        bt.setEnabled(false);
        bt.setBackgroundColor(getResources().getColor(R.color.disableColor));

        questionNodes[quesNo].response=chosenAnswer;

        if(chosenAnswer == questionNodes[quesNo].ans){
            questionNodes[quesNo].status=3;
            questionNodes[quesNo].result="Your Score: +3 \nCorrect Answer: ("+questionNodes[quesNo].ans+")";
            TextView res = (TextView)findViewById(R.id.qsresult);
            res.setText(questionNodes[quesNo].result);
            totalMarks+=3;
            totalQues++;
            TextView scoreCard = (TextView)findViewById(R.id.Score);
            scoreCard.setText(""+totalMarks+"");
            TextView ques = (TextView)findViewById(R.id.Questions);
            ques.setText(""+totalQues+"");
            Button b = (Button)findViewById(R.id.btn1);

            if(quesNo==0)
                b = (Button)findViewById(R.id.btn1);
            else if(quesNo==1)
                b = (Button)findViewById(R.id.btn2);
            else if(quesNo==2)
                b = (Button)findViewById(R.id.btn3);
            else if(quesNo==3)
                b = (Button)findViewById(R.id.btn4);
            else if(quesNo==4)
                b = (Button)findViewById(R.id.btn5);
            else if(quesNo==5)
                b = (Button)findViewById(R.id.btn6);
            else if(quesNo==6)
                b = (Button)findViewById(R.id.btn7);
            else if(quesNo==7)
                b = (Button)findViewById(R.id.btn8);
            else if(quesNo==8)
                b = (Button)findViewById(R.id.btn9);
            else if(quesNo==9)
                b = (Button)findViewById(R.id.btn10);

            b.setBackgroundColor(Color.GREEN);
            Toast.makeText(this,"CORRECT",Toast.LENGTH_SHORT).show();
        }
        else{
            questionNodes[quesNo].status=-1;
            questionNodes[quesNo].result="Your Score: -1 \nCorrect Answer: ("+questionNodes[quesNo].ans+")";
            TextView res = (TextView)findViewById(R.id.qsresult);
            res.setText(questionNodes[quesNo].result);
            totalMarks--;
            totalQues++;
            TextView scoreCard = (TextView)findViewById(R.id.Score);
            scoreCard.setText(""+totalMarks+"");
            TextView ques = (TextView)findViewById(R.id.Questions);
            ques.setText(""+totalQues+"");
            Button b = (Button)findViewById(R.id.btn1);
            if(quesNo==0)
                b = (Button)findViewById(R.id.btn1);
            else if(quesNo==1)
                b = (Button)findViewById(R.id.btn2);
            else if(quesNo==2)
                b = (Button)findViewById(R.id.btn3);
            else if(quesNo==3)
                b = (Button)findViewById(R.id.btn4);
            else if(quesNo==4)
                b = (Button)findViewById(R.id.btn5);
            else if(quesNo==5)
                b = (Button)findViewById(R.id.btn6);
            else if(quesNo==6)
                b = (Button)findViewById(R.id.btn7);
            else if(quesNo==7)
                b = (Button)findViewById(R.id.btn8);
            else if(quesNo==8)
                b = (Button)findViewById(R.id.btn9);
            else if(quesNo==9)
                b = (Button)findViewById(R.id.btn10);
            b.setBackgroundColor(Color.RED);
            Toast.makeText(this,"WRONG ANSWER!!",Toast.LENGTH_SHORT).show();
        }


    }

    public void giveUp(View view){
        TextView qno = (TextView) findViewById(R.id.Qno);
        int quesNo = Integer.parseInt(qno.getText().toString().substring(1,2))-1;

        RadioGroup rg=(RadioGroup) findViewById(R.id.opts);
        rg.clearCheck();

        for(int i=0;i<rg.getChildCount();i++){
            rg.getChildAt(i).setEnabled(false);
        }
        Button bt = (Button) findViewById(R.id.giveup);
        bt.setEnabled(false);
        bt.setBackgroundColor(getResources().getColor(R.color.disableColor));
        bt = (Button) findViewById(R.id.submitbtn);
        bt.setEnabled(false);
        bt.setBackgroundColor(getResources().getColor(R.color.disableColor));

        questionNodes[quesNo].status=1;

        questionNodes[quesNo].result="Your Score: 0 \nCorrect Answer: ("+questionNodes[quesNo].ans+")";
        TextView res = (TextView)findViewById(R.id.qsresult);
        res.setText(questionNodes[quesNo].result);

        questionNodes[quesNo].response=-1;
        totalQues++;
        TextView ques = (TextView)findViewById(R.id.Questions);
        ques.setText(""+totalQues+"");

        Button b = (Button)findViewById(R.id.btn1);
        if(quesNo==0)
            b = (Button)findViewById(R.id.btn1);
        else if(quesNo==1)
            b = (Button)findViewById(R.id.btn2);
        else if(quesNo==2)
            b = (Button)findViewById(R.id.btn3);
        else if(quesNo==3)
            b = (Button)findViewById(R.id.btn4);
        else if(quesNo==4)
            b = (Button)findViewById(R.id.btn5);
        else if(quesNo==5)
            b = (Button)findViewById(R.id.btn6);
        else if(quesNo==6)
            b = (Button)findViewById(R.id.btn7);
        else if(quesNo==7)
            b = (Button)findViewById(R.id.btn8);
        else if(quesNo==8)
            b = (Button)findViewById(R.id.btn9);
        else if(quesNo==9)
            b = (Button)findViewById(R.id.btn10);
        b.setBackgroundColor(Color.RED);

        Toast.makeText(this,"Better Luck Next Time !",Toast.LENGTH_SHORT).show();
    }

    public void goPrvQs(View view){
        TextView qno = (TextView) findViewById(R.id.Qno);
        int quesNo = Integer.parseInt(qno.getText().toString().substring(1,2))-1;
        if(quesNo==0 && qno.getText().toString().charAt(2)=='0')quesNo=9;
        ImageView prv = (ImageView) findViewById(R.id.navprv);
        ImageView nex = (ImageView) findViewById(R.id.navnex);
        if(quesNo==1){
            prv.setVisibility(View.INVISIBLE);
        }
        else prv.setVisibility(View.VISIBLE);
        nex.setVisibility(View.VISIBLE);
        quesNo--;

        TextView qnoview = (TextView) findViewById(R.id.Qno);
        TextView qntitle = (TextView) findViewById(R.id.Question);
        RadioButton opt1 = (RadioButton) findViewById(R.id.option1);
        RadioButton opt2 = (RadioButton) findViewById(R.id.option2);
        RadioButton opt3 = (RadioButton) findViewById(R.id.option3);
        RadioButton opt4 = (RadioButton) findViewById(R.id.option4);
        int temp=quesNo+1;
        qnoview.setText("Q"+temp+".");
        qntitle.setText(questionNodes[quesNo].quest);
        opt1.setText(questionNodes[quesNo].op.get(0));
        opt2.setText(questionNodes[quesNo].op.get(1));
        opt3.setText(questionNodes[quesNo].op.get(2));
        opt4.setText(questionNodes[quesNo].op.get(3));

        if(questionNodes[quesNo].status==0){
            RadioGroup rg=(RadioGroup) findViewById(R.id.opts);
            rg.clearCheck();
            TextView res = (TextView)findViewById(R.id.qsresult);
            res.setText(questionNodes[quesNo].result);

            for(int i=0;i<rg.getChildCount();i++){
                rg.getChildAt(i).setEnabled(true);
            }
            Button bt = (Button) findViewById(R.id.giveup);
            bt.setEnabled(true);
            bt.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            bt = (Button) findViewById(R.id.submitbtn);
            bt.setEnabled(true);
            bt.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
        else{
            Set set = hmp.entrySet();
            Iterator it=set.iterator();
            if(questionNodes[quesNo].status == 1){
                RadioGroup rg=(RadioGroup) findViewById(R.id.opts);
                rg.clearCheck();
            }
            else{
                while(it.hasNext()){
                    Map.Entry mentry = (Map.Entry) it.next();
                    if((Integer)mentry.getValue() == questionNodes[quesNo].response){
                        int id=(Integer)mentry.getKey();
                        RadioButton rb =(RadioButton) findViewById(id);
                        rb.setChecked(true);
                        break;
                    }
                }
            }

            RadioGroup rg=(RadioGroup) findViewById(R.id.opts);
            for(int i=0;i<rg.getChildCount();i++){
                rg.getChildAt(i).setEnabled(false);
            }
            Button bt = (Button) findViewById(R.id.giveup);
            bt.setEnabled(false);
            bt.setBackgroundColor(getResources().getColor(R.color.disableColor));
            bt = (Button) findViewById(R.id.submitbtn);
            bt.setEnabled(false);
            bt.setBackgroundColor(getResources().getColor(R.color.disableColor));
            TextView res = (TextView)findViewById(R.id.qsresult);
            res.setText(questionNodes[quesNo].result);
        }
    }

    public void goNexQs(View view){
        TextView qno = (TextView) findViewById(R.id.Qno);
        int quesNo = Integer.parseInt(qno.getText().toString().substring(1,2))-1;
//        if(quesNo==0 && qno.getText().toString().charAt(2)=='0')quesNo=9;

        ImageView prv = (ImageView) findViewById(R.id.navprv);
        ImageView nex = (ImageView) findViewById(R.id.navnex);

        if(quesNo == 8){
            nex.setVisibility(View.INVISIBLE);
        }
        else nex.setVisibility(View.VISIBLE);

        prv.setVisibility(View.VISIBLE);

        quesNo++;
        TextView qnoview = (TextView) findViewById(R.id.Qno);
        TextView qntitle = (TextView) findViewById(R.id.Question);
        RadioButton opt1 = (RadioButton) findViewById(R.id.option1);
        RadioButton opt2 = (RadioButton) findViewById(R.id.option2);
        RadioButton opt3 = (RadioButton) findViewById(R.id.option3);
        RadioButton opt4 = (RadioButton) findViewById(R.id.option4);

        int temp=quesNo+1;
        qnoview.setText("Q"+temp+".");
        qntitle.setText(questionNodes[quesNo].quest);
        opt1.setText(questionNodes[quesNo].op.get(0));
        opt2.setText(questionNodes[quesNo].op.get(1));
        opt3.setText(questionNodes[quesNo].op.get(2));
        opt4.setText(questionNodes[quesNo].op.get(3));

        if(questionNodes[quesNo].status==0){
            RadioGroup rg=(RadioGroup) findViewById(R.id.opts);
            rg.clearCheck();
            TextView res = (TextView)findViewById(R.id.qsresult);
            res.setText(questionNodes[quesNo].result);

            for(int i=0;i<rg.getChildCount();i++){
                rg.getChildAt(i).setEnabled(true);
            }
            Button bt = (Button) findViewById(R.id.giveup);
            bt.setEnabled(true);
            bt.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            bt = (Button) findViewById(R.id.submitbtn);
            bt.setEnabled(true);
            bt.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
        else{
            Set set = hmp.entrySet();
            Iterator it=set.iterator();
            if(questionNodes[quesNo].status == 1){
                RadioGroup rg=(RadioGroup) findViewById(R.id.opts);
                rg.clearCheck();
            }
            else{
                while(it.hasNext()){
                    Map.Entry mentry = (Map.Entry) it.next();
                    if((Integer)mentry.getValue() == questionNodes[quesNo].response){
                        int id=(Integer)mentry.getKey();
                        RadioButton rb =(RadioButton) findViewById(id);
                        rb.setChecked(true);
                        break;
                    }
                }
            }

            RadioGroup rg=(RadioGroup) findViewById(R.id.opts);
            for(int i=0;i<rg.getChildCount();i++){
                rg.getChildAt(i).setEnabled(false);
            }
            Button bt = (Button) findViewById(R.id.giveup);
            bt.setEnabled(false);
            bt.setBackgroundColor(getResources().getColor(R.color.disableColor));
            bt = (Button) findViewById(R.id.submitbtn);
            bt.setEnabled(false);
            bt.setBackgroundColor(getResources().getColor(R.color.disableColor));

            TextView res = (TextView)findViewById(R.id.qsresult);
            res.setText(questionNodes[quesNo].result);
        }
    }

    public void goToQ(View view){
        Button b = (Button) view;

        int quesNo = Integer.parseInt(b.getText().toString().substring(0,1))-1;
        if(quesNo==0 && (b.getText().toString()).length() > 1 )quesNo=9;

        ImageView prv = (ImageView) findViewById(R.id.navprv);
        ImageView nex = (ImageView) findViewById(R.id.navnex);
        if(quesNo==0){
            prv.setVisibility(View.INVISIBLE);
        }
        else prv.setVisibility(View.VISIBLE);

        if(quesNo==9){
            nex.setVisibility(View.INVISIBLE);
        }
        else nex.setVisibility(View.VISIBLE);

        TextView qnoview = (TextView) findViewById(R.id.Qno);
        TextView qntitle = (TextView) findViewById(R.id.Question);
        RadioButton opt1 = (RadioButton) findViewById(R.id.option1);
        RadioButton opt2 = (RadioButton) findViewById(R.id.option2);
        RadioButton opt3 = (RadioButton) findViewById(R.id.option3);
        RadioButton opt4 = (RadioButton) findViewById(R.id.option4);

        int temp=quesNo+1;
        qnoview.setText("Q"+temp+".");
        qntitle.setText(questionNodes[quesNo].quest);
        opt1.setText(questionNodes[quesNo].op.get(0));
        opt2.setText(questionNodes[quesNo].op.get(1));
        opt3.setText(questionNodes[quesNo].op.get(2));
        opt4.setText(questionNodes[quesNo].op.get(3));

        if(questionNodes[quesNo].status==0){
            RadioGroup rg=(RadioGroup) findViewById(R.id.opts);
            rg.clearCheck();
            TextView res = (TextView)findViewById(R.id.qsresult);
            res.setText(questionNodes[quesNo].result);

            for(int i=0;i<rg.getChildCount();i++){
                rg.getChildAt(i).setEnabled(true);
            }
            Button bt = (Button) findViewById(R.id.giveup);
            bt.setEnabled(true);
            bt.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            bt = (Button) findViewById(R.id.submitbtn);
            bt.setEnabled(true);
            bt.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
        else{
            Set set = hmp.entrySet();
            Iterator it=set.iterator();
            if(questionNodes[quesNo].status == 1){
                RadioGroup rg=(RadioGroup) findViewById(R.id.opts);
                rg.clearCheck();
            }
            else{
                while(it.hasNext()){
                    Map.Entry mentry = (Map.Entry) it.next();
                    if((Integer)mentry.getValue() == questionNodes[quesNo].response){
                        int id=(Integer)mentry.getKey();
                        RadioButton rb =(RadioButton) findViewById(id);
                        rb.setChecked(true);
                        break;
                    }
                }
            }


            RadioGroup rg=(RadioGroup) findViewById(R.id.opts);
            for(int i=0;i<rg.getChildCount();i++){
                rg.getChildAt(i).setEnabled(false);
            }
            Button bt = (Button) findViewById(R.id.giveup);
            bt.setEnabled(false);
            bt.setBackgroundColor(getResources().getColor(R.color.disableColor));
            bt = (Button) findViewById(R.id.submitbtn);
            bt.setEnabled(false);
            bt.setBackgroundColor(getResources().getColor(R.color.disableColor));
            TextView res = (TextView)findViewById(R.id.qsresult);
            res.setText(questionNodes[quesNo].result);
        }
    }

    public void share(View view){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "My Score on Quiz It is "+ totalMarks +".It's quizzing time baby!");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

}
