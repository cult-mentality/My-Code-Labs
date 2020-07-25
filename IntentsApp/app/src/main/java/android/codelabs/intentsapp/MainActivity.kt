package android.codelabs.intentsapp

import android.codelabs.intentsapp.SecondActivity.Companion.REPLY
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun sendMessage(view: View) {
        val intent = Intent()
        intent.putExtra(MESSAGE, editText?.text.toString())
        intent.setClass(this, SecondActivity::class.java)
        this.startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                editText?.text?.clear()
                data?.getStringExtra(REPLY)?.let {
                    textView3?.visibility = View.VISIBLE
                    textView4?.text = it
                    textView4?.visibility = View.VISIBLE
                }
            }
        }
    }

    companion object {
        const val MESSAGE = "Message"
        const val TEXT_REQUEST = 1
    }
}
