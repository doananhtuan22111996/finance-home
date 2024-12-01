package vn.finance.buildSrc

object Configs {

    object BuildModule {
        const val HOME_PRESENTATION = ":home:presentation"
        const val HOME_BUSINESS = ":home:business"
        const val HOME_API = ":homeApi"
    }

    object Home {
        const val PRESENTATION_NAMESPACE = "vn.finance.home.presentation"
        const val BUSINESS_NAMESPACE = "vn.finance.home.business"
        const val API_NAMESPACE = "vn.finance.home.api"
    }

    object Demo {
        const val NAMESPACE = "vn.finance.demo"
        const val APPLICATION_ID = "vn.finance.demo"
        const val VERSION_CODE = 1
        const val VERSION_NAME = "1.0.0"
    }

    object Artifact {
        const val GROUP_ID = "vn.finance.libs"
        const val ARTIFACT_PRESENTATION_ID = "feature-home-presentation"
        const val ARTIFACT_BUSINESS_ID = "feature-home-business"
        const val ARTIFACT_API_ID = "feature-home-api"
        const val VERSION = "1.0.4"
    }
}
