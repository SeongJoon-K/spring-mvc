package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);
        log.trace(" trace log={}", name);
        log.debug(" debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);


        return "ok";
    }
}
/**
 * @RestController : return 할 때, 그냥 String 이 리턴된다.
 * @Controller : return 할 때, 그냥 view name이 반환된다.
 */

/**
 * 로그의 레벨에 대하여
 * trace -> debug -> info -> warn -> error 순으로 레벨이 올라간다
 * 운영서버에서는 info 레벨에서 남긴다.
 * 개발서버에는 다 할 수 있는데, 운영서버에서는 절대 안된다.
 */
//log.trace(" trace log={}", name);
//log.debug(" debug log={}", name);
//log.info(" info log={}", name);
//log.warn(" warn log={}", name);
//log.error("error log={}", name);

//        log.info(" info log=" + name); 이렇게 사용하면 안된다.
//이는 자바 언어가 하기 전에 문자열을 더하는 연산이 일어난다.
// 기본 로그 레벨이 info 로 설정되어 있어서 출력이 되진 않음
// 하지만 연산이 되어 있기 때문에 메모리 리소스를 낭비하게 된다.
//        log.info(" info log={}", name);
