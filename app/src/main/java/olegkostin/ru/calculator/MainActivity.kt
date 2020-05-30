package olegkostin.ru.calculator

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    val clickList = mutableListOf<MediaPlayer>()
    var result_sum = ""
    var tempSum: Double = 0.0
    var tempMunis: Double = 0.0
    var tempMul: Double = 0.0
    var tempDiv: Double = 0.0
    var tempPercent: Double = 0.0
    var tempRes: Double = 0.0
    var stopRuinMyApp = true
    var stopRuinMyAppDotaStyle = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val delete = findViewById<View>(R.id.delete)
        delete.setOnClickListener(this)

        val one = findViewById<View>(R.id.one)
        one.setOnClickListener(this)
        val two = findViewById<View>(R.id.two)
        two.setOnClickListener(this)
        val three = findViewById<View>(R.id.three)
        three.setOnClickListener(this)
        val four = findViewById<View>(R.id.four)
        four.setOnClickListener(this)
        val five = findViewById<View>(R.id.five)
        five.setOnClickListener(this)
        val six = findViewById<View>(R.id.six)
        six.setOnClickListener(this)
        val seven = findViewById<View>(R.id.seven)
        seven.setOnClickListener(this)
        val eight = findViewById<View>(R.id.eight)
        eight.setOnClickListener(this)
        val nine = findViewById<View>(R.id.nine)
        nine.setOnClickListener(this)
        val zero = findViewById<View>(R.id.zero)
        zero.setOnClickListener(this)
        val plus = findViewById<View>(R.id.plus)
        plus.setOnClickListener(this)
        result.setOnClickListener(this)
        minus.setOnClickListener(this)
        mul.setOnClickListener(this)
        div.setOnClickListener(this)
        dota.setOnClickListener(this)
        backspace.setOnClickListener(this)
        percent.setOnClickListener(this)



        clickList.add(MediaPlayer.create(this, R.raw.switch1))
        clickList.add(MediaPlayer.create(this, R.raw.switch2))
        clickList.add(MediaPlayer.create(this, R.raw.switch3))
        clickList.add(MediaPlayer.create(this, R.raw.switch4))
        clickList.add(MediaPlayer.create(this, R.raw.switch5))
        clickList.add(MediaPlayer.create(this, R.raw.switch6))
        clickList.add(MediaPlayer.create(this, R.raw.switch7))
        clickList.add(MediaPlayer.create(this, R.raw.switch8))
        clickList.add(MediaPlayer.create(this, R.raw.switch9))
        clickList.add(MediaPlayer.create(this, R.raw.switch10))
        clickList.add(MediaPlayer.create(this, R.raw.switch11))
        clickList.add(MediaPlayer.create(this, R.raw.switch12))
        clickList.add(MediaPlayer.create(this, R.raw.switch13))
        clickList.add(MediaPlayer.create(this, R.raw.switch14))
        clickList.add(MediaPlayer.create(this, R.raw.switch15))
        clickList.add(MediaPlayer.create(this, R.raw.switch16))
        clickList.add(MediaPlayer.create(this, R.raw.switch17))
        clickList.add(MediaPlayer.create(this, R.raw.switch18))
        clickList.add(MediaPlayer.create(this, R.raw.switch19))
        clickList.add(MediaPlayer.create(this, R.raw.switch20))
        clickList.add(MediaPlayer.create(this, R.raw.switch21))
        clickList.add(MediaPlayer.create(this, R.raw.switch22))
        clickList.add(MediaPlayer.create(this, R.raw.switch23))
        clickList.add(MediaPlayer.create(this, R.raw.switch24))
        clickList.add(MediaPlayer.create(this, R.raw.switch25))
        clickList.add(MediaPlayer.create(this, R.raw.switch26))
        clickList.add(MediaPlayer.create(this, R.raw.switch27))
        clickList.add(MediaPlayer.create(this, R.raw.switch28))
        clickList.add(MediaPlayer.create(this, R.raw.switch29))
        clickList.add(MediaPlayer.create(this, R.raw.switch30))
        clickList.add(MediaPlayer.create(this, R.raw.switch31))
        clickList.add(MediaPlayer.create(this, R.raw.switch32))
        clickList.add(MediaPlayer.create(this, R.raw.switch33))
        clickList.add(MediaPlayer.create(this, R.raw.switch34))
        clickList.add(MediaPlayer.create(this, R.raw.switch35))
        clickList.add(MediaPlayer.create(this, R.raw.switch36))
        clickList.add(MediaPlayer.create(this, R.raw.switch37))
        clickList.add(MediaPlayer.create(this, R.raw.switch38))


    }

    override fun onClick(v: View?) {
        when (v) {
            delete -> {
                clickList.random().start()
                tempRes = 0.0
                result_sum = ""
                result_panel.text = ""
                tempMunis = 0.0
                tempSum = 0.0
                tempMul = 0.0
                tempDiv = 0.0
            }
            result -> {
                clickList.random().start()
                if (!result_sum.isEmpty())
                    tempRes = result_sum.toDouble()
                result_sum = ""
                if (tempSum != 0.0) {
                    tempRes = tempSum + tempRes
                    tempRes = tempRes * 1000
                    val result = Math.round(tempRes).toInt()
                    tempRes = result.toDouble() / 1000
                } else if (tempMunis != 0.0) {
                    tempRes = tempMunis - tempRes
                    tempRes = tempRes * 1000
                    val result = Math.round(tempRes).toInt()
                    tempRes = result.toDouble() / 1000
                } else if (tempMul != 0.0) {
                    tempRes = tempMul * tempRes
                    tempRes = tempRes * 1000
                    val result = Math.round(tempRes).toInt()
                    tempRes = result.toDouble() / 1000
                } else if (tempPercent != 0.0) {
                    tempRes = (tempPercent / 100) * tempRes
                    tempRes = tempRes * 1000
                    val result = Math.round(tempRes).toInt()
                    tempRes = result.toDouble() / 1000
                } else if (tempDiv != 0.0) {
                    tempRes = tempDiv.div(tempRes)

                    tempRes = tempRes * 1000
                    val result = Math.round(tempRes).toInt()
                    tempRes = result.toDouble() / 1000
                } else {
                    Snackbar.make(
                        this.findViewById(R.id.coor),
                        "не знаю, что считать(",
                        Snackbar.LENGTH_LONG
                    ).show();
                }
                if ((tempRes.toInt()).toDouble() == tempRes)
                    result_panel.text = tempRes.toInt().toString()
                else
                    result_panel.text = tempRes.toString()
                tempMunis = 0.0
                tempSum = 0.0
                tempMul = 0.0
                tempPercent = 0.0
                tempDiv = 0.0
                top_ressum.text = ""
                stopRuinMyApp = true
                stopRuinMyAppDotaStyle = true
            }
            mul -> {
                clickList.random().start()
                stopRuinMyAppDotaStyle = true
                if (stopRuinMyApp) {
                    if (tempRes.toInt() != 0 || tempRes != 0.0) {
                        tempMul = tempRes
                        top_ressum.text = tempRes.toString()
                        tempRes = 0.0
                    } else {
                        tempMul = result_sum.toDouble()
                        top_ressum.text = result_sum
                    }
                    tempMunis = 0.0
                    tempSum = 0.0
                    tempDiv = 0.0

                    result_sum = ""
                    stopRuinMyApp = false
                }
            }

            div -> {
                clickList.random().start()
                if (stopRuinMyApp) {
                    if (tempRes.toInt() != 0 || tempRes != 0.0) {
                        tempDiv = tempRes
                        top_ressum.text = tempRes.toString()
                        tempRes = 0.0
                    } else {
                        tempDiv = result_sum.toDouble()
                        top_ressum.text = result_sum
                    }
                    tempMunis = 0.0
                    tempSum = 0.0
                    tempMul = 0.0

                    result_sum = ""
                    stopRuinMyApp = false
                }
            }
            plus -> {
                stopRuinMyAppDotaStyle = true
                clickList.random().start()
                if (stopRuinMyApp) {
                    if (tempRes != 0.0) {
                        tempSum = tempRes
                        top_ressum.text = tempRes.toString()
                        tempRes = 0.0
                    } else {
                        tempSum = result_sum.toDouble()
                        top_ressum.text = result_sum
                    }

                    tempMunis = 0.0
                    tempMul = 0.0
                    tempDiv = 0.0

                    result_sum = ""
                    stopRuinMyApp = false
                }
            }
            minus -> {
                clickList.random().start()
                if (stopRuinMyApp) {
                    if (tempRes.toInt() != 0 || tempRes != 0.0) {
                        tempMunis = tempRes
                        top_ressum.text = tempRes.toString()
                        tempRes = 0.0
                    } else {
                        tempMunis = result_sum.toDouble()
                        top_ressum.text = result_sum
                    }

                    tempSum = 0.0
                    tempMul = 0.0
                    tempDiv = 0.0

                    result_sum = ""
                    stopRuinMyApp = false
                }
            }
            dota -> {
                clickList.random().start()
                if (stopRuinMyAppDotaStyle) {
                    if (!result_sum.isEmpty()) {
                        result_sum += "."
                        stopRuinMyAppDotaStyle = false
                    }
                    result_panel.text = result_sum
                }
            }

            backspace -> {
                clickList.random().start()
                if (!result_sum.isEmpty()) {
                    result_sum = result_sum.substring(0, result_sum.length - 1)
                    result_panel.text = result_sum
                }
            }
            percent -> {
                clickList.random().start()
                if (stopRuinMyApp) {
                    if (tempRes.toInt() != 0 || tempRes != 0.0) {
                        tempPercent = tempRes
                        top_ressum.text = tempRes.toString()
                        tempRes = 0.0
                    } else {
                        tempPercent = result_sum.toDouble()
                        top_ressum.text = result_sum
                    }
                    tempMunis = 0.0
                    tempSum = 0.0
                    tempDiv = 0.0
                    result_sum = ""
                    stopRuinMyApp = false
                }

            }

            one -> {
                clickList.random().start()
                result_sum += "1"
                result_panel.text = result_sum
            }
            two -> {
                clickList.random().start()
                result_sum += "2"
                result_panel.text = result_sum
            }

            three -> {
                clickList.random().start()
                result_sum += "3"
                result_panel.text = result_sum
            }
            four -> {
                clickList.random().start()
                result_sum += "4"
                result_panel.text = result_sum
            }
            five -> {
                clickList.random().start()
                result_sum += "5"
                result_panel.text = result_sum
            }
            six -> {
                clickList.random().start()
                result_sum += "6"
                result_panel.text = result_sum
            }
            seven -> {
                clickList.random().start()
                result_sum += "7"
                result_panel.text = result_sum
            }
            eight -> {
                clickList.random().start()
                result_sum += "8"
                result_panel.text = result_sum
            }
            nine -> {
                clickList.random().start()
                result_sum += "9"
                result_panel.text = result_sum
            }
            zero -> {
                clickList.random().start()
                if (!result_sum.isEmpty())
                    result_sum += "0"
                result_panel.text = result_sum
            }

        }
    }

}




