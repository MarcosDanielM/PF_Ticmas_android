package com.ticmas.android.finalapp.model

data class ComparisonModel(val text1: String, val text2: String) {
     val areEqual: Boolean
          get() = text1 == text2
}
