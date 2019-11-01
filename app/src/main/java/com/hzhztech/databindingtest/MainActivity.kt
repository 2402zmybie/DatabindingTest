package com.hzhztech.databindingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.hzhztech.databindingtest.databinding.ActivityMainBinding
import com.hzhztech.databindingtest.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myViewModel:MyViewModel
//    lateinit var textView:TextView
//    lateinit var button: Button
    //BuildProject 自动生成的一个类 这是DataBinding方式一,  方式二是直接在xml中绑定数据
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //方法一需要
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //方法一不需要
//        textView = findViewById(R.id.textView)
        //方法一不需要
//        button = findViewById(R.id.button)

        myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)

        // 方式一的控件全部在binding中进行管理  ActivityMainBinding是google自动生成的一个类
//        myViewModel.number.observe(this,object :Observer<Int> {
//            override fun onChanged(t: Int?) {
//                binding.textView.text = myViewModel.number.value.toString()
//            }
//        })
//
//        binding.button.setOnClickListener {
//            myViewModel.addNumber()
//        }

        //方式二  换成这个方式 在xml中进行数据的显示和绑定
        binding.data = myViewModel
        binding.lifecycleOwner = this



    }
}
