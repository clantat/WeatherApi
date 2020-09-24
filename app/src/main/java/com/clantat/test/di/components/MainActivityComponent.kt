package com.clantat.test.di.components

import com.clantat.test.core.MainActivity
import com.clantat.test.di.scope.MainActivityScope
import dagger.Subcomponent

@MainActivityScope
@Subcomponent
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}