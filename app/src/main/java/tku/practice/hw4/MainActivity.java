package tku.practice.hw4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText linear, algorithm, probability;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView(){
        linear = findViewById(R.id.linear);
        algorithm = findViewById(R.id.algorithm);
        probability = findViewById(R.id.probability);

    }

    private boolean inputcorrect(EditText et){
        String pattern = "1[0]{2}|[0-9]{1,2}";
        String text = et.getText().toString();
        if (!text.matches(pattern)){
            et.setError("must be 0~100");
            return false;
        }
        else{
            return true;
        }

    }

    public void calculate(View view){

        boolean inputok = inputcorrect(linear) & inputcorrect(algorithm) & inputcorrect(probability);
        if (!inputok){
            return;
        }

        int l = Integer.parseInt(linear.getText().toString()),
                a = Integer.parseInt(algorithm.getText().toString()),
                p = Integer.parseInt(probability.getText().toString());
        Intent intent = new Intent(this, result.class);
        Bundle bundle = new Bundle();
        bundle.putInt("linear", l);
        bundle.putInt("algorithm", a);
        bundle.putInt("probability", p);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
