package sa.edu.tuwaiq.fockos.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.constraintlayout.motion.widget.MotionLayout
import sa.edu.tuwaiq.fockos.R
import sa.edu.tuwaiq.fockos.databinding.ActivitySplashBinding
//@NOURAH ALNASSER
class Splash : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val logo:ImageView = findViewById(R.id.imageView7)
        binding.splashImageView.setTransitionListener(object  : MotionLayout.TransitionListener {
            override fun onTransitionStarted(motionLayout: MotionLayout?, startId: Int, endId: Int) {


            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {

            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                var intent = Intent (this@Splash, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {

            }


        })

    }






}








