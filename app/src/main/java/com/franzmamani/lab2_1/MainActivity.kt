package com.franzmamani.lab2_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() ,ContadorListener{

    var frac1:frac1?=null;
    var frac2:frac2?=null;
    var frac3:frac3?=null;

    var cont=0;
    override  fun incrementar(){
        cont++;
    }

    override fun getValorActual(): Int {
        return cont;
    }

    override fun reducir() {
        if(cont>0) cont--;
        else cont=0;
    }

    override fun resetear() {
        cont=0;
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        frac1= frac1()
        frac1?.addContadorListener(this)
        frac2= frac2()
        frac2?.addListener(this)
        frac3= frac3()
        frac3?.addListener2(this)

        val btn1=findViewById<Button>(R.id.botonF1);
        val btn2=findViewById<Button>(R.id.botonF2);
        val btn3=findViewById<Button>(R.id.botonR)


        btn1.setOnClickListener {
            val trn = getSupportFragmentManager().beginTransaction()
            trn.replace(R.id.frameContenedor,frac1!!)
            trn.commit();
        }
        btn2.setOnClickListener {
            val trn=getSupportFragmentManager().beginTransaction()
            trn.replace(R.id.frameContenedor,frac2!!)
            trn.commit();
        }
        btn3.setOnClickListener {
            val trn=getSupportFragmentManager().beginTransaction()
            trn.replace(R.id.frameContenedor,frac3!!)
            trn.commit()
        }
    }
}