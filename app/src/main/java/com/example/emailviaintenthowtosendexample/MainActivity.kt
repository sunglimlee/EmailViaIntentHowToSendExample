package com.example.emailviaintenthowtosendexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var mEditTextTo : EditText
    private lateinit var mEditSubject : EditText
    private lateinit var mEditMessage : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mEditTextTo = findViewById(R.id.edit_text_to)
        mEditSubject = findViewById(R.id.edit_text_subject)
        mEditMessage = findViewById(R.id.edit_text_message)
        val button : Button = findViewById(R.id.button_send)
        button.setOnClickListener {
            sendMail()
        }
    }

    private fun sendMail() {
        val recipientList : String = mEditTextTo.text.toString()
        val recipients : List<String> = recipientList.split(",")

        val subject : String = mEditSubject.text.toString()
        val message : String = mEditMessage.text.toString()

        val intent : Intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL, arrayListOf(recipients))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, message)
        intent.setType("message/rfc822")
        startActivity(Intent.createChooser(intent, "Choose an email client"))
    }
}