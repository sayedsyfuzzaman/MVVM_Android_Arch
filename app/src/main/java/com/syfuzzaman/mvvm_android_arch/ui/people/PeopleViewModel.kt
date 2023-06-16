package com.syfuzzaman.mvvm_android_arch.ui.people

import androidx.lifecycle.ViewModel
import com.syfuzzaman.mvvm_android_arch.data.network.apiservice.PopularPeopleApiService
import com.syfuzzaman.mvvm_android_arch.data.network.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val peopleApiService: PopularPeopleApiService
):ViewModel(){
//    val peopleApiResponse = SingleLiveEvent<Resource<TmdbPeopleBaseResponse>>()
    val scrollToHighlightsListTop = SingleLiveEvent<Boolean>()

//    fun popularPeopleApi(page:Int){
//        viewModelScope.launch {
//            val response = resultFromExternalResponse { peopleApiService.execute(page) }
//            peopleApiResponse.value = response
//        }
//    }
}