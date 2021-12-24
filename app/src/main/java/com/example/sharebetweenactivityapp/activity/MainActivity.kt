package com.example.sharebetweenactivityapp.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sharebetweenactivityapp.R
import com.example.sharebetweenactivityapp.model.Person
import com.example.sharebetweenactivityapp.model.User

class MainActivity : AppCompatActivity() {
    val LAUNCH_DETAILS = 1001
    var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val sendButton = findViewById<Button>(R.id.btn_send)
        val person = Person("Jonibek", "Xolmonov")
        val user = User(1234, "JonibekXolmonov")
        sendButton.setOnClickListener {
            exchangeObjectParcel(user)
        }
    }

    private fun passString(value: String) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(Intent.EXTRA_TEXT, value)
        startActivity(intent)
    }

    private fun passObjectDataSerial(person: Person) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("person", person)
        startActivity(intent)
    }

    private fun passObjectDataParcel(user: User) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
    }

    //old version
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == LAUNCH_DETAILS) {
//            if (resultCode == Activity.RESULT_OK) {
//                val text = data?.getStringExtra(Intent.EXTRA_TEXT)
//                textView = findViewById(R.id.tv_text)
//                textView?.text = text
//            }
//        }
//    }


    val detailLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK) {
            val data: Intent? = it.data
            val text = data!!.getStringExtra(Intent.EXTRA_TEXT)
            textView = findViewById(R.id.tv_text)
            textView?.text = text
        }
    }

    private fun exchangeString(value: String) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(Intent.EXTRA_TEXT, value)
        // startActivityForResult(intent, LAUNCH_DETAILS)
        detailLauncher.launch(intent)
    }

    private fun exchangeObjectSerial(person: Person) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("person", person)
        //startActivityForResult(intent, LAUNCH_DETAILS)
        detailLauncher.launch(intent)
    }

    private fun exchangeObjectParcel(user: User) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("user", user)
        //startActivityForResult(intent, LAUNCH_DETAILS)
        detailLauncher.launch(intent)
    }


}