package com.clantat.test.di.components

import com.clantat.test.di.scope.RootScope
import com.clantat.test.presentation.fragments.RootFragment
import dagger.Subcomponent

@RootScope
@Subcomponent()
interface RootFragmentComponent {
    fun inject(rootFragment: RootFragment)
}