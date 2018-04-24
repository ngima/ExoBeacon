package com.exotrac.exobeacon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.nearby.Nearby
import com.google.android.gms.nearby.messages.Message
import com.google.android.gms.nearby.messages.MessageListener
import com.google.android.gms.nearby.messages.Strategy
import com.google.android.gms.nearby.messages.SubscribeOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    var mMessageListener: MessageListener? = null

    var mMessage = Message("Hello World".toByteArray())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMessageListener = object : MessageListener() {
            override fun onFound(message: Message) {
                Toast.makeText(baseContext, String(message.content), Toast.LENGTH_LONG).show()
                Logger.d(TAG, "Found message: " + String(message.content))
            }

            override fun onLost(message: Message) {
                Toast.makeText(baseContext, String(message.content), Toast.LENGTH_LONG).show()
                Logger.d(TAG, "Lost sight of message: " + String(message.content))
            }
        }

        buttonSendMessage.setOnClickListener {
            Nearby.getMessagesClient(this).publish(mMessage)
        }

    }

    override fun onStart() {
        super.onStart()

        Nearby.getMessagesClient(this).publish(mMessage)

        var options = SubscribeOptions.Builder()
                .setStrategy(Strategy.BLE_ONLY)
                .build()

        if (mMessageListener != null)
            Nearby.getMessagesClient(this).subscribe(mMessageListener!!, options)
    }

    override fun onStop() {
        Nearby.getMessagesClient(this).unpublish(mMessage)
        if (mMessageListener != null)
            Nearby.getMessagesClient(this).unsubscribe(mMessageListener!!)
        super.onStop()
    }
}
