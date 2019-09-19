package models.datas;

public class RoleData {
    private int userId;
    private int userRole;
    private int adminRole;

    @Override
    public String toString() {
        return "RoleData{" +
                "userId=" + userId +
                ", userRole=" + userRole +
                ", adminRole=" + adminRole +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public int getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(int adminRole) {
        this.adminRole = adminRole;
    }
}
