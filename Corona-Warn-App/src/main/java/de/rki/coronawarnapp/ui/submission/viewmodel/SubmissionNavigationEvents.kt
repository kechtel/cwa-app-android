package de.rki.coronawarnapp.ui.submission.viewmodel

import com.google.android.gms.common.api.ApiException
import de.rki.coronawarnapp.coronatest.qrcode.CoronaTestQRCode

sealed class SubmissionNavigationEvents {
    object NavigateToContact : SubmissionNavigationEvents()
    object NavigateToDispatcher : SubmissionNavigationEvents()
    object NavigateToQRCodeScan : SubmissionNavigationEvents()
    object NavigateToDataPrivacy : SubmissionNavigationEvents()

    object NavigateToSymptomIntroduction : SubmissionNavigationEvents()
    object NavigateToTAN : SubmissionNavigationEvents()
    object NavigateToConsent : SubmissionNavigationEvents()
    object NavigateToMainActivity : SubmissionNavigationEvents()
    data class NavigateToResultPendingScreen(val consentGiven: Boolean) : SubmissionNavigationEvents()
    data class NavigateToResultAvailableScreen(val consentGiven: Boolean) : SubmissionNavigationEvents()
    data class NavigateToDeletionWarningFragment(val coronaTestQRCode: CoronaTestQRCode) : SubmissionNavigationEvents()
    data class ResolvePlayServicesException(val exception: ApiException) : SubmissionNavigationEvents()
}
