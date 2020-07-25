package android.codelabs.intentsapp

import android.codelabs.intentsapp.MainActivity.Companion.MESSAGE
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val message = intent.getStringExtra(MESSAGE) ?: ""
        textView2?.text = message
    }


    companion object {
        const val REPLY = "reply"
    }

    fun sendReply(view: View) {
        val reply = editText2?.text.toString()
        val intent = Intent()
        intent.putExtra(REPLY, reply)
        setResult(RESULT_OK, intent)
        finish()
    }
}
