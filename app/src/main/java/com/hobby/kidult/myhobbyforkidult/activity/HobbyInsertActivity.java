package com.hobby.kidult.myhobbyforkidult.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.hobby.kidult.myhobbyforkidult.common.Define;
import com.hobby.kidult.myhobbyforkidult.R;

public class HobbyInsertActivity extends AppCompatActivity{

    private Context mContext;
    private Intent mIntent;

    private long gameCnt;

    //ui
    Button btn_Game_Insert;

    EditText edt_Game_Name;
    Spinner spi_Game_Condition, spi_Game_OpenYN, spi_Game_EndingYN, spi_Game_RentYN;
    EditText edt_Game_Price, edt_Game_Buy_Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ps4_game_insert);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        mContext = this;

        mIntent = getIntent();
        gameCnt = mIntent.getLongExtra("gameLastNumber",0);

        edt_Game_Name = (EditText) findViewById(R.id.edt_Game_Name);
        edt_Game_Price = (EditText) findViewById(R.id.edt_Game_Price);
        edt_Game_Buy_Date = (EditText) findViewById(R.id.edt_Game_Price);

        spi_Game_Condition = (Spinner) findViewById(R.id.spi_Game_Condition);
        spi_Game_OpenYN = (Spinner) findViewById(R.id.spi_Game_OpenYN);
        spi_Game_EndingYN = (Spinner) findViewById(R.id.spi_Game_EndingYN);
        spi_Game_RentYN = (Spinner) findViewById(R.id.spi_Game_RentYN);



















        // DB 테이블에 데이터 추가
        btn_Game_Insert = (Button) findViewById(R.id.btn_Game_Insert);
        btn_Game_Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Define.dbHelper.insert("","","","","",0, "");
            }
        });


    }
}
