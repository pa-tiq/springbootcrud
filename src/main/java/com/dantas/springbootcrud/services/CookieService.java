package com.dantas.springbootcrud.services;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieService {
    public static void setCookie(HttpServletResponse response, String key, String value, int seconds)
            throws UnsupportedEncodingException {
        Cookie cookie = new Cookie(key, URLEncoder.encode(value, "UTF-8"));
        cookie.setMaxAge(seconds);
        cookie.setHttpOnly(true); // o cookie só será alterado pelo servidor, nunca pelo javascript
        response.addCookie(cookie);
    }

    public static String getCookie(HttpServletRequest request, String key) throws UnsupportedEncodingException {
        String ck = Optional.ofNullable(request.getCookies())
                .flatMap(cookies -> Arrays.stream(cookies)
                        .filter(cookie -> key.equals(cookie.getName()))
                        .findAny())
                .map(e -> e.getValue()).orElse(null);
        ck = URLDecoder.decode(ck, "UTF-8");
        return ck;
    }
}
