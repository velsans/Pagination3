package com.vel.saveo.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.vel.saveo.ui.main.api.ApiService
import com.vel.saveo.ui.main.api.RetroInstance
import com.vel.saveo.ui.main.model.CharacterData
import com.vel.saveo.ui.main.utils.CharacterPagingSource
import kotlinx.coroutines.flow.Flow

/**
 * Created by Velmurugan on 10/12/2021.
 */
class MainActivityViewModel : ViewModel() {

    var apiService: ApiService = RetroInstance.getRetroInstance().create(ApiService::class.java)

    fun getListData(): Flow<PagingData<CharacterData>> {
        return Pager(config = PagingConfig(pageSize = 20, maxSize = 200),
            pagingSourceFactory = { CharacterPagingSource(apiService) }).flow.cachedIn(viewModelScope)
    }
}