package com.example.androidcomposetdd.viewmodel

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class TextViewModelTest {
    @Test
    fun testUpdateText() {
        /// given
        // 레드: 아직 뷰모델 없지만 뷰모델에 있는 스트링 상태 업데이트
        // 그린: 뷰모델만 만든다.
        val viewModel = TextViewModel()

        /// when
        // 레드: 뷰모델에 메서드 없음
        // 그린: 뷰모델에 메서드만 만든다.
        viewModel.updateText("Hello, World!")

        /// then
        // 레드: 뷰모델에 상태 없음, updateText() 구현 안 함.
        // 그린, 리팩터: 뷰모델에 상태 있음, updateText() 구현 함.
        assertThat(viewModel.displayText).isEqualTo("Hello, World!")
    }
}










