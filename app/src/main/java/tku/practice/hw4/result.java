package tku.practice.hw4;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class result extends AppCompatActivity {

    private TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        txv = findViewById(R.id.textView);
        showresult();
    }

    private void showresult(){
        NumberFormat nf = NumberFormat.getInstance();
        Bundle bundle = getIntent().getExtras();
        int l = bundle.getInt("linear"),
                a = bundle.getInt("algorithm"),
                p = bundle.getInt("probability"),
                sum = l + a + p;
        double average = sum / 3.0;
        String text = "Linear Algebra : " + l + "\nAlgorithm : "
                + a + "\nProbability syllabus : " + p + "\nsum : " + sum + "\naverage : " + nf.format(average);
        txv.setText(text);
        alert(average);

    }

    private void alert(double average){
        String message = new String();
        String status = new String();
        int pic = 0;

        if (average >= 95){
            message = "Almost Perfect !";
            status = "Pass";
        }
        else if (average >= 60){
            message = "Good !";
            status = "Pass";
        }
        else{
            message = "Fail !";
            status = "Fail";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(status);
        builder.show();
    }

    public void back(View view){
        finish();
    }
}
