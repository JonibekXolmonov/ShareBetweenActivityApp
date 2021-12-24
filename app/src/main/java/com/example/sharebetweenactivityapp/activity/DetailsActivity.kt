package com.example.sharebetweenactivityapp.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sharebetweenactivityapp.R
import com.example.sharebetweenactivityapp.model.Person
import com.example.sharebetweenactivityapp.model.User

class DetailsActivity : AppCompatActivity() {
    var textDetails: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        initView()
    }

    private fun initView() {
        val sendDetails = findViewById<Button>(R.id.btn_send_data_details)
        val person = Person("Saidahmad", "Ataullayev")
        val user = User(2345, "AtaullayevSaidahmadBro")

        receiveObjectParcel()

        sendDetails.setOnClickListener {
            backObjectParcelToSenderActivity(user)
        }
    }

    private fun receiveText() {
        textDetails = findViewById(R.id.tv_text_receiver)
        val text = intent.getStringExtra(Intent.EXTRA_TEXT)
        textDetails?.text = text
    }

    private fun receiveObjectSerial() {
        textDetails = findViewById(R.id.tv_text_receiver)
        val objectData = intent.getSerializableExtra("person")
        textDetails?.text = objectData.toString()
    }

    private fun receiveObjectParcel() {
        textDetails = findViewById(R.id.tv_text_receiver)
        val objectData = intent.getParcelableExtra<User>("user")
        textDetails?.text = objectData.toString()
    }

    private fun backStringToSenderActivity(value: String) {
        val intent = Intent()
        intent.putExtra(Intent.EXTRA_TEXT, value)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun backObjectSerialToSenderActivity(person: Person) {
        val intent = Intent()
        intent.putExtra(Intent.EXTRA_TEXT, person.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun backObjectParcelToSenderActivity(user: User) {
        val intent = Intent()
        intent.putExtra(Intent.EXTRA_TEXT, user.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}