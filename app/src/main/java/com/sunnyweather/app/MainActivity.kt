package com.sunnyweather.app

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener
import com.permission.lgx.PermissionX


typealias PermissionCallback = (Boolean,List<String>)-> Unit

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.MakeCall).setOnClickListener {
            PermissionX.request(this, Manifest.permission.CALL_PHONE){
                allGranted,deniedList ->
                if(allGranted){
                    call()
                }else {
                    Toast.makeText(this,"You denied $deniedList",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun call() {
        try{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
        }
    }


}