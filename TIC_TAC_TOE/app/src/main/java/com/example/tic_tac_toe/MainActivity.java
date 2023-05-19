package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tic_tac_toe.R;

public class MainActivity extends AppCompatActivity {
    boolean winner =false;
    int image_click=-1;
    int player=1; //Cross
    int [][]winning={{0,1,2},{3,4,5},{6,7,8}};
    int []game={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load (View view) {
        ImageView v = (ImageView) view;
        int tag = Integer.parseInt(v.getTag().toString());
        image_click=game[tag];
        if(winner == false && image_click==-1 ) {
            if (player == 1) {
                v.setImageResource(R.drawable.download1);
                game[tag] = player;
                Toast.makeText(this, tag + " " + "Cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.circle);
                game[tag] = player;
                Toast.makeText(this, tag + " " + "Circle", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int i = 0; i < winning.length; i++) {
                if ((game[winning[i][0]] == game[winning[i][1]] && game[winning[i][1]] == game[winning[i][2]] && game[winning[i][0]] > -1) || (game[winning[0][i]] == game[winning[1][i]] && game[winning[1][i]] == game[winning[2][i]] && game[winning[0][i]] > -1))    {
                    Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    winner=true;
                }
                if(i==0)
                {
                    if  ((game[winning[i][0]] == game[winning[i+1][1]] && game[winning[i+1][1]] == game[winning[i+2][2]] && game[winning[i][0]] > -1) || (game[winning[i][2]] == game[winning[i+1][1]] && game[winning[i+1][1]] == game[winning[i+2][0]] && game[winning[i][2]] > -1)){
                        Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                        winner=true;
                    }
                }
            }
        }

    }
    public void reset(View view) {
        GridLayout gridlayout = findViewById(R.id.gridlayout);
        int total_image = gridlayout.getChildCount();
        for (int i = 0; i < total_image; i++)
        {
            ImageView v =(ImageView) gridlayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        winner=false;
        image_click=-1;
        for(int i=0;i<game.length;i++)
        {
            game[i]=-1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}