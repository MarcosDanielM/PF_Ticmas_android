package com.ticmas.android.finalapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ticmas.android.finalapp.model.ComparisonModel
import com.ticmas.android.finalapp.view.ComparisonViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class ComparisonViewModelTest {

    private lateinit var viewModel: ComparisonViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()


    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = ComparisonViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testComparisonModelAreEqual() = runTest  {
        val viewModel = ComparisonModel("hello", "hello")
        assertEquals(true, viewModel.areEqual)
    }


    @Test
    fun testComparisonModelAreNotEqual()  = runTest  {
        val model = ComparisonModel("hello", "world")
        assertEquals(false, model.areEqual)
    }

    @Test
    fun testViewModelComparison()  = runTest  {
        val viewModel = ComparisonViewModel()
        viewModel.compareTexts("car", "car")
        assertEquals(true, viewModel.resultLiveData.value)
    }
}