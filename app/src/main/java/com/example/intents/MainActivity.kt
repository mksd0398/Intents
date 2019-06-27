package com.example.intents

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mTvMessage : TextView
    private lateinit var mBtnJump : Button
    private lateinit var mEtName : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mInitWidgets()
        mInitObjects()

        val msg:String? = intent.getStringExtra("message")
        mEtName.setText(msg)

        if(msg == null){
            mTvMessage.text = String.format(getString(R.string.hey))
        }else{
            mTvMessage.text = String.format(getString(R.string.hey) + msg)
        }

        Log.i("formatinfo" , String.format(getString(R.string.hey) + msg))
        mBtnJump.setOnClickListener{
            val msg = mEtName.text.toString().trim()
            if(msg.isEmpty()){
                Toast.makeText(applicationContext , "please enter something!!" , Toast.LENGTH_SHORT).show()
            }else{
                val intentToSecondActivity = Intent(applicationContext, SecondActivity::class.java)
                intentToSecondActivity.putExtra("message", msg)
                startActivity(intentToSecondActivity)
                finish()
            }
        }

    }

    private fun mInitObjects() {

    }

    private fun mInitWidgets() {
        mTvMessage = findViewById(R.id.xTvMessage)
        mBtnJump = findViewById(R.id.xBtnJump)
        mEtName = findViewById(R.id.xEtName)
    }


}
