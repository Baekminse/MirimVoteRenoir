package kr.hs.emirim.mirimvoterenoir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] imgNames = {"윤재혁","재혁","째혁","멤트 와","차우","혁","재역","주ㅐ혁","재"};
    int[] voteCount = new int[imgNames.length];
    ImageView[] imgVs = new ImageView[imgNames.length];
    int[] imgVIds = {R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6, R.id.img7, R.id.img8, R.id.img9};
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDone = findViewById(R.id.btn_done);
        btnDone.setOnClickListener(btnListener);
        setTitle("멤트와");
        for(int i = 0; i<voteCount.length; i++){
            voteCount[i] = 0;
        }
        for(int i=0; i<imgVs.length; i++){
            final int index;
            index = i;
            imgVs[index] = findViewById(imgVIds[index]);
            imgVs[index].setOnClickListener(imgVListener);
        }

    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("voteCount",voteCount);
            intent.putExtra("imgNames",imgNames);
            startActivity(intent);
        }
    };

    View.OnClickListener imgVListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            voteCount[index]++;
            Toast.makeText(getApplicationContext(), imgNames[index]+": 총" + voteCount[index] +"표",Toast.LENGTH_LONG).show();
        }

    };

}