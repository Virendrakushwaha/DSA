package LLD;

import java.util.List;

public class Splitwise {

    //Functional Requirements
    //1.Users add their expense EXACT/EQUAL/PERCENT
//    {
//        <userId><total price given by user> <No.of users> <all user-ids><EXACT/EQUAL/PERCENT> <money values>
//         u1 1200 4 u1,u2,u3,u4 EXACT 200 300 400 300
//    }
//    {
//        u1 800 4 u1,u2,u3,u4 EQUAL
//    }
//    {
//        u1 800 4 u1,u2,u3,u4 PERCENT 10 20 50 20
//    }

    //2.Show balances by user-id
    //3.Show balances for all

    //NFR



}

class User {
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    private String userId;
    private String name;
    private String email;
    private Integer phone;


}

abstract class  Split{
    private User user;
    private Double amount;

    public Split(User user) {
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

class Equal extends Split{

    public Equal(User user) {
        super(user);
    }

}
class Exact extends Split{

    public Exact(User user,Double amount){
        super(user);
        this.amount = amount;
    }
}

class Percent extends Split{

    public Percent(User user,Double amt){
        super(user);
        this.amt = amt;
    }


}

class ExpenseMetadata{

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String imgUrl;
    private String name;
}

class Expense{
    private String expenseId;
    private User user;
    private List<Split> listSplit;
    private String userIdPaidBy;
    private ExpenseMetadata expenseMetadata;
}