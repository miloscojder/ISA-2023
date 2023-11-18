package com.example.ISAproject.model;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String mobile;
	
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String sex;
	@Column
	private String profession;
	@Column
	private String organizationInformation;
	@Column
	private boolean enabled;
	@Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;
	@Column
	private String role;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Timestamp now = new Timestamp(new Date().getTime());
        this.setLastPasswordResetDate(now);
        this.password = password;
    }
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	 public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@JsonIgnore
	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return this.authorities;
	    }
	    public void setAuthorities(List<Authority> authorities) {
	        this.authorities = authorities;
	    }
	
	
	@Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Timestamp getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getOrganizationInformation() {
		return organizationInformation;
	}
	public void setOrganizationInformation(String organizationInformation) {
		this.organizationInformation = organizationInformation;
	}
	
	public User() {}
	
	
	 public User(Long id, String username, String password, String email, String firstName, String lastName,
			String mobile, String city, String state, String sex, String profession,
			String organizationInformation, boolean enabled, Timestamp lastPasswordResetDate, String role,
			List<Authority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.city = city;
		this.state = state;
		this.sex = sex;
		this.profession = profession;
		this.organizationInformation = organizationInformation;
		this.enabled = enabled;
		this.lastPasswordResetDate = lastPasswordResetDate;
		this.role = role;
		this.authorities = authorities;
	}
	
	 
	 
	public User(String username, String password, String email, String firstName, String lastName, String mobile, String city, String state, String sex, String profession,
			String organizationInformation, boolean enabled, Timestamp lastPasswordResetDate, String role,
			List<Authority> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.city = city;
		this.state = state;
		this.sex = sex;
		this.profession = profession;
		this.organizationInformation = organizationInformation;
		this.enabled = enabled;
		this.lastPasswordResetDate = lastPasswordResetDate;
		this.role = role;
		this.authorities = authorities;
	}
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		 return true;
	}
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
	        return true;
	    }
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
}