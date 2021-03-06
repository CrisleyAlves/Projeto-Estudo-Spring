package com.estudojavaspring.ProjetoEstudoSpring.Error;

/**
 * Created by Crisley Alves on 23, set, 2017
 **/
public class ValidationErrorsDetails extends ErrorsDetail {

    private String field;
    private String fieldMessage;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public void setFieldMessage(String fieldMessage) {
        this.fieldMessage = fieldMessage;
    }

    public static final class Builder {

        private String title;
        private int status;
        private String detail;
        private Long timeStamp;
        private String developerMessage;
        private String field;
        private String fieldMessage;


        private Builder() {

        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timeStamp(Long timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public Builder fieldMessage(String fieldMessage) {
            this.fieldMessage = fieldMessage;
            return this;
        }

        public ValidationErrorsDetails build() {
            ValidationErrorsDetails ValidationErrorDetails = new ValidationErrorsDetails();
            ValidationErrorDetails.setDeveloperMessage(developerMessage);
            ValidationErrorDetails.setDetail(detail);
            ValidationErrorDetails.setTitle(title);
            ValidationErrorDetails.setTimeStamp(timeStamp);
            ValidationErrorDetails.setStatus(status);
            ValidationErrorDetails.setField(field);
            ValidationErrorDetails.setFieldMessage(fieldMessage);
            return ValidationErrorDetails;
        }
    }
}
