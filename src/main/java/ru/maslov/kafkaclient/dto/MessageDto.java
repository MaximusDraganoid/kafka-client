package ru.maslov.kafkaclient.dto;

public class MessageDto {

    private Long messageId;
    private String startDate;
    private String endDate;
    private String currency;

    public MessageDto() {
    }

    public MessageDto(Long messageId, String startDate, String endDate, String currency) {
        this.messageId = messageId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currency = currency;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "messageId=" + messageId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
