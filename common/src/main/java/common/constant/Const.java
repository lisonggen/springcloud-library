package common.constant;

public interface Const {

    public interface BookStatus {
        String NORMAL = "NORMAL";
        String LOANED_OUT = "LOANED_OUT";
        String OFF_SHELF = "OFF_SHELF";
    }

    public interface UserRole {
        String NORMAL = "NORMAL";
        String ADMIN = "ADMIN";
    }

    public interface IdCardType {
        String ID_CARD = "ID_CARD";
        String STUDENT_CARD = "STUDENT_CARD";
        String OFFICER_CARD = "OFFICER_CARD";
    }
}
