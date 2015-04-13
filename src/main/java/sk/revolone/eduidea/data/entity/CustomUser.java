package sk.revolone.eduidea.data.entity;

public interface CustomUser {
    Long getId();
	String getEmail();
	String getFirstName();
	String getLastName();
	String getUsername();
	String getPassword();
	Role getRole();
}
