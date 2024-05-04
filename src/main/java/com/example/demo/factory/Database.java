package com.example.demo.factory;

public class Database {
    private String userName;
    private String password;
    private String host;

    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }


    public String getHost() {
        return host;
    }


    private Database (DatabaseBuilder builder){
        this.host = builder.host;
        this.password = builder.password;
        this.userName = builder.userName;
    }

    static class DatabaseBuilder {
        private String userName;
        private String password;
        private String host;


        public DatabaseBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public DatabaseBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public DatabaseBuilder setHost(String host) {
            this.host = host;
            return this;
        }

        public Database build() {
            return new Database(this);
        }
    }
}
