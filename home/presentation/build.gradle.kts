import vn.finance.buildSrc.Configs

plugins {
    vn.core.plugins.androidLibrary
    vn.core.plugins.androidCompose
    vn.core.plugins.androidPublishing
}

android {
    namespace = Configs.Home.PRESENTATION_NAMESPACE
}

publishing {
    publications {
        create<MavenPublication>(Configs.Artifact.ARTIFACT_PRESENTATION_ID) {
            afterEvaluate {
                from(components["all"])
            }
            groupId = Configs.Artifact.GROUP_ID
            artifactId = Configs.Artifact.ARTIFACT_PRESENTATION_ID
            version = Configs.Artifact.VERSION
        }
    }
}

dependencies {
    implementation(project(Configs.BuildModule.HOME_BUSINESS))
    implementation(project(Configs.BuildModule.HOME_API))

    implementation(libs.coreDomain)
    implementation(libs.coreData)
    implementation(libs.coreCompose)
    implementation(libs.financeTheme)
    implementation(libs.financeStatisticApi)
    implementation(libs.financeProfileApi)
    implementation(libs.financeNotificationApi)
}
