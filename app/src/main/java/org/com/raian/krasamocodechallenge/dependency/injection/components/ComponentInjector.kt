package org.com.raian.krasamocodechallenge.dependency.injection.components

import dagger.Component
import org.com.raian.krasamocodechallenge.dependency.injection.modules.NetworkModule
import org.com.raian.krasamocodechallenge.view.viewmodel.StockViewModel

@Component(modules = [NetworkModule::class])
interface ComponentInjector {

    fun inject(viewModel: StockViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ComponentInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }

}