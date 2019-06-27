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
    private lateinit var mEtPlace: EditText
    private lateinit var mTvActivityName: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mInitWidgets()
        mInitObjects()
        mBtnJump.setOnClickListener{
            val msg = mEtPlace.text.toString().trim()
            if(msg.isEmpty()){
                Toast.makeText(applicationContext , "please enter something!!" , Toast.LENGTH_SHORT).show()
            }else{

                val intentToSecondActivity = Intent(applicationContext, SecondActivity::class.java)
                intentToSecondActivity.putExtra("message", msg)
                startActivityForResult(intentToSecondActivity, 1);
            }
        }

    }

     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                val msg  = data!!.getStringExtra("message")

                Log.i("whats wrong" , "nothing we recevied the msg $msg")
                mEtPlace.setText(msg)
                if(msg == null){
                    mTvMessage.text = String.format(getString(R.string.hey))
                }else{
                    mTvMessage.text = String.format(getString(R.string.hey) + msg)
                }

            }
        }
    }

    private fun mInitObjects() {
        mTvActivityName.text = "First Activity"
        mEtName.visibility = View.VISIBLE
    }

    private fun mInitWidgets() {
        mTvMessage = findViewById(R.id.xTvMessage)
        mBtnJump = findViewById(R.id.xBtnJump)
        mEtName = findViewById(R.id.xEtName)
        mEtPlace = findViewById(R.id.xEtPlace)
        mTvActivityName = findViewById(R.id.xTvActivityName)
    }

}
