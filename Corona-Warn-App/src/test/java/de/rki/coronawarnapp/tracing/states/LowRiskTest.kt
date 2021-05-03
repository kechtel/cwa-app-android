package de.rki.coronawarnapp.tracing.states

import android.content.Context
import de.rki.coronawarnapp.R
import de.rki.coronawarnapp.risk.RiskState
import de.rki.coronawarnapp.util.TimeAndDateExtensions.toLocalDateUtc
import io.kotest.matchers.shouldBe
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.joda.time.Instant
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class LowRiskTest {

    @MockK private lateinit var context: Context

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        every {
            context.getString(
                R.string.risk_card_low_risk_most_recent_body_encounter_on_single_day,
                any()
            )
        } returns "String not relevant for this test"
    }

    private val defaultRisk = LowRisk(
        riskState = RiskState.LOW_RISK,
        isInDetailsMode = false,
        calculatedAt = Instant.now(),
        allowManualUpdate = false,
        daysWithEncounters = 0,
        daysSinceInstallation = 4,
        lastEncounterAt = null
    )

    @Test
    fun `Active tracing row should be visible in low risk card on the home screen when there are no encounters`() {
        defaultRisk.isGoneOnContentLowView(context) shouldBe false
    }

    @Test
    fun `Active tracing row should be gone in low risk card on the home screen when there are encounters`() {
        defaultRisk
            .copy(daysWithEncounters = 1, lastEncounterAt = Instant.now().toLocalDateUtc())
            .isGoneOnContentLowView(context) shouldBe true
    }

    @Test
    fun `Active tracing row should be shown in low risk detail screen when there are no encounters`() {
        defaultRisk
            .copy(isInDetailsMode = true)
            .isGoneOnContentLowView(context) shouldBe false
    }

    @Test
    fun `Active tracing row should be shown in low risk detail screen when there are encounters`() {
        defaultRisk
            .copy(daysWithEncounters = 1, lastEncounterAt = Instant.now().toLocalDateUtc(), isInDetailsMode = true)
            .isGoneOnContentLowView(context) shouldBe false
    }
}
