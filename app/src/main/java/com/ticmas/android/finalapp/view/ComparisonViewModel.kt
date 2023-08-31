package com.ticmas.android.finalapp.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ticmas.android.finalapp.model.ComparisonModel

class ComparisonViewModel : ViewModel() {


    internal val resultLiveData = MutableLiveData<Boolean>()

    fun compareTexts(text1: String, text2: String) {
        val model = ComparisonModel(text1, text2)
        resultLiveData.value = model.areEqual
    }


}
