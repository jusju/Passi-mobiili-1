package fi.softala.tyokykypassi.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by villeaaltonen on 01/11/2016.
 */

public class Answerpoints {

    @SerializedName("answerpoint_id")
    private Integer answerpointId;
    @SerializedName("answer_text")
    private String answerText;
    @SerializedName("instructor_comment")
    private String instructorComment;
    @SerializedName("instructor_rating")
    private String instructorRating;
    @SerializedName("imageURL")
    private String imageUrl;
    @SerializedName("answersheet_id")
    private Integer answersheetId;
    @SerializedName("waypoint_id")
    private Integer waypointId;
    @SerializedName("option_id")
    private Integer optionId;
    @SerializedName("option_text")
    private String optionText;

    public Answerpoints() {
    }

    public Integer getAnswerpointId() {
        return answerpointId;
    }

    public void setAnswerpointId(Integer answerpointId) {
        this.answerpointId = answerpointId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public String getInstructorComment() {
        return instructorComment;
    }

    public void setInstructorComment(String instructorComment) {
        this.instructorComment = instructorComment;
    }

    public String getInstructorRating() {
        return instructorRating;
    }

    public void setInstructorRating(String instructorRating) {
        this.instructorRating = instructorRating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getAnswersheetId() {
        return answersheetId;
    }

    public void setAnswersheetId(Integer answersheetId) {
        this.answersheetId = answersheetId;
    }

    public Integer getWaypointId() {
        return waypointId;
    }

    public void setWaypointId(Integer waypointId) {
        this.waypointId = waypointId;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    @Override
    public String toString() {
        return "Answerpoints{" +
                "answerpointId=" + answerpointId +
                ", answerText='" + answerText + '\'' +
                ", instructorComment='" + instructorComment + '\'' +
                ", instructorRating='" + instructorRating + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", answersheetId=" + answersheetId +
                ", waypointId=" + waypointId +
                ", optionId=" + optionId +
                ", optionText='" + optionText + '\'' +
                '}';
    }
}
