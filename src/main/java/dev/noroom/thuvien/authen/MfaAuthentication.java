//package dev.noroom.thuvien.authen;
//
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.CredentialsContainer;
//
//import java.util.Collections;
//
//public class MfaAuthentication extends AbstractAuthenticationToken {
//    private final Authentication authentication;
//
//    public MfaAuthentication(Authentication authentication) {
//        super(Collections.emptyList());
//        this.authentication = authentication;
//    }
//
//    @Override
//    public Object getCredentials() {
//        return authentication.getCredentials();
//    }
//
//    @Override
//    public Object getPrincipal() {
//        return authentication.getPrincipal();
//    }
//
//    @Override
//    public void eraseCredentials() {
//        if (this.authentication instanceof CredentialsContainer) {
//            ((CredentialsContainer) this.authentication).eraseCredentials();
//        }
//    }
//}
