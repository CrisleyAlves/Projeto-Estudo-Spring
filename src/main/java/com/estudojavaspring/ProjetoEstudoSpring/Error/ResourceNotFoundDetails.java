package com.estudojavaspring.ProjetoEstudoSpring.Error;

/**
 * Created by Crisley Alves on 23, set, 2017
 **/
public class ResourceNotFoundDetails extends ErrorsDetail {

    public static final class Builder {

        private String title;
        private int status;
        private String detail;
        private Long timeStamp;
        private String developerMessage;


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

        public ResourceNotFoundDetails build() {
            ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
            resourceNotFoundDetails.setDeveloperMessage(developerMessage);
            resourceNotFoundDetails.setDetail(detail);
            resourceNotFoundDetails.setTitle(title);
            resourceNotFoundDetails.setTimeStamp(timeStamp);
            resourceNotFoundDetails.setStatus(status);
            return resourceNotFoundDetails;
        }
    }
}
