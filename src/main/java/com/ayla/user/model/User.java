package com.ayla.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.sql.Timestamp;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
})
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "encrypted_password", nullable = false)
    @JsonProperty("encrypted_password")
    private String encryptedPassword;

    @Column(name = "reset_password_token")
    @JsonProperty("reset_password_token")
    private String resetPasswordToken;

    @Column(name = "reset_password_sent_at")
    @JsonProperty("reset_password_sent_at")
    private Timestamp resetPasswordSentAt;

    @Column(name = "remember_created_at")
    @JsonProperty("remember_created_at")
    private Timestamp rememberCreatedAt;

    @JsonProperty("sign_in_count")
    private Integer signInCount = 0;

    @Column(name = "current_sign_in_at")
    @JsonProperty("current_sign_in_at")
    private Timestamp currentSignInAt;

    @Column(name = "last_sign_in_at")
    @JsonProperty("last_sign_in_at")
    private Timestamp lastSignInAt;

    @Column(name = "current_sign_in_ip")
    @JsonProperty("current_sign_in_ip")
    private String currentSignInIp;

    @Column(name = "confirmation_token")
    @JsonProperty("confirmation_token")
    private String confirmationToken;

    @Column(name = "confirmed_at")
    @JsonProperty("confirmed_at")
    private Timestamp confirmedAt;

    @Column(name = "confirmation_sent_at")
    @JsonProperty("confirmation_sent_at")
    private Timestamp confirmationSentAt;

    @Column(name = "unconfirmed_email")
    @JsonProperty("unconfirmed_email")
    private String unconfirmedEmail;

    @Column(name = "authentication_token")
    @JsonProperty("authentication_token")
    private String authenticationToken;

    @Column(name = "firstname")
    @JsonProperty("firstname")
    private String firstname;

    @Column(name = "lastname")
    @JsonProperty("lastname")
    private String lastname;

    @Column(name = "company")
    @JsonProperty("company")
    private String company;

    @Column(name = "street")
    @JsonProperty("street")
    private String street;

    @Column(name = "city")
    @JsonProperty("city")
    private String city;

    @Column(name = "state")
    @JsonProperty("state")
    private String state;

    @Column(name = "zip")
    @JsonProperty("zip")
    private String zip;

    @Column(name = "zip2")
    @JsonProperty("zip2")
    private String zip2;

    @Column(name = "country")
    @JsonProperty("country")
    private String country;

    @Column(name = "phone")
    @JsonProperty("phone")
    private String phone;

    @Column(name = "secquestion1")
    @JsonProperty("secquestion1")
    private String secquestion1;

    @Column(name = "secanswer1")
    @JsonProperty("secanswer1")
    private String secanswer1;

    @Column(name = "secquestion2")
    @JsonProperty("secquestion2")
    private String secquestion2;


    @Column(name = "secanswer2")
    @JsonProperty("secanswer2")
    private String secanswer2;

    @Column(name = "secquestion3")
    @JsonProperty("secquestion3")
    private String secquestion3;

    @Column(name = "secanswer3")
    @JsonProperty("secanswer3")
    private String secanswer3;

    @Column(name = "logged_in_at")
    @JsonProperty("logged_in_at")
    private Timestamp logged_in_at;

    @Column(name = "admin")
    @JsonProperty("admin")
    private Short admin;

    @Column(name = "security_key")
    @JsonProperty("security_key")
    private String securityKey;

    @Column(name = "approved")
    @JsonProperty("approved")
    private Short approved;

    @Column(name = "oem_id")
    @JsonProperty("oem_id")
    private Integer oemId;

    @Column(name = "created_at")
    @JsonProperty("created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @JsonProperty("updated_at")
    private Timestamp updatedAt;

    @Column(name = "auth_token")
    @JsonProperty("auth_token")
    private String auth_token;

    @Column(name = "ayla_dev_kit_num")
    @JsonProperty("ayla_dev_kit_num")
    private String aylaDevKitNum;

    @Column(name = "oem_approved")
    @JsonProperty("oem_approved")
    private Short oemApproved;

    @Column(name = "terms_token")
    @JsonProperty("terms_token")
    private String termsToken;

    @Column(name = "terms_email_sent_at")
    @JsonProperty("terms_email_sent_at")
    private String termsEmailSentAt;

    @Column(name = "terms_accepted_at")
    @JsonProperty("terms_accepted_at")
    private String termsAcceptedAt;

    @Column(name = "terms_accepted")
    @JsonProperty("terms_accepted")
    private Short termsAccepted = 0;

    @Column(name = "origin_oem_id")
    @JsonProperty("origin_oem_id")
    private Integer originOemId;

    @Column(name = "phone_country_code")
    @JsonProperty("phone_country_code")
    private String phoneCountryCode;

    @Column(name = "uuid")
    @JsonProperty("uuid")
    private String uuid;

    @Column(name = "sso_provider_id")
    @JsonProperty("sso_provider_id")
    private Integer ssoProviderId;

    @Column(name = "nickname")
    @JsonProperty("nickname")
    private String nickname;

    @Column(name = "failed_attempts")
    @JsonProperty("failed_attempts")
    private Integer failedAttempts = 0;

    @Column(name = "locked_at")
    @JsonProperty("locked_at")
    private Timestamp locked_at;

    @Column(name = "encrypted_mfa_secret")
    @JsonProperty("encrypted_mfa_secret")
    private String encryptedMfaSecret;

    @Column(name = "encrypted_mfa_secret_iv")
    @JsonProperty("encrypted_mfa_secret_iv")
    private String encryptedMfaSecretIv;

    @Column(name = "encrypted_mfa_secret_salt")
    @JsonProperty("encrypted_mfa_secret_salt")
    private String encryptedMfaSecretSalt;

    @Column(name = "mfa_method")
    @JsonProperty("mfa_method")
    private String mfaMethod;

    @Column(name = "last_mfa_token_at")
    @JsonProperty("last_mfa_token_at")
    private Timestamp lastMfaTokenAt;

    @Column(name = "gdpr_suspended")
    @JsonProperty("gdpr_suspended")
    private Short gdprSuspended = 0;

    @Column(name = "gdpr_suspended_at")
    @JsonProperty("gdpr_suspended_at")
    private Timestamp gdprSuspendedAt;

    @Column(name = "username")
    @JsonProperty("username")
    private String username;

    @Column(name = "alternate_email")
    @JsonProperty("alternate_email")
    private String alternateEmail;

    @Column(name = "alternate_phone", length = 20)
    @JsonProperty("alternate_phone")
    private String alternatePhone;

    @Column(name = "phone_number", length = 20)
    @JsonProperty("phone_number")
    private String phoneNumber;

    @Column(name = "primary_contact", length = 20)
    @JsonProperty("primary_contact")
    private String primaryContact;

    @Column(name = "role_name", length = 20)
    @JsonProperty("role_name")
    private String roleName;
}
