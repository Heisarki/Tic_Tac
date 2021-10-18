package com.example.hskp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    int t;
    int player = 0;
    int[] mem = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] win={{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    GridLayout grid;
    String winn;
    TextView textView;
    ImageView count;
    boolean end =true;

    public void play(View view){

        LinearLayout lay= (LinearLayout) findViewById(R.id.linearLayout);
        lay.setVisibility(View.INVISIBLE);
        //lay.setAlpha(0f);


        player=0;
        for(int i=0; i < mem.length; i++){
            mem[i]=2;
        }
        //String m= Integer.toString(mem[0]);
        //count.setImageResource(R.drawable.yellow);
        //GridLayout gri = (GridLayout) findViewById(R.id.gridLayout);
        //String m=Integer.toString(gri.getChildCount());
        //Log.i("my_var", m);
        //System.out.println(player);


        ImageView i = (ImageView) findViewById(R.id.imageView1);
        i.setImageResource(0);

        ImageView m = (ImageView) findViewById(R.id.imageView2);
        m.setImageResource(0);


        ImageView o = (ImageView) findViewById(R.id.imageView3);
        o.setImageResource(0);

        ImageView p = (ImageView) findViewById(R.id.imageView4);
        p.setImageResource(0);


        ImageView r = (ImageView) findViewById(R.id.imageView5);
        r.setImageResource(0);

        ImageView t = (ImageView) findViewById(R.id.imageView6);
        t.setImageResource(0);


        ImageView a = (ImageView) findViewById(R.id.imageView7);
        a.setImageResource(0);

        ImageView f = (ImageView) findViewById(R.id.imageView8);
        f.setImageResource(0);

        ImageView n = (ImageView) findViewById(R.id.imageView9);
        n.setImageResource(0);

        end= true;

    }



    public void drop(View view) {

        ImageView count = (ImageView) view;
        int counter = Integer.parseInt(count.getTag().toString());

        if (mem[counter] == 2 & end) {
            mem[counter] = player;
            count.setTranslationY(-1000f);

            if (player == 0) {
                count.setImageResource(R.drawable.w);
                player = 1;
            } else {
                count.setImageResource(R.drawable.q);
                player = 0;
            }
            System.out.println(count.getTag().toString());
            count.animate().translationYBy(1000f).rotation(360).setDuration(100);



            for(int[] winner: win) {


                if ((mem[winner[0]]) == (mem[winner[1]]) && (mem[winner[0]]) == (mem[winner[2]])
                        && (mem[winner[0]]) != 2) {

                    /*if (mem[winner[0]]==0) {
                        System.out.println("wimnner is red");

                    }*/
                    winn = "0";
                    if (mem[winner[0]] == 1) {
                        System.out.println("wimnner is yellow");
                        winn = "X";
                    } else {
                        LinearLayout lay = (LinearLayout) findViewById(R.id.linearLayout);
                        lay.setVisibility(View.VISIBLE);
                        textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Its a draw\n Try again");
                    }


                    LinearLayout lay = (LinearLayout) findViewById(R.id.linearLayout);
                    lay.setVisibility(View.VISIBLE);
                    textView = (TextView) findViewById(R.id.textView);
                    textView.setText(winn + " has Won");
                    end = false;

                    //lay.setAlpha(1f);

                }
            }


            }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
