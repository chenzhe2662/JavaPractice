package java_1203;

import java.util.Date;

public class BorrowInfo {
    private Integer studentId;
    private String studentName;
    private Integer bookId;
    private String bookName;
    private Date startTime;
    private Date endTime;

    @Override
    public String toString() {
        return "BorrowInfo{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
