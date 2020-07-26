package docfriends.assignment.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Getter
@Setter
public class Utils {

    // Request 객체 얻기
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

        return attr.getRequest();
    }

    // 세션 객체 얻기
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static void registerSessionByMemberId(Long memberId) {
        if (memberId != null && memberId > 0) {
            getSession().setAttribute("memberId", memberId);
        }
    }

    public static Object getMemberIdFromSession() {
        return getSession().getAttribute("memberId");
    }






}
