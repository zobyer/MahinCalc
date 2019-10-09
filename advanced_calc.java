package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Set;

public class advanced_calc extends AppCompatActivity {



    private Button sin_bt,cos_bt,tan_bt,sq_bt,sqr_bt,ret_bt;
    private TextView out_tv;
    private EditText ent_et;

    double result;
    double num;

    DatabaseReference refer;
    Member mem;

    long maxid=0,xid=0;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_calc);

        sin_bt=findViewById(R.id.sin_bt);
        cos_bt=findViewById(R.id.cos_bt);
        tan_bt=findViewById(R.id.tan_bt);
        sq_bt=findViewById(R.id.sq_bt);
        sqr_bt=findViewById(R.id.sqr_bt);
        ret_bt=findViewById(R.id.ret_bt);
        out_tv=findViewById(R.id.out_tv);
        ent_et=findViewById(R.id.ent_et);
        mem=new Member();
        refer= FirebaseDatabase.getInstance().getReference().child("Member");
        refer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    maxid=(dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        sin_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snum;
                   snum=ent_et.getText().toString();

                if(snum.isEmpty()) {
                    Toast.makeText( advanced_calc.this, "No input",Toast.LENGTH_SHORT).show();
                    return;

                }
                num=Double.parseDouble(snum);
                num= (num/180)*3.141592;
                result=Math.sin(num);
                out_tv.setText(String.valueOf(result));

                mem.setNum(result);
                refer.child(String.valueOf(maxid+1)).setValue(mem);
                Toast.makeText(advanced_calc.this,"Data Inserted",Toast.LENGTH_SHORT).show();

            }
        })
        ;


        cos_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snum;
                snum=ent_et.getText().toString();

                if(snum.isEmpty()) {
                    Toast.makeText( advanced_calc.this, "No input",Toast.LENGTH_SHORT).show();
                    return;

                }
                num=Double.parseDouble(snum);
                num= (num/180)*3.141592;
                result=Math.cos(num);
                out_tv.setText(String.valueOf(result));
                mem.setNum(result);
                refer.child(String.valueOf(maxid+1)).setValue(mem);

                Toast.makeText(advanced_calc.this,"Data Inserted",Toast.LENGTH_SHORT).show();

            }
        })
        ;

        tan_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snum;
                snum=ent_et.getText().toString();

                if(snum.isEmpty()) {
                    Toast.makeText( advanced_calc.this, "No input",Toast.LENGTH_SHORT).show();
                    return;

                }
                num=Double.parseDouble(snum);
                num= (num/180)*3.141592;
                result=Math.tan(num);
                out_tv.setText(String.valueOf(result));
                mem.setNum(result);
                refer.child(String.valueOf(maxid+1)).setValue(mem);
                Toast.makeText(advanced_calc.this,"Data Inserted",Toast.LENGTH_SHORT).show();

            }
        })
        ;

        sq_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snum;
                snum=ent_et.getText().toString();

                if(snum.isEmpty()) {
                    Toast.makeText( advanced_calc.this, "No input",Toast.LENGTH_SHORT).show();
                    return;

                }
                num=Double.parseDouble(snum);
                result=Math.pow(num,2);
                out_tv.setText(String.valueOf(result));
                mem.setNum(result);
                refer.child(String.valueOf(maxid+1)).setValue(mem);
                Toast.makeText(advanced_calc.this,"Data Inserted",Toast.LENGTH_SHORT).show();

            }
        })
        ;

        sqr_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snum;
                snum=ent_et.getText().toString();

                if(snum.isEmpty()) {
                    Toast.makeText( advanced_calc.this, "No input",Toast.LENGTH_SHORT).show();
                    return;

                }
                num=Double.parseDouble(snum);
                result=Math.sqrt(num);
                out_tv.setText(String.valueOf(result));
                mem.setNum(result);
                refer.child(String.valueOf(maxid+1)).setValue(mem);
                Toast.makeText(advanced_calc.this,"Data Inserted",Toast.LENGTH_SHORT).show();

            }
        })
        ;


        ret_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refer= FirebaseDatabase.getInstance().getReference().child("Member").child("12");
                   refer.addValueEventListener(new ValueEventListener() {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                          String num1=dataSnapshot.child("num").getValue().toString();
                          out_tv.setText(num1);
                       }

                       @Override
                       public void onCancelled(@NonNull DatabaseError databaseError) {

                       }
                   });


            }
        });


    }
}
