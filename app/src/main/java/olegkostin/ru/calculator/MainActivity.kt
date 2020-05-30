package olegkostin.ru.calculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var result_sum = ""
    var tempSum : Double = 0.0
    var tempMunis  : Double = 0.0
    var tempMul : Double = 0.0
    var tempDiv  : Double = 0.0
    var tempRes : Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val top_ressum = findViewById<View>(R.id.top_ressum)
        var delete = findViewById<View>(R.id.delete)
        delete.setOnClickListener(this)
        var result_panel = findViewById<View>(R.id.result_panel)
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
    }

    override fun onClick(v: View?) {
        when (v) {
            delete -> {
                tempRes = 0.0
                result_sum = ""
                result_panel.text = ""
                tempMunis =0.0
                tempSum =0.0
                tempMul = 0.0
                tempDiv =0.0
            }
            result -> {
                if(!result_sum.isEmpty())
                tempRes = result_sum.toDouble()
                result_sum = ""
                if ( tempSum != 0.0 ) {
                    tempRes = tempSum + tempRes

                }
           else     if (tempMunis != 0.0 ) {
                    tempRes = tempMunis - tempRes

                }
           else     if (tempMul != 0.0 ) {
                    tempRes = tempMul * tempRes

                }
          else      if ( tempDiv != 0.0 ) {
                    tempRes = tempDiv.div(tempRes)

                    tempRes = tempRes * 1000
                    val result = Math.round(tempRes).toInt()
                     tempRes = result.toDouble() / 1000
                }
                else{
                    Snackbar.make(this.findViewById(R.id.coor), "не знаю, что считать(", Snackbar.LENGTH_LONG).show();
                }

                result_panel.text = tempRes.toString()
                tempMunis =0.0
                tempSum =0.0
                tempMul = 0.0
                tempDiv =0.0
                top_ressum.text = ""
            }
            mul -> {
                if (tempRes.toInt() != 0   || tempRes != 0.0) {
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

            }

            div -> {
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

            }
            plus -> {
                if (tempRes != 0.0) {
                    tempSum = tempRes.toDouble()
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

            }
            minus -> {
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

            }
            one -> {

                result_sum += "1"
                result_panel.text = result_sum
            }
            two -> {

                result_sum += "2"
                result_panel.text = result_sum
            }
            two -> {
                result_sum += "2"
                result_panel.text = result_sum
            }
            three -> {
                result_sum += "3"
                result_panel.text = result_sum
            }
            four -> {
                result_sum += "4"
                result_panel.text = result_sum
            }
            five -> {
                result_sum += "5"
                result_panel.text = result_sum
            }
            six -> {
                result_sum += "6"
                result_panel.text = result_sum
            }
            seven -> {
                result_sum += "7"
                result_panel.text = result_sum
            }
            eight -> {
                result_sum += "8"
                result_panel.text = result_sum
            }
            nine -> {
                result_sum += "9"
                result_panel.text = result_sum
            }
            zero -> {
                if (!result_sum.isEmpty())
                    result_sum += "0"
                result_panel.text = result_sum
            }

        }
    }

}
