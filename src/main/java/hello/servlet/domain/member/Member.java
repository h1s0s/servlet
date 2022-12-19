package hello.servlet.domain.member;

/**
 * packageName  : hello.servlet.domain.member
 * fileName     : Member
 * author       : sshan
 * date         : 2022-12-19
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2022-12-19          sshan            최초생성
 */

import lombok.Data;

@Data
public class Member {

    private Long id;
    private String username;
    private int age;

    public Member() {
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
