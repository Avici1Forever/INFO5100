package Karl.Util;

// Table for RegisteredCourse page and RegisterForCourse page
public class RegisteredCourseTable {
    private String title;
    private String subjectDescription;
    private String courseCode;
    private Integer CRN;
    private Integer hours;
    private String instructor;
    private String term;
    private String meetingTime;
    private Integer remainedSeats;
    private Integer totalSeats;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getCRN() {
        return CRN;
    }

    public void setCRN(Integer CRN) {
        this.CRN = CRN;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
    }

    public Integer getRemainedSeats() {
        return remainedSeats;
    }

    public void setRemainedSeats(Integer remainedSeats) {
        this.remainedSeats = remainedSeats;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    @Override
    public String toString() {
        return "EnrolledCourseTable{" +
                "title='" + title + '\'' +
                ", subjectDescription='" + subjectDescription + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", CRN=" + CRN +
                ", hours=" + hours +
                ", instructor='" + instructor + '\'' +
                ", term='" + term + '\'' +
                ", meetingTime='" + meetingTime + '\'' +
                ", remainedSeats=" + remainedSeats +
                ", totalSeats=" + totalSeats +
                '}';
    }
}
