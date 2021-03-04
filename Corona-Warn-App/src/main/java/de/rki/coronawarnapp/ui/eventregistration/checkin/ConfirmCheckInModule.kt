package de.rki.coronawarnapp.ui.eventregistration.checkin

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import de.rki.coronawarnapp.util.viewmodel.CWAViewModel
import de.rki.coronawarnapp.util.viewmodel.CWAViewModelFactory
import de.rki.coronawarnapp.util.viewmodel.CWAViewModelKey

@Module
abstract class ConfirmCheckInModule {
    @Binds
    @IntoMap
    @CWAViewModelKey(ConfirmCheckInViewModel::class)
    abstract fun confirmCheckInFragment(
        factory: ConfirmCheckInViewModel.Factory
    ): CWAViewModelFactory<out CWAViewModel>
}
