package com.test.voicetubeapp.ui.countdown

import android.os.Bundle
import android.os.CountDownTimer
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.test.voicetubeapp.R
import com.test.voicetubeapp.databinding.FragmentCountdownBinding
import com.test.voicetubeapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_countdown.*

class CountdownFragment: BaseFragment<FragmentCountdownBinding, CountdownViewModel>() {

    companion object {
        fun newInstance(): CountdownFragment {
            val fragment = CountdownFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    lateinit var countDownTimer: CountDownTimer
    var isCountdown = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupListener()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_countdown
    }

    override fun getViewModelClass(): Class<CountdownViewModel>? {
        return CountdownViewModel::class.java
    }

    override fun onResume() {
        if(isCountdown) {
            startCountDownTimer(viewModel.second * 1000)
        }
        super.onResume()
    }

    override fun onPause() {
        if(isCountdown) {
            countDownTimer.cancel()
        }
        super.onPause()
    }

    private fun setupToolbar() {
        binding.toolbarContainer.toolbarTitleText.text = getString(R.string.countdown)
    }

    private fun setupListener() {
        countdownBtn.setOnClickListener {
            if(!TextUtils.isEmpty(secondEditText.text.toString())) {
                viewModel.second = secondEditText.text.toString().toLong()
                startCountDownTimer(viewModel.second * 1000)
                isCountdown = true
                countdownBtn.isEnabled = false
                secondEditText.isEnabled = false
            } else {
                Toast.makeText(context, getString(R.string.hint_input_second), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startCountDownTimer(milliseconds: Long) {
        countDownTimer = object: CountDownTimer(milliseconds, 1000)  {
            override fun onTick(millisUntilFinished: Long) {
                viewModel.second = millisUntilFinished / 1000
                secondText.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                isCountdown = false
                countdownBtn.isEnabled = true
                secondEditText.isEnabled = true
                Toast.makeText(context, getString(R.string.countdown_finish), Toast.LENGTH_SHORT).show()
            }
        }
        countDownTimer.start()
    }

}