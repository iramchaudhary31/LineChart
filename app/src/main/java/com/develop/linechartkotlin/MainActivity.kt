package com.develop.linechartkotlin

import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.size
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.renderer.XAxisRenderer
import com.github.mikephil.charting.utils.MPPointF
import com.github.mikephil.charting.utils.Transformer
import com.github.mikephil.charting.utils.Utils
import com.github.mikephil.charting.utils.ViewPortHandler
import java.util.*


class MainActivity : AppCompatActivity() {

    private var lineChart: LineChart? = null
    private var highestVisibleX = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


   findViewById<ImageView>(R.id.iv_right_arrow).setOnClickListener {

       highestVisibleX= lineChart!!.highestVisibleX.toDouble()
        lineChart!!.moveViewToX(highestVisibleX.toFloat() + 1)

}

        findViewById<ImageView>(R.id.iv_left_arrow).setOnClickListener {
            highestVisibleX= lineChart!!.size.toDouble()
            lineChart!!.moveViewToX(highestVisibleX.toFloat() - 2)
        }

        lineChart = findViewById<View>(R.id.lineChart) as LineChart

        lineChart!!.setDragEnabled(true)
        lineChart!!.setScaleEnabled(false)

        lineChart!!.isScaleXEnabled  = true
        lineChart!!.isScaleYEnabled = false

        lineChart!!.setDrawBorders(false)
        lineChart!!.getDescription().isEnabled = false



        // TODO creating manual data set
        val yValues = ArrayList<Entry>()
        yValues.add(Entry(1f, 50f))
        yValues.add(Entry(2f, 70f))
        yValues.add(Entry(3f, 30f))
        yValues.add(Entry(4f, 50f))
        yValues.add(Entry(5f, 40f))
        yValues.add(Entry(6f, 70f))
        yValues.add(Entry(7f, 65f))
        yValues.add(Entry(8f, 44f))
        yValues.add(Entry(9f, 20f))
        yValues.add(Entry(10f, 50f))
        yValues.add(Entry(11f, 50f))
        yValues.add(Entry(12f, 70f))
        yValues.add(Entry(13f, 30f))
        yValues.add(Entry(14f, 50f))
        yValues.add(Entry(15f, 40f))
        yValues.add(Entry(16f, 70f))
        yValues.add(Entry(17f, 65f))
        yValues.add(Entry(18f, 44f))
        yValues.add(Entry(19f, 20f))
        yValues.add(Entry(20f, 50f))

        val set1 = LineDataSet(yValues, "")

        set1.lineWidth = 2f

        set1.mode = LineDataSet.Mode.CUBIC_BEZIER
        set1.setDrawCircles(true)
        set1.circleRadius = 4f
        set1.circleHoleColor = Color.WHITE
        set1.setCircleColor(Color.WHITE)
        set1.lineWidth = 1.5f


        //TODO to fill color in data curve
        set1.color = Color.RED
        set1.fillColor = Color.RED
        set1.setFillAlpha(55)
        set1.setDrawFilled(true)


        //TODO to hide the data values
        set1.setDrawValues(false)

        // TODO to hide horizontal scale on circle
        set1.setDrawHorizontalHighlightIndicator(false)
        // TODO to color the vertical scale on circle
        set1.highLightColor = Color.RED

        // TODO hide the data on top
      //  lineChart!!.getXAxis().isEnabled = false
        lineChart!!.setDrawGridBackground(false)

        lineChart!!.setBackgroundColor(getResources().getColor(R.color.transparent))

       lineChart!!.xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        lineChart!!.xAxis.textSize= 12F

        val xAxis = lineChart!!.getXAxis()
        xAxis.setDrawGridLines(false)
        xAxis.isEnabled= true


        //Todo to hide the color lable in chart
        val legend = lineChart!!.getLegend()
        legend.isEnabled = false


        // TODO Disable the right y axis
        val rightYAxis = lineChart!!.getAxisRight()
        rightYAxis.isEnabled = false
        rightYAxis.setDrawGridLines(false)
        rightYAxis.setDrawLabels(false)

        // TODO Disable the left y axis
        val leftYAxis = lineChart!!.getAxisLeft()
        leftYAxis.mAxisMinimum = 0f
        leftYAxis.mAxisMaximum = 100f
        leftYAxis.granularity = 100f
        leftYAxis.isEnabled = false
        leftYAxis.setDrawGridLines(false)
        leftYAxis.setDrawLabels(false)

        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(set1)

        val data = LineData(dataSets)

        //TODO set data into mchart
        lineChart!!.setData(data)
        lineChart!!.setVisibleXRangeMaximum(6f)
        lineChart!!.invalidate()
        lineChart!!.setScaleEnabled(false)
        lineChart!!.setTouchEnabled(true)
        lineChart!!.setPinchZoom(false)
        lineChart!!.isDoubleTapToZoomEnabled = false

        lineChart!!.setXAxisRenderer(CustomXAxisRenderer(lineChart!!.viewPortHandler, lineChart!!.xAxis, lineChart!!.getTransformer(YAxis.AxisDependency.LEFT)))


    }

    class CustomXAxisRenderer(viewPortHandler: ViewPortHandler?, xAxis: XAxis?, trans: Transformer?) : XAxisRenderer(viewPortHandler, xAxis, trans) {
        override fun drawLabel(c: Canvas?, formattedLabel: String, x: Float, y: Float, anchor: MPPointF?, angleDegrees: Float) {
            val line = formattedLabel.split("\n".toRegex()).toTypedArray()
            Utils.drawXAxisValue(c, line[0], x, y, mAxisLabelPaint, anchor, angleDegrees)
            Utils.drawXAxisValue(c, line[1], x + mAxisLabelPaint.textSize, y + mAxisLabelPaint.textSize, mAxisLabelPaint, anchor, angleDegrees)
        }
    }

}