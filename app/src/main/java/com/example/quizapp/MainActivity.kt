package com.example.quizapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
val startButton :Button = findViewById(R.id.start_button)
val etname :EditText = findViewById(R.id.name_id)


        val ivGif :ImageView = findViewById(R.id.iv_gif)
        val tvLoop :TextView = findViewById(R.id.tv_loop)
//        val ivGif :ImageView = findViewById(R.id.iv_gif)
        //showGif
        Glide.with(this).load(R.drawable.gohandragonballz).into(ivGif)

        tvLoop.setOnClickListener {
             Toast.makeText(this,"سيبني في حالي يعم ",Toast.LENGTH_LONG).show()
               ivGif.animate().apply {
                duration =1000
                 rotationBy(360F)
               }.withEndAction{

                   Glide.with(this).load(R.drawable.android).into(ivGif)
                   ivGif.animate().apply {
                       duration =1000
                       rotationBy(360F)
                   }

               }.start()
 }

       startButton.setOnClickListener {
           if(etname.text.isNotEmpty()){
            val intent = Intent(this,QuizQuestionActivity::class.java)
          intent.putExtra(Constants.USER_NAME,etname.text.toString())
               startActivity(intent)
finish()
           }else {

               Toast.makeText(this,"دخل اسمك يعم انت",Toast.LENGTH_LONG).show()
           }

       }

    }

fun showGif(){
    val ivGif :ImageView = findViewById(R.id.iv_gif)
    Glide.with(this).load(R.drawable.gohandragonballz).into(ivGif)
}
}