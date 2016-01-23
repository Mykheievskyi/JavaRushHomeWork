package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public final static  class Constants
    {
        public final static String SERVER_IS_NOT_ACCESSIBLE_FOR_NOW = "Server is not accessible for now.";
        public final static String USER_IS_NOT_AUTHORIZED = "User is not authorized.";
        public final static String USER_IS_BANNED = "User is banned.";
        public final static String ACCESS_IS_DENIDED = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException()
        {
            super(Constants.SERVER_IS_NOT_ACCESSIBLE_FOR_NOW);
        }

        public ServerNotAccessibleException(Throwable cause)
        {
            super(Constants.SERVER_IS_NOT_ACCESSIBLE_FOR_NOW, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.USER_IS_NOT_AUTHORIZED);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.USER_IS_NOT_AUTHORIZED, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.USER_IS_BANNED);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.USER_IS_BANNED, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.ACCESS_IS_DENIDED);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.ACCESS_IS_DENIDED, cause);
        }
    }
}
