package ru.gb.androidstart.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.gb.androidstart.kotlintest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.executeButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                execute()
            }
        })
    }

    private fun execute() {
        val movie01: Movie = Movie()
        binding.titleTextView.text = movie01.title
        binding.genreTextView.text = movie01.genre.toString()

        val movie02: Movie = Movie("Lord of the Rings")
        val mysteriousObject = object {
            init {
                val movieCopy: Movie = movie02.copy(genre = Genre.FANTASY)
                binding.copyTitleTextView.text = movieCopy.title
                binding.copyGenreTextView.text = movieCopy.genre.toString()
            }
        }

        Thread(Runnable {
            var i = 1.0
            for (genre in Genre.values()) {
                binding.cycleOutputTextView.text = genre.toString()
                binding.cycleOutputTextView.setBackgroundResource(
                        if (i % 2 == 0.0)
                            R.color.pink_200
                        else
                            R.color.green_300
                )
                i++
                Thread.sleep(1000)
            }
        }).start()
    }

}