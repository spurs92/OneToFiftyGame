package com.spurs.onetofifty;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button[] btns=new Button[25];

    int cnt=1; //현재 눌러야 될 번호

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=(TextView)findViewById(R.id.text1);

        Random rnd=new Random();
        int[] arr=new int[25];
        //중복되지 않은 25개의 랜덤값 부여하기..
        for (int i=0;i<25; i++){
            arr[i]=rnd.nextInt(25)+1;//1~25
            for(int k=0; k<i; k++){
                if(arr[i]==arr[k]){
                    i--;
                    break;
                }
            }
        }

        //참조변수 25개에 버튼 객체를 참조시키는 작업
        for(int i=0; i<25;i++){
            btns[i]=(Button)findViewById(R.id.btn01+i);
            btns[i].setText(arr[i]+"");
            btns[i].setTag(arr[i]);
        }
    }//onCreate Method..

    //멤버 메소드
    //onClick속성이 부여된 View가 클릭되면 자동으로 실행되는 메소드
    //onClick속에서 작성한 메소드의 이름으로 메소들를 설계
    //강제 규칙
    //1.public
    //2.void
    //3.메소드명 : onClick속성에 작성한 이름과 같아야 함
    //4.파라미터 : View 타입 1개만 가능
    public void clickBtn(View v){

        Button btn=null;
        if(v instanceof Button) btn=(Button) v;

        //클릭된 v(버튼)에 써있는 글씨 얻어오기
        //String s=btn.getText().toString();
        String s=btn.getTag().toString();
        //얻어온 글씨를 정수형으로 변환
        int num=Integer.parseInt(s);

        //얻어온 글씨가 눌러야할 cnt번호와 같은지 비교
        if(num==cnt){
            btn.setText("OK");
            btn.setTextColor(Color.RED);
            btn.setBackgroundColor(Color.TRANSPARENT);
            cnt++;
            text.setText(cnt+"");
        }

        if(cnt>25){
            text.setText("Clear");
        }
    }

    public void clickImg(View v){

        String s= v.getTag().toString();
        text.getText();

    }

}//MainActivity class..
