package com.hobby.kidult.myhobbyforkidult;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hobby.kidult.myhobbyforkidult.common.Define;
import com.hobby.kidult.myhobbyforkidult.helper.Ps4Game_DbHelper;

public class Main extends AppCompatActivity implements View.OnClickListener {

    protected Context mContext;

    private Ps4Game_DbHelper dbHelper;

    long gameCnt = 0;

    TextView tv_Game_Cnt, tv_Game_NewRate, tv_Game_EndingRate, tv_Game_OpenRate, tv_Game_PriceAll;
    Button btn_game_insert, btn_game_modify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mContext = this;

        dbHelper = new Ps4Game_DbHelper(Main.this, "Ps4Game.db", null, 1);
        //dbHelper.testDB();

        tv_Game_Cnt = (TextView) findViewById(R.id.tv_Game_Cnt);
        tv_Game_NewRate = (TextView) findViewById(R.id.tv_Game_NewRate);
        tv_Game_EndingRate = (TextView) findViewById(R.id.tv_Game_EndingRate);
        tv_Game_OpenRate = (TextView) findViewById(R.id.tv_Game_OpenRate);
        tv_Game_PriceAll = (TextView) findViewById(R.id.tv_Game_PriceAll);


        btn_game_insert = (Button) findViewById(R.id.btn_game_insert);
        btn_game_insert.setOnClickListener(this);

        btn_game_modify = (Button) findViewById(R.id.btn_game_modify);
        btn_game_modify.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if( id == R.id.btn_game_insert)
        {
            /*
            Intent intent = new Intent(mContext, HobbyInsertActivity.class);
            intent.putExtra("gameLastNumber", gameCnt);

            startActivityForResult(intent, 00);
            */
            dbHelper.insert("","","","","",0, "");

        }
        else if( id == R.id.btn_game_modify)
        {
            gameCnt = dbHelper.getCount(Define.PS4_GAME_TABLE);
            Toast.makeText(mContext, "현재 개수는 " + gameCnt, Toast.LENGTH_SHORT).show();
            tv_Game_Cnt.setText(gameCnt+"개");
        }
    }

    protected void onActivityResult(int reqID, int result, Intent data) {
        super.onActivityResult(reqID, result, data);
        if( result == RESULT_OK) {
            switch(reqID) {
                case 00:
                    Toast.makeText(mContext, "입력 완료", Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    }
}
