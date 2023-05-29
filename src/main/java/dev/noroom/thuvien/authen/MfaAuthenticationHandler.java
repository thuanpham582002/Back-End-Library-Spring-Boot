//package dev.noroom.thuvien.authen;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//
//import java.io.IOException;
//
//public class MfaAuthenticationHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler {
//    private final AuthenticationSuccessHandler successHandler;
//
//    public MfaAuthenticationHandler(String url) {
//        SimpleUrlAuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler(url);
//        successHandler.setAlwaysUseDefaultTargetUrl(true);
//        this.successHandler = successHandler;
//    }
//
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//
//    }
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//    }
//
//    private void saveMfaAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        SecurityContextHolder.getContext().setAuthentication(new MfaAuthentication(authentication));
//        successHandler.onAuthenticationSuccess(request, response, authentication);
//    }
//}
