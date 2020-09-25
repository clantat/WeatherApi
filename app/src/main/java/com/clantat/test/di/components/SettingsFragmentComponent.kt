package com.clantat.test.di.components

import com.clantat.test.di.modules.SettingsModule
import com.clantat.test.di.scope.SettingsScope
import com.clantat.test.presentation.fragments.SettingsFragment
import dagger.Subcomponent

@SettingsScope
@Subcomponent(modules = [SettingsModule::class])
interface SettingsFragmentComponent {
    fun inject(settingsFragment: SettingsFragment)
}
