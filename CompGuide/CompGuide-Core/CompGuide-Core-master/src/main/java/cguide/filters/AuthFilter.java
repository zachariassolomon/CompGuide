package cguide.filters;

import cguide.db.beans.AutenticacaoBean;
import cguide.db.beans.AutenticacaoManager;
import cguide.db.beans.UserManager;
import cguide.db.exception.DAOException;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;

public class AuthFilter implements Filter {

    private static boolean DEV_MODE = false;

    public void init(FilterConfig filterConfig) throws ServletException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "AuthFilter is initializing");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String authToken = null;

        if (DEV_MODE) {
            // always set an admin as requester
            httpServletRequest.setAttribute("requestOwner", UserManager.getInstance().getUserBeanByID(1L));
        } else if (httpServletRequest.getCookies() != null && httpServletRequest.getCookies().length > 0) {
            for (Cookie cookie : httpServletRequest.getCookies()) {
                if (cookie.getName().equals("auth-token")) {
                    authToken = cookie.getValue();
                    break;
                }
            }
            if (authToken != null && authToken.length() > 0) {
                try {
                    AutenticacaoBean[] autenticacaoBeans = AutenticacaoManager.getInstance().
                            loadByWhere(" where auth = '" + authToken + "';");
                    if (autenticacaoBeans != null && autenticacaoBeans.length > 0) {
                        if (autenticacaoBeans[0].getDuracao().before(new Date())) {
                            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                                    "Token provided is too old. Please renew it.");
                            return;
                        } else {
                            httpServletRequest.setAttribute("requestOwner", UserManager.getInstance().
                                    getUserBeanByID(autenticacaoBeans[0].getUtilizadorId()));
                        }
                        // TODO remove old tokens from database
                    }
                } catch (DAOException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error while obtaining user from auth cookie", e);
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "AuthFilter destroyed");
    }
}
