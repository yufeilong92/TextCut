package com.lawyee.textcut;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTv1;
    private Button mBtn;
    private TextView mTv;
    private TextView mTv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mTv1 = (TextView) findViewById(R.id.tv1);
        mBtn = (Button) findViewById(R.id.btn);
        mTv = (TextView) findViewById(R.id.tv);

        mBtn.setOnClickListener(this);
        mTv2 = (TextView) findViewById(R.id.tv2);
        mTv2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                String trim = mTv1.getText().toString().trim();
                String substring = trim.substring(trim.indexOf(","), trim.length());
             mTv2.setText(substring);
                StringTokenizer tokenizer = new StringTokenizer(trim, ",");
                List<String> mList = new ArrayList<>();
                while (tokenizer.hasMoreTokens()) {
                    String s = tokenizer.nextToken();
                    mList.add(s);
                }
                mTv.setText(mList.get(0) + "\n" + mList.get(1));
                break;
        }
    }
}
