package com.ali.framework.model.bean;

public class LoginBean {

    /**
     * access_token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbImFsbCJdLCJleHAiOjE1OTEwNjg3MTYsImp0aSI6ImM1NDQzMGQzLTkxMmEtNDAxYS05MjU1LWZiMjQ4NDFiMDFhMiIsInVzZXJpbmZvIjp7InVzZXJ0eXBlIjoiNSJ9LCJjbGllbnRfaWQiOiJTU08iLCJpc0NsaWVudE9ubHkiOmZhbHNlfQ.fYV-sEPYI4VDtoWEGnQB880uRciHEOD4L_kuNW-Tv30
     * token_type : bearer
     * refresh_token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbImFsbCJdLCJhdGkiOiJjNTQ0MzBkMy05MTJhLTQwMWEtOTI1NS1mYjI0ODQxYjAxYTIiLCJleHAiOjE1OTEyNDE1MTYsImp0aSI6IjhlNDJiODE2LTU0YzgtNDNjNy05NGFjLTkzNmE0ZWQ5MGNhZiIsInVzZXJpbmZvIjp7InVzZXJ0eXBlIjoiNSJ9LCJjbGllbnRfaWQiOiJTU08iLCJpc0NsaWVudE9ubHkiOmZhbHNlfQ.JPVpgY8a9hzMmDzFtsBvelgDK7buRzXx59LdqaJPIK4
     * expires_in : 7199
     * scope : all
     * userinfo : {"usertype":"5"}
     * isClientOnly : false
     * jti : c54430d3-912a-401a-9255-fb24841b01a2
     */
    private String access_token;
    private String token_type;
    private String refresh_token;
    private int expires_in;
    private String scope;
    private UserinfoBean userinfo;
    private boolean isClientOnly;
    private String jti;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public UserinfoBean getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserinfoBean userinfo) {
        this.userinfo = userinfo;
    }

    public boolean isIsClientOnly() {
        return isClientOnly;
    }

    public void setIsClientOnly(boolean isClientOnly) {
        this.isClientOnly = isClientOnly;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public static class UserinfoBean {
        /**
         * usertype : 5
         */

        private String usertype;

        public String getUsertype() {
            return usertype;
        }

        public void setUsertype(String usertype) {
            this.usertype = usertype;
        }
    }
}
