package com.sample.sampleforteach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        Switch switch1 = (Switch)findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText1 = (EditText)findViewById(R.id.editText1);
                EditText editText2 = (EditText)findViewById(R.id.editText2);

                TextView resultView = (TextView)findViewById(R.id.resultView);


                //入力内容を取得
                String strNum = editText1.getText().toString();
                String strMoney = editText2.getText().toString();

                //Intに変換
                int num = Integer.parseInt(strNum);
                int money = Integer.parseInt(strMoney);

                //割り算の計算
                int result;
                if (flag == 1){
                    result = money / num;
                    result *= 1.08;
                }else {
                    result = money / num;
                }

                //結果を表示
                resultView.setText(Integer.toString(result));

                //EditTextの内容をクリア
                editText1.getEditableText().clear();
                editText2.getEditableText().clear();
            }
        });
    }

    //追加
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        if (isChecked == true){
            flag = 1;
        } else {
            flag = 0;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
