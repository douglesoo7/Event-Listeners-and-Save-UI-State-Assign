package com.example.eventlistenersandsaveuistates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mEtCharacters;
    private TextView mTvButtonState;
    private Button mBtnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mEtCharacters.addTextChangedListener(textWatcher);
        mBtnClick.setOnClickListener(this);
    }

    private void initViews() {
        mEtCharacters=findViewById(R.id.etCharacters);
        mTvButtonState=findViewById(R.id.tvButtonState);
        mBtnClick=findViewById(R.id.btnClick);
    }

    private TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (mEtCharacters.getText().toString().length()>6)
                Toast.makeText(MainActivity.this,mEtCharacters.getText().toString(),Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch(id){
            case R.id.btnClick:
                mTvButtonState.setText("ButtonClicked");
                break;
        }
    }
}