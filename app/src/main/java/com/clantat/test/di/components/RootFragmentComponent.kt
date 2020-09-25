package com.clantat.test.di.components

import com.clantat.test.di.modules.RootModule
import com.clantat.test.di.scope.RootScope
import com.clantat.test.presentation.fragments.RootFragment
import dagger.Subcomponent

@RootScope
@Subcomponent(modules = [RootModule::class])
interface RootFragmentComponent {
    fun inject(rootFragment: RootFragment)
}