package dpu.dao.admin;

public interface UserDAO {

    String retrievePassword(String username);

    String sendMail(String emailTo, String subject, String body);

}
