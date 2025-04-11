package com.example.myozinsheexample.data

import com.example.myozinsheexample.R

object OnboardingInfoList {
    val onboardingModelList: List<OnboardingModel>
        get() = listOf(
            OnboardingModel(
                R.drawable.image_onboarding1,
                "ÖZINŞE-ге қош келдің!",
                "Фильмдер, телехикаялар, ситкомдар, анимациялық жобалар, телебағдарламалар мен реалити-шоулар, аниме және тағы басқалары"
            ),
            OnboardingModel(
                R.drawable.image_ondoarding2,
                "ÖZINŞE-ге қош келдің!",
                "Кез келген құрылғыдан қара Сүйікті фильміңді қосымша төлемсіз телефоннан, планшеттен, ноутбуктан қара"
            ),
            OnboardingModel(
                R.drawable.image_onboarding3,
                "ÖZINŞE-ге қош келдің!",
                "Тіркелу оңай. Қазір тіркел де қалаған фильміңе қол жеткіз"
            )
        )
}

