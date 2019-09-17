package models.datas;

public class OrdersData {

    private int orderId;
    private int userId;
    private int tourId;
    private int countryId;

    @Override
    public String toString() {
        return "OrdersData{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", tourId=" + tourId +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }


}
