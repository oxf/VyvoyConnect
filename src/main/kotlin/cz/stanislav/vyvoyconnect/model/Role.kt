package cz.stanislav.vyvoyconnect.model

enum class Role(val value: String) {
    APPLICANT("APPLICANT"),
    INTERVIEWER("INTERVIEWER"),
    CLIENT("CLIENT"),
    ADMIN("ADMIN")
}