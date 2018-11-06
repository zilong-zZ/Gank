package com.zl.gank.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zl.gank.data.ClassificationBean

class HomeViewModel : ViewModel() {

    val ClassificationBean: MutableLiveData<ClassificationBean> by lazy {
        MutableLiveData<ClassificationBean>()
    }
}