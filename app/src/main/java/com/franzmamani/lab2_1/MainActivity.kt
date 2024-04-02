package com.franzmamani.lab2_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import android.widget.Toolbar

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val infla=menuInflater
        infla.inflate(R.menu.menu_tb,menu)

        /*val item =menu?.findItem(R.id.ibuscar)
        val sv=item?.actionView as android.widget.SearchView?
        sv?.setOnQueryTextListener( object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                val activity=sv.context as MainActivity
                Toast.makeText(activity,"buscar :" +p0,Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val activity=sv.context as MainActivity
                Toast.makeText(activity,newText,Toast.LENGTH_SHORT ).show()
                return true
            }


        })

         */
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.iguardar->Toast.makeText(this,"clic en guardar",Toast.LENGTH_SHORT).show()
            R.id.iajustar->Toast.makeText(this,"clic en ajustes",Toast.LENGTH_SHORT).show()
            R.id.ibuscar->Toast.makeText(this,"clic en buscar",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mtoolb=findViewById<androidx.appcompat.widget.Toolbar>(R.id.IncluTB)
        setSupportActionBar(mtoolb)

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