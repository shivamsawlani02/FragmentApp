package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    Button firstFrag,secondFrag,bottom;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstFrag=findViewById(R.id.firstFragment);
        secondFrag=findViewById(R.id.secondFragment);
        frameLayout=findViewById(R.id.frameLayout);
        bottom=findViewById(R.id.bottom_btnl);

        firstFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new FirstFragment());
            }
        });
        secondFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new SecondFragment());
            }
        });
        bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,BottomNavActivity.class);
                startActivity(intent);

            }
        });



    }
    public void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    /*public void onClick(View view) {
        View.OnClickListener showFrag= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.firstFragment:
                        loadFragment(new FirstFragment());
                        break;
                    case R.id.secondFragment:
                        loadFragment(new SecondFragment());
                        break;
                    case R.id.bottom_btnl:
                        Intent intent=new Intent(MainActivity.this,BottomNavActivity.class);
                        startActivity(intent);
                }
            }
        };

    }

     */
}
