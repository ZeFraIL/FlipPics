package zeev.fraiman.flippics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class FlipPics extends AppCompatActivity {

    int[] pics={R.drawable.wolf1,R.drawable.wolf2,R.drawable.wolf3,R.drawable.wolf4,R.drawable.wolf5};
    ImageView[] ivPics=new ImageView[pics.length];
    Button bPrev, bNext;
    ViewFlipper vf;
    Context context;

    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_pics);

        initElements();

        tvWelcome.setText("Welcome!");
        tvWelcome.setBackgroundColor(Color.parseColor("#123FAB"));
        tvWelcome.setTextColor(Color.YELLOW);
        tvWelcome.setPadding(20,10,45,70);
        tvWelcome.setVisibility(View.INVISIBLE);


        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vf.setOutAnimation(context, android.R.anim.slide_out_right);
                vf.showNext();
            }
        });

        bPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vf.setInAnimation(context, android.R.anim.slide_in_left);
                vf.showPrevious();
            }
        });

    }

    private void initElements() {
        context=FlipPics.this;
        bPrev=findViewById(R.id.bPrev);
        bNext=findViewById(R.id.bNext);
        vf=findViewById(R.id.vf);
        tvWelcome=findViewById(R.id.tvWelcome);
        for (int i = 0; i < pics.length; i++) {
            ivPics[i]=new ImageView(context);
            ivPics[i].setImageResource(pics[i]);
            vf.addView(ivPics[i]);
        }

    }
}