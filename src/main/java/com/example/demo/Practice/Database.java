package com.example.demo.Practice;

public class Database {
    private String host;
    private String user;
    private String port;
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Database(DatabaseBuilder builder){
        this.host = builder.host;
        this.password = builder.password;
        this.port= builder.port;
        this.user = builder.user;
    }

    public static class DatabaseBuilder{
        private String host;
        private String user;
        private String port;
        private String password;

        public Database build(DatabaseBuilder builder){
            return new Database(builder);
        }

        public DatabaseBuilder withHost(String host){
            this.host = host;
            return this;
        }

        public DatabaseBuilder withUser(String user){
            this.user = user;
            return this;
        }

        public DatabaseBuilder withPort(String port){
            this.port = port;
            return this;
        }

        public DatabaseBuilder withPassword(String password){
            this.password = password;
            return this;
        }

    }


}
