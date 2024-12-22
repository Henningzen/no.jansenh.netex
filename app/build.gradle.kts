plugins {
    id("buildlogic.java-application-conventions")
}

dependencies {
    implementation(project(":utilities"))
}

application {
    mainClass = "no.jansenh.netex.App"
}
